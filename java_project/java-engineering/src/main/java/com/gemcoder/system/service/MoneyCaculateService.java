package com.gemcoder.system.service;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gemcoder.system.bo.OrderMoneyBo;
import com.gemcoder.system.bo.OrderMoneyRuleDetailBo;

@Service
public class MoneyCaculateService {
	private static final Logger log = LoggerFactory.getLogger(MoneyCaculateService.class);
	private Integer findRuleId(int yardId) {
		StringBuilder parkingSql = new StringBuilder(
				"SELECT billing_rule_id FROM billing_rule_parking where parking_lot_info_id=? and enable_status='生效中' ");
		List<Map<String, Object>> rules = executeSQL(parkingSql.toString(), yardId);
		if (rules == null || rules.isEmpty()) {
			return null;
		}
		Map<String, Object> rule = rules.get(0);
		Object billing_rule_id = rule.get("billing_rule_id");
		return Integer.valueOf(billing_rule_id.toString());
	}

	/**
	 * 计算停车费用以及收费详细表，支持跨天
	 * 
	 * @param plateNo
	 *            车牌
	 * @param yardId
	 *            停车场ID,parking_lot_info 表主键
	 * @param newEnergy
	 *            当前车辆是否新能源车
	 * @param white
	 *            当前车辆是否白牌车
	 * @param exitTime
	 *            离场时间
	 * @return
	 */
	public OrderMoneyBo caculateBilllingMoney(String licensePlate, int yardId, boolean newEnergy, boolean white,
			Date exitTime) throws Exception {
		int billRuleId = 0;
		if (licensePlate == null) {
			throw new Exception("车牌不存在");
			// return new BigDecimal(0.0);
		}
		{
			StringBuilder parkingSql = new StringBuilder("SELECT billing_rule_id FROM parking_lot_info where id=?");
			List<Object> parkingParams = new ArrayList<>();
			parkingParams.add(yardId);
			List<Map<String, Object>> rules = executeSQL(parkingSql.toString(), parkingParams.toArray());
			if (rules.isEmpty()) {
				throw new Exception("停车场计费规则记录未找到");
			}
			Map<String, Object> rule = rules.get(0);
			Object billing_rule_id = rule.get("billing_rule_id");
			if (billing_rule_id != null) {
				billRuleId = Integer.valueOf(billing_rule_id.toString());
			} else {
				billRuleId = findRuleId(yardId);
			}

			// ruleName=(String)rule.get("rule_name");
		}
		return _caculateBilllingMoney(licensePlate, yardId, billRuleId, newEnergy, white, exitTime);
	}

	public OrderMoneyBo _caculateBilllingMoney(String licensePlate, int yardId, int billRuleId, boolean newEnergy,
			boolean white, Date exitTime) throws Exception {

		// 根据yardId和plateNo查询车辆订单记录
		// 根据yardId查询规则
		// 根据规则和时间计算费用
		// 返回费用
		String ruleName = "";

		Date entryTime = null;
		{
			StringBuilder parkingSql = new StringBuilder(
					"SELECT entry_time FROM user_order WHERE license_plate = ?  and parking_lot_id =? ORDER BY entry_time DESC LIMIT 1");
			List<Object> parkingParams = new ArrayList<>();
			parkingParams.add(licensePlate);
			parkingParams.add(yardId);
			List<Map<String, Object>> parkingRecords = executeSQL(parkingSql.toString(), parkingParams.toArray());
			if (parkingRecords.isEmpty()) {
				log.info("停车记录未找到,{},{}",licensePlate,yardId);
				throw new Exception("停车记录未找到");
			}
			Map<String, Object> parkingRecord = parkingRecords.get(0);
			entryTime = (Date) parkingRecord.get("entry_time");
		}
		// 计算总停车时长
		// long totalParkingTime = (exitTime.getTime() - entryTime.getTime()) / (1000 *
		// 60); // 转换为分钟

		// 按日期拆分
		List<Date[]> multiDays = splitByDay(entryTime, exitTime);
		Map<String, Object> billingRule = null;
		{
			StringBuilder parkingSql = new StringBuilder("SELECT * FROM billing_rules where id=?");
			List<Object> parkingParams = new ArrayList<>();
			parkingParams.add(billRuleId);
			List<Map<String, Object>> rules = executeSQL(parkingSql.toString(), parkingParams.toArray());
			if (rules.isEmpty()) {
				throw new Exception("计费规则记录未找到");
			}
			billingRule = rules.get(0);
		}
		String billingStandard = (String) billingRule.get("billing_standard");
		ruleName = (String) billingRule.get("rule_name");
		OrderMoneyBo multiDayOrderMoneyBo = new OrderMoneyBo();
		/**
		 * 多天的总计费
		 */
		multiDayOrderMoneyBo.setLicensePlate(licensePlate);
		/**
		 * 单日计费列表
		 */
		List<OrderMoneyBo> oneDayOrderMoneyBoList = new ArrayList<>();
		for (Date[] pair : multiDays) {
			Date oneDayEntryTime = pair[0];
			Date oneDayExitTime = pair[1];
			OrderMoneyBo orderMoneyBo = new OrderMoneyBo();
			orderMoneyBo.setLicensePlate(licensePlate);
			if ("免费停车".equals(billingStandard)) {
				int durMinutes = millisecond2minute (oneDayExitTime.getTime() - oneDayEntryTime.getTime()) ;/// 1000 / 60;
				orderMoneyBo.addNewDetail(billRuleId, oneDayEntryTime, oneDayExitTime, "免费停车", licensePlate,
						BigDecimal.ZERO, ruleName, durMinutes);
				oneDayOrderMoneyBoList.add(orderMoneyBo);
				continue;
			}
			long timespan = exitTime.getTime() - entryTime.getTime();
			if (timespan < 0) {
				throw new Exception("时间错误");
			}
			if ("按次收费".equals(billingStandard)) {
				anci(orderMoneyBo, licensePlate, newEnergy, yardId, white, oneDayEntryTime, oneDayExitTime, billingRule,
						billRuleId, ruleName);
				oneDayOrderMoneyBoList.add(orderMoneyBo);
				continue;
			} else if ("自然天收费".equals(billingStandard)) {
				zirantian(orderMoneyBo, licensePlate, newEnergy, yardId, white, oneDayEntryTime, oneDayExitTime,
						billingRule, billRuleId, ruleName);
				oneDayOrderMoneyBoList.add(orderMoneyBo);
				continue;
			} else if ("分段收费".equals(billingStandard)) {
				fenduan(orderMoneyBo, licensePlate, newEnergy, yardId, white, oneDayEntryTime, oneDayExitTime,
						billingRule, billRuleId, ruleName);
				oneDayOrderMoneyBoList.add(orderMoneyBo);
				continue;
			} else if ("节假日/工作日不同费用".equals(billingStandard)) {
				jiejiarigongzuori(orderMoneyBo, licensePlate, newEnergy, yardId, white, oneDayEntryTime, oneDayExitTime,
						billingRule, billRuleId, ruleName);
				oneDayOrderMoneyBoList.add(orderMoneyBo);
				continue;
			} else {
				throw new Exception("无效的收费方案");
			}
		}
		oneDayOrderMoneyBoList.forEach(r -> {
			multiDayOrderMoneyBo.getDetails().addAll(r.getDetails());
			BigDecimal money = multiDayOrderMoneyBo.getMoney();
			money = money.add(r.getMoney());
			multiDayOrderMoneyBo.setMoney(money);
		});

		return multiDayOrderMoneyBo;

	}

