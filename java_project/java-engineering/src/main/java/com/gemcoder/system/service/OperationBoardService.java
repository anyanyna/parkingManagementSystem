package com.gemcoder.system.service;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gemcoder.system.bo.Result;
import com.gemcoder.system.util.DateTimeUtil;

/**
 * 运营看板
 * 
 * @author jiang *查询参数说明 sector 版块 parking_lot_status 状态 parking_lot_type 类型
 *         parking_lot_name，id 车场
 */
@Service
public class OperationBoardService {
	private static final Logger log = LoggerFactory.getLogger(OperationBoardService.class);
	// static final SimpleDateFormat yyyyMMddSdf = new
	// SimpleDateFormat("yyyy-MM-dd");
	// static final SimpleDateFormat yyyyMMddHHmmssSdf = new
	// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 应收金额
	 * 
	 * @param paramMap
	 * @return
	 */
	public Result getSummary(Map<String, Object> paramMap) {
		// 默认当月数据
		BigDecimal recievableAmount = recievableAmount(paramMap);
		BigDecimal recievedAmount = recievedAmount(paramMap);
		String receivedRatio = receivedRatio(paramMap);
		BigDecimal unitParkingAmount = unitParkingAmount(paramMap);
		Map<String, Object> result = new HashMap<>();
		result.put("receivable_amount", recievableAmount);// 应收
		result.put("received_amount", recievedAmount);// 实收
		result.put("received_ratio", receivedRatio);// 收缴率
		result.put("unit_parking_amount", unitParkingAmount);// 单位泊车收益
		return new Result(true, "Success", result);
	}

	/**
	 * 
	 * @param paramMap
	 * @return
	 */
	public Result getAmountReceivable(Map<String, Object> paramMap) {
		// 默认六个月数据
		SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		String beginDate = paramMap.get("beginDate") != null ? String.valueOf(paramMap.get("beginDate")) : null;
		String endDate = paramMap.get("endDate") != null ? String.valueOf(paramMap.get("endDate")) : null;
		String timeType = paramMap.get("timeType") != null ? String.valueOf(paramMap.get("timeType")) : null;

		if (StringUtils.isEmpty(beginDate) && StringUtils.isEmpty(endDate) && StringUtils.isEmpty(timeType)) {
			beginDate = beginOfMonth(DateTimeUtil.addMonth(new Date(), -6));
			endDate = yyyyMMddSdf.format(new Date());
			timeType = "month";
		}
		String[] formDate = formalTimeFormat(beginDate, endDate);
		beginDate = formDate[0];
		endDate = formDate[1];
		List<String> yardNames = getYardNameList(loadYards(paramMap));
		StringBuilder sql = new StringBuilder(
				"select  sum(receivable_amount) as receivable_amount,${dateType} query_time from user_order where 1=1 ");
		List<Object> params = new ArrayList<>();

		if (yardName != null && yardName.size() == 1) {
			sql.append(" and parking_lot_id=?");
			params.add(trimStr(yardName));
		} else if (yardName != null && yardName.size() > 1) {
			sql.append(" and parking_lot_id in(?");
			params.add(yardName.get(0));
			for (int i = 1; i < yardName.size() - 1; ++i) {
				sql.append(",? ");
				params.add(yardName.get(i));
			}
			sql.append(" ,?) ");
			params.add(yardName.get(yardName.size() - 1));
		}

		if (beginDate != null) {
			sql.append(" and exit_time>=? ");
			params.add(beginDate);
		}
		if (endDate != null) {
			sql.append(" and exit_time<=? ");
			params.add(endDate);
		}
		appendYardListParams(sql, params, yardNames, "parking_lot");
		sql.append(" group by query_time ");
		List<Map<String, Object>> countResult = executeSQL(
				sql.toString().replace("${dateType}", mapDateType(timeType, "exit_time")), params);
		// TODO 补充缺失的数据
		replaceNaN(countResult, "receivable_amount");
		try {
			fillEmpty(countResult, beginDate, endDate, timeType, "receivable_amount", 0);
		} catch (Exception e) {
		}
		return new Result(true, "Success", countResult);
	}

