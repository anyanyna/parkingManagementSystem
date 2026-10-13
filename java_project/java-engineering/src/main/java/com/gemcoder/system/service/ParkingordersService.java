package com.gemcoder.system.service;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gemcoder.system.bo.OrderMoneyBo;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.util.OrderPaymentChannelConstant;
import com.gemcoder.system.util.OrderPaymentStatusConstant;
import com.gemcoder.system.util.OrderStatusConstant;
import com.gemcoder.system.util.RowUtil;

@Service
public class ParkingordersService {
	private static final Logger log = LoggerFactory.getLogger(ParkingordersService.class);
	@Resource
	MoneyCaculateService moneyCaculateService;
	@Resource
	VehicleOutYardService vehicleOutYardService;

	public Result getParkingOrders(Map<String, Object> paramMap) {
		// Initialize SQL and parameters
		StringBuilder sql = new StringBuilder(
				"SELECT id, order_code, license_plate, license_type, parking_lot, order_status, payment_status, entry_time, exit_time, parking_duration, order_amount, discount_amount, receivable_amount, received_amount, refund_amount, payment_channel, discount_channel, cashier, operation,order_source,refund,order_type FROM user_order WHERE 1=1");
		List<Object> params = new ArrayList<>();
		// Check if there are selected rows
		List<Map<String, Object>> selectedRows = (List<Map<String, Object>>) paramMap.get("selectedRows");
		if (selectedRows != null && !selectedRows.isEmpty()) {
			sql.append(" AND id IN (");
			for (int i = 0; i < selectedRows.size(); i++) {
				sql.append("?");
				if (i < selectedRows.size() - 1) {
					sql.append(", ");
				}
				params.add(selectedRows.get(i).get("id"));
			}
			sql.append(")");
			// Execute SQL
			List<Map<String, Object>> result = executeSQL(sql.toString(), params.toArray());
			RowUtil.setRowNumber(result, null, null);
			// Return result
			return new Result(true, "Export successful", result);
		} else {
			// If no rows are selected, export current page data
			Integer current = Integer.valueOf(String.valueOf(paramMap.get("current")));
			Integer pageSize = Integer.valueOf(String.valueOf(paramMap.get("pageSize")));
			sql.append(" ORDER BY id DESC, create_time DESC LIMIT ?, ?");
			params.add((current - 1) * pageSize);
			params.add(pageSize);
			// Execute SQL
			List<Map<String, Object>> result = executeSQL(sql.toString(), params.toArray());
			RowUtil.setRowNumber(result, pageSize, current);
			// Return result
			return new Result(true, "Export successful", result);
		}
	}

	public Result queryParkingOrders(Map<String, Object> paramMap) {
		/**
		 * 数据后处理
		 */
		Result rst = _queryParkingOrders(paramMap);
		if (!rst.flag) {
			return rst;
		}
		Map<String, Object> data = (Map<String, Object>) rst.getData();
		if (data == null) {
			return rst;
		}
		// 暂时没有后处理需要
		// data.get("data");
		return rst;
	}

