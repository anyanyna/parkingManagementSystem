package com.gemcoder.system.service;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.gemcoder.system.ws.CapMatchServcie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gemcoder.system.bo.Result;
import com.gemcoder.system.util.OrderPaymentStatusConstant;
import com.gemcoder.system.util.OrderSourceConstants;
import com.gemcoder.system.ws.CommandService;
import com.gemcoder.system.ws.GlobalMessageCacheManager;
import com.gemcoder.system.ws.VehicleRecord;

@Service
public class AppBaseService {
	private static final Logger log = LoggerFactory.getLogger(AppBaseService.class);
	GlobalMessageCacheManager globalMessageCacheManager = GlobalMessageCacheManager.getInstance();

	@Resource
	ParkingordersService parkingordersService;
	@Resource
	VehiclemanagementService vehiclemanagementService;
	@Resource
	VehicleInYardService vehicleInYardService;

	@Resource
	CommandService commandService;

	/**
	 * 道闸当前车牌
	 * 
	 * @param cam_id
	 * @return
	 */
	public Result currentPlate(String cam_id) {
		VehicleRecord vr = globalMessageCacheManager.getCurrentVehicleRecord(cam_id);
		if (vr == null) {
			return new Result(false, "没有找到车牌", null);
		}
		Map<String, String> data = new HashMap<>();
		String plate_num = vr.getMsgBody().getString("plate_num");
		data.put("plate_num", plate_num);
		return new Result(true, "车牌查询结果", data);
	}

	public Result yardDetail(Integer yardId) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = executeSQL("select * from parking_lot_info where id=?", yardId);
		Map<String, Object> data = new HashMap<>();
		data.put("total", list.size());
		data.put("data", list);
		if (list.isEmpty()) {
			return new Result(false, "没有查到停车场数据");
		}
		return new Result(true, "停车场详情", data);
	}

	/**
	 * 
	 * @param yardId
	 *            车场编号
	 * @param cam_id
	 *            道闸编号
	 * @param plate_num
	 *            车牌
	 * @param plateType
	 *            车辆类型（蓝牌，绿牌，白牌）
	 * @return
	 */
	public Result vehicleInYard(Integer yardId, String cam_id, String plate_num, String plateType) {
		log.info("扫码进场,{},{},{},{}", yardId, cam_id, plate_num, plateType);
		vehiclemanagementService.saveVehicleScanQRcodeInRecord(cam_id, plate_num, plateType);
		Result b = vehicleInYardService.vehicleInYard(OrderSourceConstants.scanCode, yardId, cam_id, plate_num,
				plateType);
		if (b.isFlag()) {
			return new Result(true, "车辆入场", null);
		} else {
			return new Result(false, "车辆入失败," + b.getMessage(), b.getData());
		}
	}

	/**
	 * 查找车辆对应的订单
	 * 
	 * @param yardId
	 * @param plate_num
	 * @return
	 */
	public Result userOrderOutYard(Integer yardId, String plate_num) {
		List<Map<String, Object>> list = executeSQL(
				"select * from user_order where license_plate=? and parking_lot_id=?  and order_status='车辆入场' and (payment_status=? or payment_status is null)    order by create_time desc limit 1",
				plate_num, yardId,OrderPaymentStatusConstant.waitpay);
		Map<String, Object> data = new HashMap<>();
		data.put("total", list.size());
		data.put("data", list);
		if (list.isEmpty()) {
			return new Result(false, "没有查到订单");
		}
		return new Result(true, "订单详情", data);
	}

	/**
	 * 结算
	 * 
	 * @param orderId
	 * @param payment_channel
	 * @return
	 */
	public Result settlement(Integer orderId, String payment_channel) {
		Map<String, Object> newparamMap = new HashMap<String, Object>();
		newparamMap.put("id", orderId);
		newparamMap.put("payment_channel", payment_channel);

		Result r = parkingordersService.settlementOrder(newparamMap);
		if (!r.isFlag()) {
			return r;
		}
		Map<String, Object> orderInfo = parkingordersService.getParkingOrderById(orderId);
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(orderInfo);

		Map<String, Object> data = new HashMap<>();
		data.put("total", 1);
		data.put("data", list);
		return new Result(true, "订单详情", data);
	}

	public Result openOutBarier(Integer orderId, String plate_num, String cam_id) {
		String createUsername = sdkOfGetCurrentUserName();
		commandService.openBarier(cam_id, plate_num, false, true);
		//TODO
		List<Map<String, Object>> camList = executeSQL("select * from barrier_gate_equipment where cam_id=?", cam_id);
		String channels = null;
		if (!camList.isEmpty()) {
			// return new Result(false, "没有找到道闸设备", "没有找到道闸设备");
			log.warn("没有找到道闸设备:{}", plate_num);
			channels = (String) camList.get(0).get("channels");
		}
		String content="出场抬杆:" + plate_num+",出口："+channels;
		//抓拍？
		saveOrderOperationRecord(orderId, 1, createUsername, "出场抬杆", "出场抬杆:" + plate_num, content,
				content, new Date());
		return new Result(true, "抬杆完成", "抬杆完成");
	}
	public Result saveOrderOperationRecord(int orderId, int serialNumber, String operator, String operationType,
			String operationDescription, String operationRecord, String operationDetail, Date operationTime) {
		String createUsername = sdkOfGetCurrentUserName();
		// 构建SQL插入语句
		StringBuilder insertSql = new StringBuilder(
				"INSERT INTO order_operation_record (order_id, serial_number, operator, operation_type, operation_description,operation_record,operation_detail,operation_time,create_username, create_time,update_username,update_time) "
						+ "VALUES (?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?)");
		List<Object> params = new ArrayList<>();
		params.add(orderId);
		params.add(serialNumber);
		params.add(operator);
		params.add(operationType);
		params.add(operationDescription);
		params.add(operationRecord);
		params.add(operationDetail);
		params.add(operationTime);
		params.add(createUsername);
		params.add(new Date());
		params.add(createUsername);
		params.add(new Date());
		// 执行SQL插入语句
		int insertRows = executeSQL(insertSql.toString(), params.toArray());
		// 返回结果
		if (insertRows > 0) {
			return new Result(true, "order operation record created successfully", null);
		} else {
			return new Result(false, "Failed to create order operation record", null);
		}

	}

}