	/**
	 * 实收金额
	 * 
	 * @param paramMap
	 * @return
	 */
	public Result getAmountReceived(Map<String, Object> paramMap) {
		SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		String beginDate = paramMap.get("beginDate") != null ? String.valueOf(paramMap.get("beginDate")) : null;
		String endDate = paramMap.get("endDate") != null ? String.valueOf(paramMap.get("endDate")) : null;
		String timeType = paramMap.get("timeType") != null ? String.valueOf(paramMap.get("timeType")) : null;

		if (StringUtils.isEmpty(beginDate) && StringUtils.isEmpty(endDate) && StringUtils.isEmpty(timeType)) {
			beginDate = beginOfMonth(DateTimeUtil.addMonth(new Date(), -6));
			endDate = yyyyMMddSdf.format(new Date());
			timeType = "month";
		}
		String[] formDate = formalTimeFormat(beginDate, endDate);
		beginDate = formDate[0];
		endDate = formDate[1];
		List<String> yardNames = getYardNameList(loadYards(paramMap));
		StringBuilder sql = new StringBuilder(
				"select  sum(received_amount) as received_amount,${dateType} query_time from user_order where 1=1 ");
		List<Object> params = new ArrayList<>();

		if (yardName != null && yardName.size() == 1) {
			sql.append(" and parking_lot_id=?");
			params.add(trimStr(yardName));
		} else if (yardName != null && yardName.size() > 1) {
			sql.append(" and parking_lot_id in(?");
			params.add(yardName.get(0));
			for (int i = 1; i < yardName.size() - 1; ++i) {
				sql.append(",? ");
				params.add(yardName.get(i));
			}
			sql.append(" ,?) ");
			params.add(yardName.get(yardName.size() - 1));
		}

		if (beginDate != null) {
			sql.append(" and exit_time>=?");
			params.add(beginDate);
		}
		if (endDate != null) {
			sql.append(" and exit_time<=?");
			params.add(endDate);
		}
		appendYardListParams(sql, params, yardNames, "parking_lot");
		sql.append(" group by query_time ");
		List<Map<String, Object>> countResult = executeSQL(
				sql.toString().replace("${dateType}", mapDateType(timeType, "exit_time")), params);
		// TODO 补充缺失的数据
		replaceNaN(countResult, "received_amount");
		try {
			fillEmpty(countResult, beginDate, endDate, timeType, "received_amount", 0);
		} catch (Exception e) {
		}
		return new Result(true, "Success", countResult);
	}

	/**
	 * 收缴率
	 * 
	 * @param paramMap
	 * @return
	 */
	public Result getReceiveAmountRatio(Map<String, Object> paramMap) {
		SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		String beginDate = paramMap.get("beginDate") != null ? String.valueOf(paramMap.get("beginDate")) : null;
		String endDate = paramMap.get("endDate") != null ? String.valueOf(paramMap.get("endDate")) : null;
		String timeType = paramMap.get("timeType") != null ? String.valueOf(paramMap.get("timeType")) : null;

		if (StringUtils.isEmpty(beginDate) && StringUtils.isEmpty(endDate) && StringUtils.isEmpty(timeType)) {
			beginDate = beginOfMonth(DateTimeUtil.addMonth(new Date(), -6));
			endDate = yyyyMMddSdf.format(new Date());
			timeType = "month";
		}
		String[] formDate = formalTimeFormat(beginDate, endDate);
		beginDate = formDate[0];
		endDate = formDate[1];
		List<String> yardNames = getYardNameList(loadYards(paramMap));
		StringBuilder sql = new StringBuilder(
				"select  sum(received_amount)/sum(receivable_amount) as ratio,${dateType} query_time from user_order where 1=1 ");
		List<Object> params = new ArrayList<>();
		if (yardName != null && yardName.size() == 1) {
			sql.append(" and parking_lot_id=?");
			params.add(trimStr(yardName));
		} else if (yardName != null && yardName.size() > 1) {
			sql.append(" and parking_lot_id in(?");
			params.add(yardName.get(0));
			for (int i = 1; i < yardName.size() - 1; ++i) {
				sql.append(",? ");
				params.add(yardName.get(i));
			}
			sql.append(" ,?) ");
			params.add(yardName.get(yardName.size() - 1));
		}
		if (beginDate != null) {
			sql.append(" and exit_time>=?");
			params.add(beginDate);
		}
		if (endDate != null) {
			sql.append(" and exit_time<=?");
			params.add(endDate);
		}
		appendYardListParams(sql, params, yardNames, "parking_lot");
		sql.append(" group by query_time ");
		List<Map<String, Object>> countResult = executeSQL(
				sql.toString().replace("${dateType}", mapDateType(timeType, "exit_time")), params);
		// TODO 补充缺失的数据
		replaceNaN(countResult, "ratio");
		try {
			fillEmpty(countResult, beginDate, endDate, timeType, "ratio", 0);
		} catch (Exception e) {
		}
		return new Result(true, "Success", countResult);
	}