	protected Result _queryParkingOrders(Map<String, Object> paramMap) {
		Object paymentStatuses = paramMap.get("PaymentStatusvalue1");
		List<String> licensePlates = new ArrayList<>();
		if (paramMap.get("Licenseplatenumbervalue1") != null) {
			Object Licenseplatenumbervalue1 = paramMap.get("Licenseplatenumbervalue1");
			if (Licenseplatenumbervalue1 instanceof String[]) {
				if (((String[]) Licenseplatenumbervalue1).length > 0) {
					for (String s : (String[]) Licenseplatenumbervalue1) {
						licensePlates.add(s);
					}
				}
			} else if (Licenseplatenumbervalue1 instanceof List) {
				List<String> licensePlateList = (List<String>) Licenseplatenumbervalue1;
				licensePlates.addAll(licensePlateList);
			} else if (Licenseplatenumbervalue1 instanceof String) {
				if (!StringUtils.isEmpty((String) Licenseplatenumbervalue1)) {
					licensePlates.add((String) Licenseplatenumbervalue1);
				}
			}
		}
		Object licenseTypes = paramMap.get("Typeoflicenseplatevalue1");
		String parkingLot = paramMap.get("Parkingvalue1") != null ? String.valueOf(paramMap.get("Parkingvalue1"))
				: null;
		Object orderStatuses = paramMap.get("OrderStatusvalue1");

		// 进入时间
		List<String> entry_time = paramMap.get("entry_time") != null ? (List<String>) paramMap.get("entry_time") : null;
		// 订单金额
		String order_amount = paramMap.get("order_amount") != null ? String.valueOf(paramMap.get("order_amount"))
				: null;
		// 离开时间
		List<String> exit_time = paramMap.get("exit_time") != null ? (List<String>) paramMap.get("exit_time") : null;
		// 停车时长

		String min_parking_duration = paramMap.get("min_parking_duration") != null
				? String.valueOf(paramMap.get("min_parking_duration"))
				: null;

		String max_parking_duration = paramMap.get("max_parking_duration") != null
				? String.valueOf(paramMap.get("max_parking_duration"))
				: null;

		Object payment_channel = paramMap.get("payment_channel");

		Object discount_channel = paramMap.get("discount_channel");

		// 初始化 SQL 和参数
		StringBuilder sql = new StringBuilder(
				"SELECT id, order_code, license_plate, license_type, parking_lot, order_status, payment_status, DATE_FORMAT(entry_time, '%Y-%m-%d %H:%i:%s') AS entry_time, DATE_FORMAT(exit_time, '%Y-%m-%d %H:%i:%s') AS exit_time, parking_duration AS parking_duration  , order_amount, discount_amount, receivable_amount, received_amount, refund_amount, payment_channel, discount_channel, cashier, operation,order_source,refund,order_type,parking_lot_id FROM user_order WHERE 1=1");
		List<Object> params = new ArrayList<>();
		StringBuilder countSql = new StringBuilder("SELECT COUNT(*) as total FROM user_order WHERE 1=1");
		List<Object> countParams = new ArrayList<>();

		// 根据输入参数添加过滤条件
		if (licensePlates != null && !licensePlates.isEmpty()) {
			if (licensePlates.size() == 1) {
				sql.append(" AND license_plate LIKE ?");
				countSql.append(" AND license_plate LIKE ?");
				params.add("%" + licensePlates.get(0) + "%");
				countParams.add("%" + licensePlates.get(0) + "%");
			} else {
				sql.append(" AND license_plate in (?");
				countSql.append(" AND license_plate in( ?");
				params.add(licensePlates.get(0));
				countParams.add(licensePlates.get(0));
				for (int i = 1; i < licensePlates.size() - 1; ++i) {
					sql.append(" ,?");
					countSql.append(" ,?");
					params.add(licensePlates.get(i));
					countParams.add(licensePlates.get(i));
				}
				sql.append(" ,?)");
				countSql.append(" ,?)");
				params.add(licensePlates.get(licensePlates.size() - 1));
				countParams.add(licensePlates.get(licensePlates.size() - 1));
			}
		}

		appendFilters(sql, countSql, "license_type", licenseTypes, params, countParams);
		if (parkingLot != null && !parkingLot.isEmpty()) {
			sql.append(" AND parking_lot LIKE ?");
			countSql.append(" AND parking_lot LIKE ?");
			params.add("%" + parkingLot + "%");
			countParams.add("%" + parkingLot + "%");
		}

		appendFilters(sql, countSql, "order_status", orderStatuses, params, countParams);
		appendFilters(sql, countSql, "payment_status", paymentStatuses, params, countParams);

		appendFilters(sql, countSql, "payment_channel", payment_channel, params, countParams);
		appendFilters(sql, countSql, "discount_channel", discount_channel, params, countParams);

		if (entry_time != null && entry_time.size() > 1) {
			sql.append(" AND entry_time BETWEEN ? AND ?");
			params.add(entry_time.get(0));
			params.add(entry_time.get(1));
			countSql.append(" AND entry_time BETWEEN ? AND ?");
			countParams.add(entry_time.get(0));
			countParams.add(entry_time.get(1));
		}

		if (exit_time != null && exit_time.size() > 1) {
			sql.append(" AND exit_time BETWEEN ? AND ?");
			params.add(exit_time.get(0));
			params.add(exit_time.get(1));
			countSql.append(" AND exit_time BETWEEN ? AND ?");
			countParams.add(exit_time.get(0));
			countParams.add(exit_time.get(1));
		}
		if (min_parking_duration != null && !min_parking_duration.isEmpty()) {
			int minParkingDuration;
			try {
				minParkingDuration = Integer.parseInt(min_parking_duration);
			} catch (NumberFormatException e) {
				return new Result(false, "停车时长输入错误：Invalid Parking Duration:" + min_parking_duration, null);
			}
			sql.append(" AND parking_duration >= ?");
			countSql.append(" AND parking_duration >= ?");
			params.add(minParkingDuration);
			countParams.add(minParkingDuration);
		}

		if (max_parking_duration != null && !max_parking_duration.isEmpty()) {
			int maxParkingDuration;
			try {
				maxParkingDuration = Integer.parseInt(max_parking_duration);
			} catch (NumberFormatException e) {
				return new Result(false, "停车时长输入错误：Invalid Parking Duration:" + max_parking_duration, null);
			}
			sql.append(" AND parking_duration <= ?");
			countSql.append(" AND parking_duration <= ?");
			params.add(maxParkingDuration);
			countParams.add(maxParkingDuration);
		}

		if (order_amount != null && !order_amount.isEmpty()) {
			double orderAmount;
			try {
				orderAmount = Double.parseDouble(order_amount);
			} catch (NumberFormatException e) {
				return new Result(false, "订单金额输入错误：Invalid order amount:" + order_amount, null);
			}
			sql.append(" AND order_amount = ?");
			countSql.append(" AND order_amount = ?");
			params.add(orderAmount);
			countParams.add(orderAmount);
		}

		// Add pagination
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		sql.append(" ORDER BY id DESC,create_time DESC LIMIT ?, ?");
		params.add((current - 1) * pageSize);
		params.add(pageSize);

		// Execute SQL
		List<Map<String, Object>> result = executeSQL(sql.toString(), params.toArray());
		// Execute count SQL
		List<Map<String, Object>> countResult = executeSQL(countSql.toString(), countParams.toArray());
		int total = Integer.valueOf(String.valueOf(countResult.get(0).get("total")));

		// Return result with total count
		Map<String, Object> data = new HashMap<>();
		RowUtil.setRowNumber(result, pageSize, current);
		data.put("total", total);
		data.put("data", result);
		return new Result(true, "Query successful", data);
	}