	/**
	 * 按次收费
	 * 
	 * @param licensePlate
	 * @param newEnergy
	 * @param yardId
	 * @param white
	 * @param entryTime
	 * @param exitTime
	 * @param billingRule
	 * @param billRuleId
	 * @return
	 * @throws Exception
	 */
	private OrderMoneyBo anci(OrderMoneyBo orderMoneyBo, String licensePlate, boolean newEnergy, int yardId,
			boolean white, Date entryTime, Date exitTime, Map<String, Object> billingRule, int billRuleId,
			String ruleName) throws Exception {
		// 计算免费时长

		if (white) {
			Object white_plate_car_free = (Object) billingRule.get("white_plate_car_free");
			if (white_plate_car_free != null && ("1".equals(white_plate_car_free.toString())
					|| "是".equals(white_plate_car_free.toString()) || "开启".equals(white_plate_car_free.toString())
					|| "开".equals(white_plate_car_free.toString()))) {
				int durMinutes = millisecond2minute (exitTime.getTime() - entryTime.getTime());// / 1000 / 60;
				orderMoneyBo.addNewDetail(billRuleId, entryTime, exitTime, "白牌车免费", licensePlate, BigDecimal.ZERO,
						ruleName, durMinutes);
				return orderMoneyBo;
			}
		}
		long timespan = millisecond2minute(exitTime.getTime() - entryTime.getTime());// / 1000 / 60;

		boolean useNewEnergy = false;// 是否使用了新能源的减免

		int left = leftNewEnergyFreeTime(licensePlate, yardId, billingRule);
		if (left > 0) {
			Object new_energy_free_duration_reduction = (Object) billingRule.get("new_energy_free_duration_reduction");
			if (newEnergy && new_energy_free_duration_reduction != null
					&& ("1".equals(new_energy_free_duration_reduction.toString())
							|| "是".equals(new_energy_free_duration_reduction.toString())
							|| "开启".equals(new_energy_free_duration_reduction.toString())
							|| "开".equals(new_energy_free_duration_reduction.toString()))) {
				// if (new_energy_free_duration_reduction == 1 && newEnergy) {
				// 开启了新能源免费时长，并且是新能源车
				useNewEnergy = true;
				Integer new_energy_free_duration = (Integer) billingRule.get("new_energy_free_duration");
				timespan = timespan - new_energy_free_duration;
				if (timespan <= 0) {
					int durMinutes = millisecond2minute (exitTime.getTime() - entryTime.getTime());// / 1000 / 60;
					orderMoneyBo.addNewDetail(billRuleId, entryTime, exitTime, "新能源免费时长", licensePlate, BigDecimal.ZERO,
							ruleName, durMinutes);
					return orderMoneyBo;
				} else {
					int durMinutes = new_energy_free_duration;
					orderMoneyBo.addNewDetail(billRuleId, entryTime,
							new Date(entryTime.getTime() + new_energy_free_duration * 1000 * 60), "免费时长", licensePlate,
							new BigDecimal(0.0), ruleName, durMinutes);
					entryTime.setTime(entryTime.getTime() + new_energy_free_duration * 1000 * 60);
				}
			}
		}
		/**
		 * 新能源减免和一般减免不能共用
		 */
		Object free_duration_reduction = (Object) billingRule.get("free_duration_reduction");
		if (!useNewEnergy && free_duration_reduction != null
				&& ("1".equals(free_duration_reduction.toString()) || "是".equals(free_duration_reduction.toString())
						|| "开启".equals(free_duration_reduction.toString())
						|| "开".equals(free_duration_reduction.toString()))) {
			Integer free_duration = (Integer) billingRule.get("free_duration");
			timespan = timespan - free_duration;
			if (timespan <= 0) {
				int durMinutes = millisecond2minute(exitTime.getTime() - entryTime.getTime()) ;/// 1000 / 60;
				orderMoneyBo.addNewDetail(billRuleId, entryTime, exitTime, "免费时长", licensePlate, BigDecimal.ZERO,
						ruleName, durMinutes);
				return orderMoneyBo;
			} else {
				int durMinutes = free_duration;
				orderMoneyBo.addNewDetail(billRuleId, entryTime,
						new Date(entryTime.getTime() + free_duration * 1000 * 60), "免费时长", licensePlate,
						new BigDecimal(0.0), ruleName, durMinutes);
				entryTime.setTime(entryTime.getTime() + free_duration * 1000 * 60);
			}
		}

		BigDecimal temporary_car = new BigDecimal(Double.parseDouble(billingRule.get("temporary_car").toString()));
		// Integer stored_value_car=(Integer)billingRule.get("stored_value_car");
		int durMinutes = (int) timespan;
		orderMoneyBo.addNewDetail(billRuleId, entryTime, exitTime, "临时车收费金额", licensePlate, temporary_car, ruleName,
				durMinutes);
		orderMoneyBo.setMoney(temporary_car);
		return orderMoneyBo;
	}