	/**
	 * 服务车次
	 * 
	 * @param paramMap
	 * @return
	 */
	public Result getServVehicleCount(Map<String, Object> paramMap) {
		SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		String beginDate = paramMap.get("beginDate") != null ? String.valueOf(paramMap.get("beginDate")) : null;
		String endDate = paramMap.get("endDate") != null ? String.valueOf(paramMap.get("endDate")) : null;
		String timeType = paramMap.get("timeType") != null ? String.valueOf(paramMap.get("timeType")) : null;

		if (StringUtils.isEmpty(beginDate) && StringUtils.isEmpty(endDate) && StringUtils.isEmpty(timeType)) {
			beginDate = beginOfMonth(DateTimeUtil.addMonth(new Date(), -6));
			endDate = yyyyMMddSdf.format(new Date());
			timeType = "month";
		}
		String[] formDate = formalTimeFormat(beginDate, endDate);
		beginDate = formDate[0];
		endDate = formDate[1];
		List<String> yardNames = getYardNameList(loadYards(paramMap));
		StringBuilder sql = new StringBuilder(
				"select count(1) as vehicle_count,${dateType} query_time from user_order where 1=1 ");
		List<Object> params = new ArrayList<>();
		if (yardName != null && yardName.size() == 1) {
			sql.append(" and parking_lot_id=?");
			params.add(trimStr(yardName));
		} else if (yardName != null && yardName.size() > 1) {
			sql.append(" and parking_lot_id in(?");
			params.add(yardName.get(0));
			for (int i = 1; i < yardName.size() - 1; ++i) {
				sql.append(",? ");
				params.add(yardName.get(i));
			}
			sql.append(" ,?) ");
			params.add(yardName.get(yardName.size() - 1));
		}
		if (beginDate != null) {
			sql.append(" and exit_time>=?");
			params.add(beginDate);
		}
		if (endDate != null) {
			sql.append(" and exit_time<=?");
			params.add(endDate);
		}
		appendYardListParams(sql, params, yardNames, "parking_lot");
		sql.append(" group by query_time");

		List<Map<String, Object>> countResult = executeSQL(
				sql.toString().replace("${dateType}", mapDateType(timeType, "exit_time")), params);
		// TODO 补充缺失的数据
		replaceNaN(countResult, "vehicle_count");
		try {
			fillEmpty(countResult, beginDate, endDate, timeType, "vehicle_count", 0);
		} catch (Exception e) {
		}
		return new Result(true, "Success", countResult);
	}

	public Result getYardList(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> countResult = executeSQL("select id,parking_lot_name from parking_lot_info");
		return new Result(true, "Success", countResult);
	}

	/**
	 * 应收 默认当月数据
	 * 
	 * @param paramMap
	 * @return
	 */
	private BigDecimal recievableAmount(Map<String, Object> paramMap) {
		SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		String beginDate = paramMap.get("beginDate") != null ? String.valueOf(paramMap.get("beginDate")) : null;
		String endDate = paramMap.get("endDate") != null ? String.valueOf(paramMap.get("endDate")) : null;
		String timeType = paramMap.get("timeType") != null ? String.valueOf(paramMap.get("timeType")) : null;

		if (StringUtils.isEmpty(beginDate) && StringUtils.isEmpty(endDate)) {
			beginDate = beginOfMonth(new Date());
			endDate = yyyyMMddHHmmssSdf.format(new Date());
			timeType = "month";
		}
		String[] formDate = formalTimeFormat(beginDate, endDate);
		beginDate = formDate[0];
		endDate = formDate[1];
		List<String> yardNames = getYardNameList(loadYards(paramMap));
		StringBuilder sql = new StringBuilder(
				"select sum(receivable_amount) receivable_amount from user_order where 1=1 ");
		List<Object> params = new ArrayList<>();
		if (yardName != null && yardName.size() == 1) {
			sql.append(" and parking_lot_id=?");
			params.add(trimStr(yardName));
		} else if (yardName != null && yardName.size() > 1) {
			sql.append(" and parking_lot_id in(?");
			params.add(yardName.get(0));
			for (int i = 1; i < yardName.size() - 1; ++i) {
				sql.append(",? ");
				params.add(yardName.get(i));
			}
			sql.append(" ,?) ");
			params.add(yardName.get(yardName.size() - 1));
		}
		if (beginDate != null) {
			sql.append(" and exit_time>=?");
			params.add(beginDate);
		}
		if (endDate != null) {
			sql.append(" and exit_time<=?");
			params.add(endDate);
		}
		appendYardListParams(sql, params, yardNames, "parking_lot");
		List<Map<String, Object>> singleResult = executeSQL(sql.toString(), params);
		if (singleResult == null || singleResult.isEmpty() || singleResult.get(0).get("receivable_amount") == null) {
			return BigDecimal.ZERO;
		}
		BigDecimal rst = (BigDecimal) singleResult.get(0).get("receivable_amount");
		if (rst == null) {
			return BigDecimal.ZERO;
		}
		return rst;
	}