	private void appendFilters(StringBuilder sqlBuilder, StringBuilder countSqlBuilder, String paramName, Object object,
			List<Object> params, List<Object> countParams) {
		if (object instanceof List) {
			List<Object> values = (List<Object>) object;
			if (!values.isEmpty()) {
				sqlBuilder.append(" AND ").append(paramName).append(" IN (");
				countSqlBuilder.append(" AND ").append(paramName).append(" IN (");
				for (int i = 0; i < values.size(); i++) {
					sqlBuilder.append("?");
					countSqlBuilder.append("?");
					if (i < values.size() - 1) {
						sqlBuilder.append(", ");
						countSqlBuilder.append(", ");
					}
					params.add(values.get(i));
					countParams.add(values.get(i));
				}
				sqlBuilder.append(")");
				countSqlBuilder.append(")");
			}
		}
	}

	public Result getOrderPaymentRecords(Map<String, Object> paramMap) {
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		Integer orderId = paramMap.get("orderId") != null ? Integer.valueOf(String.valueOf(paramMap.get("orderId")))
				: null;
		StringBuilder sql = new StringBuilder(
				"SELECT id, serial_number, payment_source, payment_method, transaction_amount, transaction_time, transaction_status FROM order_payment_record WHERE 1=1");
		List<Object> params = new ArrayList<>();
		if (orderId != null) {
			sql.append(" AND order_id = ?");
			params.add(orderId);
		}
		sql.append(" ORDER BY transaction_time DESC LIMIT ?, ?");
		params.add((current - 1) * pageSize);
		params.add(pageSize);
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		StringBuilder countSql = new StringBuilder("SELECT COUNT(*) AS total FROM order_payment_record WHERE 1=1");
		List<Object> countParams = new ArrayList<>();
		if (orderId != null) {
			countSql.append(" AND order_id = ?");
			countParams.add(orderId);
		}
		List<Map<String, Object>> countResult = executeSQL(countSql.toString(), countParams.toArray());
		Integer total = Integer.valueOf(String.valueOf(countResult.get(0).get("total")));
		Map<String, Object> result = new HashMap<>();
		RowUtil.setRowNumber(data, pageSize, current);
		result.put("total", total);
		result.put("data", data);
		return new Result(true, "Query successful", result);
	}

	public Result getBillingDetails(Map<String, Object> paramMap) {
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		Integer orderId = paramMap.get("orderId") != null ? Integer.valueOf(String.valueOf(paramMap.get("orderId")))
				: null;
		StringBuilder sql = new StringBuilder(
				"SELECT a.id, a.serial_number, a.billing_type, a.billing_vehicle, a.billing_period, a.start_time, a.end_time, CONCAT(FLOOR(a.duration / 60), '小时',  MOD(a.duration, 60),'分钟' ) AS duration , a.billing_rule,a.amount,b.rule_name FROM billing_detail a join billing_rules b on a.billing_rule=b.id WHERE 1=1");
		List<Object> params = new ArrayList<>();
		if (orderId != null) {
			sql.append(" AND a.order_id = ?");
			params.add(orderId);
		}
		sql.append(" ORDER BY a.id DESC LIMIT ?, ?");
		params.add((current - 1) * pageSize);
		params.add(pageSize);
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		StringBuilder countSql = new StringBuilder("SELECT COUNT(*) AS total FROM billing_detail a WHERE 1=1");
		List<Object> countParams = new ArrayList<>();
		if (orderId != null) {
			countSql.append(" AND a.order_id = ?");
			countParams.add(orderId);
		}
		List<Map<String, Object>> countResult = executeSQL(countSql.toString(), countParams.toArray());
		Integer total = Integer.valueOf(String.valueOf(countResult.get(0).get("total")));
		Map<String, Object> result = new HashMap<>();
		RowUtil.setRowNumber(data, pageSize, current);
		result.put("total", total);
		result.put("data", data);
		return new Result(true, "查询完成", result);
	}