	/**
	 * 自然天收费
	 * 
	 * @param licensePlate
	 * @param newEnergy
	 * @param yardId
	 * @param white
	 * @param entryTime
	 * @param exitTime
	 * @param billingRule
	 * @param billRuleId
	 * @return
	 * @throws Exception
	 */
	private OrderMoneyBo zirantian(OrderMoneyBo orderMoneyBo, String licensePlate, boolean newEnergy, int yardId,
			boolean white, Date entryTime, Date exitTime, Map<String, Object> billingRule, int billRuleId,
			String ruleName) throws Exception {

		// 计算免费时长
		if (white) {
			// Integer white_plate_car_free = (Integer)
			// billingRule.get("white_plate_car_free");
			Object white_plate_car_free = (Object) billingRule.get("white_plate_car_free");
			if (white_plate_car_free != null && ("1".equals(white_plate_car_free.toString())
					|| "是".equals(white_plate_car_free.toString()) || "开启".equals(white_plate_car_free.toString())
					|| "开".equals(white_plate_car_free.toString()))) {
				int durMinutes = millisecond2minute (exitTime.getTime() - entryTime.getTime());/// 1000 / 60;
				orderMoneyBo.addNewDetail(billRuleId, entryTime, exitTime, "白牌车免费", licensePlate, BigDecimal.ZERO,
						ruleName, durMinutes);
				return orderMoneyBo;
			}
		}
		long timespan = millisecond2minute(exitTime.getTime() - entryTime.getTime());// / 1000 / 60;
		// Integer free_duration_reduction = (Integer)
		// billingRule.get("free_duration_reduction");
		boolean useNewEnergy = false;// 是否使用了新能源的减免
		int left = leftNewEnergyFreeTime(licensePlate, yardId, billingRule);
		if (left > 0) {
			// Integer new_energy_free_duration_reduction = (Integer) billingRule
			// .get("new_energy_free_duration_reduction");
			Object new_energy_free_duration_reduction = (Object) billingRule.get("new_energy_free_duration_reduction");
			if (newEnergy && new_energy_free_duration_reduction != null
					&& ("1".equals(new_energy_free_duration_reduction.toString())
							|| "是".equals(new_energy_free_duration_reduction.toString())
							|| "开启".equals(new_energy_free_duration_reduction.toString())
							|| "开".equals(new_energy_free_duration_reduction.toString()))) {
				// if (new_energy_free_duration_reduction == 1 && newEnergy) {
				Integer new_energy_free_duration = (Integer) billingRule.get("new_energy_free_duration");
				timespan = timespan - new_energy_free_duration;
				useNewEnergy = true;
				if (timespan <= 0) {
					int durMinutes = millisecond2minute (exitTime.getTime() - entryTime.getTime());// / 1000 / 60;
					orderMoneyBo.addNewDetail(billRuleId, entryTime, exitTime, "新能源免费时长", licensePlate, BigDecimal.ZERO,
							ruleName, durMinutes);
					return orderMoneyBo;
				} else {
					int durMinutes = new_energy_free_duration;
					orderMoneyBo.addNewDetail(billRuleId, entryTime,
							new Date(entryTime.getTime() + new_energy_free_duration * 1000 * 60), "免费时长", licensePlate,
							BigDecimal.ZERO, ruleName, durMinutes);
					entryTime.setTime(entryTime.getTime() + new_energy_free_duration * 1000 * 60);
				}
			}
		}

		Object free_duration_reduction = (Object) billingRule.get("free_duration_reduction");
		if (!useNewEnergy && free_duration_reduction != null
				&& ("1".equals(free_duration_reduction.toString()) || "是".equals(free_duration_reduction.toString())
						|| "开启".equals(free_duration_reduction.toString())
						|| "开".equals(free_duration_reduction.toString()))) {
			// if (free_duration_reduction == 1) {
			Integer free_duration = (Integer) billingRule.get("free_duration");
			timespan = timespan - free_duration;
			if (timespan <= 0) {
				int durMinutes = millisecond2minute (exitTime.getTime() - entryTime.getTime()) ;/// 1000 / 60;
				orderMoneyBo.addNewDetail(billRuleId, entryTime, exitTime, "免费时长", licensePlate, BigDecimal.ZERO,
						ruleName, durMinutes);
				return orderMoneyBo;
			} else {
				int durMinutes = free_duration;
				orderMoneyBo.addNewDetail(billRuleId, entryTime,
						new Date(entryTime.getTime() + free_duration * 1000 * 60), "免费时长", licensePlate,
						new BigDecimal(0.0), ruleName, durMinutes);
				entryTime.setTime(entryTime.getTime() + free_duration * 1000 * 60);
			}
		}

		BigDecimal wd_temporary_car_cap_amount = (BigDecimal) billingRule.get("wd_temporary_car_cap_amount");
		if (wd_temporary_car_cap_amount == null) {
			wd_temporary_car_cap_amount = new BigDecimal(Double.MAX_VALUE);
		}
		fenduanByDayType(orderMoneyBo, licensePlate, newEnergy, yardId, white, entryTime, exitTime, billingRule,
				billRuleId, ruleName, false, false);
		if (orderMoneyBo.getMoney().doubleValue() > wd_temporary_car_cap_amount.doubleValue()) {
			int durMinutes = millisecond2minute (exitTime.getTime() - entryTime.getTime());// / 1000 / 60;
			orderMoneyBo.addNewDetail(billRuleId, entryTime, exitTime, "临时车封顶金额", licensePlate,
					wd_temporary_car_cap_amount, ruleName, durMinutes);
			orderMoneyBo.setMoney(wd_temporary_car_cap_amount);
			return orderMoneyBo;
		}
		return orderMoneyBo;
	}

