package com.gemcoder.system.service;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.springframework.stereotype.Service;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserId;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.util.RowUtil;

import static com.gemcoder.system.service.permission.PermissionSdkService.sdkOfgetAllPermissions;
import static com.gemcoder.system.service.permission.PermissionSdkService.sdkOfgetAllMenus;
import java.sql.SQLException;
import java.time.Year;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import cn.hutool.core.util.StrUtil;

@Service
public class BillingmanagementService {

	public Result resetBillingManagementList(Map<String, Object> paramMap) {
		// 清空查询条件
		paramMap.put("ruleName", null);
		paramMap.put("billingStandard", null);
		paramMap.put("createdTime", null);
		paramMap.put("creator", null);
		// 构建查询SQL
		StringBuilder sql = new StringBuilder(
				"SELECT id, rule_number, rule_name, billing_standard, rule_description, associated_parking_count, create_time, creator FROM billing_rules ORDER BY create_time DESC LIMIT ?, ?");
		List<Object> params = new ArrayList<>();
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		params.add((current - 1) * pageSize);
		params.add(pageSize);
		// 执行查询
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		// 查询总条数
		String countSql = "SELECT COUNT(*) AS total FROM billing_rules";
		List<Map<String, Object>> countResult = executeSQL(countSql);
		Integer total = countResult.get(0).get("total") != null
				? Integer.valueOf(String.valueOf(countResult.get(0).get("total")))
				: 0;
		// 返回结果
		RowUtil.setRowNumber(data, pageSize, current);
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("total", total);
		resultData.put("data", data);
		return new Result(true, "重置成功", resultData);
	}

	/**
	 * public Result queryBillingManagementList(Map<String, Object> paramMap) { //
	 * 构建查询SQL StringBuilder sql = new StringBuilder( "SELECT id, rule_number,
	 * rule_name, billing_standard, rule_description, associated_parking_count,
	 * create_time, creator FROM billing_rules WHERE 1=1"); // 查询总条数 StringBuilder
	 * countSql = new StringBuilder("SELECT COUNT(*) AS total FROM billing_rules
	 * WHERE 1=1");
	 * 
	 * List<Object> params = new ArrayList<>(); // 规则名称模糊查询 String ruleName =
	 * paramMap.get("ruleName") != null ? String.valueOf(paramMap.get("ruleName")) :
	 * null; if (ruleName != null && !ruleName.isEmpty()) { String item = " AND
	 * rule_name LIKE ?"; sql.append(item); countSql.append(item); params.add("%" +
	 * ruleName + "%"); } // 收费标准查询 String billingStandard =
	 * paramMap.get("billingStandard") != null ?
	 * String.valueOf(paramMap.get("billingStandard")) : null; if (billingStandard
	 * != null && !billingStandard.isEmpty()) { String item = " AND billing_standard
	 * = ?"; sql.append(item); countSql.append(item); params.add(billingStandard); }
	 * // 创建时间查询 String createdTime = paramMap.get("createdTime") != null ?
	 * String.valueOf(paramMap.get("createdTime")) : null; if (createdTime != null
	 * && !createdTime.isEmpty()) { if (createdTime.contains(",")) { String[]
	 * splited = createdTime.split(","); String item = " AND create_time >= ? and
	 * create_time<=?"; sql.append(item); countSql.append(item);
	 * params.add(splited[0]); params.add(splited[1]); } else { String item = " AND
	 * create_time >= ?"; sql.append(item); countSql.append(item);
	 * params.add(createdTime); }
	 * 
	 * } // 创建人模糊查询 String creator = paramMap.get("creator") != null ?
	 * String.valueOf(paramMap.get("creator")) : null; if (creator != null &&
	 * !creator.isEmpty()) { String item = " AND creator LIKE ?"; sql.append(item);
	 * countSql.append(item); params.add("%" + creator + "%"); } // 分页和排序
	 * sql.append(" ORDER BY create_time DESC LIMIT ?, ?"); Integer current =
	 * paramMap.get("current") != null ?
	 * Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1; Integer
	 * pageSize = paramMap.get("pageSize") != null ?
	 * Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
	 * params.add((current - 1) * pageSize); params.add(pageSize); // 执行查询
	 * List<Map<String, Object>> data = executeSQL(sql.toString(),
	 * params.toArray()); // 不包括分页参数 List<Object> countParams = new
	 * ArrayList<>(params.subList(0, params.size() - 2)); List<Map<String, Object>>
	 * countResult = executeSQL(countSql.toString(), countParams.toArray()); Integer
	 * total = countResult.get(0).get("total") != null ?
	 * Integer.valueOf(String.valueOf(countResult.get(0).get("total"))) : 0; // 返回结果
	 * RowUtil.setRowNumber(data, pageSize, current); Map<String, Object> resultData
	 * = new HashMap<>(); resultData.put("total", total); resultData.put("data",
	 * data); return new Result(true, "查询成功", resultData); }
	 **/
	public Result getBillingOperationRecords(Map<String, Object> paramMap) {
		// Extract pagination parameters
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		// Calculate offset for pagination
		int offset = (current - 1) * pageSize;
		// SQL to get total count
		String countSql = "SELECT COUNT(*) AS total FROM billing_operation_record";
		List<Map<String, Object>> countResult = executeSQL(countSql);
		int total = countResult.get(0).get("total") != null
				? Integer.valueOf(String.valueOf(countResult.get(0).get("total")))
				: 0;
		// SQL to get paginated data
		StringBuilder sql = new StringBuilder(
				"SELECT id, operation_time, operation_node, operation_content, operator FROM billing_operation_record ORDER BY operation_time DESC LIMIT ?, ?");
		List<Map<String, Object>> data = executeSQL(sql.toString(), offset, pageSize);
		// Prepare result
		Map<String, Object> resultData = new HashMap<>();
		RowUtil.setRowNumber(data, pageSize, current);
		resultData.put("total", total);
		resultData.put("data", data);
		return new Result(true, "Success", resultData);
	}

	public Result getBillingManagementList(Map<String, Object> paramMap) {

		// Extract pagination parameters
		List<Object> params = new ArrayList<>();
		List<Object> countparams = new ArrayList<>();
		String rule_name = paramMap.get("rule_name") != null ? String.valueOf(paramMap.get("rule_name")) : null;
		List<String> billing_standard = paramMap.get("billing_standard") != null
				? (ArrayList<String>) (paramMap.get("billing_standard"))
				: null;
		String creator = paramMap.get("creator") != null ? String.valueOf(paramMap.get("creator")) : null;
		/*
		 * List<String> Creatorvalue1 =new ArrayList<>();
		 * if(paramMap.get("Creatorvalue1") != null) { if(paramMap.get("Creatorvalue1")
		 * instanceof String) {
		 * Creatorvalue1.add(paramMap.get("Creatorvalue1").toString()); }else
		 * if(paramMap.get("Creatorvalue1") instanceof List) {
		 * Creatorvalue1=(List<String>)(paramMap.get("Creatorvalue1")); } }
		 */
		ArrayList<String> create_time = paramMap.get("create_time") != null
				? (ArrayList<String>) (paramMap.get("create_time"))
				: null;

		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		// Calculate offset for pagination
		Integer offset = (current - 1) * pageSize;
		// SQL to get total count
		StringBuilder countSql = new StringBuilder("SELECT COUNT(*) AS total FROM billing_rules where 1=1 ");

		// SQL to get paginated data
		StringBuilder sql = new StringBuilder("SELECT * FROM billing_rules  where 1=1 ");
		if (!StringUtils.isBlank(rule_name)) {
			sql.append(" and rule_name=? ");
			countSql.append(" and rule_name=? ");
			params.add(rule_name);
			countparams.add(rule_name);
		}
		if (!StringUtils.isBlank(creator)) {
			sql.append(" and creator=? ");
			countSql.append(" and creator=? ");
			params.add(creator);
			countparams.add(creator);
		}
		multiParams(billing_standard, sql, params, "billing_standard");
		// multiParams(Creatorvalue1, sql,params,"creator");

		multiParams(billing_standard, countSql, countparams, "billing_standard");
		// multiParams(Creatorvalue1, countSql,countparams,"creator");

		if (create_time != null && !create_time.isEmpty()) {
			if (create_time.size() > 1) {
				sql.append(" and create_time>=? ");
				sql.append(" and create_time><? ");
				countSql.append(" and create_time>=? ");
				countSql.append(" and create_time><? ");
			}
			params.add(create_time.get(0));
			params.add(create_time.get(1));
			countparams.add(create_time.get(0));
			countparams.add(create_time.get(1));
		}

		sql.append("ORDER BY create_time DESC LIMIT ?,?");

		params.add(offset);
		params.add(pageSize);

		List<Map<String, Object>> countResult = countparams.isEmpty() ? executeSQL(countSql.toString())
				: executeSQL(countSql.toString(), countparams);
		int total = countResult.get(0).get("total") != null
				? Integer.valueOf(String.valueOf(countResult.get(0).get("total")))
				: 0;
		// sql.
		// multiParams(ArrayList<String> queryList,StringBuilder sql,List<Object>
		// params,String fieldName)
		List<Map<String, Object>> data = executeSQL(sql.toString(), params);
		// Prepare result
		Map<String, Object> resultData = new HashMap<>();
		RowUtil.setRowNumber(data, pageSize, current);
		resultData.put("total", total);
		resultData.put("data", data);
		return new Result(true, "Success", resultData);
	}

	public Result getRuleInformation(Map<String, Object> paramMap) {
		// Extract rule ID
		Integer ruleId = paramMap.get("ruleId") != null ? Integer.valueOf(String.valueOf(paramMap.get("ruleId")))
				: null;
		if (ruleId == null) {
			return new Result(false, "Rule ID is required", null);
		}
		// SQL to get rule information
		StringBuilder sql = new StringBuilder(
				"SELECT rule_number, rule_name, rule_description FROM billing_rules WHERE id = ?");
		List<Map<String, Object>> data = executeSQL(sql.toString(), ruleId);
		if (data.isEmpty()) {
			return new Result(false, "No rule information found", null);
		}
		return new Result(true, "Success", data.get(0));
	}

	public Result getOperationRecords(Map<String, Object> paramMap) {
		// Extract rule ID
		Integer ruleId = paramMap.get("billing_rule_id") != null
				? Integer.valueOf(String.valueOf(paramMap.get("billing_rule_id")))
				: null;
		if (ruleId == null) {
			return new Result(false, "Rule ID is required", null);
		}
		// Extract pagination parameters
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		// Calculate offset for pagination
		int offset = (current - 1) * pageSize;
		// SQL to get total count
		String countSql = "SELECT COUNT(*) AS total FROM billing_operation_record WHERE billing_rule_id = ?";
		List<Map<String, Object>> countResult = executeSQL(countSql, ruleId);
		int total = countResult.get(0).get("total") != null
				? Integer.valueOf(String.valueOf(countResult.get(0).get("total")))
				: 0;
		// SQL to get paginated data
		StringBuilder sql = new StringBuilder(
				"SELECT id, operation_time, operation_node, operation_content, operator,billing_rule_id FROM billing_operation_record WHERE billing_rule_id = ? ORDER BY operation_time DESC LIMIT ?, ?");
		List<Map<String, Object>> data = executeSQL(sql.toString(), ruleId, offset, pageSize);
		// Prepare result
		Map<String, Object> resultData = new HashMap<>();
		RowUtil.setRowNumber(data, pageSize, current);
		resultData.put("total", total);
		resultData.put("data", data);
		return new Result(true, "Success", resultData);
	}

	/*
	 * public Result insertOperationRecord(Map<String, Object> paramMap) { Integer
	 * ruleId = paramMap.get("ruleId") != null ?
	 * Integer.valueOf(String.valueOf(paramMap.get("ruleId"))) : null; if (ruleId ==
	 * null) { return new Result(false, "Rule ID is required", null); } String
	 * operation_node = String.valueOf(paramMap.get("operation_node")); String
	 * operation_content = String.valueOf(paramMap.get("operation_content")); //
	 * String operator=String.valueOf(paramMap.get("operator")); return null;//
	 * insertOperationRecord(ruleId, operation_node, operation_content); }
	 */

	public Result deleteRecord(Map<String, Object> paramMap) {
		// 获取当前记录的ID
		Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
		if (id == null) {
			return new Result(false, "Record ID is required for deletion", null);
		}
		// 删除记录的SQL
		__insertOperationRecord(id, "删除", "删除规则");
		StringBuilder deleteSql = new StringBuilder("DELETE FROM billing_rules WHERE id = ?");
		int deleteRows = executeSQL(deleteSql.toString(), id);
		if (deleteRows > 0) {
			return new Result(true, "Record deleted successfully", null);
		} else {
			return new Result(false, "Failed to delete record", null);
		}
	}