	public Result getOrderOperationRecords(Map<String, Object> paramMap) {
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		Integer orderId = paramMap.get("orderId") != null ? Integer.valueOf(String.valueOf(paramMap.get("orderId")))
				: null;
		StringBuilder sql = new StringBuilder(
				"SELECT id, serial_number, operator, operation_type, operation_description, operation_record, operation_detail, operation_time FROM order_operation_record WHERE 1=1");
		List<Object> params = new ArrayList<>();
		if (orderId != null) {
			sql.append(" AND order_id = ?");
			params.add(orderId);
		}
		sql.append(" ORDER BY operation_time DESC LIMIT ?, ?");
		params.add((current - 1) * pageSize);
		params.add(pageSize);
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		StringBuilder countSql = new StringBuilder("SELECT COUNT(*) AS total FROM order_operation_record WHERE 1=1");
		List<Object> countParams = new ArrayList<>();
		if (orderId != null) {
			countSql.append(" AND order_id = ?");
			countParams.add(orderId);
		}
		List<Map<String, Object>> countResult = executeSQL(countSql.toString(), countParams.toArray());
		Integer total = Integer.valueOf(String.valueOf(countResult.get(0).get("total")));
		Map<String, Object> result = new HashMap<>();
		RowUtil.setRowNumber(data, pageSize, current);
		result.put("total", total);
		result.put("data", data);
		return new Result(true, "Query successful", result);
	}

	public Result getOrderDetails(Map<String, Object> paramMap) {
		Integer orderId = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
		if (orderId == null) {
			return new Result(false, "Order ID is required", null);
		}
		StringBuilder sql = new StringBuilder(
				"SELECT id, order_code, license_plate, license_type, parking_lot, order_status, payment_status, entry_time, exit_time, parking_duration, order_amount, discount_amount, receivable_amount, received_amount, refund_amount, payment_channel, discount_channel, cashier, operation,order_source,refund,order_type FROM user_order WHERE id = ?");
		List<Object> params = new ArrayList<>();
		params.add(orderId);
		List<Map<String, Object>> orderDetails = executeSQL(sql.toString(), params.toArray());
		if (orderDetails.isEmpty()) {
			return new Result(false, "Order not found", null);
		}
		Map<String, Object> result = new HashMap<>();
		result.put("orderDetails", orderDetails.get(0));
		// Fetch related payment records
		sql = new StringBuilder(
				"SELECT id, serial_number, payment_source, payment_method, transaction_amount, transaction_time, transaction_status FROM order_payment_record WHERE order_id = ?");
		List<Map<String, Object>> paymentRecords = executeSQL(sql.toString(), params.toArray());
		result.put("paymentRecords", paymentRecords);
		// Fetch related billing details
		sql = new StringBuilder(
				"SELECT id, serial_number, billing_type, billing_vehicle, billing_period, start_time, end_time, duration, billing_rule FROM billing_detail WHERE order_id = ?");
		List<Map<String, Object>> billingDetails = executeSQL(sql.toString(), params.toArray());
		result.put("billingDetails", billingDetails);
		// Fetch related operation records
		sql = new StringBuilder(
				"SELECT id, serial_number, operator, operation_type, operation_description, operation_record, operation_detail, operation_time FROM order_operation_record WHERE order_id = ?");
		List<Map<String, Object>> operationRecords = executeSQL(sql.toString(), params.toArray());
		result.put("operationRecords", operationRecords);
		return new Result(true, "Query successful", result);
	}

	public Result updateOrderPaymentStatus(Map<String, Object> paramMap) {
		Integer orderId = paramMap.get("orderId") != null ? Integer.valueOf(String.valueOf(paramMap.get("orderId")))
				: null;
		String newStatus = paramMap.get("newStatus") != null ? String.valueOf(paramMap.get("newStatus")) : null;
		if (orderId == null || newStatus == null) {
			return new Result(false, "Order ID and new status are required", null);
		}
		StringBuilder sql = new StringBuilder("UPDATE user_order SET payment_status = ? WHERE id = ?");
		List<Object> params = new ArrayList<>();
		params.add(newStatus);
		params.add(orderId);
		int rowsAffected = executeSQL(sql.toString(), params.toArray());
		if (rowsAffected > 0) {
			return new Result(true, "Update successful", null);
		} else {
			return new Result(false, "Update failed", null);
		}
	}