	/**
	 * 分段计算 将整个停车时间拆分成白天夜间多个时段
	 * 
	 * @param licensePlate
	 *            车牌
	 * @param newEnergy
	 *            新能源
	 * @param yardId
	 *            车场编号
	 * @param white
	 *            白牌车
	 * @param entryTime
	 *            进入时间
	 * @param exitTime
	 *            离开时间吗
	 * @param billingRule
	 *            计费规则
	 * @param billRuleId
	 *            计费规则编号
	 * @param isNight
	 *            是否夜间
	 * @return 收费金额
	 */
	@SuppressWarnings("unused")
	private OrderMoneyBo fenduanByDayType(OrderMoneyBo orderMoneyBo, String licensePlate, boolean newEnergy, int yardId,
			boolean white, Date entryTime, Date exitTime, Map<String, Object> billingRule, int billRuleId,
			String ruleName, boolean isNight, boolean isHoliday) {

		String billing_standard = (String) billingRule.get("billing_standard");
		String prefix = "" + (isHoliday ? "h" : "w") + (isNight ? "n" : "d");

		String billing_period_header = "";
		if ("节假日/工作日不同费用".equals(billing_standard)) {
			if (isHoliday) {
				// billing_period+="";
				billing_period_header += "节假日-";
			} else {
				billing_period_header += "工作日-";
			}
			if (isNight) {
				billing_period_header += "夜间-";
			} else {
				billing_period_header += "日间-";
			}
		} else if ("分段收费".equals(billing_standard)) {
			if (isNight) {
				billing_period_header += "夜间-";
			} else {
				billing_period_header += "日间-";
			}
		}
		StringBuilder parkingSql = new StringBuilder(
				"SELECT free_begin_time ,free_end_time FROM billing_free_time_range WHERE billing_rule_id = ?");
		List<Object> parkingParams = new ArrayList<>();
		parkingParams.add(billRuleId);
		long sumFreeTime = 0;
		List<Map<String, Object>> freetimeRanges = executeSQL(parkingSql.toString(), parkingParams.toArray());
		if (freetimeRanges != null && !freetimeRanges.isEmpty()) {
			for (Map<String, Object> mp : freetimeRanges) {
				String free_begin_time = (String) mp.get("free_begin_time");
				String free_end_time = (String) mp.get("free_end_time");
				Date dtstartFree = time2Date(entryTime, free_begin_time);// 免费时间段开始时间
				Date dtendFree = time2Date(entryTime, free_end_time);// 免费时段结束时间1
				if (exitTime.before(dtstartFree) || exitTime.equals(dtstartFree)) {
					continue;
				} else if (entryTime.after(dtendFree) || entryTime.equals(dtendFree)) {
					continue;
				} else if ((entryTime.before(dtstartFree) || entryTime.equals(dtstartFree))
						&& (exitTime.after(dtendFree) || exitTime.equals(dtendFree))) {
					long freeRange = dtendFree.getTime() - dtstartFree.getTime();
					sumFreeTime += freeRange;
					if (freeRange > 0) {
						int durMinutes = millisecond2minute (dtendFree.getTime() - dtstartFree.getTime());// / 1000 / 60;
						orderMoneyBo.addNewDetail(billRuleId, dtstartFree, dtendFree,
								"免费时段:" + millisecond2minute(freeRange ) + "分钟", licensePlate, BigDecimal.ZERO, ruleName,
								durMinutes);
					}
				} else if ((entryTime.after(dtstartFree) || entryTime.equals(dtstartFree))
						&& (exitTime.after(dtendFree) || exitTime.equals(dtendFree))) {
					long freeRange = dtendFree.getTime() - entryTime.getTime();
					sumFreeTime += freeRange;
					if (sumFreeTime > 0) {
						int durMinutes = millisecond2minute (dtendFree.getTime() - dtstartFree.getTime());// / 1000 / 60;
						orderMoneyBo.addNewDetail(billRuleId, entryTime, dtendFree,
								"免费时段:" + millisecond2minute(freeRange) + "分钟", licensePlate, BigDecimal.ZERO, ruleName,
								durMinutes);
					}
				} else if ((entryTime.before(dtstartFree) || entryTime.equals(dtstartFree))
						&& (exitTime.before(dtendFree) || exitTime.equals(dtendFree))) {
					long freeRange = exitTime.getTime() - dtstartFree.getTime();
					sumFreeTime += freeRange;
					if (freeRange > 0) {
						int durMinutes = millisecond2minute (exitTime.getTime() - dtstartFree.getTime());// / 1000 / 60;
						orderMoneyBo.addNewDetail(billRuleId, dtstartFree, exitTime,
								"免费时段:" + millisecond2minute(freeRange) + "分钟", licensePlate, BigDecimal.ZERO, ruleName,
								durMinutes);
					}
				}
			}
		}
		long timespan = exitTime.getTime() - entryTime.getTime();
		timespan -= sumFreeTime;
		if (timespan <= 0) {
			// return BigDecimal.ZERO;
			return orderMoneyBo;
		}
		/**
		 * 从毫秒变成分钟
		 */
		int timespanMinute =millisecond2minute(timespan);// (int) (timespan / 1000 / 60);
		/**
		 * temporary_car_first_ceil内每temporary_car_first_time分钟temporary_car_first_tier元
		 */
		BigDecimal temporary_car_first_tier = null;
		BigDecimal temporary_car_second_tier = null;
		BigDecimal temporary_car_third_tier = null;
		Integer temporary_car_first_time = null;
		Integer temporary_car_second_time = null;
		Integer temporary_car_third_time = null;
		Integer temporary_car_first_ceil = null;
		Integer temporary_car_second_ceil = null;
		Integer temporary_car_third_ceil = null;
		// if (isNight) {
		temporary_car_first_tier = (BigDecimal) billingRule.get(prefix + "_temporary_car_first_tier");
		temporary_car_second_tier = (BigDecimal) billingRule.get(prefix + "_temporary_car_second_tier");
		temporary_car_third_tier = (BigDecimal) billingRule.get(prefix + "_temporary_car_third_tier");

		temporary_car_first_time = (Integer) billingRule.get(prefix + "_temporary_car_first_time");
		temporary_car_second_time = (Integer) billingRule.get(prefix + "_temporary_car_second_time");
		temporary_car_third_time = (Integer) billingRule.get(prefix + "_temporary_car_third_time");
		if (temporary_car_first_time != null) {
			// 避免负数造成死循环
			temporary_car_first_time = Math.abs(temporary_car_first_time);
		}
		if (temporary_car_second_time != null) {
			temporary_car_second_time = Math.abs(temporary_car_second_time);
		}
		if (temporary_car_third_time != null) {
			temporary_car_third_time = Math.abs(temporary_car_third_time);
		}

		temporary_car_first_ceil = (Integer) billingRule.get(prefix + "_temporary_car_first_ceil");
		temporary_car_second_ceil = (Integer) billingRule.get(prefix + "_temporary_car_second_ceil");
		temporary_car_third_ceil = (Integer) billingRule.get(prefix + "_temporary_car_third_ceil");

		/*
		 * } else { temporary_car_first_tier = (BigDecimal)
		 * billingRule.get("wd_temporary_car_first_tier"); temporary_car_second_tier =
		 * (BigDecimal) billingRule.get("wd_temporary_car_second_tier");
		 * temporary_car_third_tier = (BigDecimal)
		 * billingRule.get("wd_temporary_car_third_tier"); temporary_car_first_time =
		 * (Integer) billingRule.get("wd_temporary_car_first_time");
		 * temporary_car_second_time = (Integer)
		 * billingRule.get("wd_temporary_car_second_time"); temporary_car_third_time =
		 * (Integer) billingRule.get("wd_temporary_car_third_time");
		 * temporary_car_first_ceil = (Integer)
		 * billingRule.get("wd_temporary_car_first_ceil"); temporary_car_second_ceil =
		 * (Integer) billingRule.get("wd_temporary_car_second_ceil");
		 * temporary_car_third_ceil = (Integer)
		 * billingRule.get("wd_temporary_car_third_ceil"); }
		 */

		if (timespanMinute <= temporary_car_first_ceil || temporary_car_second_ceil == null) {
			int count = 0;
			for (int i = 0; i < Integer.MAX_VALUE; ++i) {
				if (i * temporary_car_first_time >= timespanMinute) {
					count = i;
					break;
				}
			}
			BigDecimal finalMoney = temporary_car_first_tier.multiply(new BigDecimal(count));
			orderMoneyBo.addNewDetail(billRuleId, entryTime, exitTime, billing_period_header + "临时车-第一阶梯", licensePlate,
					finalMoney, ruleName, timespanMinute);
			orderMoneyBo.setMoney(finalMoney);
			return orderMoneyBo;
		} else if (timespanMinute <= (temporary_car_first_ceil + temporary_car_second_ceil)
				|| temporary_car_third_tier == null) {
			// 计算第一阶段结束时间，第二阶段开始时间
			Date firstEndtime = new Date(entryTime.getTime() + temporary_car_first_ceil * 1000 * 60);
			Date firstStartTime = new Date(entryTime.getTime());
			long firstEndtimeL = firstEndtime.getTime();
			long firstStartTimeL = firstStartTime.getTime();
			{
				int count = 0;
				if (freetimeRanges != null && !freetimeRanges.isEmpty() && sumFreeTime > 0) {
					for (Map<String, Object> mp : freetimeRanges) {
						String free_begin_time = (String) mp.get("free_begin_time");
						String free_end_time = (String) mp.get("free_end_time");
						Date dtstartFree = time2Date(entryTime, free_begin_time);// 免费时间段开始时间
						Date dtendFree = time2Date(entryTime, free_end_time);// 免费时段结束时间1
						long dtstartFreeL = dtstartFree.getTime();
						long dtendFreeL = dtendFree.getTime();
						if (firstEndtimeL <= dtendFreeL && firstStartTimeL >= dtstartFreeL) {
							firstEndtimeL += firstEndtimeL - firstStartTimeL;
						} else if (firstStartTimeL <= dtstartFreeL && firstEndtimeL >= dtendFreeL) {
							firstEndtimeL += dtendFreeL - dtstartFreeL;
						} else if (firstStartTimeL < dtendFreeL && firstStartTimeL > dtstartFreeL) {
							firstEndtimeL += dtendFreeL - firstStartTimeL;
						} else if (dtstartFreeL < firstEndtimeL && dtstartFreeL > firstStartTimeL) {
							firstEndtimeL += dtendFreeL - dtstartFreeL;
						}
					}
				}
			}
			firstEndtime.setTime(firstEndtimeL);

			BigDecimal b1 = temporary_car_first_tier
					.multiply(new BigDecimal(temporary_car_first_ceil / temporary_car_first_time));
			orderMoneyBo.addNewDetail(billRuleId, entryTime, firstEndtime, billing_period_header + "临时车-第一阶梯",
					licensePlate, b1, ruleName, temporary_car_first_ceil);
			int count = 0;
			timespanMinute -= temporary_car_first_ceil;
			for (int i = 0; i < Integer.MAX_VALUE; ++i) {
				if (i * temporary_car_second_time >= timespanMinute) {
					count = i;
					break;
				}
			}
			BigDecimal b2 = temporary_car_second_tier.multiply(new BigDecimal(count));
			orderMoneyBo.addNewDetail(billRuleId, firstEndtime, exitTime, billing_period_header + "临时车-第二阶梯",
					licensePlate, b2, ruleName, timespanMinute);
			BigDecimal finalMoney = b2.add(b1);
			orderMoneyBo.setMoney(finalMoney);
			return orderMoneyBo;
		} else {
			// 计算第一阶段结束时间，第二阶段开始时间，第二阶段结束时间

			Date firstEndtime = new Date(entryTime.getTime() + temporary_car_first_ceil * 1000 * 60);
			Date firstStartTime = new Date(entryTime.getTime());
			long firstEndtimeL = firstEndtime.getTime();
			long firstStartTimeL = firstStartTime.getTime();
			{
				int count = 0;
				if (freetimeRanges != null && !freetimeRanges.isEmpty() && sumFreeTime > 0) {
					for (Map<String, Object> mp : freetimeRanges) {
						String free_begin_time = (String) mp.get("free_begin_time");
						String free_end_time = (String) mp.get("free_end_time");
						Date dtstartFree = time2Date(entryTime, free_begin_time);// 免费时间段开始时间
						Date dtendFree = time2Date(entryTime, free_end_time);// 免费时段结束时间1
						long dtstartFreeL = dtstartFree.getTime();
						long dtendFreeL = dtendFree.getTime();
						if (firstEndtimeL <= dtendFreeL && firstStartTimeL >= dtstartFreeL) {
							firstEndtimeL += dtendFreeL - firstStartTimeL;
						} else if (firstStartTimeL <= dtstartFreeL && firstEndtimeL >= dtendFreeL) {
							firstEndtimeL += dtendFreeL - dtstartFreeL;
						} else if (firstStartTimeL < dtendFreeL && firstStartTimeL > dtstartFreeL) {
							firstEndtimeL += dtendFreeL - firstStartTimeL;
						} else if (dtstartFreeL < firstEndtimeL && dtstartFreeL > firstStartTimeL) {
							firstEndtimeL += dtendFreeL - dtstartFreeL;
						}
					}
				}
			}
			firstEndtime.setTime(firstEndtimeL);

			Date secondEndtime = new Date(firstEndtimeL + temporary_car_second_ceil * 1000 * 60);
			Date secondStartTime = new Date(firstEndtimeL);
			long secondEndtimeL = secondEndtime.getTime();
			long secondStartTimeL = secondStartTime.getTime();

			{
				int count = 0;
				if (freetimeRanges != null && !freetimeRanges.isEmpty() && sumFreeTime > 0) {
					for (Map<String, Object> mp : freetimeRanges) {
						String free_begin_time = (String) mp.get("free_begin_time");
						String free_end_time = (String) mp.get("free_end_time");
						Date dtstartFree = time2Date(entryTime, free_begin_time);// 免费时间段开始时间
						Date dtendFree = time2Date(entryTime, free_end_time);// 免费时段结束时间1
						long dtstartFreeL = dtstartFree.getTime();
						long dtendFreeL = dtendFree.getTime();
						if (secondEndtimeL <= dtendFreeL && secondStartTimeL >= dtstartFreeL) {
							secondEndtimeL += secondEndtimeL - secondStartTimeL;
						} else if (secondStartTimeL <= dtstartFreeL && secondEndtimeL >= dtendFreeL) {
							secondEndtimeL += dtendFreeL - dtstartFreeL;
						} else if (secondStartTimeL < dtendFreeL && secondStartTimeL > dtstartFreeL) {
							secondEndtimeL += dtendFreeL - secondStartTimeL;
						} else if (dtstartFreeL < secondEndtimeL && dtstartFreeL > secondStartTimeL) {
							secondEndtimeL += dtendFreeL - dtstartFreeL;
						}
					}
				}
			}
			secondEndtime.setTime(secondEndtimeL);

			BigDecimal b1 = temporary_car_first_tier
					.multiply(new BigDecimal(temporary_car_first_ceil / temporary_car_first_time));
			orderMoneyBo.addNewDetail(billRuleId, entryTime, firstEndtime, billing_period_header + "临时车-第一阶梯",
					licensePlate, b1, ruleName, temporary_car_first_ceil);
			BigDecimal b2 = temporary_car_second_tier
					.multiply(new BigDecimal((temporary_car_second_ceil) / temporary_car_second_time));
			orderMoneyBo.addNewDetail(billRuleId, firstEndtime, secondEndtime, billing_period_header + "临时车-第二阶梯",
					licensePlate, b2, ruleName, temporary_car_second_ceil);
			int count = 0;
			timespanMinute -= temporary_car_first_ceil;
			timespanMinute -= temporary_car_second_ceil;
			for (int i = 0; i < Integer.MAX_VALUE; ++i) {
				if (i * temporary_car_third_time >= timespanMinute) {
					count = i;
					break;
				}
			}
			BigDecimal b3 = temporary_car_third_tier.multiply(new BigDecimal(count));
			orderMoneyBo.addNewDetail(billRuleId, secondEndtime, exitTime, billing_period_header + "临时车-第三阶梯",
					licensePlate, b3, ruleName, timespanMinute);
			BigDecimal finalMoney = b3.add(b1).add(b2);
			orderMoneyBo.setMoney(finalMoney);
			return orderMoneyBo;
		}
	}

