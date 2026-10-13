package com.gemcoder.system.job;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.BarrierGateEquipmentBo;
import com.gemcoder.system.bo.OrderMoneyBo;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.component.MinioUtil;
import com.gemcoder.system.config.MinIOConfig;
import com.gemcoder.system.service.BarrierGateEquipmentService;
import com.gemcoder.system.service.BusinesslogicService;
import com.gemcoder.system.service.DepotconfigurationService;
import com.gemcoder.system.service.MoneyCaculateService;
import com.gemcoder.system.service.ParkingordersService;
import com.gemcoder.system.service.ScanYardCodeService;
import com.gemcoder.system.service.VehicleInYardService;
import com.gemcoder.system.service.VehicleOutYardService;
import com.gemcoder.system.service.VehiclemanagementService;
import com.gemcoder.system.util.OrderPaymentChannelConstant;
import com.gemcoder.system.util.OrderRemarkConstant;
import com.gemcoder.system.util.OrderSourceConstants;
import com.gemcoder.system.util.OrderStatusConstant;
import com.gemcoder.system.util.WsJsonUtil;
import com.gemcoder.system.ws.CommandService;
import com.gemcoder.system.ws.GlobalMessageCacheManager;
import com.gemcoder.system.ws.NewRegisterCmdCacheManager;
import com.gemcoder.system.ws.VehicleInCacheManager;
import com.gemcoder.system.ws.VehicleRecord;

/**
 * 处理收到的道闸数据
 * 
 * @author jiang
 *
 */