	public Result updateRefundAmount(Map<String, Object> paramMap) {
		String currentUserName = sdkOfGetCurrentUserName();
		Integer orderId = paramMap.get("orderId") != null ? Integer.valueOf(String.valueOf(paramMap.get("orderId")))
				: null;
		Double refundAmount = paramMap.get("refundAmount") != null
				? Double.valueOf(String.valueOf(paramMap.get("refundAmount")))
				: null;
		if (orderId == null || refundAmount == null) {
			return new Result(false, "Order ID and refund amount are required", null);
		}
		StringBuilder sql = new StringBuilder("UPDATE user_order SET refund_amount = ?,refund='是' WHERE id = ?");
		List<Object> params = new ArrayList<>();
		params.add(refundAmount);
		params.add(orderId);
		
		SimpleDateFormat sdfn=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int rowsAffected = executeSQL(sql.toString(), params.toArray());
		if (rowsAffected > 0) {
			StringBuilder styrb=new StringBuilder("退款:"+String.format("%.2f", refundAmount)+"元");
			styrb.append("。退款时间："+sdfn.format(new Date()));
			saveOrderOperationRecord(orderId, 1, currentUserName, "退款", "退款。退款金额："+String.format("%.2f", refundAmount)+"元",
					"退款。退款金额:"+String.format("%.2f", refundAmount)+"元", styrb.toString(), new Date());
			return new Result(true, "Update successful", null);
		} else {
			return new Result(false, "Update failed", null);
		}
	}

	/**
	 * 完成
	 * 
	 * @param paramMap
	 * @return
	 */
	public Result completeOrder(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		String currentUserName = sdkOfGetCurrentUserName();
		Object id = (Object) paramMap.get("id");
		if (id == null || "".equals(id)) {
			return new Result(false, "缺少参数ID", null);
		}
		Object receivedAmount = (Object) paramMap.get("receivedAmount");
		String order_status = (String) paramMap.get("order_status");
		BigDecimal received_amount = null;
		if (receivedAmount != null) {
			try {
				Double recv = Double.parseDouble(receivedAmount.toString());
				received_amount = new BigDecimal(recv);
			} catch (Exception e) {
				return new Result(false, "实收金额格式错误：" + receivedAmount, null);
			}
		}
		{
			// 更新订单
			StringBuilder sql = new StringBuilder("update user_order ");

			sql.append(" set order_status=?,");
			sql.append(" payment_status=?,");
			sql.append("  operation=?,");
			sql.append("  update_username=?,");
			if (received_amount != null) {
				sql.append("  received_amount=?,");
				sql.append("  payment_amount=?,");
				sql.append("  actual_amount=?,");
			} else {
				sql.append("  received_amount=order_amount,");
				sql.append("  payment_amount=order_amount,");
				sql.append("  actual_amount=order_amount,");
			}

			sql.append("  lift_time=now(),");
			sql.append("  update_time=now()");
			sql.append(" where id= ?");
			List<Object> params = new ArrayList<>();
			if (order_status == null || "".equals(order_status.trim())) {
				params.add(OrderStatusConstant.complete);
			} else {
				params.add(OrderStatusConstant.complete);
			}

			params.add(OrderPaymentStatusConstant.payed);
			params.add("完成订单");

			params.add(currentUserName);
			if (received_amount != null) {
				params.add(received_amount);
				params.add(received_amount);
				params.add(received_amount);
			}
			params.add(id);
			executeSQL(sql.toString(), params.toArray());
		}
		/**
		 * operationType operationDescription operationRecord operationDetail
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String operationDetail = "完成订单:已支付,完成时间：" + sdf.format(new Date());
		saveOrderOperationRecord(Integer.valueOf(id.toString()), 1, currentUserName, "完成订单", "完成订单:已支付", "完成订单",
				operationDetail, new Date());

		/**
		 * 
		 * @param payment_source
		 * @param payment_method
		 * @param transaction_amount
		 * @param transaction_time
		 * @param transaction_status
		 * @param order_id
		 * @return
		 */
		BigDecimal money = BigDecimal.ZERO;
		{
			StringBuilder sql = new StringBuilder("select order_amount from user_order  where id=" + id);
			List<Map<String, Object>> orderDetails = executeSQL(sql.toString());
			if (orderDetails != null && !orderDetails.isEmpty()) {
				BigDecimal order_amount = (BigDecimal) orderDetails.get(0).get("order_amount");
				if (order_amount != null) {
					money = order_amount;
				}
			}
		}
		saveOrderPaymentRecord("现金支付", "线下支付", money, new Date(), "完成", Integer.valueOf(id.toString()));

		{
			// 更新出入记录
			Integer vehicle_entry_exit_record_id = null;
			{
				// 查询入场记录
				String license_plate = null;
				String parking_lot = null;
				StringBuilder sql0 = new StringBuilder(
						"select license_plate,parking_lot from user_order  where id=" + id);
				List<Map<String, Object>> orderDetails = executeSQL(sql0.toString());
				if (orderDetails != null && !orderDetails.isEmpty()) {
					String license_plate1 = (String) orderDetails.get(0).get("license_plate");
					String parking_lot1 = (String) orderDetails.get(0).get("parking_lot");
					if (license_plate1 != null) {
						license_plate = license_plate1;
					}
					if (parking_lot1 != null) {
						parking_lot = parking_lot1;
					}
				}
				if (license_plate != null && parking_lot != null) {
					StringBuilder sql1 = new StringBuilder("select id from vehicle_entry_exit_record  where 1=1 ");
					sql1.append(" and license_plate_number=?");
					sql1.append(" and last_parking_lot=?");
					//sql1.append(" and user_order_id=?");
					sql1.append(" and last_exit_time is null order by id desc");
					List<Object> params = new ArrayList<>();
					params.add(license_plate);
					//params.add(Integer.valueOf(id.toString()));
					params.add(parking_lot);
					List<Map<String, Object>> vehicle_entry_exit_records = executeSQL(sql1.toString(),
							params.toArray());
					if (vehicle_entry_exit_records != null && !vehicle_entry_exit_records.isEmpty()) {
						vehicle_entry_exit_record_id = (Integer) vehicle_entry_exit_records.get(0).get("id");
					}
				}

			}
			if (vehicle_entry_exit_record_id != null) {
				String exit_name = "出口";
				String cam_id = (String) paramMap.get("cam_id");
				if (cam_id != null) {
					StringBuilder sql = new StringBuilder(
							"select channels  from barrier_gate_equipment  where cam_id=?");
					List<Map<String, Object>> li = executeSQL(sql.toString(), cam_id);
					if (!li.isEmpty()) {
						String channels = (String) li.get(0).get("channels");
						if (channels != null) {
							exit_name = channels;
						}
					}
				}
				StringBuilder sql = new StringBuilder("update  vehicle_entry_exit_record ");
				sql.append(" set last_exit_time=?,");
				sql.append(" update_username=?,");
				sql.append("  exit_name=?,");
				sql.append("  update_time=now()");
				sql.append(" where id= ?");
				List<Object> params = new ArrayList<>();
				params.add(new Date());
				params.add(currentUserName);
				params.add(exit_name);
				params.add(vehicle_entry_exit_record_id);
				executeSQL(sql.toString(), params.toArray());
			}

		}

		return new Result(true, "完成订单", null);
	}