	private OrderMoneyBo fenduanWithHoliday(OrderMoneyBo orderMoneyBo, String licensePlate, boolean newEnergy,
			int yardId, boolean white, Date entryTime, Date exitTime, Map<String, Object> billingRule, int billRuleId,
			String ruleName, boolean isHoliday, boolean fenduanDay) throws Exception {
		// 计算免费时长
		String prefix = (isHoliday ? "h" : "w");
		String wd_begin_time_range = (String) billingRule.get(prefix + "d_begin_time_range");
		String wd_end_time_range = (String) billingRule.get(prefix + "d_end_time_range");
		Date dayBegin = time2Date(entryTime, "00:00");
		// Date dayEnd = time2Date(entryTime,"23:59");// 白天结束时间
		Date dayEnd = new Date(dayBegin.getTime() + 1000L * 60 * 60 * 24);
		if (fenduanDay) {
			dayBegin = time2Date(entryTime, wd_begin_time_range);// 白天开始时间
			dayEnd = time2Date(entryTime, wd_end_time_range);// 白天结束时间
		}
		// 计算免费时长
		if (white) {
			Integer white_plate_car_free = (Integer) billingRule.get("white_plate_car_free");
			if (white_plate_car_free == 1) {
				// 白牌车
				int durMinutes =millisecond2minute(exitTime.getTime() - entryTime.getTime());// (int) (exitTime.getTime() - entryTime.getTime()) / 1000 / 60;
				orderMoneyBo.addNewDetail(billRuleId, entryTime, exitTime, "白牌车免费", licensePlate, BigDecimal.ZERO,
						ruleName, durMinutes);
				return orderMoneyBo;
			}
		}
		boolean useNewEnergy = false;// 是否使用了新能源的减免
		int left = leftNewEnergyFreeTime(licensePlate, yardId, billingRule);
		if (left > 0) {
			Object new_energy_free_duration_reduction = (Object) billingRule.get("new_energy_free_duration_reduction");
			if (new_energy_free_duration_reduction != null && newEnergy
					&& ("开".equals(new_energy_free_duration_reduction) || "1".equals(new_energy_free_duration_reduction)
							|| "开启".equals(new_energy_free_duration_reduction)
							|| "是".equals(new_energy_free_duration_reduction))) {
				Integer new_energy_free_duration = (Integer) billingRule.get("new_energy_free_duration");
				// entryTime.setTime(entryTime.getTime() + new_energy_free_duration * 60 *
				// 1000);
				useNewEnergy = true;
				if ((entryTime.getTime() + new_energy_free_duration * 60 * 1000) > exitTime.getTime()) {
					int durMinutes = millisecond2minute(exitTime.getTime() - entryTime.getTime());// / 1000 / 60;
					orderMoneyBo.addNewDetail(billRuleId, entryTime, exitTime, "新能源免费时长", licensePlate, BigDecimal.ZERO,
							ruleName, durMinutes);
					return orderMoneyBo;
				} else {
					int durMinutes = new_energy_free_duration;
					orderMoneyBo.addNewDetail(billRuleId, entryTime,
							new Date(entryTime.getTime() + new_energy_free_duration * 1000 * 60), "新能源免费时长",
							licensePlate, new BigDecimal(0.0), ruleName, durMinutes);
					entryTime.setTime(entryTime.getTime() + new_energy_free_duration * 1000 * 60);
				}
			}
		}

		// long timespan = (exitTime.getTime() - entryTime.getTime()) / 1000 / 60;
		String free_duration_reduction = (String) billingRule.get("free_duration_reduction");
		if (!useNewEnergy && free_duration_reduction != null && ("1".equals(free_duration_reduction)
				|| "开".equals(free_duration_reduction) || "开启".equals(free_duration_reduction))) {
			// 免费时长
			Integer free_duration = (Integer) billingRule.get("free_duration");
			// entryTime.setTime(entryTime.getTime() + free_duration * 60 * 1000);
			if ((entryTime.getTime() + free_duration * 60 * 1000) > exitTime.getTime()) {
				int durMinutes =  millisecond2minute(exitTime.getTime() - entryTime.getTime());// / 1000 / 60;
				orderMoneyBo.addNewDetail(billRuleId, entryTime, exitTime, "免费时长", licensePlate, BigDecimal.ZERO,
						ruleName, durMinutes);
				return orderMoneyBo;
			} else {
				int durMinutes = free_duration;
				orderMoneyBo.addNewDetail(billRuleId, entryTime,
						new Date(entryTime.getTime() + free_duration * 1000 * 60), "免费时长", licensePlate,
						new BigDecimal(0.0), ruleName, durMinutes);
				entryTime.setTime(entryTime.getTime() + free_duration * 1000 * 60);
			}
			// timespan = timespan - free_duration;
		}

		// 封顶金额
		BigDecimal wn_temporary_car_cap_amount = (BigDecimal) billingRule.get(prefix + "n_temporary_car_cap_amount");
		BigDecimal wd_temporary_car_cap_amount = (BigDecimal) billingRule.get(prefix + "d_temporary_car_cap_amount");
		if (wn_temporary_car_cap_amount == null) {
			wn_temporary_car_cap_amount = new BigDecimal(Double.MAX_VALUE);
		}
		if (wd_temporary_car_cap_amount == null) {
			wd_temporary_car_cap_amount = new BigDecimal(Double.MAX_VALUE);
		}

		if (entryTime.after(dayBegin) && exitTime.before(dayEnd)) {
			// 白天
			fenduanByDayType(orderMoneyBo, licensePlate, newEnergy, yardId, white, entryTime, exitTime, billingRule,
					billRuleId, ruleName, false, isHoliday);
			if (orderMoneyBo.getMoney().doubleValue() > wd_temporary_car_cap_amount.doubleValue()) {
				int durMinutes = millisecond2minute (exitTime.getTime() - entryTime.getTime());// / 1000 / 60;
				orderMoneyBo.addNewDetail(billRuleId, entryTime, exitTime, "日间-临时车封顶金额", licensePlate,
						wd_temporary_car_cap_amount, ruleName, durMinutes);
				orderMoneyBo.setMoney(wd_temporary_car_cap_amount);
				return orderMoneyBo;
			}
			return orderMoneyBo;
		} else if (exitTime.before(dayBegin) || entryTime.after(dayEnd)) {
			// 夜里
			fenduanByDayType(orderMoneyBo, licensePlate, newEnergy, yardId, white, entryTime, exitTime, billingRule,
					billRuleId, ruleName, true, isHoliday);
			if (orderMoneyBo.getMoney().doubleValue() > wn_temporary_car_cap_amount.doubleValue()) {
				int durMinutes =millisecond2minute(exitTime.getTime() - entryTime.getTime());// / 1000 / 60;
				orderMoneyBo.addNewDetail(billRuleId, entryTime, exitTime, "夜间-临时车封顶金额", licensePlate,
						wn_temporary_car_cap_amount, ruleName, durMinutes);
				orderMoneyBo.setMoney(wn_temporary_car_cap_amount);
				return orderMoneyBo;
			}
			return orderMoneyBo;
		} else if (entryTime.before(dayBegin) && exitTime.after(dayEnd)) {
			// 夜间，白天，夜间
			OrderMoneyBo orderMoneyBo0 = new OrderMoneyBo();
			OrderMoneyBo orderMoneyBo1 = new OrderMoneyBo();
			OrderMoneyBo orderMoneyBo2 = new OrderMoneyBo();
			fenduanByDayType(orderMoneyBo0, licensePlate, newEnergy, yardId, white, entryTime, dayBegin, billingRule,
					billRuleId, ruleName, true, isHoliday);
			fenduanByDayType(orderMoneyBo1, licensePlate, newEnergy, yardId, white, dayBegin, dayEnd, billingRule,
					billRuleId, ruleName, false, isHoliday);
			fenduanByDayType(orderMoneyBo2, licensePlate, newEnergy, yardId, white, dayEnd, exitTime, billingRule,
					billRuleId, ruleName, true, isHoliday);

			if (orderMoneyBo1.getMoney().doubleValue() > wd_temporary_car_cap_amount.doubleValue()) {
				int durMinutes = millisecond2minute (dayEnd.getTime() - dayBegin.getTime());// / 1000 / 60;
				orderMoneyBo1.addNewDetail(billRuleId, dayBegin, dayEnd, "日间-临时车封顶金额", licensePlate,
						wd_temporary_car_cap_amount, ruleName, durMinutes);
				orderMoneyBo1.setMoney(wd_temporary_car_cap_amount);
			}
			BigDecimal b0 = orderMoneyBo0.getMoney().add(orderMoneyBo2.getMoney());
			if (b0.doubleValue() > wn_temporary_car_cap_amount.doubleValue()) {
				b0 = wn_temporary_car_cap_amount;
				int durMinutes = millisecond2minute (dayBegin.getTime() - entryTime.getTime());// / 1000 / 60;
				int durMinutes1 = millisecond2minute (exitTime.getTime() - dayEnd.getTime()) ;/// 1000 / 60;
				durMinutes += durMinutes1;
				orderMoneyBo0.addNewDetail(billRuleId, entryTime, exitTime, "夜间-临时车封顶金额", licensePlate,
						wn_temporary_car_cap_amount, ruleName, durMinutes);
				orderMoneyBo0.setMoney(wn_temporary_car_cap_amount);
			}
			b0 = b0.add(orderMoneyBo1.getMoney());
			orderMoneyBo0.getDetails().forEach(r -> orderMoneyBo.getDetails().add(r));
			orderMoneyBo1.getDetails().forEach(r -> orderMoneyBo.getDetails().add(r));
			orderMoneyBo2.getDetails().forEach(r -> orderMoneyBo.getDetails().add(r));
			orderMoneyBo.setMoney(b0);
			return orderMoneyBo;
		} else if (entryTime.before(dayBegin)) {
			// 夜间，白天
			OrderMoneyBo orderMoneyBo0 = new OrderMoneyBo();
			OrderMoneyBo orderMoneyBo1 = new OrderMoneyBo();
			fenduanByDayType(orderMoneyBo0, licensePlate, newEnergy, yardId, white, entryTime, dayBegin, billingRule,
					billRuleId, ruleName, true, isHoliday);
			fenduanByDayType(orderMoneyBo1, licensePlate, newEnergy, yardId, white, dayBegin, exitTime, billingRule,
					billRuleId, ruleName, false, isHoliday);
			BigDecimal b0 = orderMoneyBo0.getMoney();
			BigDecimal b1 = orderMoneyBo1.getMoney();
			if (b1.doubleValue() > wd_temporary_car_cap_amount.doubleValue()) {
				b1 = wd_temporary_car_cap_amount;
				orderMoneyBo1.setMoney(wd_temporary_car_cap_amount);
				int durMinutes = millisecond2minute (exitTime.getTime() - dayBegin.getTime());// / 1000 / 60;
				orderMoneyBo1.addNewDetail(billRuleId, dayBegin, exitTime, "日间-临时车封顶金额", licensePlate,
						wd_temporary_car_cap_amount, ruleName, durMinutes);
			}
			if (b0.doubleValue() > wn_temporary_car_cap_amount.doubleValue()) {
				b0 = wn_temporary_car_cap_amount;
				orderMoneyBo0.setMoney(wn_temporary_car_cap_amount);
				int durMinutes = millisecond2minute(dayBegin.getTime() - entryTime.getTime());// / 1000 / 60;
				orderMoneyBo0.addNewDetail(billRuleId, entryTime, dayBegin, "夜间-临时车封顶金额", licensePlate,
						wn_temporary_car_cap_amount, ruleName, durMinutes);
			}
			b0 = b0.add(b1);
			orderMoneyBo0.getDetails().forEach(r -> orderMoneyBo.getDetails().add(r));
			orderMoneyBo1.getDetails().forEach(r -> orderMoneyBo.getDetails().add(r));
			orderMoneyBo.setMoney(b0);
			return orderMoneyBo;
		} else {
			// 白天,夜间
			OrderMoneyBo orderMoneyBo0 = new OrderMoneyBo();// 白
			OrderMoneyBo orderMoneyBo1 = new OrderMoneyBo();// 夜
			fenduanByDayType(orderMoneyBo0, licensePlate, newEnergy, yardId, white, entryTime, dayEnd, billingRule,
					billRuleId, ruleName, false, isHoliday);
			fenduanByDayType(orderMoneyBo1, licensePlate, newEnergy, yardId, white, dayEnd, exitTime, billingRule,
					billRuleId, ruleName, true, isHoliday);
			BigDecimal b0 = orderMoneyBo0.getMoney();
			BigDecimal b1 = orderMoneyBo1.getMoney();

			if (b0.doubleValue() > wd_temporary_car_cap_amount.doubleValue()) {
				b0 = wd_temporary_car_cap_amount;
				orderMoneyBo0.setMoney(wd_temporary_car_cap_amount);
				int durMinutes = millisecond2minute (dayEnd.getTime() - entryTime.getTime());// / 1000 / 60;
				orderMoneyBo1.addNewDetail(billRuleId, entryTime, dayEnd, "日间-临时车封顶金额", licensePlate,
						wd_temporary_car_cap_amount, ruleName, durMinutes);
			}
			if (b1.doubleValue() > wn_temporary_car_cap_amount.doubleValue()) {
				b1 = wn_temporary_car_cap_amount;
				orderMoneyBo0.setMoney(wn_temporary_car_cap_amount);
				int durMinutes = millisecond2minute (exitTime.getTime() - dayEnd.getTime());// / 1000 / 60;
				orderMoneyBo0.addNewDetail(billRuleId, dayEnd, exitTime, "夜间-临时车封顶金额", licensePlate,
						wn_temporary_car_cap_amount, ruleName, durMinutes);

			}
			b0 = b0.add(b1);
			orderMoneyBo0.getDetails().forEach(r -> orderMoneyBo.getDetails().add(r));
			orderMoneyBo1.getDetails().forEach(r -> orderMoneyBo.getDetails().add(r));
			orderMoneyBo.setMoney(b0);
			return orderMoneyBo;
		}
	}