	public Result refreshTableData(Map<String, Object> paramMap) {
		// 获取分页参数
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		// 查询总条数的SQL
		StringBuilder countSql = new StringBuilder("SELECT COUNT(*) AS total FROM billing_rules");
		List<Map<String, Object>> countResult = executeSQL(countSql.toString());
		Integer total = countResult.get(0).get("total") != null
				? Integer.valueOf(String.valueOf(countResult.get(0).get("total")))
				: 0;
		// 查询分页数据的SQL
		StringBuilder dataSql = new StringBuilder(
				"SELECT id, rule_number, rule_name, billing_standard, rule_description, associated_parking_count, create_time, creator FROM billing_rules ORDER BY create_time DESC LIMIT ?, ?");
		List<Object> dataParams = new ArrayList<>();
		dataParams.add((current - 1) * pageSize);
		dataParams.add(pageSize);
		List<Map<String, Object>> data = executeSQL(dataSql.toString(), dataParams.toArray());
		// 返回结果
		Map<String, Object> resultData = new HashMap<>();
		RowUtil.setRowNumber(data, pageSize, current);
		resultData.put("total", total);
		resultData.put("data", data);
		return new Result(true, "Data retrieved successfully", resultData);
	}

	public Result changeBillingScheme(Map<String, Object> paramMap) {
		return __changeBillingScheme(paramMap);

	}

	public Result changeBillingScheme2(Map<String, Object> paramMap) {
		return __changeBillingScheme(paramMap);

	}

	private Result __changeBillingScheme(Map<String, Object> paramMap) {
		Result result = new Result();
		// Extract the scheme type from the input parameters
		String chargingSchemeValue = paramMap.get("chargingSchemeValue") != null
				? String.valueOf(paramMap.get("chargingSchemeValue"))
				: null;
		String id = paramMap.get("id") != null ? String.valueOf(paramMap.get("id")) : null;
		if (id == null) {
			result.setFlag(true);
			result.setMessage("没有数据更新");
			return result;
		}
		__insertOperationRecord(Integer.valueOf(id), "更新", "修改规则。方案变更为：" + chargingSchemeValue);
		StringBuilder sql = new StringBuilder();
		List<Object> params = new ArrayList<>();
		sql.append("UPDATE billing_rules SET billing_standard = ? WHERE id = ?");
		params.add(chargingSchemeValue);
		params.add(Integer.valueOf(id));
		result.setFlag(true);
		result.setMessage("动态面板状态更新成功");
		return result;
	}

	public Result changeBillingScheme3(Map<String, Object> paramMap) {
		return __changeBillingScheme(paramMap);
	}

	public Result changeBillingScheme4(Map<String, Object> paramMap) {
		return __changeBillingScheme(paramMap);
	}

	public Result changeBillingScheme5(Map<String, Object> paramMap) {
		return __changeBillingScheme(paramMap);
	}

	public Result changeBillingScheme6(Map<String, Object> paramMap) {
		return __changeBillingScheme(paramMap);
	}

	public Result changeBillingScheme7(Map<String, Object> paramMap) {
		return __changeBillingScheme(paramMap);
	}

	public Result openNewBillingModal(Map<String, Object> paramMap) {
		// Initialize the result object
		Result result = new Result();
		try {
			// Get the current username using the provided SDK function
			String currentUsername = sdkOfGetCurrentUserName();
			// Prepare the SQL query to fetch billing details
			StringBuilder sql = new StringBuilder(
					"SELECT id, order_id, serial_number, billing_type, billing_vehicle, billing_period, start_time, end_time, duration, billing_rule, create_username, create_time, update_username, update_time FROM billing_detail WHERE 1=1");
			List<Object> params = new ArrayList<>();
			// Add conditions based on the input parameters
			if (paramMap.get("order_id") != null) {
				Integer orderId = Integer.valueOf(String.valueOf(paramMap.get("order_id")));
				sql.append(" AND order_id = ?");
				params.add(orderId);
			}
			if (paramMap.get("billing_type") != null) {
				String billingType = String.valueOf(paramMap.get("billing_type"));
				sql.append(" AND billing_type = ?");
				params.add(billingType);
			}
			// Execute the SQL query
			List<Map<String, Object>> billingDetails = executeSQL(sql.toString(), params.toArray());
			// Set the result data
			result.setFlag(true);
			result.setMessage("Billing details fetched successfully.");
			result.setData(billingDetails);
		} catch (Exception e) {
			// Handle any exceptions and set the result accordingly
			result.setFlag(false);
			result.setMessage("Error fetching billing details: " + e.getMessage());
		}
		return result;
	}

	public Result changeEditBillingScheme(Map<String, Object> paramMap) {
		return __changeBillingScheme(paramMap);
	}

	public Result changeEditBillingScheme2(Map<String, Object> paramMap) {
		return __changeBillingScheme(paramMap);
	}

	public Result handleChargingSchemeChangeHv8(Map<String, Object> paramMap) {
		return __changeBillingScheme(paramMap);
	}

	public Result handleChargingSchemeChangeyYk(Map<String, Object> paramMap) {
		return __changeBillingScheme(paramMap);
	}

	public Result handleChargingSchemeChangelDp(Map<String, Object> paramMap) {
		return __changeBillingScheme(paramMap);
	}

	public Result handleChargingSchemeChangePrw(Map<String, Object> paramMap) {
		return __changeBillingScheme(paramMap);
	}

	public Result handleChargingSchemeChangeBDF(Map<String, Object> paramMap) {
		return __changeBillingScheme(paramMap);
	}

	public Result updateBillingRule(Map<String, Object> paramMap) {
		// Extract parameters from paramMap
		String id = paramMap.get("id") != null ? String.valueOf(paramMap.get("id")) : null;
		String rule_name = paramMap.get("rule_name") != null ? String.valueOf(paramMap.get("rule_name")) : null;
		/*
		 * String ruleNumber = paramMap.get("ruleNumber") != null ?
		 * String.valueOf(paramMap.get("ruleNumber")) : null;
		 */
		String rule_description = paramMap.get("rule_description") != null
				? String.valueOf(paramMap.get("rule_description"))
				: null;
		String billing_standard = paramMap.get("billing_standard") != null
				? String.valueOf(paramMap.get("billing_standard"))
				: null;

		String free_duration = paramMap.get("free_duration") != null ? String.valueOf(paramMap.get("free_duration"))
				: null;
		String new_energy_free_duration_reduction = paramMap.get("new_energy_free_duration_reduction") != null
				? String.valueOf(paramMap.get("new_energy_free_duration_reduction"))
				: null;
		String temporary_car = paramMap.get("temporary_car") != null ? String.valueOf(paramMap.get("temporary_car"))
				: null;
		String stored_value_car = paramMap.get("stored_value_car") != null
				? String.valueOf(paramMap.get("stored_value_car"))
				: null;
		String new_energy_free_duration = paramMap.get("new_energy_free_duration") != null
				? String.valueOf(paramMap.get("new_energy_free_duration"))
				: null;
		String free_duration_reduction = paramMap.get("free_duration_reduction") != null
				? String.valueOf(paramMap.get("free_duration_reduction"))
				: null;
		String white_plate_car_free = paramMap.get("white_plate_car_free") != null
				? String.valueOf(paramMap.get("white_plate_car_free"))
				: null;
		String new_energy_free_times = paramMap.get("new_energy_free_times") != null
				? String.valueOf(paramMap.get("new_energy_free_times"))
				: null;
		String free_period_reduction = paramMap.get("free_period_reduction") != null
				? String.valueOf(paramMap.get("free_period_reduction"))
				: null;
		String segment_charging = paramMap.get("segment_charging") != null
				? String.valueOf(paramMap.get("segment_charging"))
				: null;

		// Validate required fields
		if (StrUtil.isBlank(billing_standard)) {
			return new Result(false, "收费方案不能为空.", null);
		}
		StringBuilder oldRuleSql = new StringBuilder("select * from billing_rules where id=" + id);
		List<Map<String, Object>> oldRules = executeSQL(oldRuleSql.toString());
		Map<String, Object> oldRule = oldRules.isEmpty() ? null : oldRules.get(0);
		
		StringBuilder oldHolidaySql = new StringBuilder("select * from billing_holiday_schedule where billing_rule_id=" + id);
		List<Map<String, Object>> oldHolidays = executeSQL(oldHolidaySql.toString());
		StringBuilder oldTimeRangeSql = new StringBuilder("select * from billing_free_time_range where billing_rule_id=" + id);
		List<Map<String, Object>> oldTimeRanges = executeSQL(oldTimeRangeSql.toString());
		

		// Update billing rule in the database
		StringBuilder sql = new StringBuilder(
				"UPDATE billing_rules SET rule_name = ?, rule_description = ?, billing_standard = ?,free_duration=?, "
						+ " new_energy_free_duration_reduction=?,temporary_car=?,stored_value_car=?,new_energy_free_duration=?,"
						+ " free_duration_reduction=?,white_plate_car_free=?,new_energy_free_times=?,free_period_reduction=?,segment_charging=?,"
						+ "update_username = ?, update_time = NOW() WHERE id = ?");
		List<Object> params = new ArrayList<>();
		params.add(rule_name);
		params.add(rule_description);
		params.add(billing_standard);
		params.add(free_duration);
		params.add(new_energy_free_duration_reduction);
		params.add(temporary_car);
		params.add(stored_value_car);
		params.add(new_energy_free_duration);
		params.add(free_duration_reduction);
		params.add(white_plate_car_free);
		params.add(new_energy_free_times);
		params.add(free_period_reduction);
		params.add(segment_charging);

		params.add(sdkOfGetCurrentUserName());
		params.add(id);

		int updateRows = executeSQL(sql.toString(), params.toArray());

		saveBilllingRuleDetail(Integer.parseInt(id), paramMap);

		StringBuilder newRuleSql = new StringBuilder("select * from billing_rules where id=" + id);
		List<Map<String, Object>> newRules = executeSQL(newRuleSql.toString());
		Map<String, Object> newRule = newRules.isEmpty() ? null : newRules.get(0);
		
		StringBuilder newHolidaySql = new StringBuilder("select * from billing_holiday_schedule where billing_rule_id=" + id);
		List<Map<String, Object>> newHolidays = executeSQL(newHolidaySql.toString());
		StringBuilder newTimeRangeSql = new StringBuilder("select * from billing_free_time_range where billing_rule_id=" + id);
		List<Map<String, Object>> newTimeRanges = executeSQL(newTimeRangeSql.toString());
		

		_insertOperationRecord(Integer.valueOf(id), "更新", oldRule, newRule, oldHolidays, newHolidays, oldTimeRanges,
				newTimeRanges);
		if (updateRows > 0) {
			return new Result(true, "更新成功.", null);
			// Refresh parking lot list
			// return getParkingLotList(paramMap);
		} else {
			return new Result(false, "更新失败.", null);
		}
	}

	public Result getParkingLotList(Map<String, Object> paramMap) {
		// Extract pagination parameters
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		// Construct SQL for counting total records
		StringBuilder countSql = new StringBuilder("SELECT COUNT(*) AS total FROM parking_lot_list");
		List<Map<String, Object>> countResult = executeSQL(countSql.toString());
		int total = countResult.isEmpty() ? 0 : Integer.valueOf(String.valueOf(countResult.get(0).get("total")));
		// Construct SQL for fetching paginated parking lot list
		StringBuilder sql = new StringBuilder(
				"SELECT id, sequence_number, parking_lot_code, parking_lot_name, region, sector, category, parking_lot_type, parking_lot_status, parking_spaces, operating_company, manager, contact_number, operation, create_username, create_time, update_username, update_time FROM parking_lot_list ORDER BY create_time DESC LIMIT ?, ?");
		List<Object> params = new ArrayList<>();
		params.add((current - 1) * pageSize);
		params.add(pageSize);
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		// Prepare result data
		Map<String, Object> resultData = new HashMap<>();
		RowUtil.setRowNumber(data, pageSize, current);
		resultData.put("total", total);
		resultData.put("data", data);
		return new Result(true, "Parking lot list fetched successfully.", resultData);
	}

	public Result validateRuleInformation(Map<String, Object> paramMap) {
		// Extract parameters
		String ruleName = paramMap.get("rule_name") != null ? String.valueOf(paramMap.get("rule_name")) : null;
		/*
		 * String chargingScheme = paramMap.get("chargingScheme") != null ?
		 * String.valueOf(paramMap.get("chargingScheme")) : null;
		 */
		// Validate rule name
		if (StrUtil.isBlank(ruleName)) {
			return new Result(false, "规则名称不能为空", null);
		}
		// Validate charging scheme
		/*
		 * if (StrUtil.isBlank(chargingScheme)) { return new Result(false, "收费方案不能为空",
		 * null); }
		 */
		// If all validations pass
		return new Result(true, "校验通过", null);
	}

	public Result generateRuleNumber(Map<String, Object> paramMap) {
		// Generate a unique rule number
		String ruleNumber = "RULE-" + System.currentTimeMillis();
		paramMap.put("ruleNumber", ruleNumber);
		return new Result(true, "规则编号生成成功", ruleNumber);
	}