	/**
	 * 结算
	 * 
	 * @param paramMap
	 * @return
	 */
	public Result settlementOrder(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub

		Object id = (Object) paramMap.get("id");
		if (id == null || "".equals(id)) {
			return new Result(false, "缺少参数ID", null);
		}
		Integer yardId = null;
		String plateNo = null;
		String license_type = null;
		Date entry_time = null;
		Map<String, Object> orderInfo = null;
		{
			StringBuilder sql = new StringBuilder(
					"SELECT id, parking_lot_id, license_plate,license_type,entry_time from user_order where id= ?");
			List<Object> params = new ArrayList<>();
			params.add(id);
			List<Map<String, Object>> orderInfoList = executeSQL(sql.toString(), params.toArray());
			if (orderInfoList == null || orderInfoList.isEmpty()) {
				return new Result(false, "未找到该订单", null);
			}
			orderInfo = orderInfoList.get(0);
			yardId = (Integer) orderInfo.get("parking_lot_id");
			plateNo = (String) orderInfo.get("license_plate");
			license_type = (String) orderInfo.get("license_type");
			entry_time = (Date) orderInfo.get("entry_time");
		}

		if (StringUtils.isEmpty(plateNo)) {
			return new Result(false, "车牌异常", null);
		}
		if (yardId == null) {
			return new Result(false, "未找到停车场信息", null);
		}
		if (entry_time == null) {
			return new Result(false, "未找到车辆进场时间", null);
		}
		if (vehicleOutYardService.isInBlackList(plateNo, yardId)) {
			return new Result(false, "黑名单车辆", "黑名单车辆");
		}

		boolean isWhite = false;
		boolean isNewEnergy = false;
		if ("白牌".equals(license_type)) {
			isWhite = true;
		}
		if ("绿牌".equals(license_type) || "黄绿牌".equals(license_type) || "黄绿".equals(license_type)) {
			isNewEnergy = true;
		}

		/**
		 * 计算停车费用以及收费详细表，支持跨天
		 * 
		 * @param plateNo
		 *            车牌
		 * @param newEnergy
		 *            当前车辆是否新能源车
		 * @param yardId
		 *            停车场ID,parking_lot_info 表主键
		 * @param white
		 *            当前车辆是否白牌车
		 * @param exitTime
		 *            离场时间
		 * @return
		 */
		OrderMoneyBo bo = null;
		Date now = new Date();
		try {
			bo = moneyCaculateService.caculateBilllingMoney(plateNo, yardId, isNewEnergy, isWhite, now);
		} catch (Exception e) {
			log.info("caculateBilllingMoney error!", e);
			return new Result(false, "计算出错", e.toString());
		}
		String payment_channel = (String) paramMap.get("payment_channel");
		if (StringUtils.isEmpty(payment_channel)) {
			payment_channel = OrderPaymentChannelConstant.offline;
		}
		return _settlementOrder(Integer.parseInt(id.toString()), false, payment_channel, now, orderInfo, bo);
	}