@Order(value = 200)
@Component
public class BarrierGateEquipmentDataJob implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(BarrierGateEquipmentDataJob.class);
	private VehicleInCacheManager vehicleInCacheManager = VehicleInCacheManager.getInstance();
	private GlobalMessageCacheManager globalMessageCacheManager = GlobalMessageCacheManager.getInstance();
	private NewRegisterCmdCacheManager newRegisterCmdCacheManager = NewRegisterCmdCacheManager.getInstance();
	@Resource
	MoneyCaculateService moneyCaculateService;
	@Resource
	BusinesslogicService businesslogicService;
	@Resource
	BarrierGateEquipmentService barrierGateEquipmentService;
	@Resource
	DepotconfigurationService depotconfigurationService;
	@Resource
	VehiclemanagementService vehiclemanagementService;
	@Resource
	ParkingordersService parkingordersService;
	@Resource
	CommandService commandService;
	@Resource
	ScanYardCodeService scanYardCodeService;
	@Resource
	MinioUtil minioUtil;
	/**
	 * 进场处理service
	 */
	@Resource
	VehicleInYardService vehicleInYardService;
	@Resource
	VehicleOutYardService vehicleOutYardService;
	// 处理进场数据
	ExecutorService inYardEs = Executors.newSingleThreadExecutor();
	// 处理出场数据
	ExecutorService outYardEs = Executors.newSingleThreadExecutor();
	//
	ExecutorService workersEs = Executors.newWorkStealingPool();
	ExecutorService updateBarrierGateWquipmentEs = Executors.newSingleThreadExecutor();
	volatile Map<String, BarrierGateEquipmentBo> barrierGateEquipmentBoMap = new ConcurrentHashMap<>();
	// 需要循环检查是否支付，需要多线程避免阻塞其他车辆出场
	ExecutorService checkOpenTask = Executors.newScheduledThreadPool(4);
	Map<String, Integer> yardcode2IdMap = new ConcurrentHashMap<>();
	volatile long yardcode2IdMapUpdateTime = 0;

	Map<String, Pair> lastCamCacheMap = new ConcurrentHashMap<>();

	static int max_timespan = 1000 * 60;

	/**
	 * 初始化 taos 数据库 流计算表
	 */
	@Override
	public void run(String... args) throws Exception {
		log.info("BarrierGateEquipmentDataJob start");
		inYardEs.submit(new Runnable() {

			@Override
			public void run() {
				handleInYardData();
			}

		});
		outYardEs.submit(new Runnable() {

			@Override
			public void run() {
				handleOutYardData();
			}
		});
		updateBarrierGateWquipmentEs.submit(new Runnable() {

			@Override
			public void run() {
				updateBarrierGateEquipment();
			}
		});
	}

	private void handleInYardData() {
		while (true) {
			try {
				VehicleRecord vr = vehicleInCacheManager.getInYardRecord();
				if (vr == null) {
					continue;
				}
				/**
				 * 原始记录入库
				 */
				vehiclemanagementService.saveVehicleRawInoutRecord(vr);

				// 写订单数据库
				JSONObject jsonObj = vr.getMsgBody();
				String cameId = vr.getCam_id();
				// jsonObj
				BarrierGateEquipmentBo barrierGateEquipmentBo = barrierGateEquipmentBoMap.get(cameId);
				if (barrierGateEquipmentBo == null) {
					log.info("设备表中不存在此设备：{}", cameId);
					continue;
				}
				String licensePlate = jsonObj.getString("plate_num");
				if (isNullLicensePlate(licensePlate)) {
					handleNoLicensePlateIn(vr);
				}
				Integer plate_type = (Integer) jsonObj.getInteger("plate_type");
				String plate_color = (String) jsonObj.getString("plate_color");
				String license_plate_type = WsJsonUtil.mapPlateType(plate_color, plate_type);
				Result r = vehicleInYardService.vehicleInYard(OrderSourceConstants.camAuto,
						barrierGateEquipmentBo.getParking_lot_info_id(), cameId, licensePlate, license_plate_type);

				saveMinIOPic(vr);
				String full_pic_path = vr.getMsgBody().getString("full_pic_path");
				String plate_num = vr.getMsgBody().getString("plate_num");
				updateInPic(plate_num, full_pic_path);

				if (!r.isFlag()) {
					log.info("进场失败，{}", r.getMessage());
				}
			} catch (Exception e) {
				log.warn(e.toString(), e);
			}
		}
	}

	private void handleOutYardData() {
		while (true) {
			try {
				VehicleRecord vr = vehicleInCacheManager.getOutYardRecord();
				if (vr == null) {
					continue;
				}

				vehiclemanagementService.saveVehicleRawInoutRecord(vr);
				saveMinIOPic(vr);
				final String full_pic_path = vr.getMsgBody().getString("full_pic_path");
				final String plate_num = vr.getMsgBody().getString("plate_num");
				// 写订单数据库
				JSONObject jsonObj = vr.getMsgBody();
				String cameId = vr.getCam_id();
				// jsonObj
				BarrierGateEquipmentBo barrierGateEquipmentBo = barrierGateEquipmentBoMap.get(cameId);
				if (barrierGateEquipmentBo == null) {
					log.info("设备表中不存在此设CameraWebSocketHandler备：{}", cameId);
					continue;
				}
				String licensePlate = jsonObj.getString("plate_num");
				if (isNullLicensePlate(licensePlate)) {
					handleNoLicensePlateOut(vr);
					continue;
				}
				// 判断运营规则，处理黑名单问题
				// 停车场出场扫码关闭情况下，如果经过计算，属于免费车，直接开闸放行，结算订单
				// 相机道闸接收到上报数据（有车牌）。
				// 后台查询订单判断是否提前交费订单
				// 如果是提前交费订单发送抬杆命令。
				// 如果不是提前交费订单，将上报数据放入缓存

				// 获取订单
				Future<String> fu = workersEs.submit(new Callable<String>() {

					@Override
					public String call() {
						try {
							Pair oldpair = lastCamCacheMap.get(cameId);
							lastCamCacheMap.put(cameId, new Pair(plate_num));
							if (oldpair != null) {
								if (Objects.equals(oldpair.plat_num, plate_num)) {
									if (oldpair.timestamp + max_timespan > System.currentTimeMillis()) {
										log.info("重复出场记录：{},{},{}",plate_num,cameId,full_pic_path);
										return "重复出场记录";
									}
								}
							}

							int parking_lot_info_id = barrierGateEquipmentBo.getParking_lot_info_id();
							List<Map<String, Object>> userOrderlist = parkingordersService.getLatestParkingOrdersList(
									licensePlate, parking_lot_info_id, OrderStatusConstant.inYard);
							if (userOrderlist == null || userOrderlist.isEmpty()) {
								globalMessageCacheManager.putCurrentVehicleRecord(cameId, vr);
								String plate_num = vr.getPlate_num();
								scanYardCodeService.handleNoOrder(OrderSourceConstants.camAuto, true,
										parking_lot_info_id, cameId, plate_num, vr);
								log.info("没有订单：{},{}", licensePlate, parking_lot_info_id);
								
								List<Map<String, Object>> operation_rulesList = executeSQL(
										"select * from operation_rules where parking_lot_id=?", parking_lot_info_id);
								if (operation_rulesList != null &&! operation_rulesList.isEmpty()) {
									String abnormal_handling_duplicate = (String) operation_rulesList.get(0).get("abnormal_handling_no_in_car");
									if(abnormal_handling_duplicate!=null&&abnormal_handling_duplicate.contains("放行")) {
										//无驶入车放行
										if(abnormal_handling_duplicate.contains("拉黑")){
											Integer abnormal_duplicate_block_time = (Integer) operation_rulesList.get(0)
													.get("abnormal_no_in_car_block_time");
											Date endTime = new Date();
											if(abnormal_duplicate_block_time==null) {
												abnormal_duplicate_block_time=0;
											}
											endTime.setTime(endTime.getTime() + abnormal_duplicate_block_time * 24 * 60 * 60 * 1000L);
											executeSQL("insert into vehicle_block_list (parking_lot_id,plate_num,start_time,end_time,plate_type,status,remark,create_username,update_username,vehicle_list_code) values(?,?,?,?,?,?,?,?)",
													"["+parking_lot_info_id+"]", plate_num, new Date(), endTime, plate_num,null,"生效中","车场配置:放行拉黑","sysAdmin","sysAdmin","Blacklist");
										}
										commandService.openBarier(vr, true);
									}
								}
								
								return "没有订单";
							}
							Map<String, Object> uorder = userOrderlist.get(0);

							updatePicOut(uorder, vr);

							if (vehicleOutYardService.isInBlackList(licensePlate, parking_lot_info_id)) {
								log.info("黑名单车辆：{},{}", licensePlate, parking_lot_info_id);
								return "黑名单车辆";
							}
							if (handleFreeVehicle(uorder, barrierGateEquipmentBo, vr)) {
								commandService.openBarier(vr, true);
								parkingordersService.updateLiftTime(uorder.get("id"));
								log.info("免费车辆。直接放行：{},{},{}", licensePlate, uorder.get("id"), cameId);
								return "免费车辆。直接放行";
							}

							String payment_status = (String) uorder.get("payment_status");
							if (payment_status == null) {
								globalMessageCacheManager.putCurrentVehicleRecord(cameId, vr);
								log.info("没有支付：{},{},{}", licensePlate, uorder.get("id"), cameId);
								return "没有支付";
							}
							if ("已支付,待离场".equals(payment_status) || "已支付，待离场".equals(payment_status)) {
								// 完成订单，抬杆
								Map<String, Object> paramMap = new HashMap<>();
								paramMap.put("id", uorder.get("id"));
								paramMap.put("order_status", "已完结");
								paramMap.put("cam_id", vr.getCam_id());
								parkingordersService.completeOrder(paramMap);
								commandService.openBarier(vr, true);
								log.info("完成订单，抬杆,{},{},{}", licensePlate, uorder.get("id"), cameId);
								return "完成订单，抬杆";
							}
							globalMessageCacheManager.putCurrentVehicleRecord(cameId, vr);
							return "没有支付";
						} catch (Throwable t) {
							log.warn(t.toString(), t);
							return t.getMessage();
						}
					}

				});

			} catch (Throwable e) {
				log.warn(e.toString(), e);
			}
		}
	}

	/**
	 * 如果有不用扫码直接放行规则，并且当前是免费车辆，直接抬杆放行，并完结订单
	 * 
	 * @param uorder
	 * @param barrierGateEquipmentBo
	 * @param vr
	 * @return
	 */
	private boolean handleFreeVehicle(Map<String, Object> userOrder, BarrierGateEquipmentBo barrierGateEquipmentBo,
			VehicleRecord vehicleRecord) {
		Integer parking_lot_id = (Integer) userOrder.get("parking_lot_id");
		Map<String, Object> yardRule = depotconfigurationService.getOperationRulesByYardId(parking_lot_id);
		if (yardRule == null) {
			return false;
		}
		String exit_scan = (String) yardRule.get("exit_scan");
		if (exit_scan == null) {
			return false;
		}
		if ("关闭".equals(exit_scan)) {
			return _handleFreeVehicle(parking_lot_id, userOrder, barrierGateEquipmentBo, vehicleRecord);
		}
		return false;

	}

	/**
	 * 计算费用，如果符合规则直接放行
	 * 
	 * @param userOrder
	 * @param barrierGateEquipmentBo
	 * @param vehicleRecord
	 * @return
	 */
	private boolean _handleFreeVehicle(Integer parking_lot_id, Map<String, Object> userOrder,
			BarrierGateEquipmentBo barrierGateEquipmentBo, VehicleRecord vehicleRecord) {
		String license_type = (String) userOrder.get("license_type");
		String license_plate = (String) userOrder.get("license_plate");
		boolean isWhite = false;
		boolean isNewEnergy = false;
		if ("白牌".equals(license_type)) {
			isWhite = true;
		}
		if ("绿牌".equals(license_type) || "黄绿牌".equals(license_type) || "黄绿".equals(license_type)) {
			isNewEnergy = true;
		}
		Date exitTime = new Date();
		try {
			OrderMoneyBo bo = moneyCaculateService.caculateBilllingMoney(license_plate, parking_lot_id, isNewEnergy,
					isWhite, exitTime);
			if (!BigDecimal.ZERO.equals(bo.getMoney())) {
				{
					// TODO
					log.info("测试计费");
					String payment_channel = OrderPaymentChannelConstant.voucher;
					Result r = parkingordersService._settlementOrder((Integer) userOrder.get("id"), false,
							payment_channel, exitTime, userOrder, bo);
					Map<String, Object> paramMap = new HashMap<>();
					paramMap.put("id", userOrder.get("id"));
					paramMap.put("receivedAmount", "0");
					paramMap.put("order_status", OrderStatusConstant.complete);
					paramMap.put("cam_id", vehicleRecord.getCam_id());
					parkingordersService.completeOrder(paramMap);
				}
				return false;
			}
			String payment_channel = OrderPaymentChannelConstant.online;

			Result r = parkingordersService._settlementOrder((Integer) userOrder.get("id"), false, payment_channel,
					exitTime, userOrder, bo);
			if (!r.isFlag()) {
				log.warn("结算失败:" + r.getMessage());
				return false;
			}

			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("id", userOrder.get("id"));
			paramMap.put("receivedAmount", "0");
			paramMap.put("order_status", OrderStatusConstant.complete);
			paramMap.put("cam_id", vehicleRecord.getCam_id());
			parkingordersService.completeOrder(paramMap);
			return true;
		} catch (Exception e) {
			log.warn("结算失败", e);
			return false;
		}
	}

	/**
	 * 处理无车牌
	 * 
	 * @param vr
	 */
	private void handleNoLicensePlateIn(VehicleRecord vr) {
		log.info("无车牌进场：{},{}", vr.getCam_id(), vr.getMsgBody());
	}

	private void handleNoLicensePlateOut(VehicleRecord vr) {
		log.info("无车牌出场：{},{}", vr.getCam_id(), vr.getMsgBody());
	}

	private void handleNoOrder(VehicleRecord vr) {
		log.warn("未找到订单：{},{}", vr.getCam_id(), vr.getMsgBody());
	}

	// 是否无车牌
	private boolean isNullLicensePlate(String licensePlate) {
		if (licensePlate == null || "".equals(licensePlate.trim())) {
			return true;
		}
		if ("null".equals(licensePlate.toLowerCase().trim())) {
			return true;
		}
		return false;
	}

	@Scheduled(cron = "0 0/2 * * * ?")
	public void minuteLoadCameras() {
		// 每2分钟刷新相机数据
		List<Map<String, Object>> list = barrierGateEquipmentService.loadAllCameras();
		List<Map<String, Object>> listYards = depotconfigurationService.loadAll();
		Map<Integer, String> yardId2NameMap = new HashMap<>();
		listYards.forEach(r -> {
			Integer id = (Integer) r.get("id");
			String parking_lot_name = (String) r.get("parking_lot_name");
			yardId2NameMap.put(id, parking_lot_name);
		});
		Map<String, BarrierGateEquipmentBo> newBarrierGateEquipmentBoMap = new ConcurrentHashMap<>();
		list.forEach(r -> {
			String cam_id = (String) r.get("cam_id");
			String cam_ip = (String) r.get("cam_ip");
			Date create_time = (Date) r.get("create_time");
			String create_username = (String) r.get("create_username");
			String gate_id = (String) r.get("gate_id");
			String inout = (String) r.get("in_out");
			Integer id = (Integer) r.get("id");
			Integer parking_lot_info_id = (Integer) r.get("parking_lot_info_id");
			String status = (String) r.get("cam_status");
			String update_username = (String) r.get("update_username");
			Date update_time = (Date) r.get("update_time");
			String yardName = yardId2NameMap.get(parking_lot_info_id);
			yardName = yardName == null ? ("id" + parking_lot_info_id) : yardName;
			BarrierGateEquipmentBo newBarrierGateEquipmentBo = new BarrierGateEquipmentBo();
			newBarrierGateEquipmentBo.setCam_id(cam_id);
			newBarrierGateEquipmentBo.setCam_ip(cam_ip);
			newBarrierGateEquipmentBo.setCreate_time(create_time);
			newBarrierGateEquipmentBo.setCreate_username(create_username);
			newBarrierGateEquipmentBo.setGate_id(gate_id);
			newBarrierGateEquipmentBo.setIn_out(inout);
			newBarrierGateEquipmentBo.setId(id);
			newBarrierGateEquipmentBo.setParking_lot_info_id(parking_lot_info_id);
			newBarrierGateEquipmentBo.setCam_status(status);
			newBarrierGateEquipmentBo.setUpdate_time(update_time);
			newBarrierGateEquipmentBo.setUpdate_username(update_username);
			newBarrierGateEquipmentBo.setYardName(yardName);
			newBarrierGateEquipmentBoMap.put(cam_id, newBarrierGateEquipmentBo);
		});
		barrierGateEquipmentBoMap = newBarrierGateEquipmentBoMap;
	}

	/**
	 * 加载车场数据
	 */
	private void reloadYards() {
		// TODO Auto-generated method stub
		yardcode2IdMapUpdateTime = System.currentTimeMillis();
		List<Map<String, Object>> list = executeSQL("select * from parking_lot_info");
		if (list == null || list.isEmpty()) {
			return;
		}
		yardcode2IdMap.clear();
		list.forEach(r -> {
			String parking_lot_code = (String) r.get("parking_lot_code");
			Integer id = (Integer) r.get("id");
			if (parking_lot_code != null && id != null) {
				yardcode2IdMap.put(parking_lot_code, id);
			}
		});
	}

	/**
	 * 表中插入新设备
	 * 
	 * @param json
	 */
	private void insertNewEquipment(JSONObject json) {
		// String msg_id = json.getString("msg_id");
		String cam_id = json.getString("cam_id");
		String park_id = json.getString("park_id");
		String cam_ip = json.getString("cam_ip");
		Integer yardId = 0;
		if (yardcode2IdMapUpdateTime + 1000 * 60 * 3 < System.currentTimeMillis()) {
			reloadYards();
		}
		if (yardcode2IdMap != null && !yardcode2IdMap.isEmpty()) {
			yardId = yardcode2IdMap.get(park_id);
		}
		executeSQL(
				"insert into barrier_gate_equipment (cam_id,cam_ip,parking_lot_info_id,in_out,cam_status,create_time,update_time) values(?,?,?,?,?,?,?)",
				cam_id, cam_ip, yardId, "入口", "启用", new Date(), new Date());
	}

	/**
	 * 更新设备
	 * 
	 * @param json
	 * @param list
	 */
	private void updateEquipment(JSONObject json, List<Map<String, Object>> list) {
		// TODO Auto-generated method stub
		Map<String, Object> old = list.get(0);
		Object id = old.get("id");
		String cam_id = json.getString("cam_id");
		String park_id = json.getString("park_id");
		String cam_ip = json.getString("cam_ip");
		Integer yardId = 0;
		if (yardcode2IdMapUpdateTime + 1000 * 60 * 3 < System.currentTimeMillis()) {
			reloadYards();
		}
		if (yardcode2IdMap != null && !yardcode2IdMap.isEmpty()) {
			yardId = yardcode2IdMap.get(park_id);
		}
		executeSQL("update barrier_gate_equipment set cam_ip=?,parking_lot_info_id=?,update_time=? where cam_id=? ",
				cam_ip, yardId, new Date(), cam_id);

	}

	private void _updateBarrierGateEquipment() throws InterruptedException {
		String regcmd = newRegisterCmdCacheManager.pool(60 * 5, TimeUnit.SECONDS);
		if (regcmd == null || "".equals(regcmd)) {
			return;
		}
		JSONObject json = (JSONObject) JSONObject.parse(regcmd);
		String cam_id = json.getString("cam_id");
		if (cam_id == null) {
			return;
		}
		List<Map<String, Object>> list = executeSQL("select * from barrier_gate_equipment where cam_id=?", cam_id);
		if (list == null || list.isEmpty()) {
			insertNewEquipment(json);
		} else {
			updateEquipment(json, list);
		}
	}

	private void updateBarrierGateEquipment() {
		while (true) {
			try {
				_updateBarrierGateEquipment();
			} catch (Exception e) {
				log.warn(e.toString(), e);
			}
		}

	}

	private void saveMinIOPic(VehicleRecord vr) {
		String full_pic = vr.getMsgBody().getString("full_pic");
		String plate_num = vr.getPlate_num();
		if (full_pic == null || full_pic.isBlank() || full_pic.length() < 10) {
			return;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
		StringBuilder pathBuilder = new StringBuilder();

		String nowStr = sdf.format(new Date());
		pathBuilder.append(vr.getCam_id()).append("_").append(plate_num).append("_").append(nowStr).append(".jpg");
		String filename = pathBuilder.toString();
		final String fullfilename = vr.getCam_id() + "/" + filename;
		vr.getMsgBody().put("full_pic_path", fullfilename);
		workersEs.submit(new Runnable() {
			@Override
			public void run() {
				try {
					byte[] imageBytes = Base64.getDecoder().decode(full_pic);
					minioUtil.uploadJPEG(imageBytes, fullfilename, MinIOConfig.pitureBucket);
				} catch (Throwable e) {
					log.warn("上传图片失败：" + full_pic, e);
				}
			}
		});
	}

	private void updateInPic(String plate_num, String full_pic_path) {
		List<Map<String, Object>> list = executeSQL(
				"select * from vehicle_entry_exit_record where license_plate_number=? order by id desc limit 10",
				plate_num);
		if (list.isEmpty()) {
			log.info("没有相关出入场记录，{}", plate_num);
			return;
		}
		Map<String, Object> map = list.get(0);
		Object id = map.get("id");
		executeSQL("update vehicle_entry_exit_record set entry_picture=? where id=?", full_pic_path, id);
		log.info("更新入场图片地址:{},车牌->{},ID->{}", full_pic_path, plate_num, id);
	}

	private void updatePicOut(Map<String, Object> uorder, VehicleRecord vr) {
		// TODO Auto-generated method stub
		String full_pic_path = vr.getMsgBody().getString("full_pic_path");
		Object id = uorder.get("id");
		// if(id==null) {
		// log.info("没有找到图片对应的出入场记录,{},{},{}", full_pic_path, vr.getPlate_num(), id);
		// return;
		// }
		executeSQL("update vehicle_entry_exit_record set exit_picture=? where user_order_id=?", full_pic_path, id);
		log.info("更新出场图片地址:{},车牌->{},order_id->{}", full_pic_path, vr.getPlate_num(), id);
	}

	static class Pair {
		public String plat_num;
		public long timestamp;

		public Pair(String plat_num) {
			this.plat_num = plat_num;
			this.timestamp = System.currentTimeMillis();
		}
	}
}