	public Result saveBillingRule(Map<String, Object> paramMap) {
		// Extract parameters
		String rule_number = paramMap.get("rule_number") != null ? String.valueOf(paramMap.get("rule_number")) : null;
		String rule_name = paramMap.get("rule_name") != null ? String.valueOf(paramMap.get("rule_name")) : null;
		String rule_description = paramMap.get("rule_description") != null
				? String.valueOf(paramMap.get("rule_description"))
				: null;
		String billing_standard = paramMap.get("billing_standard") != null
				? String.valueOf(paramMap.get("billing_standard"))
				: null;
		// String creator = paramMap.get("creator") != null ?
		// String.valueOf(paramMap.get("creator")) : null;
		//
		String free_duration = paramMap.get("free_duration") != null ? String.valueOf(paramMap.get("free_duration"))
				: null;
		String new_energy_free_duration_reduction = paramMap.get("new_energy_free_duration_reduction") != null
				? String.valueOf(paramMap.get("new_energy_free_duration_reduction"))
				: null;
		String temporary_car = paramMap.get("temporary_car") != null ? String.valueOf(paramMap.get("temporary_car"))
				: null;
		String stored_value_car = paramMap.get("stored_value_car") != null
				? String.valueOf(paramMap.get("stored_value_car"))
				: null;
		String new_energy_free_duration = paramMap.get("new_energy_free_duration") != null
				? String.valueOf(paramMap.get("new_energy_free_duration"))
				: null;
		String free_duration_reduction = paramMap.get("free_duration_reduction") != null
				? String.valueOf(paramMap.get("free_duration_reduction"))
				: null;
		String white_plate_car_free = paramMap.get("white_plate_car_free") != null
				? String.valueOf(paramMap.get("white_plate_car_free"))
				: null;
		String new_energy_free_times = paramMap.get("new_energy_free_times") != null
				? String.valueOf(paramMap.get("new_energy_free_times"))
				: null;
		String free_period_reduction = paramMap.get("free_period_reduction") != null
				? String.valueOf(paramMap.get("free_period_reduction"))
				: null;
		String segment_charging = paramMap.get("segment_charging") != null
				? String.valueOf(paramMap.get("segment_charging"))
				: null;

		String currentUserName = sdkOfGetCurrentUserName();
		// Insert into billing_rules table
		StringBuilder sql = new StringBuilder(
				"INSERT INTO billing_rules (rule_number, rule_name, rule_description, billing_standard, creator,"
						+ "free_duration,new_energy_free_duration_reduction,temporary_car,stored_value_car,new_energy_free_duration,free_duration_reduction,white_plate_car_free,new_energy_free_times,free_period_reduction,"
						+ " create_username, create_time,update_username,update_time,segment_charging) VALUES (?, ?, ?, ?, ?,  ?, ?, ?, ?, ?,?, ?,?,?,  ?, ?,?,?,?)");
		List<Object> params = new ArrayList<>();
		params.add(rule_number);
		params.add(rule_name);
		params.add(rule_description);
		params.add(billing_standard);
		params.add(currentUserName);

		params.add(free_duration);
		params.add(new_energy_free_duration_reduction);
		params.add(temporary_car);
		params.add(stored_value_car);
		params.add(new_energy_free_duration);
		params.add(free_duration_reduction);
		params.add(white_plate_car_free);
		params.add(new_energy_free_times);
		params.add(free_period_reduction);

		params.add(currentUserName);
		params.add(new Date());
		params.add(currentUserName);
		params.add(new Date());

		// 分段收费
		params.add(segment_charging);

		int insertRows = executeSQL(sql.toString(), params.toArray());
		List<Map<String, Object>> li = executeSQL("select max(id) as id from billing_rules");
		Integer curId = (Integer) li.get(0).get("id");

		StringBuilder newRuleSql = new StringBuilder("select * from billing_rules where id=" + curId);
		List<Map<String, Object>> newRules = executeSQL(newRuleSql.toString());
		Map<String, Object> newRule = newRules.isEmpty() ? null : newRules.get(0);
		
		StringBuilder newHolidaySql = new StringBuilder("select * from billing_holiday_schedule where billing_rule_id=" + curId);
		List<Map<String, Object>> newHolidays = executeSQL(newHolidaySql.toString());
		StringBuilder newTimeRangeSql = new StringBuilder("select * from billing_free_time_range where billing_rule_id=" + curId);
		List<Map<String, Object>> newTimeRanges = executeSQL(newTimeRangeSql.toString());
		
		
		saveBilllingRuleDetail(curId, paramMap);
		//saveBilllingStepMoney(curId, paramMap);
		
		_insertOperationRecord(curId, "新建", null, newRule,null,newHolidays,null,newTimeRanges);
		if (insertRows > 0) {
			return new Result(true, "计费规则保存成功", null);
		} else {
			return new Result(false, "计费规则保存失败", null);
		}
	}

	private int saveBilllingRuleDetail(int billingRuleId, Map<String, Object> paramMap) {
		/**
		 * 节假日
		 */
		saveBilllingHoliday(billingRuleId, paramMap);
		/**
		 * 阶梯计费
		 */
		saveBilllingStepMoney(billingRuleId, paramMap);
		/**
		 * 免费时段
		 */
		saveBilllingFreeTimeRange(billingRuleId, paramMap);
		return 0;
	}

	public int saveBilllingHoliday(int billingRuleId, Map<String, Object> paramMap) {
		/**
		 * 先删除再保存
		 */
		{
			List<Object> params = new ArrayList<>();
			params.add(billingRuleId);
			executeSQL("delete from billing_holiday_schedule where billing_rule_id=?", params.toArray());
		}

		Object list = paramMap.get("holiday_start_date");
		Object list2 = paramMap.get("holiday_end_date");
		Object list3 = paramMap.get("holiday_remarks");
		int sum = 0;
		if (list != null && list instanceof List) {
			List holiday_start_date_list = (List) list;
			List holiday_end_date_list = (List) list2;
			List holiday_remark_list = (List) list3;
			sum = holiday_start_date_list.size();
			for (int i = 0; i < holiday_start_date_list.size() && i < holiday_end_date_list.size()
					&& i < holiday_remark_list.size(); ++i) {
				StringBuilder sql = new StringBuilder(
						"INSERT INTO billing_holiday_schedule (holiday_start_date, holiday_end_date,holiday_remarks, billing_rule_id) VALUES (?, ?, ?,?)");
				List<Object> params = new ArrayList<>();
				params.add(holiday_start_date_list.get(i));
				params.add(holiday_end_date_list.get(i));
				params.add(holiday_remark_list.get(i));

				params.add(billingRuleId);
				int c = executeSQL(sql.toString(), params.toArray());
			}
		}

		/*
		 * int sum = 0; for (int i = 0; i < 20; ++i) { String holidayStartDate =
		 * paramMap.get("holiday_start_date" + i) != null ?
		 * String.valueOf(paramMap.get("holidayStartDate" + i)) : null; String
		 * holidayEndDate = paramMap.get("holidayEndDate" + i) != null ?
		 * String.valueOf(paramMap.get("holidayEndDate" + i)) : null; String
		 * holidayRemark = paramMap.get("holidayRemark" + i) != null ?
		 * String.valueOf(paramMap.get("holidayRemark" + i)) : null;
		 * 
		 * if (holidayStartDate == null || holidayEndDate == null) { continue; }
		 * StringBuilder sql = new StringBuilder(
		 * "INSERT INTO billing_holiday_schedule (holiday_start_date, holiday_end_date, holiday_remarks, billing_rule_id) VALUES (?, ?, ?, ?)"
		 * ); List<Object> params = new ArrayList<>(); params.add(holidayStartDate);
		 * params.add(holidayEndDate); params.add(holidayRemark);
		 * params.add(billingRuleId); int c = executeSQL(sql.toString(),
		 * params.toArray()); sum += c; }
		 */
		return sum;
	}

