package com.gemcoder.system.service;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserId;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.util.OrderPaymentStatusConstant;
import com.gemcoder.system.util.OrderStatusConstant;
import com.gemcoder.system.util.OrderCodeUtil;

import static com.gemcoder.system.service.permission.PermissionSdkService.sdkOfgetAllPermissions;
import static com.gemcoder.system.service.permission.PermissionSdkService.sdkOfgetAllMenus;
import java.sql.SQLException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import cn.hutool.core.util.RandomUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class BusinesslogicService {

	public Result generateLicensePlate(Map<String, Object> paramMap) {
		// 使用Hutool工具类生成随机车牌号
		String licensePlate = cn.hutool.core.util.RandomUtil.randomString("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789", 7);
		// 返回生成的车牌号
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("licensePlate", licensePlate);
		return new Result(true, "License plate generated successfully", resultData);
	}

	public Result createParkingOrder(Map<String, Object> paramMap) {
		// 获取当前时间作为订单创建时间
		java.util.Date currentTime = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
		// String formattedTime = sdf.format(currentTime);
		// 从paramMap中获取车牌号
		String licensePlate = paramMap.get("licensePlate") != null ? String.valueOf(paramMap.get("licensePlate"))
				: null;
		String parking_lot = (String) paramMap.get("parking_lot");
		String license_plate_type = (String) paramMap.get("license_plate_type");
		Integer parking_lot_id = (Integer) paramMap.get("parking_lot_id");
		String order_source = (String) paramMap.get("order_source");
		Date entry_time = (Date) paramMap.get("entry_time");
		// 生成订单编号：创建时间-车牌号后5位
		String orderCode = OrderCodeUtil.generateOrderCode(licensePlate);// formattedTime + "-" + (licensePlate != null
																			// && licensePlate.length() >= 5 ?
																			// licensePlate.substring(licensePlate.length()
																			// - 5) : "00000");
		// 获取当前用户名
		String createUsername = sdkOfGetCurrentUserName();
		// 构建SQL插入语句
		StringBuilder insertSql = new StringBuilder(
				"INSERT INTO user_order (order_type,order_source,order_code, license_plate,license_type, order_status,payment_status,operation,parking_lot,parking_lot_id ,entry_time, create_username, create_time) VALUES (?,?,?, ?,?, ?,?,?,?, ?, ?, ?, ?)");
		List<Object> params = new ArrayList<>();
		params.add("临停");// 月租
		params.add(order_source);
		params.add(orderCode);
		params.add(licensePlate);
		params.add(license_plate_type);
		params.add(OrderStatusConstant.inYard);
		params.add(null);
		params.add("创建订单");
		params.add(parking_lot);
		params.add(parking_lot_id);
		params.add(entry_time == null ? currentTime : entry_time);
		params.add(createUsername);
		params.add(currentTime);
		// 执行SQL插入语句
		int insertRows = executeSQL(insertSql.toString(), params.toArray());
		StringBuilder maxIdSql = new StringBuilder("select max(id) as id from user_order");
		List<Map<String, Object>> li = executeSQL(maxIdSql.toString(), null);
		Integer orderId = (Integer) li.get(0).get("id");
		saveOrderOperationRecord(orderId, 1, createUsername, "创建订单", "创建订单:" + orderCode, "创建订单:" + orderCode,
				"创建订单:" + orderCode + ",车牌：" + licensePlate, currentTime);
		// 返回结果

		{
			// 插入停车记录

			// String license_plate_type=(String)paramMap.get("license_plate_type");
			Object entry_name = (Object) paramMap.get("entry_name");

			StringBuilder sql = new StringBuilder(
					"insert into vehicle_entry_exit_record (last_entry_time,last_parking_lot,license_plate_number,license_plate_type,entry_name,contact,berth_number ,create_username,create_time,update_username,update_time,parking_lot_info_id,user_order_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			List<Object> paramsVEER = new ArrayList<>();
			paramsVEER.add(entry_time == null ? currentTime : entry_time);
			paramsVEER.add(parking_lot);
			paramsVEER.add(licensePlate);
			paramsVEER.add(license_plate_type);
			paramsVEER.add(entry_name);
			paramsVEER.add("");
			paramsVEER.add((new Random()).nextInt(32));
			paramsVEER.add(createUsername);
			paramsVEER.add(new Date());
			paramsVEER.add(createUsername);
			paramsVEER.add(new Date());
			paramsVEER.add(parking_lot_id);
			paramsVEER.add(orderId);
			executeSQL(sql.toString(), paramsVEER.toArray());
		}

		if (insertRows > 0) {
			return new Result(true, "订单创建成功", li.get(0));
		} else {
			return new Result(false, "订单创建失败", null);
		}
	}

	public Result queryVehicleOrder(Map<String, Object> paramMap) {
		// Initialize SQL query to select specific fields from user_order table
		StringBuilder sql = new StringBuilder(
				"SELECT id, order_code, license_plate, order_status, payment_status, entry_time, exit_time, order_amount FROM user_order WHERE 1=1");
		List<Object> params = new ArrayList<>();
		// Check if license_plate is provided and add it to the query
		String licensePlate = paramMap.get("license_plate") != null ? String.valueOf(paramMap.get("license_plate"))
				: null;
		if (licensePlate != null && !licensePlate.isEmpty()) {
			sql.append(" AND license_plate = ?");
			params.add(licensePlate);
		}
		// Execute the SQL query
		List<Map<String, Object>> result = executeSQL(sql.toString(), params.toArray());
		// Return the result wrapped in a Result object
		return new Result(true, "Query executed successfully", result);
	}

	public Result updatePaymentStatus(Map<String, Object> paramMap) {
		// Initialize SQL update statement to modify specific fields in user_order table
		StringBuilder sql = new StringBuilder(
				"UPDATE user_order SET payment_status = ?,order_status=?, operation=?,payment_channel=?, payment_staff = ?, payment_amount = ?,actual_amount=?,received_amount=?, exit_time = ? WHERE id = ?");
		List<Object> params = new ArrayList<>();
		// Set the values for the update
		// String paymentStatus = "已支付";
		String paymentStaff = "系统";
		Object paymentAmount = (Object) paramMap.get("paymentAmount");
		String licensePlate = (String) paramMap.get("licensePlate");
		String payment_status = (String) paramMap.get("payment_status");
		Object exitTime = (Object) paramMap.get("exitTime");
		String order_status = (String) paramMap.get("order_status");
		String operation = (String) paramMap.get("operation");
		String payment_channel = (String) paramMap.get("payment_channel");
		// String exitTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new
		// Date());
		// String licensePlate = paramMap.get("license_plate") != null ?
		// String.valueOf(paramMap.get("license_plate")) : null;
		String id = paramMap.get("id") != null ? String.valueOf(paramMap.get("id")) : null;
		// Add the values to the parameters list
		params.add(payment_status);
		params.add(order_status);
		params.add(operation);
		params.add(payment_channel);
		params.add(paymentStaff);
		params.add(paymentAmount);
		params.add(paymentAmount);
		params.add(paymentAmount);
		params.add(exitTime);
		params.add(Integer.valueOf(id));
		// Execute the SQL update
		int updateRows = executeSQL(sql.toString(), params.toArray());
		// Return the result wrapped in a Result object
		String createUsername = sdkOfGetCurrentUserName();

		saveOrderOperationRecord(Integer.valueOf(id), 1, createUsername, "更新订单", "更新订单:" + payment_status,
				"更新订单:" + payment_status, "更新订单:" + payment_status + ",车牌：" + licensePlate + ",金额：" + paymentAmount,
				new Date());

		return new Result(updateRows > 0, updateRows > 0 ? "Update successful" : "Update failed", null);
	}

	protected Result saveOrderOperationRecord(int orderId, int serialNumber, String operator, String operationType,
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