	/**
	 * 实收
	 * 
	 * @param paramMap
	 * @return
	 */
	private BigDecimal recievedAmount(Map<String, Object> paramMap) {
		SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		String beginDate = paramMap.get("beginDate") != null ? String.valueOf(paramMap.get("beginDate")) : null;
		String endDate = paramMap.get("endDate") != null ? String.valueOf(paramMap.get("endDate")) : null;
		String timeType = paramMap.get("timeType") != null ? String.valueOf(paramMap.get("timeType")) : null;

		if (StringUtils.isEmpty(beginDate) && StringUtils.isEmpty(endDate)) {
			beginDate = beginOfMonth(new Date());
			endDate = yyyyMMddHHmmssSdf.format(new Date());
			timeType = "month";
		}
		String[] formDate = formalTimeFormat(beginDate, endDate);
		beginDate = formDate[0];
		endDate = formDate[1];
		List<String> yardNames = getYardNameList(loadYards(paramMap));
		StringBuilder sql = new StringBuilder("select sum(received_amount) received_amount from user_order where 1=1 ");
		List<Object> params = new ArrayList<>();
		if (yardName != null && yardName.size() == 1) {
			sql.append(" and parking_lot_id=?");
			params.add(trimStr(yardName));
		} else if (yardName != null && yardName.size() > 1) {
			sql.append(" and parking_lot_id in(?");
			params.add(yardName.get(0));
			for (int i = 1; i < yardName.size() - 1; ++i) {
				sql.append(",? ");
				params.add(yardName.get(i));
			}
			sql.append(" ,?) ");
			params.add(yardName.get(yardName.size() - 1));
		}
		if (beginDate != null) {
			sql.append(" and exit_time>=?");
			params.add(beginDate);
		}
		if (endDate != null) {
			sql.append(" and exit_time<=?");
			params.add(endDate);
		}
		appendYardListParams(sql, params, yardNames, "parking_lot");
		List<Map<String, Object>> singleResult = executeSQL(sql.toString(), params);
		if (singleResult == null || singleResult.isEmpty() || singleResult.get(0).get("received_amount") == null) {
			return BigDecimal.ZERO;
		}
		BigDecimal rst = (BigDecimal) singleResult.get(0).get("received_amount");
		return rst;
	}