	private OrderMoneyBo fenduan(OrderMoneyBo orderMoneyBo, String licensePlate, boolean newEnergy, int yardId,
			boolean white, Date entryTime, Date exitTime, Map<String, Object> billingRule, int billRuleId,
			String ruleName) throws Exception {
		return fenduanWithHoliday(orderMoneyBo, licensePlate, newEnergy, yardId, white, entryTime, exitTime,
				billingRule, billRuleId, ruleName, false, true);
	}

	@SuppressWarnings("deprecation")
	private OrderMoneyBo jiejiarigongzuori(OrderMoneyBo orderMoneyBo, String licensePlate, boolean newEnergy,
			int yardId, boolean white, Date entryTime, Date exitTime, Map<String, Object> billingRule, int billRuleId,
			String ruleName) throws Exception {
		boolean isholiday = false;
		{
			StringBuilder parkingSql = new StringBuilder(
					"SELECT holiday_start_date,holiday_end_date FROM billing_holiday_schedule where billing_rule_id=?");
			List<Object> parkingParams = new ArrayList<>();
			parkingParams.add(billRuleId);
			List<Map<String, Object>> holidays = executeSQL(parkingSql.toString(), parkingParams.toArray());
			if (holidays == null || holidays.isEmpty()) {
				isholiday = false;
			} else {
				for (Map<String, Object> mp : holidays) {
					Date holiday_start_date = parse(mp.get("holiday_start_date").toString());
					Date holiday_end_date = parse(mp.get("holiday_end_date").toString());
					holiday_end_date.setHours(23);
					holiday_end_date.setMinutes(59);
					holiday_end_date.setSeconds(59);
					if (holiday_start_date.before(exitTime) && holiday_end_date.after(exitTime)) {
						isholiday = true;
						break;
					}
				}
			}
		}
		Object segment_charging = (Object) billingRule.get("segment_charging");
		boolean fenduanDay = false;
		if (segment_charging != null) {
			String segmentCharging = segment_charging.toString();
			if (segmentCharging.equals("1") || segmentCharging.equals("开") || segmentCharging.equals("开启")) {
				fenduanDay = true;
			}
		}
		return fenduanWithHoliday(orderMoneyBo, licensePlate, newEnergy, yardId, white, entryTime, exitTime,
				billingRule, billRuleId, ruleName, isholiday, fenduanDay);
	}