	private int saveBilllingStepMoney(int billingRuleId, Map<String, Object> paramMap) {

		StringBuilder sql = new StringBuilder("update billing_rules SET ");
		sql.append(" wd_temporary_car_first_tier=?,");
		sql.append(" wd_temporary_car_second_tier=?,");
		sql.append(" wd_temporary_car_third_tier=?,");
		sql.append(" wd_stored_value_car_first_tier=?,");
		sql.append(" wd_stored_value_car_second_tier=?,");
		sql.append(" wd_stored_value_car_third_tier=?,");
		sql.append(" wd_temporary_car_cap_amount=?,");
		sql.append(" wd_stored_value_car_cap_amount=?,");
		sql.append(" wd_begin_time_range=?,");
		sql.append(" wd_end_time_range=?,");

		sql.append(" wn_temporary_car_first_tier =?,");
		sql.append(" wn_temporary_car_second_tier =?,");
		sql.append(" wn_temporary_car_third_tier =?,");
		sql.append(" wn_stored_value_car_first_tier =?,");
		sql.append(" wn_stored_value_car_second_tier =?,");
		sql.append(" wn_stored_value_car_third_tier =?,");
		sql.append(" wn_temporary_car_cap_amount =?,");
		sql.append(" wn_stored_value_car_cap_amount =?,");
		sql.append(" wn_begin_time_range =?,");
		sql.append(" wn_end_time_range =?,");
		sql.append(" wn_second_begin_time_range =?,");
		sql.append(" wn_second_end_time_range =?,");

		sql.append(" hd_temporary_car_first_tier =?,");
		sql.append(" hd_temporary_car_second_tier =?,");
		sql.append(" hd_temporary_car_third_tier =?,");
		sql.append(" hd_stored_value_car_first_tier =?,");
		sql.append(" hd_stored_value_car_second_tier =?,");
		sql.append(" hd_stored_value_car_third_tier =?,");
		sql.append(" hd_temporary_car_cap_amount =?,");
		sql.append(" hd_stored_value_car_cap_amount =?,");
		sql.append(" hd_begin_time_range =?,");
		sql.append(" hd_end_time_range =?,");

		sql.append(" hn_temporary_car_first_tier =?,");
		sql.append(" hn_temporary_car_second_tier =?,");
		sql.append(" hn_temporary_car_third_tier =?,");
		sql.append(" hn_stored_value_car_first_tier =?,");
		sql.append(" hn_stored_value_car_second_tier =?,");
		sql.append(" hn_stored_value_car_third_tier =?,");
		sql.append(" hn_temporary_car_cap_amount =?,");
		sql.append(" hn_stored_value_car_cap_amount =?,");
		sql.append(" hn_begin_time_range =?,");
		sql.append(" hn_end_time_range =?,");
		sql.append(" hn_second_begin_time_range =?,");
		sql.append(" hn_second_end_time_range =?,");

		sql.append(" wd_temporary_car_first_time=?,");
		sql.append(" wd_temporary_car_second_time=?,");
		sql.append(" wd_temporary_car_third_time=?,");
		sql.append(" wd_stored_value_car_first_time=?,");
		sql.append(" wd_stored_value_car_second_time=?,");
		sql.append(" wd_stored_value_car_third_time=?,");
		sql.append(" wn_temporary_car_first_time =?,");
		sql.append(" wn_temporary_car_second_time =?,");
		sql.append(" wn_temporary_car_third_time =?,");
		sql.append(" wn_stored_value_car_first_time =?,");
		sql.append(" wn_stored_value_car_second_time =?,");
		sql.append(" wn_stored_value_car_third_time =?,");
		sql.append(" hd_temporary_car_first_time =?,");
		sql.append(" hd_temporary_car_second_time =?,");
		sql.append(" hd_temporary_car_third_time =?,");
		sql.append(" hd_stored_value_car_first_time =?,");
		sql.append(" hd_stored_value_car_second_time =?,");
		sql.append(" hd_stored_value_car_third_time =?,");
		sql.append(" hn_temporary_car_first_time =?,");
		sql.append(" hn_temporary_car_second_time =?,");
		sql.append(" hn_temporary_car_third_time =?,");
		sql.append(" hn_stored_value_car_first_time =?,");
		sql.append(" hn_stored_value_car_second_time =?,");
		sql.append(" hn_stored_value_car_third_time =?,");

		sql.append(" wd_temporary_car_first_ceil=?,");
		sql.append(" wd_temporary_car_second_ceil=?,");
		sql.append(" wd_temporary_car_third_ceil=?,");
		sql.append(" wd_stored_value_car_first_ceil=?,");
		sql.append(" wd_stored_value_car_second_ceil=?,");
		sql.append(" wd_stored_value_car_third_ceil=?,");
		sql.append(" wn_temporary_car_first_ceil =?,");
		sql.append(" wn_temporary_car_second_ceil =?,");
		sql.append(" wn_temporary_car_third_ceil =?,");
		sql.append(" wn_stored_value_car_first_ceil =?,");
		sql.append(" wn_stored_value_car_second_ceil =?,");
		sql.append(" wn_stored_value_car_third_ceil =?,");
		sql.append(" hd_temporary_car_first_ceil =?,");
		sql.append(" hd_temporary_car_second_ceil =?,");
		sql.append(" hd_temporary_car_third_ceil =?,");
		sql.append(" hd_stored_value_car_first_ceil =?,");
		sql.append(" hd_stored_value_car_second_ceil =?,");
		sql.append(" hd_stored_value_car_third_ceil =?,");
		sql.append(" hn_temporary_car_first_ceil =?,");
		sql.append(" hn_temporary_car_second_ceil =?,");
		sql.append(" hn_temporary_car_third_ceil =?,");
		sql.append(" hn_stored_value_car_first_ceil =?,");
		sql.append(" hn_stored_value_car_second_ceil =?,");
		sql.append(" hn_stored_value_car_third_ceil =?");

		sql.append(" where id=?");

		String wdTemporaryCarFirstTier = paramMap.get("wd_temporary_car_first_tier") != null
				? String.valueOf(paramMap.get("wd_temporary_car_first_tier"))
				: null;
		String wdTemporaryCarSecondTier = paramMap.get("wd_temporary_car_second_tier") != null
				? String.valueOf(paramMap.get("wd_temporary_car_second_tier"))
				: null;
		String wdTemporaryCarThirdTier = paramMap.get("wd_temporary_car_third_tier") != null
				? String.valueOf(paramMap.get("wd_temporary_car_third_tier"))
				: null;
		String wdStoredValueCarFirstTier = paramMap.get("wd_stored_value_car_first_tier") != null
				? String.valueOf(paramMap.get("wd_stored_value_car_first_tier"))
				: null;
		String wdStoredValueCarSecondTier = paramMap.get("wd_stored_value_car_second_tier") != null
				? String.valueOf(paramMap.get("wd_stored_value_car_second_tier"))
				: null;
		String wdStoredValueCarThirdTier = paramMap.get("wd_stored_value_car_third_tier") != null
				? String.valueOf(paramMap.get("wd_stored_value_car_third_tier"))
				: null;
		String wdTemporaryCarCapAmount = paramMap.get("wd_temporary_car_cap_amount") != null
				? String.valueOf(paramMap.get("wd_temporary_car_cap_amount"))
				: null;
		String wdStoredValueCarCapAmount = paramMap.get("wd_stored_value_car_cap_amount") != null
				? String.valueOf(paramMap.get("wd_stored_value_car_cap_amount"))
				: null;
		String wdBeginTimeRange = paramMap.get("wd_begin_time_range") != null
				? String.valueOf(paramMap.get("wd_begin_time_range"))
				: null;
		String wdEndTimeRange = paramMap.get("wd_end_time_range") != null
				? String.valueOf(paramMap.get("wd_end_time_range"))
				: null;

		String wnTemporaryCarFirstTier = paramMap.get("wn_temporary_car_first_tier") != null
				? String.valueOf(paramMap.get("wn_temporary_car_first_tier"))
				: null;
		String wnTemporaryCarSecondTier = paramMap.get("wn_temporary_car_second_tier") != null
				? String.valueOf(paramMap.get("wn_temporary_car_second_tier"))
				: null;
		String wnTemporaryCarThirdTier = paramMap.get("wn_temporary_car_third_tier") != null
				? String.valueOf(paramMap.get("wn_temporary_car_third_tier"))
				: null;
		String wnStoredValueCarFirstTier = paramMap.get("wn_stored_value_car_first_tier") != null
				? String.valueOf(paramMap.get("wn_stored_value_car_first_tier"))
				: null;
		String wnStoredValueCarSecondTier = paramMap.get("wn_stored_value_car_second_tier") != null
				? String.valueOf(paramMap.get("wn_stored_value_car_second_tier"))
				: null;
		String wnStoredValueCarThirdTier = paramMap.get("wn_stored_value_car_third_tier") != null
				? String.valueOf(paramMap.get("wn_stored_value_car_third_tier"))
				: null;
		String wnTemporaryCarCapAmount = paramMap.get("wn_temporary_car_cap_amount") != null
				? String.valueOf(paramMap.get("wn_temporary_car_cap_amount"))
				: null;
		String wnStoredValueCarCapAmount = paramMap.get("wn_stored_value_car_cap_amount") != null
				? String.valueOf(paramMap.get("wn_stored_value_car_cap_amount"))
				: null;
		String wnBeginTimeRange = paramMap.get("wn_begin_time_range") != null
				? String.valueOf(paramMap.get("wn_begin_time_range"))
				: null;
		String wnEndTimeRange = paramMap.get("wn_end_time_range") != null
				? String.valueOf(paramMap.get("wn_end_time_range"))
				: null;
		String wnSecondBeginTimeRange = paramMap.get("wn_second_begin_time_range") != null
				? String.valueOf(paramMap.get("wn_second_begin_time_range"))
				: null;
		String wnSecondEndTimeRange = paramMap.get("wn_second_end_time_range") != null
				? String.valueOf(paramMap.get("wn_second_end_time_range"))
				: null;

		String hdTemporaryCarFirstTier = paramMap.get("hd_temporary_car_first_tier") != null
				? String.valueOf(paramMap.get("hd_temporary_car_first_tier"))
				: null;
		String hdTemporaryCarSecondTier = paramMap.get("hd_temporary_car_second_tier") != null
				? String.valueOf(paramMap.get("hd_temporary_car_second_tier"))
				: null;
		String hdTemporaryCarThirdTier = paramMap.get("hd_temporary_car_third_tier") != null
				? String.valueOf(paramMap.get("hd_temporary_car_third_tier"))
				: null;
		String hdStoredValueCarFirstTier = paramMap.get("hd_stored_value_car_first_tier") != null
				? String.valueOf(paramMap.get("hd_stored_value_car_first_tier"))
				: null;
		String hdStoredValueCarSecondTier = paramMap.get("hd_stored_value_car_second_tier") != null
				? String.valueOf(paramMap.get("hd_stored_value_car_second_tier"))
				: null;
		String hdStoredValueCarThirdTier = paramMap.get("hd_stored_value_car_third_tier") != null
				? String.valueOf(paramMap.get("hd_stored_value_car_third_tier"))
				: null;
		String hdTemporaryCarCapAmount = paramMap.get("hd_temporary_car_cap_amount") != null
				? String.valueOf(paramMap.get("hd_temporary_car_cap_amount"))
				: null;
		String hdStoredValueCarCapAmount = paramMap.get("hd_stored_value_car_cap_amount") != null
				? String.valueOf(paramMap.get("hd_stored_value_car_cap_amount"))
				: null;
		String hdBeginTimeRange = paramMap.get("hd_begin_time_range") != null
				? String.valueOf(paramMap.get("hd_begin_time_range"))
				: null;
		String hdEndTimeRange = paramMap.get("hd_end_time_range") != null
				? String.valueOf(paramMap.get("hd_end_time_range"))
				: null;

		String hnTemporaryCarFirstTier = paramMap.get("hn_temporary_car_first_tier") != null
				? String.valueOf(paramMap.get("hn_temporary_car_first_tier"))
				: null;
		String hnTemporaryCarSecondTier = paramMap.get("hn_temporary_car_second_tier") != null
				? String.valueOf(paramMap.get("hn_temporary_car_second_tier"))
				: null;
		String hnTemporaryCarThirdTier = paramMap.get("hn_temporary_car_third_tier") != null
				? String.valueOf(paramMap.get("hn_temporary_car_third_tier"))
				: null;
		String hnStoredValueCarFirstTier = paramMap.get("hn_stored_value_car_first_tier") != null
				? String.valueOf(paramMap.get("hn_stored_value_car_first_tier"))
				: null;
		String hnStoredValueCarSecondTier = paramMap.get("hn_stored_value_car_second_tier") != null
				? String.valueOf(paramMap.get("hn_stored_value_car_second_tier"))
				: null;
		String hnStoredValueCarThirdTier = paramMap.get("hn_stored_value_car_third_tier") != null
				? String.valueOf(paramMap.get("hn_stored_value_car_third_tier"))
				: null;

		String hnTemporaryCarCapAmount = paramMap.get("hn_temporary_car_cap_amount") != null
				? String.valueOf(paramMap.get("hn_temporary_car_cap_amount"))
				: null;
		String hnStoredValueCarCapAmount = paramMap.get("hn_stored_value_car_cap_amount") != null
				? String.valueOf(paramMap.get("hn_stored_value_car_cap_amount"))
				: null;
		String hnBeginTimeRange = paramMap.get("hn_begin_time_range") != null
				? String.valueOf(paramMap.get("hn_begin_time_range"))
				: null;
		String hnEndTimeRange = paramMap.get("hn_end_time_range") != null
				? String.valueOf(paramMap.get("hn_end_time_range"))
				: null;
		String hnSecondBeginTimeRange = paramMap.get("hn_second_begin_time_range") != null
				? String.valueOf(paramMap.get("hn_second_begin_time_range"))
				: null;
		String hnSecondEndTimeRange = paramMap.get("hn_second_end_time_range") != null
				? String.valueOf(paramMap.get("hn_second_end_time_range"))
				: null;

		String wdTemporaryCarFirstTime = paramMap.get("wd_temporary_car_first_time") != null
				? String.valueOf(paramMap.get("wd_temporary_car_first_time"))
				: null;
		String wdTemporaryCarSecondTime = paramMap.get("wd_temporary_car_second_time") != null
				? String.valueOf(paramMap.get("wd_temporary_car_second_time"))
				: null;
		String wdTemporaryCarThirdTime = paramMap.get("wd_temporary_car_third_time") != null
				? String.valueOf(paramMap.get("wd_temporary_car_third_time"))
				: null;
		String wdStoredValueCarFirstTime = paramMap.get("wd_stored_value_car_first_time") != null
				? String.valueOf(paramMap.get("wd_stored_value_car_first_time"))
				: null;
		String wdStoredValueCarSecondTime = paramMap.get("wd_stored_value_car_second_time") != null
				? String.valueOf(paramMap.get("wd_stored_value_car_second_time"))
				: null;
		String wdStoredValueCarThirdTime = paramMap.get("wd_stored_value_car_third_time") != null
				? String.valueOf(paramMap.get("wd_stored_value_car_third_time"))
				: null;

		String wnTemporaryCarFirstTime = paramMap.get("wn_temporary_car_first_time") != null
				? String.valueOf(paramMap.get("wn_temporary_car_first_time"))
				: null;
		String wnTemporaryCarSecondTime = paramMap.get("wn_temporary_car_second_time") != null
				? String.valueOf(paramMap.get("wn_temporary_car_second_time"))
				: null;
		String wnTemporaryCarThirdTime = paramMap.get("wn_temporary_car_third_time") != null
				? String.valueOf(paramMap.get("wn_temporary_car_third_time"))
				: null;
		String wnStoredValueCarFirstTime = paramMap.get("wn_stored_value_car_first_time") != null
				? String.valueOf(paramMap.get("wn_stored_value_car_first_time"))
				: null;
		String wnStoredValueCarSecondTime = paramMap.get("wn_stored_value_car_second_time") != null
				? String.valueOf(paramMap.get("wn_stored_value_car_second_time"))
				: null;
		String wnStoredValueCarThirdTime = paramMap.get("wn_stored_value_car_third_time") != null
				? String.valueOf(paramMap.get("wn_stored_value_car_third_time"))
				: null;

		String hdTemporaryCarFirstTime = paramMap.get("hd_temporary_car_first_time") != null
				? String.valueOf(paramMap.get("hd_temporary_car_first_time"))
				: null;
		String hdTemporaryCarSecondTime = paramMap.get("hd_temporary_car_second_time") != null
				? String.valueOf(paramMap.get("hd_temporary_car_second_time"))
				: null;
		String hdTemporaryCarThirdTime = paramMap.get("hd_temporary_car_third_time") != null
				? String.valueOf(paramMap.get("hd_temporary_car_third_time"))
				: null;
		String hdStoredValueCarFirstTime = paramMap.get("hd_stored_value_car_first_time") != null
				? String.valueOf(paramMap.get("hd_stored_value_car_first_time"))
				: null;
		String hdStoredValueCarSecondTime = paramMap.get("hd_stored_value_car_second_time") != null
				? String.valueOf(paramMap.get("hd_stored_value_car_second_time"))
				: null;
		String hdStoredValueCarThirdTime = paramMap.get("hd_stored_value_car_third_time") != null
				? String.valueOf(paramMap.get("hd_stored_value_car_third_time"))
				: null;

		String hnTemporaryCarFirstTime = paramMap.get("hn_temporary_car_first_time") != null
				? String.valueOf(paramMap.get("hn_temporary_car_first_time"))
				: null;
		String hnTemporaryCarSecondTime = paramMap.get("hn_temporary_car_second_time") != null
				? String.valueOf(paramMap.get("hn_temporary_car_second_time"))
				: null;
		String hnTemporaryCarThirdTime = paramMap.get("hn_temporary_car_third_time") != null
				? String.valueOf(paramMap.get("hn_temporary_car_third_time"))
				: null;
		String hnStoredValueCarFirstTime = paramMap.get("hn_stored_value_car_first_time") != null
				? String.valueOf(paramMap.get("hn_stored_value_car_first_time"))
				: null;
		String hnStoredValueCarSecondTime = paramMap.get("hn_stored_value_car_second_time") != null
				? String.valueOf(paramMap.get("hn_stored_value_car_second_time"))
				: null;
		String hnStoredValueCarThirdTime = paramMap.get("hn_stored_value_car_third_time") != null
				? String.valueOf(paramMap.get("hn_stored_value_car_third_time"))
				: null;

		String wdTemporaryCarFirstCeil = paramMap.get("wd_temporary_car_first_ceil") != null
				? String.valueOf(paramMap.get("wd_temporary_car_first_ceil"))
				: null;
		String wdTemporaryCarSecondCeil = paramMap.get("wd_temporary_car_second_ceil") != null
				? String.valueOf(paramMap.get("wd_temporary_car_second_ceil"))
				: null;
		String wdTemporaryCarThirdCeil = paramMap.get("wd_temporary_car_third_ceil") != null
				? String.valueOf(paramMap.get("wd_temporary_car_third_ceil"))
				: null;
		String wdStoredValueCarFirstCeil = paramMap.get("wd_stored_value_car_first_ceil") != null
				? String.valueOf(paramMap.get("wd_stored_value_car_first_ceil"))
				: null;
		String wdStoredValueCarSecondCeil = paramMap.get("wd_stored_value_car_second_ceil") != null
				? String.valueOf(paramMap.get("wd_stored_value_car_second_ceil"))
				: null;
		String wdStoredValueCarThirdCeil = paramMap.get("wd_stored_value_car_third_ceil") != null
				? String.valueOf(paramMap.get("wd_stored_value_car_third_ceil"))
				: null;

		String wnTemporaryCarFirstCeil = paramMap.get("wn_temporary_car_first_ceil") != null
				? String.valueOf(paramMap.get("wn_temporary_car_first_ceil"))
				: null;
		String wnTemporaryCarSecondCeil = paramMap.get("wn_temporary_car_second_ceil") != null
				? String.valueOf(paramMap.get("wn_temporary_car_second_ceil"))
				: null;
		String wnTemporaryCarThirdCeil = paramMap.get("wn_temporary_car_third_ceil") != null
				? String.valueOf(paramMap.get("wn_temporary_car_third_ceil"))
				: null;
		String wnStoredValueCarFirstCeil = paramMap.get("wn_stored_value_car_first_ceil") != null
				? String.valueOf(paramMap.get("wn_stored_value_car_first_ceil"))
				: null;
		String wnStoredValueCarSecondCeil = paramMap.get("wn_stored_value_car_second_ceil") != null
				? String.valueOf(paramMap.get("wn_stored_value_car_second_ceil"))
				: null;
		String wnStoredValueCarThirdCeil = paramMap.get("wn_stored_value_car_third_ceil") != null
				? String.valueOf(paramMap.get("wn_stored_value_car_third_ceil"))
				: null;

		String hdTemporaryCarFirstCeil = paramMap.get("hd_temporary_car_first_ceil") != null
				? String.valueOf(paramMap.get("hd_temporary_car_first_ceil"))
				: null;
		String hdTemporaryCarSecondCeil = paramMap.get("hd_temporary_car_second_ceil") != null
				? String.valueOf(paramMap.get("hd_temporary_car_second_ceil"))
				: null;
		String hdTemporaryCarThirdCeil = paramMap.get("hd_temporary_car_third_ceil") != null
				? String.valueOf(paramMap.get("hd_temporary_car_third_ceil"))
				: null;
		String hdStoredValueCarFirstCeil = paramMap.get("hd_stored_value_car_first_ceil") != null
				? String.valueOf(paramMap.get("hd_stored_value_car_first_ceil"))
				: null;
		String hdStoredValueCarSecondCeil = paramMap.get("hd_stored_value_car_second_ceil") != null
				? String.valueOf(paramMap.get("hd_stored_value_car_second_ceil"))
				: null;
		String hdStoredValueCarThirdCeil = paramMap.get("hd_stored_value_car_third_ceil") != null
				? String.valueOf(paramMap.get("hd_stored_value_car_third_ceil"))
				: null;

		String hnTemporaryCarFirstCeil = paramMap.get("hn_temporary_car_first_ceil") != null
				? String.valueOf(paramMap.get("hn_temporary_car_first_ceil"))
				: null;
		String hnTemporaryCarSecondCeil = paramMap.get("hn_temporary_car_second_ceil") != null
				? String.valueOf(paramMap.get("hn_temporary_car_second_ceil"))
				: null;
		String hnTemporaryCarThirdCeil = paramMap.get("hn_temporary_car_third_ceil") != null
				? String.valueOf(paramMap.get("hn_temporary_car_third_ceil"))
				: null;
		String hnStoredValueCarFirstCeil = paramMap.get("hn_stored_value_car_first_ceil") != null
				? String.valueOf(paramMap.get("hn_stored_value_car_first_ceil"))
				: null;
		String hnStoredValueCarSecondCeil = paramMap.get("hn_stored_value_car_second_ceil") != null
				? String.valueOf(paramMap.get("hn_stored_value_car_second_ceil"))
				: null;
		String hnStoredValueCarThirdCeil = paramMap.get("hn_stored_value_car_third_ceil") != null
				? String.valueOf(paramMap.get("hn_stored_value_car_third_ceil"))
				: null;

		List<Object> params = new ArrayList<>();

		params.add(wdTemporaryCarFirstTier);
		params.add(wdTemporaryCarSecondTier);
		params.add(wdTemporaryCarThirdTier);
		params.add(wdStoredValueCarFirstTier);
		params.add(wdStoredValueCarSecondTier);
		params.add(wdStoredValueCarThirdTier);
		params.add(wdTemporaryCarCapAmount);
		params.add(wdStoredValueCarCapAmount);
		params.add(wdBeginTimeRange);
		params.add(wdEndTimeRange);

		params.add(wnTemporaryCarFirstTier);
		params.add(wnTemporaryCarSecondTier);
		params.add(wnTemporaryCarThirdTier);
		params.add(wnStoredValueCarFirstTier);
		params.add(wnStoredValueCarSecondTier);
		params.add(wnStoredValueCarThirdTier);
		params.add(wnTemporaryCarCapAmount);
		params.add(wnStoredValueCarCapAmount);
		params.add(wnBeginTimeRange);
		params.add(wnEndTimeRange);
		params.add(wnSecondBeginTimeRange);
		params.add(wnSecondEndTimeRange);

		params.add(hdTemporaryCarFirstTier);
		params.add(hdTemporaryCarSecondTier);
		params.add(hdTemporaryCarThirdTier);
		params.add(hdStoredValueCarFirstTier);
		params.add(hdStoredValueCarSecondTier);
		params.add(hdStoredValueCarThirdTier);
		params.add(hdTemporaryCarCapAmount);
		params.add(hdStoredValueCarCapAmount);
		params.add(hdBeginTimeRange);
		params.add(hdEndTimeRange);

		params.add(hnTemporaryCarFirstTier);
		params.add(hnTemporaryCarSecondTier);
		params.add(hnTemporaryCarThirdTier);
		params.add(hnStoredValueCarFirstTier);
		params.add(hnStoredValueCarSecondTier);
		params.add(hnStoredValueCarThirdTier);
		params.add(hnTemporaryCarCapAmount);
		params.add(hnStoredValueCarCapAmount);
		params.add(hnBeginTimeRange);
		params.add(hnEndTimeRange);
		params.add(hnSecondBeginTimeRange);
		params.add(hnSecondEndTimeRange);

		params.add(wdTemporaryCarFirstTime);
		params.add(wdTemporaryCarSecondTime);
		params.add(wdTemporaryCarThirdTime);
		params.add(wdStoredValueCarFirstTime);
		params.add(wdStoredValueCarSecondTime);
		params.add(wdStoredValueCarThirdTime);
		params.add(wnTemporaryCarFirstTime);
		params.add(wnTemporaryCarSecondTime);
		params.add(wnTemporaryCarThirdTime);
		params.add(wnStoredValueCarFirstTime);
		params.add(wnStoredValueCarSecondTime);
		params.add(wnStoredValueCarThirdTime);
		params.add(hdTemporaryCarFirstTime);
		params.add(hdTemporaryCarSecondTime);
		params.add(hdTemporaryCarThirdTime);
		params.add(hdStoredValueCarFirstTime);
		params.add(hdStoredValueCarSecondTime);
		params.add(hdStoredValueCarThirdTime);
		params.add(hnTemporaryCarFirstTime);
		params.add(hnTemporaryCarSecondTime);
		params.add(hnTemporaryCarThirdTime);
		params.add(hnStoredValueCarFirstTime);
		params.add(hnStoredValueCarSecondTime);
		params.add(hnStoredValueCarThirdTime);

		params.add(wdTemporaryCarFirstCeil);
		params.add(wdTemporaryCarSecondCeil);
		params.add(wdTemporaryCarThirdCeil);
		params.add(wdStoredValueCarFirstCeil);
		params.add(wdStoredValueCarSecondCeil);
		params.add(wdStoredValueCarThirdCeil);
		params.add(wnTemporaryCarFirstCeil);
		params.add(wnTemporaryCarSecondCeil);
		params.add(wnTemporaryCarThirdCeil);
		params.add(wnStoredValueCarFirstCeil);
		params.add(wnStoredValueCarSecondCeil);
		params.add(wnStoredValueCarThirdCeil);
		params.add(hdTemporaryCarFirstCeil);
		params.add(hdTemporaryCarSecondCeil);
		params.add(hdTemporaryCarThirdCeil);
		params.add(hdStoredValueCarFirstCeil);
		params.add(hdStoredValueCarSecondCeil);
		params.add(hdStoredValueCarThirdCeil);
		params.add(hnTemporaryCarFirstCeil);
		params.add(hnTemporaryCarSecondCeil);
		params.add(hnTemporaryCarThirdCeil);
		params.add(hnStoredValueCarFirstCeil);
		params.add(hnStoredValueCarSecondCeil);
		params.add(hnStoredValueCarThirdCeil);

		params.add(billingRuleId);
		int c = executeSQL(sql.toString(), params.toArray());
		return c;

	}