	/**
	 * 收缴率
	 * 
	 * @param paramMap
	 * @return
	 */
	private String receivedRatio(Map<String, Object> paramMap) {
		SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		String beginDate = paramMap.get("beginDate") != null ? String.valueOf(paramMap.get("beginDate")) : null;
		String endDate = paramMap.get("endDate") != null ? String.valueOf(paramMap.get("endDate")) : null;
		String timeType = paramMap.get("timeType") != null ? String.valueOf(paramMap.get("timeType")) : null;

		if (StringUtils.isEmpty(beginDate) && StringUtils.isEmpty(endDate)) {
			beginDate = beginOfMonth(new Date());
			endDate = yyyyMMddHHmmssSdf.format(new Date());
			timeType = "month";
		}
		String[] formDate = formalTimeFormat(beginDate, endDate);
		beginDate = formDate[0];
		endDate = formDate[1];
		List<String> yardNames = getYardNameList(loadYards(paramMap));
		StringBuilder sql = new StringBuilder(
				"select sum(received_amount)/sum(receivable_amount) received_ratio from user_order where 1=1 ");
		List<Object> params = new ArrayList<>();
		if (yardName != null && yardName.size() == 1) {
			sql.append(" and parking_lot=?");
			params.add(trimStr(yardName));
		} else if (yardName != null && yardName.size() > 1) {
			sql.append(" and parking_lot in(?");
			params.add(yardName.get(0));
			for (int i = 1; i < yardName.size() - 1; ++i) {
				sql.append(",? ");
				params.add(yardName.get(i));
			}
			sql.append(" ,?) ");
			params.add(yardName.get(yardName.size() - 1));
		}
		if (beginDate != null) {
			sql.append(" and exit_time>=?");
			params.add(beginDate);
		}
		if (endDate != null) {
			sql.append(" and exit_time<=?");
			params.add(endDate);
		}
		appendYardListParams(sql, params, yardNames, "parking_lot");
		List<Map<String, Object>> singleResult = executeSQL(sql.toString(), params);
		if (singleResult == null || singleResult.isEmpty() || singleResult.get(0).get("received_ratio") == null) {
			return "0";
		}
		Double rst = Double.parseDouble(singleResult.get(0).get("received_ratio").toString());
		rst=safeDouble(rst);
		return String.format("%.2f", rst);
	}

	/**
	 * 单位停车金额
	 * 
	 * @param paramMap
	 * @return
	 */
	private BigDecimal unitParkingAmount(Map<String, Object> paramMap) {
		SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List yardName = paramMap.get("yardName") != null ? (List) (paramMap.get("yardName")) : null;
		String beginDate = paramMap.get("beginDate") != null ? String.valueOf(paramMap.get("beginDate")) : null;
		String endDate = paramMap.get("endDate") != null ? String.valueOf(paramMap.get("endDate")) : null;
		String timeType = paramMap.get("timeType") != null ? String.valueOf(paramMap.get("timeType")) : null;

		if (StringUtils.isEmpty(beginDate) && StringUtils.isEmpty(endDate)) {
			beginDate = beginOfMonth(new Date());
			endDate = yyyyMMddHHmmssSdf.format(new Date());
			timeType = "month";
		}
		String[] formDate = formalTimeFormat(beginDate, endDate);
		beginDate = formDate[0];
		endDate = formDate[1];
		List<String> yardNames = getYardNameList(loadYards(paramMap));
		StringBuilder sql = new StringBuilder("select avg(received_amount) avg_amount from user_order where 1=1 ");
		List<Object> params = new ArrayList<>();

		if (yardName != null && yardName.size() == 1) {
			sql.append(" and parking_lot_id=?");
			params.add(trimStr(yardName));
		} else if (yardName != null && yardName.size() > 1) {
			sql.append(" and parking_lot_id in(?");
			params.add(yardName.get(0));
			for (int i = 1; i < yardName.size() - 1; ++i) {
				sql.append(",? ");
				params.add(yardName.get(i));
			}
			sql.append(" ,?) ");
			params.add(yardName.get(yardName.size() - 1));
		}

		if (beginDate != null) {
			sql.append(" and exit_time>=?");
			params.add(beginDate);
		}
		if (endDate != null) {
			sql.append(" and exit_time<=?");
			params.add(endDate);
		}
		appendYardListParams(sql, params, yardNames, "parking_lot");
		List<Map<String, Object>> singleResult = executeSQL(sql.toString(), params);
		if (singleResult == null || singleResult.isEmpty() || singleResult.get(0).get("avg_amount") == null) {
			return BigDecimal.ZERO;
		}
		BigDecimal rst = (BigDecimal) singleResult.get(0).get("avg_amount");
		return rst;
	}

	private void appendYardListParams(StringBuilder sql, List<Object> params, List<String> yardNames,
			String yardNameField) {
		if (yardNames != null && !yardNames.isEmpty()) {
			if (yardNames.size() == 1) {
				sql.append(" and " + yardNameField + "=?");
				params.add(yardNames.get(0));
			} else {
				sql.append(" and " + yardNameField + " in(?");
				params.add(yardNames.get(0));
				for (int i = 1; i < yardNames.size() - 1; ++i) {
					sql.append(",?");
					params.add(yardNames.get(i));
				}
				sql.append(",?) ");
				params.add(yardNames.get(yardNames.size() - 1));
			}
		}
	}