	/**
	 * 剩余可用次数
	 * 
	 * @param licensePlate
	 * @param yardId
	 * @param billingRule
	 * @return
	 */
	private int leftNewEnergyFreeTime(String licensePlate, int yardId, Map<String, Object> billingRule) {
		Integer new_energy_free_times = (Integer) billingRule.get("new_energy_free_times");
		if (new_energy_free_times == null) {
			return 0;
		}
		if (new_energy_free_times < 0) {
			return Integer.MAX_VALUE;
		}

		String sql = "select count(1) as counter from user_order where license_plate=? and exit_time is not null and parking_lot in(select parking_lot_name from parking_lot_info where id= ?)";
		List<Object> params = new ArrayList<>();
		params.add(licensePlate);
		params.add(yardId);
		List<Map<String, Object>> times = executeSQL(sql, params.toArray());
		if (times != null && !times.isEmpty() && times.get(0).get("counter") != null) {
			int counter = Integer.parseInt(times.get(0).get("counter").toString());
			return new_energy_free_times - counter;
		}
		return new_energy_free_times;
	}

	private static String[] splite(String str, char c) {
		if (str == null || str.isBlank()) {
			return new String[] { str };
		}
		List<String> al = new ArrayList<>();
		StringBuilder strb = new StringBuilder();
		for (int i = 0; i < str.length(); ++i) {
			char cr = str.charAt(i);
			if (cr == c) {
				al.add(strb.toString());
				strb.setLength(0);
			} else {
				strb.append(cr);
			}
		}
		if (strb.length() > 0) {
			al.add(strb.toString());
		}
		if (al.size() <= 0) {
			return new String[0];
		}
		String[] r = (String[]) al.toArray(new String[al.size()]);
		return r;
	}