	public int saveBilllingFreeTimeRange(int billingRuleId, Map<String, Object> paramMap) {
		/**
		 * 先删除再保存
		 */
		{
			List<Object> params = new ArrayList<>();
			params.add(billingRuleId);
			executeSQL("delete from billing_free_time_range where billing_rule_id=?", params.toArray());
		}
		int sum = 0;
		Object list = paramMap.get("free_Begin_Time");
		Object list2 = paramMap.get("free_end_time");
		if (list != null && list instanceof List) {
			List free_Begin_Time_list = (List) list;
			List free_end_time_list = (List) list2;
			for (int i = 0; i < free_Begin_Time_list.size() && i < free_end_time_list.size(); ++i) {
				StringBuilder sql = new StringBuilder(
						"INSERT INTO billing_free_time_range (free_begin_time, free_end_time, billing_rule_id) VALUES (?, ?, ?)");
				List<Object> params = new ArrayList<>();
				params.add(free_Begin_Time_list.get(i));
				params.add(free_end_time_list.get(i));
				params.add(billingRuleId);
				int c = executeSQL(sql.toString(), params.toArray());
			}
		}
		/*
		 * for (int i = 0; i < 10; ++i) { String freeBeginTime =
		 * paramMap.get("freeBeginTime" + i) != null ?
		 * String.valueOf(paramMap.get("freeBeginTime" + i)) : null; String freeEndTime
		 * = paramMap.get("freeEndTime" + i) != null ?
		 * String.valueOf(paramMap.get("freeEndTime" + i)) : null;
		 * 
		 * if (freeBeginTime == null || freeEndTime == null) { continue; } StringBuilder
		 * sql = new StringBuilder(
		 * "INSERT INTO billing_free_time_range (free_begin_time, free_end_time, billing_rule_id) VALUES (?, ?, ?)"
		 * ); List<Object> params = new ArrayList<>(); params.add(freeBeginTime);
		 * params.add(freeEndTime); params.add(billingRuleId); int c =
		 * executeSQL(sql.toString(), params.toArray()); sum += c; }
		 */
		return sum;
	}

	public Result refreshBillingManagementList(Map<String, Object> paramMap) {
		// Extract pagination parameters
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		// Query billing rules with pagination
		StringBuilder sql = new StringBuilder(
				"SELECT id, rule_number, rule_name, billing_standard, rule_description, create_time, creator FROM billing_rules ORDER BY create_time DESC LIMIT ?, ?");
		List<Object> params = new ArrayList<>();
		params.add((current - 1) * pageSize);
		params.add(pageSize);
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		// Count total records
		String countSql = "SELECT COUNT(*) AS total FROM billing_rules";
		List<Map<String, Object>> countResult = executeSQL(countSql);
		int total = countResult.get(0).get("total") != null
				? Integer.valueOf(String.valueOf(countResult.get(0).get("total")))
				: 0;
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("total", total);
		resultData.put("data", data);
		return new Result(true, "计费管理列表刷新成功", resultData);
	}