	private List<String> getYardNameList(List<Map<String, Object>> yardList) {
		List<String> yardnames = new ArrayList<>();
		if (yardList == null || yardList.isEmpty()) {
			return yardnames;
		}
		yardList.forEach(m -> {
			String parking_lot_name = (String) m.get("parking_lot_name");
			if (parking_lot_name != null) {
				yardnames.add(parking_lot_name);
			}
		});
		return yardnames;
	}

	private List<Map<String, Object>> loadYards(Map<String, Object> paramMap) {
		List<String> type = paramMap.get("type") != null ? (List<String>) (paramMap.get("type")) : null;
		List<String> status = paramMap.get("status") != null ? (List<String>) (paramMap.get("status")) : null;
		List<String> sector = paramMap.get("sector") != null ? (List<String>) (paramMap.get("sector")) : null;
		return loadYards(type, status, sector);
	}

	private List<Map<String, Object>> loadYards(List<String> type, List<String> status, List<String> sector) {
		StringBuilder sql = new StringBuilder(
				"select id,parking_lot_code,parking_lot_name from parking_lot_info where 1=1 ");
		List<Object> params = new ArrayList<>();
		if (type != null && type.size() == 1) {
			sql.append(" and parking_lot_type=?");
			params.add(type);
		} else if (type != null && type.size() > 1) {
			sql.append(" and parking_lot_type in(?");
			params.add(type.get(0));
			for (int i = 1; i < type.size() - 1; ++i) {
				sql.append(",? ");
				params.add(type.get(i));
			}
			sql.append(" ,?) ");
			params.add(type.get(type.size() - 1));
		}

		if (status != null && status.size() == 1) {
			sql.append(" and parking_lot_status=?");
			params.add(status);
		} else if (status != null && status.size() > 1) {
			sql.append(" and parking_lot_status in(?");
			params.add(status.get(0));
			for (int i = 1; i < status.size() - 1; ++i) {
				sql.append(",? ");
				params.add(status.get(i));
			}
			sql.append(" ,?) ");
			params.add(status.get(status.size() - 1));
		}

		if (sector != null && sector.size() == 1) {
			sql.append(" and parking_lot_status=?");
			params.add(sector);
		} else if (sector != null && sector.size() > 1) {
			sql.append(" and parking_lot_status in(?");
			params.add(sector.get(0));
			for (int i = 1; i < sector.size() - 1; ++i) {
				sql.append(",? ");
				params.add(sector.get(i));
			}
			sql.append(" ,?) ");
			params.add(sector.get(sector.size() - 1));
		}

		List<Map<String, Object>> yardResult = executeSQL(sql.toString(), params);
		return yardResult;
	}