	/**
	 * 
	 * H:mm HHmm HH:mm HHmmss HH:mm:ss
	 * 
	 * @param hhmm
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static Date time2Date(Date dt, String hhmm) {
		if (hhmm == null) {
			return new Date();
		}
		Date date = new Date();
		if (dt != null) {
			date = new Date(dt.getTime());
		}
		hhmm = hhmm.trim();
		String[] splited = splite(hhmm, ':');
		if (splited.length == 1) {
			if (hhmm.length() == 4) {
				// Date date = new Date();
				date.setHours(Integer.parseInt(hhmm.substring(0, 2)));
				date.setMinutes(Integer.parseInt(hhmm.substring(2)));
				date.setSeconds(0);
				return date;
			}
			if (hhmm.length() == 6) {
				// Date date = new Date();
				date.setHours(Integer.parseInt(hhmm.substring(0, 2)));
				date.setMinutes(Integer.parseInt(hhmm.substring(2, 4)));
				date.setSeconds(Integer.parseInt(hhmm.substring(4)));
				return date;
			}
			return new Date();
		} else if (splited.length == 2) {
			// Date date = new Date();
			date.setHours(Integer.parseInt(splited[0]));
			date.setMinutes(Integer.parseInt(splited[1]));
			date.setSeconds(0);
			return date;
		} else if (splited.length == 3) {
			// Date date = new Date();
			date.setHours(Integer.parseInt(splited[0]));
			date.setMinutes(Integer.parseInt(splited[1]));
			date.setSeconds(Integer.parseInt(splited[2]));
			return date;
		}
		return new Date();
	}

	/*
	 * public static void main(String[] args) { String[] sss=splite("111",':');
	 * for(String s:sss) { System.out.println(s); } }
	 */
	@SuppressWarnings("deprecation")
	public static List<Date[]> splitByDay(Date beginTime, Date endTime) {
		List<Date[]> result = new ArrayList<>();
		Date start = new Date(beginTime.getTime());
		Date end = new Date(endTime.getTime());
		while (true) {
			Date endD = new Date(start.getTime());
			endD.setHours(23);
			endD.setMinutes(59);
			endD.setSeconds(59);
			if (endD.getTime() < end.getTime()) {
				result.add(new Date[] { start, endD });
				Date nexDay = new Date(start.getTime() + 24 * 60 * 60 * 1000);
				nexDay.setHours(0);
				nexDay.setMinutes(0);
				nexDay.setSeconds(0);
				start = nexDay;
				continue;
			} else {
				result.add(new Date[] { start, end });
				break;
			}
		}
		return result;
	}

	static final SimpleDateFormat sdf_yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	static final SimpleDateFormat sdf_yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	static final SimpleDateFormat sdf_yyyyMMdd_HH_mm_ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private static Date parse(String yyyymmdd) {
		if (yyyymmdd == null || yyyymmdd.isBlank()) {
			return null;
		}
		yyyymmdd = yyyymmdd.trim();
		try {
			if (yyyymmdd.length() == 8) {
				return sdf_yyyyMMdd.parse(yyyymmdd);
			} else if (yyyymmdd.length() == 10) {
				return sdf_yyyy_MM_dd.parse(yyyymmdd);
			} else {
				return sdf_yyyyMMdd_HH_mm_ss.parse(yyyymmdd);
			}
		} catch (Exception e) {
			return null;
		}

	}

	private int saveDetail(int order_id, int serialNumber, OrderMoneyRuleDetailBo detail) {
		String currentUserName = sdkOfGetCurrentUserName();
		StringBuilder sql = new StringBuilder(
				"INSERT INTO billing_detail (serial_number,order_id, billing_type, billing_vehicle, billing_period, start_time, end_time, duration, billing_rule,amount,"
						+ "create_username,create_time,update_username,update_time)"
						+ "  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		// id, serial_number, billing_type, billing_vehicle, billing_period, start_time,
		// end_time, duration, billing_rule FROM billing_detail
		List<Object> params = new ArrayList<>();
		// params.add(orderId);
		params.add(serialNumber);
		params.add(order_id);
		params.add(detail.getRuleName());
		params.add(detail.getLicensePlate());
		params.add(detail.getRuleType());
		params.add(detail.getBeginTime());
		params.add(detail.getEndTime());
		params.add(detail.getMinutes());
		params.add(detail.getRuleId());
		params.add(detail.getMoney());

		params.add(currentUserName);
		params.add(new Date());
		params.add(currentUserName);
		params.add(new Date());

		int insertRows = executeSQL(sql.toString(), params.toArray());
		return insertRows;
	}

	public int saveDetails(int order_id, int serialNumber, List<OrderMoneyRuleDetailBo> details) {

		if (details == null || details.isEmpty()) {
			return 0;
		}
		details.forEach(r -> {
			saveDetail(order_id, serialNumber, r);
		});
		return 0;
	}

	/**
	 * 毫秒变成分钟，余数大等于1秒向上取整
	 * 
	 * @param millisecond
	 * @return
	 */
	private int millisecond2minute(long millisecond) {
		millisecond = millisecond / 1000;
		int minute = (int) Math.ceil((millisecond + 0.0d) / 60.0d);
		return minute;
	}
	/*
	 * public static void main(String[] args) { Date start=new Date();
	 * start.setTime(start.getTime()-1000*60*60*24*5); Date date=new Date();
	 * List<Date[]> result=splitByDay(start,date); result.forEach(r->{
	 * System.out.println(r[0].toString() +"--->"+r[1].toString()); }); }
	 */
}