	public Result getAssociatedParkingLots(Map<String, Object> paramMap) {
		// 获取分页参数
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		// 获取计费规则ID
		Integer billingRuleId = paramMap.get("billingRuleId") != null
				? Integer.valueOf(String.valueOf(paramMap.get("billingRuleId")))
				: null;
		// 构建查询SQL
		StringBuilder sql = new StringBuilder(
				"SELECT apl.id, apl.parking_lot_code, apl.parking_lot_name, apl.create_time, apl.parking_lot_status, apl.manager ");
		sql.append("FROM parking_lot_info apl ");
		sql.append("JOIN billing_rules br ON br.id = apl.billing_rule_id ");
		sql.append("WHERE 1=1 ");
		List<Object> params = new ArrayList<>();
		if (billingRuleId != null) {
			sql.append("AND br.id = ? ");
			params.add(billingRuleId);
		}
		sql.append("ORDER BY apl.create_time DESC ");
		sql.append("LIMIT ?, ?");
		params.add((current - 1) * pageSize);
		params.add(pageSize);
		// 执行查询SQL
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		// 构建查询总数SQL
		StringBuilder countSql = new StringBuilder("SELECT COUNT(*) ");
		countSql.append("FROM parking_lot_info apl ");
		countSql.append("JOIN billing_rules br ON br.id = apl.id ");
		countSql.append("WHERE 1=1 ");
		List<Object> countParams = new ArrayList<>();
		if (billingRuleId != null) {
			countSql.append("AND br.id = ? ");
			countParams.add(billingRuleId);
		}
		// 执行查询总数SQL
		List<Map<String, Object>> countResult = executeSQL(countSql.toString(), countParams.toArray());
		Integer total = countResult != null && !countResult.isEmpty()
				? Integer.valueOf(String.valueOf(countResult.get(0).get("COUNT(*)")))
				: 0;
		// 返回结果
		RowUtil.setRowNumber(data, pageSize, current);
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("total", total);
		resultData.put("data", data);
		return new Result(true, "查询成功", resultData);
	}

	public Result changeSegmentedBilling(Map<String, Object> paramMap) {
		// Initialize the result object
		Result result = new Result();
		result.setFlag(true);
		result.setMessage("Dynamic panel state updated successfully.");
		return result;
	}

	public Result changeSegmentedBilling2(Map<String, Object> paramMap) {
		// Initialize the result object
		Result result = new Result();
		result.setFlag(true);
		result.setMessage("Dynamic panel state updated successfully.");
		return result;
	}

	public Result addHolidayComponent(Map<String, Object> paramMap) {
		// 获取当前用户ID
		Integer userId = sdkOfGetCurrentUserId();
		// 获取参数
		String holiday_remarks = paramMap.get("holiday_remarks") != null
				? String.valueOf(paramMap.get("holiday_remarks"))
				: null;
		String dateRangeholiday_start_date = paramMap.get("holiday_start_date") != null
				? (String) paramMap.get("holiday_start_date")
				: null;
		String holiday_end_date = paramMap.get("holiday_end_date") != null ? (String) paramMap.get("holiday_end_date")
				: null;
		// 检查日期范围是否为空

		// 构建插入SQL
		StringBuilder insertSql = new StringBuilder(
				"INSERT INTO billing_holiday_schedule (holiday_start_date, holiday_end_date, holiday_remarks, user_id) VALUES (?, ?, ?, ?)");
		List<Object> params = new ArrayList<>();
		params.add(dateRangeholiday_start_date);
		params.add(holiday_end_date);
		params.add(holiday_remarks);
		params.add(userId);
		// 执行SQL
		int insertRows = executeSQL(insertSql.toString(), params.toArray());
		// 返回结果
		if (insertRows > 0) {
			return new Result(true, "节假日动态组件添加成功", null);
		} else {
			return new Result(false, "节假日动态组件添加失败", null);
		}
	}

	public Result getHolidaysList(Map<String, Object> paramMap) {
		/*
		 * Integer current = paramMap.get("current") != null ?
		 * Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1; Integer
		 * pageSize = paramMap.get("pageSize") != null ?
		 * Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
		 */
		StringBuilder sql = new StringBuilder(
				"select id,holiday_start_date, holiday_end_date, holiday_remarks,user_id, billing_rule_id  from  billing_holiday_schedule  where 1=1");
		// 获取参数
		String billing_rule_id = paramMap.get("billing_rule_id") != null
				? String.valueOf(paramMap.get("billing_rule_id"))
				: null;
		List<Object> params = new ArrayList<>();
		if (billing_rule_id != null && !billing_rule_id.isEmpty()) {
			sql.append(" AND billing_rule_id = ?");
			params.add(Integer.parseInt(billing_rule_id));
		}
		// 执行SQL
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		// 返回结果
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("total", data.size());
		resultData.put("data", data);
		return new Result(true, "查询成功", resultData);
	}

	public Result getFreeTimeRange(Map<String, Object> paramMap) {

		StringBuilder sql = new StringBuilder(
				"select  id,free_begin_time, free_end_time,  billing_rule_id  from  billing_free_time_range  where 1=1");
		// 获取参数
		String billing_rule_id = paramMap.get("billing_rule_id") != null
				? String.valueOf(paramMap.get("billing_rule_id"))
				: null;
		List<Object> params = new ArrayList<>();
		if (billing_rule_id != null && !billing_rule_id.isEmpty()) {
			sql.append(" AND billing_rule_id = ?");
			params.add(Integer.parseInt(billing_rule_id));
		}
		// 执行SQL
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		// 返回结果
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("total", data.size());
		resultData.put("data", data);
		return new Result(true, "查询成功", resultData);
	}

	public Result getBillingRuleDetails(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		Integer ruleId = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
		if (ruleId == null) {
			return new Result(false, "Rule ID is required", null);
		}
		// SQL to get rule information
		StringBuilder sql = new StringBuilder("SELECT * FROM billing_rules WHERE id = ?");
		List<Map<String, Object>> data = executeSQL(sql.toString(), ruleId);
		// RowUtil.setRowNumber(data, pageSize, current);
		if (data.isEmpty()) {
			return new Result(false, "No rule information found", null);
		}
		return new Result(true, "Success", data.get(0));
	}

	public Result searchBillingManagementList(Map<String, Object> paramMap) {
		// 构建查询SQL
		// Creationtimevalue1 Creatorvalue1 RuleNamevalue1 chargingstandardvalue1
		// {"RuleNamevalue1":"呜呜呜呜","chargingstandardvalue1":["免费停车","按次收费"],"Creatorvalue1":"xxx","Creationtimevalue1":["2024-10-08","2024-10-23"],"current":1,"pageSize":10}
		StringBuilder sql = new StringBuilder("SELECT * FROM billing_rules WHERE 1=1");
		// 查询总条数
		StringBuilder countSql = new StringBuilder("SELECT COUNT(*) AS total FROM billing_rules WHERE 1=1");

		List<Object> params = new ArrayList<>();
		// 规则名称模糊查询
		String ruleName = paramMap.get("RuleNamevalue1") != null ? String.valueOf(paramMap.get("RuleNamevalue1"))
				: null;
		if (!StringUtils.isBlank(ruleName)) {
			String item = " AND rule_name LIKE ?";
			sql.append(item);
			countSql.append(item);
			params.add("%" + ruleName + "%");
		}
		String creator = paramMap.get("Creatorvalue1") != null ? String.valueOf(paramMap.get("Creatorvalue1")) : null;
		if (!StringUtils.isBlank(creator)) {
			String item = " AND creator LIKE ?";
			sql.append(item);
			countSql.append(item);
			params.add("%" + creator + "%");
		}
		// 收费标准查询 chargingstandardvalue1
		Object chargingstandardvalue1 = paramMap.get("chargingstandardvalue1");

		if (chargingstandardvalue1 != null && chargingstandardvalue1 instanceof List) {
			List strs = (List) chargingstandardvalue1;
			if (strs.size() == 1) {
				String item = " AND billing_standard = ?";
				sql.append(item);
				countSql.append(item);
				params.add(strs.get(0).toString());
			} else if (strs.size() > 1) {
				String item = " AND billing_standard in (?";
				sql.append(item);
				countSql.append(item);
				params.add(strs.get(0).toString());
				for (int i = 1; i < strs.size() - 1; ++i) {
					sql.append(",?");
					countSql.append(",?");
					params.add(strs.get(i));
				}
				sql.append("?)");
				countSql.append("?)");
				params.add(strs.get(strs.size() - 1));
			}
		}
		// 创建时间查询
		Object Creationtimevalue1 = paramMap.get("Creationtimevalue1");
		if (Creationtimevalue1 != null && Creationtimevalue1 instanceof List) {
			List times = (List) Creationtimevalue1;
			if (times.size() == 2) {
				String item = " AND create_time >= ? and create_time<=?";
				sql.append(item);
				countSql.append(item);
				params.add(times.get(0).toString());
				params.add(times.get(1).toString());
			}

		}

		// 分页和排序
		sql.append(" ORDER BY create_time DESC LIMIT ?, ?");
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		params.add((current - 1) * pageSize);
		params.add(pageSize);
		// 执行查询
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		// 不包括分页参数
		List<Object> countParams = new ArrayList<>(params.subList(0, params.size() - 2));
		List<Map<String, Object>> countResult = executeSQL(countSql.toString(), countParams.toArray());
		Integer total = countResult.get(0).get("total") != null
				? Integer.valueOf(String.valueOf(countResult.get(0).get("total")))
				: 0;
		// 返回结果
		if (data != null && !data.isEmpty()) {
			data.forEach(r -> {
				Integer id = (Integer) r.get("id");
				if (id != null) {
					List<Map<String, Object>> counterR = executeSQL(
							"select count(1) as counter from billing_rule_parking where billing_rule_id=?", id);
					if (counterR != null && !counterR.isEmpty() && null != counterR.get(0).get("counter")) {
						int ct = Integer.valueOf(counterR.get(0).get("counter").toString());
						r.put("associated_parking_count", ct);
						// associated_parking_count
					}
				}
			});
		}
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("total", total);
		resultData.put("data", data);
		return new Result(true, "查询成功", resultData);
	}
////////////////////////////////////////////////////

	public Result getRuleInfo(Map<String, Object> paramMap) {
		// 获取规则ID
		Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
		// 构建查询SQL
		StringBuilder sql = new StringBuilder("SELECT * FROM billing_rules WHERE id = ?");
		List<Object> params = new ArrayList<>();
		params.add(id);
		// 执行查询
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		// 返回结果
		if (data.isEmpty()) {
			return new Result(false, "未找到对应的规则信息", null);
		} else {
			return new Result(true, "查询成功", data.get(0));
		}
	}

	public Result fetchTableData(Map<String, Object> paramMap) {
		// Initialize the result object
		Result result = new Result();
		// Extract pagination parameters
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		// Calculate offset for pagination
		int offset = (current - 1) * pageSize;
		// Construct SQL for fetching data with pagination
		StringBuilder sql = new StringBuilder("SELECT * ");
		sql.append("FROM parking_lot_info ");
		sql.append("ORDER BY create_time DESC ");
		sql.append("LIMIT ? OFFSET ?");
		// Execute SQL and fetch data
		List<Map<String, Object>> data = executeSQL(sql.toString(), pageSize, offset);
		// Construct SQL for counting total records
		String countSql = "SELECT COUNT(*) AS total FROM parking_lot_info ";
		// Execute SQL and fetch total count
		List<Map<String, Object>> countResult = executeSQL(countSql);
		int total = countResult.isEmpty() ? 0 : Integer.valueOf(String.valueOf(countResult.get(0).get("total")));
		// Set result data
		Map<String, Object> resultData = new HashMap<>();
		RowUtil.setRowNumber(data, pageSize, current);
		resultData.put("data", data);
		resultData.put("total", total);
		// Set result properties
		result.setFlag(true);
		result.setMessage("Data fetched successfully");
		result.setData(resultData);
		return result;
	}

	public Result syncHolidayTimes(Map<String, Object> paramMap) {
		// 获取当前年份
		/*
		 * int currentYear = Year.now().getValue(); // 获取当前登录者的用户名 String
		 * currentUserName = sdkOfGetCurrentUserName(); // 查询当年的中国节假日时间 StringBuilder
		 * selectSql = new
		 * StringBuilder("SELECT id, serial_number, holiday_date, holiday_name FROM holiday_time_table WHERE YEAR(holiday_date) = ?"
		 * ); List<Object> selectParams = new ArrayList<>();
		 * selectParams.add(currentYear); List<Map<String, Object>> holidayTimes =
		 * executeSQL(selectSql.toString(), selectParams.toArray()); //
		 * 插入到拷贝_拷贝_拷贝_节假日时间表6 StringBuilder insertSql = new
		 * StringBuilder("INSERT INTO copy_holiday_time_table (serial_number, start_date, end_date, remarks, create_time, create_username, update_time, update_username) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
		 * ); Timestamp currentTime = new Timestamp(System.currentTimeMillis()); for
		 * (Map<String, Object> holiday : holidayTimes) { List<Object> insertParams =
		 * new ArrayList<>(); Integer serialNumber = holiday.get("serial_number") !=
		 * null ? Integer.valueOf(String.valueOf(holiday.get("serial_number"))) : null;
		 * Date holidayDate = holiday.get("holiday_date") != null ?
		 * Date.valueOf(String.valueOf(holiday.get("holiday_date"))) : null; String
		 * holidayName = holiday.get("holiday_name") != null ?
		 * String.valueOf(holiday.get("holiday_name")) : null;
		 * insertParams.add(serialNumber); insertParams.add(holidayDate);
		 * insertParams.add(holidayDate); insertParams.add(holidayName);
		 * insertParams.add(currentTime); insertParams.add(currentUserName);
		 * insertParams.add(currentTime); insertParams.add(currentUserName);
		 * executeSQL(insertSql.toString(), insertParams.toArray()); }
		 */
		// 返回结果
		Result result = new Result();
		result.setFlag(true);
		result.setMessage("同步节假日时间成功");
		return result;
	}