	private void fillEmptyByDay(List<Map<String, Object>> list, String begin, String end, String defaultKey,
			Object defaultValue, long step) throws Exception {
		// TODO Auto-generated method stub
		if (begin.length() > 10) {
			begin = begin.substring(0, 10);
		}
		if (end.length() > 10) {
			end = end.substring(0, 10);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// list.sort((o1, o2) -> ((Date) o1.get("query_time")).compareTo((Date)
		// o2.get("query_time")));
		Date currentDate = sdf.parse(begin);
		Date endDate = sdf.parse(end);
		while (!currentDate.after(endDate)) {
			boolean find = false;
			for (Map<String, Object> m : list) {
				if (m.get("query_time").toString().equals((sdf.format(currentDate)))) {
					find = true;
					break;
				}
			}
			if (!find) {
				Map<String, Object> item = new HashMap<>();
				item.put("query_time", sdf.format(currentDate));
				item.put(defaultKey, defaultValue);
				list.add(item);
			}

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(currentDate);
			// 增加一个月
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			currentDate.setTime(calendar.getTimeInMillis());
		}
		list.sort((o1, o2) -> {
			try {
				Date s1 = sdf.parse((String) o1.get("query_time"));
				Date s2 = sdf.parse((String) o2.get("query_time"));
				return s1.compareTo(s2);
			} catch (Exception e) {
				return 0;
			}
		});
	}

	private void fillEmptyByMonth(List<Map<String, Object>> list, String begin, String end, String defaultKey,
			Object defaultValue) throws Exception {
		// TODO Auto-generated method stub
		if (begin.length() > 10) {
			begin = begin.substring(0, 10);
		}
		if (end.length() > 10) {
			end = end.substring(0, 10);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM");
		// Date currentDate = new Date(begin.getTime());
		// Date endDate = new Date(end.getTime());
		Date currentDate = sdf.parse(begin);
		Date endDate = sdf.parse(end);

		while (!currentDate.after(endDate)) {
			boolean find = false;
			for (Map<String, Object> m : list) {
				if (m.get("query_time").equals((sdf2.format(currentDate)))) {
					find = true;
					break;
				}
			}
			if (!find) {
				Map<String, Object> item = new HashMap<>();
				item.put("query_time", sdf2.format(currentDate));
				item.put(defaultKey, defaultValue);
				list.add(item);
			}
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(currentDate);
			// 增加一个月
			calendar.add(Calendar.MONTH, 1);
			currentDate.setTime(calendar.getTimeInMillis());
		}

		list.sort((o1, o2) -> {
			try {
				Date s1 = sdf.parse((String) o1.get("query_time") + "-01");
				Date s2 = sdf.parse((String) o2.get("query_time") + "-01");
				return s1.compareTo(s2);
			} catch (Exception e) {
				return 0;
			}
		});
	}

	// yyyy-MN-dd HH:mm:ss
	private void fillEmptyByHour(List<Map<String, Object>> list, String begin, String end, String defaultKey,
			Object defaultValue) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		list.sort((o1, o2) -> ((Date) o1.get("create_time")).compareTo((Date) o2.get("create_time")));
		Date currentDate = sdf.parse(begin);// new Date(begin.getTime());
		Date endDate = sdf.parse(end); // new Date(end.getTime());
		while (!currentDate.after(endDate)) {
			boolean find = false;
			for (Map<String, Object> m : list) {
				if (m.get("query_time").toString().equals(sdf.format(currentDate))) {
					find = true;
					break;
				}
			}
			if (!find) {
				Map<String, Object> item = new HashMap<>();
				item.put("query_time", sdf.format(currentDate));
				item.put(defaultKey, defaultValue);
				list.add(item);
			}

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(currentDate);
			// 增加一个月
			calendar.add(Calendar.HOUR, 1);
			currentDate.setTime(calendar.getTimeInMillis());
		}

		list.sort((o1, o2) -> {
			try {
				Date s1 = sdf.parse((String) o1.get("query_time"));
				Date s2 = sdf.parse((String) o2.get("query_time"));
				return s1.compareTo(s2);
			} catch (Exception e) {
				return 0;
			}
		});
	}

	private void fillEmptyByYear(List<Map<String, Object>> list, String begin, String end, String defaultKey,
			Object defaultValue) {
		// TODO Auto-generated method stub
		if (begin.length() > 4) {
			begin = begin.substring(0, 4);
		}
		if (end.length() > 4) {
			end = end.substring(0, 4);
		}
		list.sort((o1, o2) -> ((Date) o1.get("query_time")).compareTo((Date) o2.get("query_time")));
		AtomicInteger currentDate = new AtomicInteger(Integer.parseInt(begin));
		AtomicInteger endDate = new AtomicInteger(Integer.parseInt(end));
		while (!(currentDate.intValue() > endDate.intValue())) {
			boolean find = false;
			for (Map<String, Object> m : list) {
				if (m.get("query_time").toString().equals((String.valueOf(currentDate)))) {
					find = true;
					break;
				}
			}
			if (!find) {
				Map<String, Object> item = new HashMap<>();
				item.put("query_time", String.valueOf(currentDate));
				item.put(defaultKey, defaultValue);
				list.add(item);
			}
			currentDate.addAndGet(1);
		}
		list.sort((o1, o2) -> {
			try {
				Integer s1 = Integer.parseInt((String) o1.get("query_time"));
				Integer s2 = Integer.parseInt((String) o2.get("query_time"));
				return s1.compareTo(s2);
			} catch (Exception e) {
				return 0;
			}
		});
	}

	private void fillEmpty(List<Map<String, Object>> list, String begin, String end, String timeType, String defaultKey,
			Object defaultValue) throws Exception {
		if (1 == 1) {
			// return;
		}
		if ("日".equals(timeType) || "day".equals(timeType) || "date".equals(timeType)) {
			fillEmptyByDay(list, begin, end, defaultKey, defaultValue, 1000L * 60 * 60 * 24);
		} else if ("月".equals(timeType) || "month".equals(timeType)) {
			fillEmptyByMonth(list, begin, end, defaultKey, defaultValue);
		} else if ("年".equals(timeType) || "year".equals(timeType)) {
			fillEmptyByYear(list, begin, end, defaultKey, defaultValue);
		} else {
			fillEmptyByHour(list, begin, end, defaultKey, defaultValue);
		}
	}

	private void replaceNaN(List<Map<String, Object>> list, String fieldName) {
		list.forEach(m -> {
			Object obj = m.get(fieldName);
			if (obj == null) {
				m.put(fieldName, 0);
			} else if (obj instanceof Double) {
				double d = (double) obj;
				if (Double.isInfinite(d) || Double.isNaN(d)) {
					m.put(fieldName, 0);
				}
			}
		});
	}

	private String mapDateType(String dateType, String field) {
		if (dateType == null) {
			return "DATE_FORMAT(" + field + ", '%Y-%m-%d') ";
		}
		if ("hour".equals(dateType) || "小时".equals(dateType) || "时".equals(dateType)) {
			return "hour(" + field + ") ";
		}
		if ("day".equals(dateType) || "date".equals(dateType) || "日".equals(dateType)) {
			return "DATE_FORMAT(" + field + ", '%Y-%m-%d') ";
		}
		if ("month".equals(dateType) || "月".equals(dateType)) {
			return "DATE_FORMAT(" + field + ", '%Y-%m') ";
		}
		if ("year".equals(dateType) || "年".equals(dateType)) {
			return "DATE_FORMAT(" + field + ", '%Y') ";
		}
		return "DATE_FORMAT(" + field + ", '%Y-%m-%d') ";
	}

	private String beginOfMonth(Date date) {
		SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		date.setDate(1);
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		return yyyyMMddSdf.format(date);
	}

	/**
	 * 处理 yyyy yyyy-MM yyyy-MM-dd 不同形式数据
	 * 
	 * @param beginDate
	 * @param endDate
	 * @param sqlBuilder
	 * @param params
	 * @param dateField
	 */
	private String[] formalTimeFormat(String beginDate, String endDate) {
		SimpleDateFormat yyyyMMddSdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat yyyyMMddHHmmssSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (beginDate == null || endDate == null) {
			return new String[] { beginDate, endDate };
		}
		if (beginDate != null && beginDate.trim().length() <= 4) {
			// 年
			beginDate = beginDate.trim() + "-01-01 00:00:00";
		} else if (beginDate != null && beginDate.trim().length() <= 7) {
			beginDate = beginDate.trim() + "-01 00:00:00";
		} else {
			if (beginDate.length() < 19) {
				beginDate = beginDate.trim() + " 00:00:00";
			}
		}
		if (endDate != null && endDate.trim().length() <= 4) {
			// 年
			endDate = endDate.trim() + "-12-31 23:59:59";
		} else if (endDate != null && endDate.trim().length() <= 7) {
			// 月
			String ed = endDate.trim() + "-01 23:59:59";
			try {
				Date dt = yyyyMMddHHmmssSdf.parse(ed);
				dt = DateTimeUtil.monthEnd(dt);
				endDate = yyyyMMddHHmmssSdf.format(dt);
			} catch (Exception e) {
				log.error(endDate, e);
			}
			// endDate=endDate+"-31 23:59:59";
		} else {
			Date endtime = new Date();
			try {
				endtime = yyyyMMddSdf.parse(endDate);
			} catch (Exception e) {
				log.error(endDate, e);
			}
			endtime.setHours(23);
			endtime.setMinutes(59);
			endtime.setSeconds(59);
			endDate = yyyyMMddHHmmssSdf.format(endtime);
		}
		return new String[] { beginDate, endDate };
	}

	private String trimStr(Object str) {
		if (str == null) {
			return null;
		}
		return str.toString().replace('[', ' ').replace(']', ' ').replace(',', ' ').trim();
	}

	private double safeDouble(Double d) {
		if (d == null) {
			return 0d;
		}
		if (Double.isNaN(d) || Double.isInfinite(d)) {
			return 0d;
		}
		return d;
	}
	/*
	 * public static void main(String[] aegs) { String[]
	 * a=formalTimeFormat("2000","2023"); String[]
	 * b=formalTimeFormat("2000-01","2023-02"); String[]
	 * c=formalTimeFormat("2000-01-12","2023-02-23"); System.out.println(a[0]);
	 * System.out.println(a[1]); System.out.println(b[0]); System.out.println(b[1]);
	 * System.out.println(c[0]); System.out.println(c[1]); }
	 */

}