	/**
	 * 
	 * @param id订单id
	 * @param advancePay提前支付
	 * @param now离场时间
	 * @param orderInfo订单信息
	 * @param bo计费信息
	 * @return
	 */
	public Result _settlementOrder(int id, boolean advancePay, String payment_channel, Date now,
			Map<String, Object> orderInfo, OrderMoneyBo bo) {
		String currentUserName = sdkOfGetCurrentUserName();
		Date entry_time = (Date) orderInfo.get("entry_time");
		long timespan = now.getTime() - entry_time.getTime();
		timespan = timespan / 1000 / 60;
		BigDecimal zhekou = BigDecimal.ZERO;
		if (bo.getDetails() != null) {
			bo.getDetails().forEach(r -> {
			});
		}
		{
			// 更新订单
			BigDecimal money = bo.getMoney();
			StringBuilder sql = new StringBuilder("update user_order ");
			sql.append(" set order_amount=?,");
			sql.append("  receivable_amount=?,");
			sql.append("  exit_time=?,");
			// sql.append(" order_status=?,");
			sql.append("  payment_status=?,");
			sql.append("  discount_amount=?,");
			sql.append("  refund_amount=?,");
			sql.append("  payment_channel=?,");

			sql.append("  parking_duration=?,");
			sql.append("  operation=?,");
			sql.append("  update_username=?,");

			sql.append("  update_time=now()");
			sql.append(" where id= ?");
			List<Object> params = new ArrayList<>();
			params.add(money);
			params.add(money);
			params.add(now);
			// params.add(OrderStatusConstant.inYard);
			params.add(OrderPaymentStatusConstant.waitpay);
			params.add(zhekou);
			params.add(BigDecimal.ZERO);
			params.add(payment_channel);
			params.add((int) timespan);
			params.add("结算");
			params.add(currentUserName);
			params.add(id);
			executeSQL(sql.toString(), params.toArray());
		}
		/**
		 * 如果结算过，清除之前的结算记录
		 * 
		 */
		// TODO 删除之前备份到另外一张表？
		executeSQL("delete from billing_detail where order_id=?", id);
		moneyCaculateService.saveDetails(id, 1, bo.getDetails());

		/**
		 * operationType operationDescription operationRecord operationDetail
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String operationDetail = "结算订单，金额：" + bo.getMoney().doubleValue() + ",停车时长：" + timespan + "分钟，进场时间"
				+ sdf.format(entry_time) + ",结算订单时间：" + sdf.format(now);
		saveOrderOperationRecord(id, 1, currentUserName, "结算订单", "结算订单:未支付", "结算订单，金额：" + bo.getMoney().doubleValue(),
				operationDetail, new Date());
		// saveOrderPaymentRecord(Integer.valueOf(id.toString()));
		return new Result(true, "结算完成", null);

	}

	public Result closeOrder(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		String currentUserName = sdkOfGetCurrentUserName();
		Object id = (Object) paramMap.get("id");
		if (id == null || "".equals(id)) {
			return new Result(false, "缺少参数ID", null);
		}

		Integer yardId = null;
		String plateNo = null;
		String license_type = null;
		Date entry_time = null;
		{
			StringBuilder sql = new StringBuilder(
					"SELECT id, parking_lot_id, license_plate,license_type,entry_time from user_order where id= ?");
			List<Object> params = new ArrayList<>();
			params.add(id);
			List<Map<String, Object>> orderInfoList = executeSQL(sql.toString(), params.toArray());
			if (orderInfoList == null || orderInfoList.isEmpty()) {
				return new Result(false, "未找到该订单", null);
			}
			Map<String, Object> orderInfo = orderInfoList.get(0);
			yardId = (Integer) orderInfo.get("parking_lot_id");
			plateNo = (String) orderInfo.get("license_plate");
			license_type = (String) orderInfo.get("license_type");
			entry_time = (Date) orderInfo.get("entry_time");
		}

		if (StringUtils.isEmpty(plateNo)) {
			return new Result(false, "车牌异常", null);
		}
		if (yardId == null) {
			return new Result(false, "未找到停车场信息", null);
		}
		if (entry_time == null) {
			return new Result(false, "未找到车辆进场时间", null);
		}
		boolean isWhite = false;
		boolean isNewEnergy = false;
		if ("白牌".equals(license_type)) {
			isWhite = true;
		}
		if ("绿牌".equals(license_type) || "黄绿牌".equals(license_type) || "黄绿".equals(license_type)) {
			isNewEnergy = true;
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
		OrderMoneyBo bo = null;
		Date now = new Date();
		try {
			bo = moneyCaculateService.caculateBilllingMoney(plateNo, yardId, isNewEnergy, isWhite, now);
		} catch (Exception e) {
			log.info("caculateBilllingMoney error!", e);
			return new Result(false, "计算出错", e.toString());
		}
		long timespan = now.getTime() - entry_time.getTime();
		timespan = timespan / 1000 / 60;
		BigDecimal zhekou = BigDecimal.ZERO;
		if (bo.getDetails() != null) {
			bo.getDetails().forEach(r -> {
			});
		}
		{
			// 更新订单
			BigDecimal money = bo.getMoney();
			StringBuilder sql = new StringBuilder("update user_order ");
			sql.append(" set order_amount=?,");
			sql.append("  receivable_amount=?,");
			sql.append("  exit_time=?,");
			sql.append("  order_status=?,");
			sql.append("  payment_status=?,");
			sql.append("  discount_amount=?,");
			sql.append("  refund_amount=?,");
			// sql.append(" payment_channel=?,");

			// sql.append(" parking_duration=?,");
			sql.append("  operation=?,");
			sql.append("  update_username=?,");

			sql.append("  update_time=now()");
			sql.append(" where id= ?");
			List<Object> params = new ArrayList<>();
			params.add(money);
			params.add(money);
			params.add(now);
			params.add("关闭");
			params.add("待支付");
			params.add(zhekou);
			params.add(BigDecimal.ZERO);
			// params.add("线下缴费");
			// params.add((int) timespan);
			params.add("关闭订单");
			params.add(currentUserName);
			params.add(id);
			executeSQL(sql.toString(), params.toArray());
		}
		moneyCaculateService.saveDetails(Integer.parseInt(id.toString()), 1, bo.getDetails());
		/**
		 * operationType operationDescription operationRecord operationDetail
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String operationDetail = "关闭订单，金额：" + bo.getMoney().doubleValue() + ",停车时长：" + timespan + "分钟，进场时间"
				+ sdf.format(entry_time) + ",关闭订单时间：" + sdf.format(now);
		saveOrderOperationRecord(Integer.valueOf(id.toString()), 1, currentUserName, "关闭订单", "关闭订单:待支付",
				"关闭订单，金额：" + bo.getMoney().doubleValue(), operationDetail, new Date());

		return new Result(true, "关闭订成功", null);
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

	/**
	 * 
	 * @param payment_source
	 * @param payment_method
	 * @param transaction_amount
	 * @param transaction_time
	 * @param transaction_status
	 * @param order_id
	 * @return
	 */
	private int saveOrderPaymentRecord(String payment_source, String payment_method, BigDecimal transaction_amount,
			Date transaction_time, String transaction_status, int order_id) {
		String currentUserName = sdkOfGetCurrentUserName();
		StringBuilder insertSql = new StringBuilder(
				" insert into order_payment_record ( payment_source, payment_method, transaction_amount, transaction_time, transaction_status,order_id,create_username,create_time,update_username,update_time ) values (?,?,?,?,?,?,?,?,?,?)");
		List<Object> params = new ArrayList<>();
		params.add(payment_source);
		params.add(payment_method);
		params.add(transaction_amount);
		params.add(transaction_time);
		params.add(transaction_status);
		params.add(order_id);
		params.add(currentUserName);
		params.add(new Date());
		params.add(currentUserName);
		params.add(new Date());
		int insertRows = executeSQL(insertSql.toString(), params.toArray());
		return insertRows;
	}

	/**
	 * 获取最新的订单列表
	 * 
	 * @param licensePlate
	 * @param parking_lot_info_id
	 * @return
	 */
	public List<Map<String, Object>> getLatestParkingOrdersList(String licensePlate, int parking_lot_info_id,String order_status) {
		StringBuilder sql0 = new StringBuilder(
				"select * from user_order  where license_plate=? and parking_lot_id=? and order_status=? and exit_time is null order by create_time desc limit 10");
		List<Object> params = new ArrayList<>();
		params.add(licensePlate);
		params.add(parking_lot_info_id);
		params.add(order_status);
		List<Map<String, Object>> orderDetails = executeSQL(sql0.toString(), params.toArray());
		return orderDetails;
	}

	public Map<String, Object> getParkingOrderById(int orderId) {
		StringBuilder sql0 = new StringBuilder("select * from user_order where id=" + orderId);
		List<Map<String, Object>> orderDetails = executeSQL(sql0.toString());
		if (orderDetails == null || orderDetails.isEmpty()) {
			return null;
		}
		return orderDetails.get(0);
	}
	public void updateLiftTime(Object orderId) {
		StringBuilder insertSql = new StringBuilder(
				" update  user_order  set lift_time=?,update_time=?  where id=?");
		List<Object> params = new ArrayList<>();
		params.add(new Date());
		params.add(new Date());
		params.add(orderId);
		executeSQL(insertSql.toString(), params.toArray());
	}
}