	void multiParams(List<String> queryList, StringBuilder sql, List<Object> params, String fieldName) {
		// TODO XXXXXXXXXXXXXXX
		if (queryList != null && queryList.size() > 0) {
			if (queryList.size() == 1 && !StringUtils.isEmpty(queryList.get(0))) {
				sql.append(" AND " + fieldName + " = ? ");
				if (params != null) {
					params.add(queryList.get(0));
				}
			} else {
				sql.append(" AND " + fieldName + " in(?");
				if (params != null) {
					params.add(queryList.get(0));
				}
				for (int i = 1; i < queryList.size() - 1; ++i) {
					sql.append(" ,?");
					if (params != null) {
						params.add(queryList.get(i));
					}
				}
				sql.append(" ,?) ");
				if (params != null) {
					params.add(queryList.get(queryList.size() - 1));
				}
			}
		}
	}

	public Result deleteHoliday(Map<String, Object> paramMap) {
		Result result = new Result();
		String id = paramMap.get("id").toString();
		executeSQL("delete from billing_holiday_schedule where id=" + id);
		result.setFlag(true);
		result.setMessage("删除成功");
		return result;
	}

	public Result deleteHolidayByRule(Map<String, Object> paramMap) {
		Result result = new Result();
		String id = paramMap.get("billing_rule_id").toString();
		executeSQL("delete from billing_holiday_schedule where billing_rule_id=" + id);
		result.setFlag(true);
		result.setMessage("删除成功");
		return result;
	}

	public Result deleteFreeTimeRange(Map<String, Object> paramMap) {
		Result result = new Result();
		String id = paramMap.get("id").toString();
		executeSQL("delete from billing_free_time_range where id=" + id);
		result.setFlag(true);
		result.setMessage("删除成功");
		return result;
	}

	public Result deleteFreeTimeRangeByRule(Map<String, Object> paramMap) {
		Result result = new Result();
		String id = paramMap.get("billing_rule_id").toString();
		executeSQL("delete from billing_free_time_range where billing_rule_id=" + id);
		result.setFlag(true);
		result.setMessage("删除成功");
		return result;
	}

	public Result getYardListByRule(Map<String, Object> paramMap) {

		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		Integer billing_rule_id = paramMap.get("billing_rule_id") != null
				? Integer.valueOf(String.valueOf(paramMap.get("billing_rule_id")))
				: null;
		if (billing_rule_id == null) {
			return new Result(false, "缺少参数：billing_rule_id");
		}
		// Query billing rules with pagination
		StringBuilder sql = new StringBuilder(
				"select a.*,b.relation_time,b.create_username as relation_username,b.enable_status as enable_status from parking_lot_info a  join billing_rule_parking b on b.parking_lot_info_id=a.id  where 1=1 ");
		List<Object> params = new ArrayList<>();
		sql.append(" and b.billing_rule_id =? ");
		params.add(billing_rule_id);

		sql.append(" ORDER BY a.id DESC LIMIT ?,? ");
		params.add((current - 1) * pageSize);
		params.add(pageSize);
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		// Count total records
		StringBuilder countSql = new StringBuilder(
				"select count(1) as counter from parking_lot_info a  join billing_rule_parking b on b.parking_lot_info_id=a.id  where 1=1 ");

		List<Object> countparams = new ArrayList<>();
		countSql.append(" and b.billing_rule_id =? ");
		countparams.add(billing_rule_id);
		List<Map<String, Object>> countResult = executeSQL(countSql.toString(), countparams);

		int total = countResult.get(0).get("counter") != null
				? Integer.valueOf(String.valueOf(countResult.get(0).get("counter")))
				: 0;
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("total", total);
		resultData.put("data", data);
		return new Result(true, "车场列表刷新成功", resultData);
	}

	private void addHolidayChangeRecord(StringBuilder contentStrb, List<Map<String, Object>> oldHolidays,
			List<Map<String, Object>> newHolidays) {
		if ((oldHolidays == null || oldHolidays.isEmpty()) && (newHolidays == null || newHolidays.isEmpty())) {
			return;
		}
		if (oldHolidays == null || oldHolidays.isEmpty()) {
			// 全都新增
			newHolidays.forEach(r -> {
				contentStrb.append("增加假日：").append(r.get("holiday_remarks")).append("[")
						.append(r.get("holiday_start_date")).append("-").append(r.get("holiday_end_date")).append("];");
			});
			return;
		}
		if (newHolidays == null || newHolidays.isEmpty()) {
			// 全都删除
			oldHolidays.forEach(r -> {
				contentStrb.append("删除假日：").append(r.get("holiday_remarks")).append("[")
						.append(r.get("holiday_start_date")).append("-").append(r.get("holiday_end_date")).append("];");
			});
			return;
		}
		flag: for (int i = oldHolidays.size() - 1; i >= 0; i--) {
			Map<String, Object> oldH = oldHolidays.get(i);
			for (int j = newHolidays.size() - 1; j >= 0; j--) {
				Map<String, Object> newH = newHolidays.get(j);
				Object od_holiday_remarks = oldH.get("holiday_remarks");
				Object ne_holiday_remarks = newH.get("holiday_remarks");
				Object od_holiday_start_date = oldH.get("holiday_start_date");
				Object ne_holiday_start_date = newH.get("holiday_start_date");
				Object od_holiday_end_date = oldH.get("holiday_end_date");
				Object ne_holiday_end_date = newH.get("holiday_end_date");
				if (Objects.equals(od_holiday_remarks, ne_holiday_remarks)) {
					if (Objects.equals(od_holiday_start_date, ne_holiday_start_date)) {
						if (Objects.equals(od_holiday_end_date, ne_holiday_end_date)) {
							newHolidays.remove(j);
							oldHolidays.remove(i);
							continue flag;
						}
					}
				}
			}
		}
		if (!newHolidays.isEmpty()) {
			newHolidays.forEach(r -> {
				contentStrb.append("增加假日：").append(r.get("holiday_remarks")).append("[")
						.append(r.get("holiday_start_date")).append("-").append(r.get("holiday_end_date")).append("];");
			});
		}
		if (!oldHolidays.isEmpty()) {
			oldHolidays.forEach(r -> {
				contentStrb.append("删除假日：").append(r.get("holiday_remarks")).append("[")
						.append(r.get("holiday_start_date")).append("-").append(r.get("holiday_end_date")).append("];");
			});
		}
	}

	private void addTimeRangeChangeRecord(StringBuilder contentStrb, List<Map<String, Object>> oldTimeRange,
			List<Map<String, Object>> newTimeRange) {
		if ((oldTimeRange == null || oldTimeRange.isEmpty()) && (newTimeRange == null || newTimeRange.isEmpty())) {
			return;
		}
		if (oldTimeRange == null || oldTimeRange.isEmpty()) {
			// 全都新增
			newTimeRange.forEach(r -> {
				contentStrb.append("增加免费时段：").append("[").append(r.get("free_begin_time")).append("-")
						.append(r.get("free_end_time")).append("];");
			});
			return;
		}
		if (newTimeRange == null || newTimeRange.isEmpty()) {
			// 全都删除
			oldTimeRange.forEach(r -> {
				contentStrb.append("删除免费时段：").append("[").append(r.get("free_begin_time")).append("-")
						.append(r.get("free_end_time")).append("];");
			});
			return;
		}
		flag: for (int i = oldTimeRange.size() - 1; i >= 0; i--) {
			Map<String, Object> oldH = oldTimeRange.get(i);
			for (int j = newTimeRange.size() - 1; j >= 0; j--) {
				Map<String, Object> newH = newTimeRange.get(j);
				Object od_free_begin_time = oldH.get("free_begin_time");
				Object ne_free_begin_time = newH.get("free_begin_time");
				Object od_free_end_time = oldH.get("free_end_time");
				Object ne_free_end_time = newH.get("free_end_time");
				if (Objects.equals(od_free_begin_time, ne_free_begin_time)) {
					if (Objects.equals(od_free_end_time, ne_free_end_time)) {
						newTimeRange.remove(j);
						oldTimeRange.remove(i);
						continue flag;
					}
				}
			}
		}
		if (!newTimeRange.isEmpty()) {
			newTimeRange.forEach(r -> {
				contentStrb.append("增加免费时段：").append("[")
						.append(r.get("free_begin_time")).append("-").append(r.get("free_end_time")).append("];");
			});
		}
		if (!oldTimeRange.isEmpty()) {
			oldTimeRange.forEach(r -> {
				contentStrb.append("删除免费时段：").append("[")
						.append(r.get("free_begin_time")).append("-").append(r.get("free_end_time")).append("];");
			});
		}
	}

	private Result _insertOperationRecord(int ruleId, String operationNode, Map<String, Object> oldRule,
			Map<String, Object> newRule, List<Map<String, Object>> oldHolidays, List<Map<String, Object>> newHolidays,
			List<Map<String, Object>> oldTimeRange, List<Map<String, Object>> newTimeRange) {
		if (oldRule == null) {
			// 新建
			StringBuilder contentBuilder = new StringBuilder("新建规则。");
			Set<String> newKeys = newRule.keySet();
			for (String newk : newKeys) {
				Object newObj = newRule.get(newk);
				if (newObj == null) {
					continue;
				}
				if ("".equals(newObj)) {
					continue;
				}
				addCotent(1, contentBuilder, newk, null, newObj);
			}
			if(newHolidays!=null) {
				contentBuilder.append(",节假日"+newHolidays.size()+"个");
			}
			if(newTimeRange!=null) {
				contentBuilder.append(",免费时段"+newTimeRange.size()+"个");
			}
			return __insertOperationRecord(ruleId, operationNode, contentBuilder.toString());
		}
		StringBuilder contentBuilder = new StringBuilder("修改规则。");
		Set<String> oldKeys = oldRule.keySet();
		Set<String> newKeys = newRule.keySet();
		for (String old : oldKeys) {
			// 处理删除，修改
			Object oldObj = oldRule.get(old);
			Object newObj = newRule.get(old);
			if (newObj == null && oldObj != null) {
				// 删除
				addCotent(2, contentBuilder, old, oldObj, null);
			} else if (oldObj == null && newObj != null) {
				// 新增
				addCotent(1, contentBuilder, old, null, newObj);
			} else if (oldObj != null && newObj != null && !Objects.equals(oldObj, newObj)) {
				// 修改
				addCotent(3, contentBuilder, old, oldObj, newObj);
			}
		}
		// 只处理新增
		for (String newk : newKeys) {
			Object oldObj = oldRule.get(newk);
			Object newObj = newRule.get(newk);
			if (oldObj != null) {
				continue;
			}
			if (newObj == null) {
				continue;
			}
			if ("".equals(newObj)) {
				continue;
			}
			addCotent(1, contentBuilder, newk, null, newObj);
		}
		addTimeRangeChangeRecord(contentBuilder,oldTimeRange, newTimeRange);
		addHolidayChangeRecord(contentBuilder, oldHolidays, newHolidays); 
		return __insertOperationRecord(ruleId, operationNode, contentBuilder.toString());
	}

	public Result __insertOperationRecord(int ruleId, String operationNode, String operationContent) {
		String currentUserName = sdkOfGetCurrentUserName();
		StringBuilder sql = new StringBuilder(
				"insert into billing_operation_record ( operation_time, operation_node, operation_content, operator,billing_rule_id,create_username,create_time,update_username,update_time) values (?,?,?,?,?,?,?,?,?)");
		List<Object> params = new ArrayList<>();
		params.add(new Date());
		params.add(operationNode);
		params.add(operationContent);
		params.add(currentUserName);
		params.add(ruleId);
		params.add(currentUserName);
		params.add(new Date());
		params.add(currentUserName);
		params.add(new Date());
		executeSQL(sql.toString(), params.toArray());
		// Set the result data
		return new Result(true, "Billing details fetched successfully.");
	}

	private void addCotent(int type, StringBuilder contentStrb, String key, Object oldObj, Object newObj) {
		// type 1 新增；2 删除；3修改
		if ("update_time".equals(key)) {
			return;
		}
		if (type == 1) {
			contentStrb.append("增加：").append(doMapKey(key)).append("，新值：").append(newObj).append(";");
		} else if (type == 2) {
			contentStrb.append("删除：").append(doMapKey(key)).append("，原值：").append(oldObj).append(";");
		} else {
			contentStrb.append("修改：").append(doMapKey(key)).append("，值：").append(oldObj).append("->").append(newObj)
					.append(";");
		}
	}

	private String doMapKey(String key) {
		if (key.equals("rule_number"))
			return "规则编号";
		if (key.equals("rule_name"))
			return "规则名称";
		if (key.equals("billing_standard"))
			return "收费方案";
		if (key.equals("rule_description"))
			return "规则描述";
		if (key.equals("status"))
			return "规则状态";
		if (key.equals("creator"))
			return "创建人";
		if (key.equals("associated_parking_count"))
			return "关联车场数";
		if (key.equals("free_duration"))
			return "免费时长";
		if (key.equals("new_energy_free_duration_reduction"))
			return "新能源减免开关";
		if (key.equals("temporary_car"))
			return "临时车收费金额";
		if (key.equals("stored_value_car"))
			return "储值车收费金额";
		if (key.equals("new_energy_free_duration"))
			return "新能源免费时长";
		if (key.equals("free_duration_reduction"))
			return "免费时常开关";
		if (key.equals("white_plate_car_free"))
			return "白牌车免费开关";
		if (key.equals("new_energy_free_times"))
			return "新能源免费次数";
		if (key.equals("free_period_reduction"))
			return "时段减免开关";
		if (key.equals("wd_temporary_car_cap_amount"))
			return "工作日、白天、临时车收费封顶金额";
		if (key.equals("wd_stored_value_car_cap_amount"))
			return "工作日、白天、储值车收费封顶金额";
		if (key.equals("wn_temporary_car_cap_amount"))
			return "工作日、夜间、临时车收费封顶金额";
		if (key.equals("wn_stored_value_car_cap_amount"))
			return "工作日、夜间、储值车收费封顶金额";
		if (key.equals("hd_temporary_car_cap_amount"))
			return "节假日、白天、临时车收费封顶金额";
		if (key.equals("hd_stored_value_car_cap_amount"))
			return "节假日、白天、储值车收费封顶金额";
		if (key.equals("hn_temporary_car_cap_amount"))
			return "节假日、夜间、临时车收费封顶金额";
		if (key.equals("hn_stored_value_car_cap_amount"))
			return "节假日、夜间、储值车收费封顶金额";
		if (key.equals("wd_begin_time_range"))
			return "工作日、白天开始时间";
		if (key.equals("wd_end_time_range"))
			return "工作日、夜间结束时间";
		if (key.equals("wn_begin_time_range"))
			return "工作日、夜间第一段开始时间";
		if (key.equals("wn_end_time_range"))
			return "工作日、夜间第一段结束时间";
		if (key.equals("wn_second_begin_time_range"))
			return "工作日、夜间第二段开始时间";
		if (key.equals("wn_second_end_time_range"))
			return "工作日、夜间第二段结束时间";
		if (key.equals("hd_begin_time_range"))
			return "节假日、白天开始时间";
		if (key.equals("hd_end_time_range"))
			return "节假日、夜间结束时间";
		if (key.equals("hn_begin_time_range"))
			return "节假日、夜间第一段开始时间";
		if (key.equals("hn_end_time_range"))
			return "节假日、夜间第一段结束时间";
		if (key.equals("hn_second_begin_time_range"))
			return "节假日、夜间第二段开始时间";
		if (key.equals("hn_second_end_time_range"))
			return "节假日、夜间第二段结束时间";
		if (key.equals("wd_temporary_car_first_tier"))
			return "工作日、白天、第一阶段临时车收费价格";
		if (key.equals("wd_temporary_car_second_tier"))
			return "工作日、白天、第二阶段临时车收费价格";
		if (key.equals("wd_temporary_car_third_tier"))
			return "工作日、白天、第三阶段临时车收费价格";
		if (key.equals("wd_stored_value_car_first_tier"))
			return "工作日、白天、第一阶段储值车收费价格";
		if (key.equals("wd_stored_value_car_second_tier"))
			return "工作日、白天、第二阶段储值车收费价格";
		if (key.equals("wd_stored_value_car_third_tier"))
			return "工作日、白天、第三阶段储值车收费价格";
		if (key.equals("wn_temporary_car_first_tier"))
			return "工作日、夜间、第一阶段临时车收费价格";
		if (key.equals("wn_temporary_car_second_tier"))
			return "工作日、夜间、第二阶段临时车收费价格";
		if (key.equals("wn_temporary_car_third_tier"))
			return "工作日、夜间、第三阶段临时车收费价格";
		if (key.equals("wn_stored_value_car_first_tier"))
			return "工作日、夜间、第一阶段储值车收费价格";
		if (key.equals("wn_stored_value_car_second_tier"))
			return "工作日、夜间、第二阶段储值车收费价格";
		if (key.equals("wn_stored_value_car_third_tier"))
			return "工作日、夜间、第三阶段储值车收费价格";
		if (key.equals("hd_temporary_car_first_tier"))
			return "节假日、白天、第一阶段临时车收费价格";
		if (key.equals("hd_temporary_car_second_tier"))
			return "节假日、白天、第二阶段临时车收费价格";
		if (key.equals("hd_temporary_car_third_tier"))
			return "节假日、白天、第三阶段临时车收费价格";
		if (key.equals("hd_stored_value_car_first_tier"))
			return "节假日、白天、第一阶段储值车收费价格";
		if (key.equals("hd_stored_value_car_second_tier"))
			return "节假日、白天、第二阶段储值车收费价格";
		if (key.equals("hd_stored_value_car_third_tier"))
			return "节假日、白天、第三阶段储值车收费价格";
		if (key.equals("hn_temporary_car_first_tier"))
			return "节假日、夜间、第一阶段临时车收费价格";
		if (key.equals("hn_temporary_car_second_tier"))
			return "节假日、夜间、第二阶段临时车收费价格";
		if (key.equals("hn_temporary_car_third_tier"))
			return "节假日、夜间、第三阶段临时车收费价格";
		if (key.equals("hn_stored_value_car_first_tier"))
			return "节假日、夜间、第一阶段储值车收费价格";
		if (key.equals("hn_stored_value_car_second_tier"))
			return "节假日、夜间、第二阶段储值车收费价格";
		if (key.equals("hn_stored_value_car_third_tier"))
			return "节假日、夜间、第三阶段储值车收费价格";
		if (key.equals("wd_temporary_car_first_time"))
			return "工作日、白天、第一阶段临时车时间步长";
		if (key.equals("wd_temporary_car_second_time"))
			return "工作日、白天、第二阶段临时车时间步长";
		if (key.equals("wd_temporary_car_third_time"))
			return "工作日、白天、第三阶段临时车时间步长";
		if (key.equals("wd_stored_value_car_first_time"))
			return "工作日、白天、第一阶段储值车时间步长";
		if (key.equals("wd_stored_value_car_second_time"))
			return "工作日、白天、第二阶段储值车时间步长";
		if (key.equals("wd_stored_value_car_third_time"))
			return "工作日、白天、第三阶段储值车时间步长";
		if (key.equals("wn_temporary_car_first_time"))
			return "工作日、夜间、第一阶段临时车时间步长";
		if (key.equals("wn_temporary_car_second_time"))
			return "工作日、夜间、第二阶段临时车时间步长";
		if (key.equals("wn_temporary_car_third_time"))
			return "工作日、夜间、第三阶段临时车时间步长";
		if (key.equals("wn_stored_value_car_first_time"))
			return "工作日、夜间、第一阶段储值车时间步长";
		if (key.equals("wn_stored_value_car_second_time"))
			return "工作日、夜间、第二阶段储值车时间步长";
		if (key.equals("wn_stored_value_car_third_time"))
			return "工作日、夜间、第三阶段储值车时间步长";
		if (key.equals("hd_temporary_car_first_time"))
			return "节假日、白天、第一阶段临时车时间步长";
		if (key.equals("hd_temporary_car_second_time"))
			return "节假日、白天、第二阶段临时车时间步长";
		if (key.equals("hd_temporary_car_third_time"))
			return "节假日、白天、第三阶段临时车时间步长";
		if (key.equals("hd_stored_value_car_first_time"))
			return "节假日、白天、第一阶段储值车时间步长";
		if (key.equals("hd_stored_value_car_second_time"))
			return "节假日、白天、第二阶段储值车时间步长";
		if (key.equals("hd_stored_value_car_third_time"))
			return "节假日、白天、第三阶段储值车时间步长";
		if (key.equals("hn_temporary_car_first_time"))
			return "节假日、夜间、第一阶段临时车时间步长";
		if (key.equals("hn_temporary_car_second_time"))
			return "节假日、夜间、第二阶段临时车时间步长";
		if (key.equals("hn_temporary_car_third_time"))
			return "节假日、夜间、第三阶段临时车时间步长";
		if (key.equals("hn_stored_value_car_first_time"))
			return "节假日、夜间、第一阶段储值车时间步长";
		if (key.equals("hn_stored_value_car_second_time"))
			return "节假日、夜间、第二阶段储值车时间步长";
		if (key.equals("hn_stored_value_car_third_time"))
			return "节假日、夜间、第三阶段储值车时间步长";
		if (key.equals("wd_temporary_car_first_ceil"))
			return "工作日、白天、第一阶段临时车时间上限";
		if (key.equals("wd_temporary_car_second_ceil"))
			return "工作日、白天、第二阶段临时车时间上限";
		if (key.equals("wd_temporary_car_third_ceil"))
			return "工作日、白天、第三阶段临时车时间上限";
		if (key.equals("wd_stored_value_car_first_ceil"))
			return "工作日、白天、第一阶段储值车时间上限";
		if (key.equals("wd_stored_value_car_second_ceil"))
			return "工作日、白天、第二阶段储值车时间上限";
		if (key.equals("wd_stored_value_car_third_ceil"))
			return "工作日、白天、第三阶段储值车时间上限";
		if (key.equals("wn_temporary_car_first_ceil"))
			return "工作日、夜间、第一阶段临时车时间上限";
		if (key.equals("wn_temporary_car_second_ceil"))
			return "工作日、夜间、第二阶段临时车时间上限";
		if (key.equals("wn_temporary_car_third_ceil"))
			return "工作日、夜间、第三阶段临时车时间上限";
		if (key.equals("wn_stored_value_car_first_ceil"))
			return "工作日、夜间、第一阶段储值车时间上限";
		if (key.equals("wn_stored_value_car_second_ceil"))
			return "工作日、夜间、第二阶段储值车时间上限";
		if (key.equals("wn_stored_value_car_third_ceil"))
			return "工作日、夜间、第三阶段储值车时间上限";
		if (key.equals("hd_temporary_car_first_ceil"))
			return "节假日、白天、第一阶段临时车时间上限";
		if (key.equals("hd_temporary_car_second_ceil"))
			return "节假日、白天、第二阶段临时车时间上限";
		if (key.equals("hd_temporary_car_third_ceil"))
			return "节假日、白天、第三阶段临时车时间上限";
		if (key.equals("hd_stored_value_car_first_ceil"))
			return "节假日、白天、第一阶段储值车时间上限";
		if (key.equals("hd_stored_value_car_second_ceil"))
			return "节假日、白天、第二阶段储值车时间上限";
		if (key.equals("hd_stored_value_car_third_ceil"))
			return "节假日、白天、第三阶段储值车时间上限";
		if (key.equals("hn_temporary_car_first_ceil"))
			return "节假日、夜间、第一阶段临时车时间上限";
		if (key.equals("hn_temporary_car_second_ceil"))
			return "节假日、夜间、第二阶段临时车时间上限";
		if (key.equals("hn_temporary_car_third_ceil"))
			return "节假日、夜间、第三阶段临时车时间上限";
		if (key.equals("hn_stored_value_car_first_ceil"))
			return "节假日、夜间、第一阶段储值车时间上限";
		if (key.equals("hn_stored_value_car_second_ceil"))
			return "节假日、夜间、第二阶段储值车时间上限";
		if (key.equals("hn_stored_value_car_third_ceil"))
			return "节假日、夜间、第三阶段储值车时间上限";
		if (key.equals("create_username"))
			return "创建者用户名称";
		if (key.equals("create_time"))
			return "创建时间";
		if (key.equals("update_username"))
			return "最后修改者用户名称";
		if (key.equals("update_time"))
			return "最后修改时间";
		if (key.equals("created_time"))
			return "创建时间";
		if (key.equals("created_by"))
			return "创建人";
		if (key.equals("associated_time"))
			return "关联时间";
		if (key.equals("associated_person"))
			return "关联人";
		if (key.equals("parking_lot_id"))
			return "车场编号";
		if (key.equals("charging_scheme"))
			return "车场方案";
		if (key.equals("segment_charging"))
			return "分时段收费";
		return "ID";
	}
}
