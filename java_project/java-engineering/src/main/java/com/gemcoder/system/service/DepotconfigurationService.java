package com.gemcoder.system.service;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import static com.gemcoder.system.datasource.JdbcTemplateUtil.sdkOfPaginationQueryCount;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserId;

import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.datasource.JdbcTemplateUtil;
import com.gemcoder.system.util.RowUtil;

import static com.gemcoder.system.service.permission.PermissionSdkService.sdkOfgetAllPermissions;
import static com.gemcoder.system.service.permission.PermissionSdkService.sdkOfgetAllMenus;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Date;
import cn.hutool.core.util.StrUtil;

/**
 * 停车场管理
 * 
 * @author jiang
 *
 */
@Service
public class DepotconfigurationService {
	private static final Logger log = LoggerFactory.getLogger(DepotconfigurationService.class);

	/**
	 * parking_lot_info 基础信息 platform_info 平台信息 operation_rules 运营规则 billing_rules
	 * 计费规则 booth_management 岗亭管理 extended_info 拓展信息 file_attachment_list 文件附件
	 * 
	 * TODO 增加字段 bill_rule_id
	 */
	/**
	 * 停车场列表
	 * 
	 * @param paramMap
	 * @return
	 */
	public Result getYardList(Map<String, Object> paramMap) {
		// Initialize parameters
		String nameOfYard = paramMap.get("Nameofyardvalue1") != null ? String.valueOf(paramMap.get("Nameofyardvalue1"))
				: null;
		String operatingCompany = paramMap.get("OperatingCompanyvalue1") != null
				? String.valueOf(paramMap.get("OperatingCompanyvalue1"))
				: null;
		String area = paramMap.get("Areavalue1") != null ? String.valueOf(paramMap.get("Areavalue1")) : null;
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		// Build SQL for counting total records
		StringBuilder countSql = new StringBuilder("SELECT COUNT(*) AS total FROM parking_lot_info WHERE 1=1");
		List<Object> countParams = new ArrayList<>();
		if (nameOfYard != null && !nameOfYard.isEmpty()) {
			countSql.append(" AND parking_lot_name LIKE ?");
			countParams.add("%" + nameOfYard.trim() + "%");
		}
		if (operatingCompany != null && !operatingCompany.isEmpty()) {
			countSql.append(" AND operating_company LIKE ?");
			countParams.add("%" + operatingCompany.trim() + "%");
		}
		if (area != null && !area.isEmpty()) {
			countSql.append(" AND region LIKE ?");
			countParams.add("%" + area.trim() + "%");
		}
		// Execute count query
		List<Map<String, Object>> countResult = countParams.isEmpty() ? executeSQL(countSql.toString())
				: executeSQL(countSql.toString(), countParams.toArray());
		int total = countResult.isEmpty() ? 0 : Integer.parseInt(String.valueOf(countResult.get(0).get("total")));
		// Build SQL for fetching data with pagination
		StringBuilder dataSql = new StringBuilder("SELECT *  FROM parking_lot_info WHERE 1=1");
		List<Object> dataParams = new ArrayList<>(countParams);
		dataSql.append(" ORDER BY create_time DESC LIMIT ?, ?");
		dataParams.add((current - 1) * pageSize);
		dataParams.add(pageSize);
		// Execute data query
		List<Map<String, Object>> data = executeSQL(dataSql.toString(), dataParams.toArray());
		// Prepare result
		RowUtil.setRowNumber(data, pageSize, current);
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("total", total);
		resultData.put("data", data);
		return new Result(true, "Query successful", resultData);
	}

	public Result searchYardList(Map<String, Object> paramMap) {
		// Initialize SQL query and parameters list
		StringBuilder sql = new StringBuilder("SELECT * FROM parking_lot_info WHERE 1=1");
		List<Object> params = new ArrayList<>();
		// Extract parameters from paramMap
		String parkingLotName = paramMap.get("Nameofyardvalue1") != null ? (String) paramMap.get("Nameofyardvalue1")
				: null;
		String operatingCompany = paramMap.get("OperatingCompanyvalue1") != null
				? (String) (paramMap.get("OperatingCompanyvalue1"))
				: null;
		List Areavalue1 = (List) paramMap.get("Areavalue1");
		List<String> region = new ArrayList<String>();
		List<List<String>> region2 = new ArrayList<List<String>>();
		if (Areavalue1 != null && !Areavalue1.isEmpty()) {
			for (Object i : Areavalue1) {
				if (i instanceof String) {
					region.add((String) i);
				} else if (i instanceof List) {
					List<String> li = (List<String>) i;
					region2.add(li);
					/*
					 * List li = (List) i; for (Object j : li) { if (j != null) { //
					 * strj.add(j.toString()); region.add(j.toString()); } }
					 */
				}
			}
		}
		// List<String> region = paramMap.get("Areavalue1") != null ? (List<String>
		// )(paramMap.get("Areavalue1")) : null;
		List<String> parkingLotType = paramMap.get("parkingLotType") != null
				? (List<String>) (paramMap.get("parkingLotType"))
				: null;
		List<String> category = paramMap.get("category") != null ? (List<String>) (paramMap.get("category")) : null;
		List<String> sector = paramMap.get("sector") != null ? (List<String>) (paramMap.get("sector")) : null;
		List<String> parkingLotStatus = paramMap.get("parkingLotStatus") != null
				? (List<String>) (paramMap.get("parkingLotStatus"))
				: null;
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		// Add conditions to SQL query based on non-null parameters
		if (StrUtil.isNotEmpty(parkingLotName)) {
			sql.append(" AND parking_lot_name LIKE ? ");
			params.add("%" + parkingLotName.trim() + "%");
		}
		if (StrUtil.isNotEmpty(operatingCompany)) {
			sql.append(" AND operating_company LIKE ? ");
			params.add("%" + operatingCompany.trim() + "%");
		}
		if (!region.isEmpty()) {
			multiParamsLikeOr(region, sql, params, "region");
		} else if (!region2.isEmpty()) {
			multiParamsLikeOr2(region2, sql, params, "region");
		}
		multiParams(parkingLotType, sql, params, "parking_lot_type");
		multiParams(category, sql, params, "category");
		multiParams(sector, sql, params, "sector");
		multiParams(parkingLotStatus, sql, params, "parking_lot_status");

		// Add order by clause
		sql.append(" ORDER BY create_time DESC ");
		// Calculate offset for pagination
		int offset = (current - 1) * pageSize;
		sql.append(" LIMIT ?, ?");
		params.add(offset);
		params.add(pageSize);
		// Execute the query
		List<Map<String, Object>> data = executeSQL(sql.toString(), params);
		// Count total records
		StringBuilder countSql = new StringBuilder("SELECT COUNT(*) as counter FROM parking_lot_info WHERE 1=1 ");
		// Exclude pagination params
		List<Object> countParams = new ArrayList<>();// (params.subList(0, params.size() - 2));
		if (StrUtil.isNotEmpty(parkingLotName)) {
			countSql.append(" AND parking_lot_name LIKE ? ");
			countParams.add("%" + parkingLotName.trim() + "%");
		}
		if (StrUtil.isNotEmpty(operatingCompany)) {
			countSql.append(" AND operating_company LIKE ? ");
			countParams.add("%" + operatingCompany.trim() + "%");
		}

		if (!region.isEmpty()) {
			multiParamsLikeOr(region, countSql, countParams, "region");
		} else if (!region2.isEmpty()) {
			multiParamsLikeOr2(region2, countSql, countParams, "region");
		}
		multiParams(parkingLotType, countSql, countParams, "parking_lot_type");
		multiParams(category, countSql, countParams, "category");
		multiParams(sector, countSql, countParams, "sector");
		multiParams(sector, countSql, countParams, "parking_lot_status");

		List<Map<String, Object>> countResult = countParams.isEmpty() ? executeSQL(countSql.toString())
				: executeSQL(countSql.toString(), countParams);
		int total = countResult.isEmpty() ? 0 : Integer.parseInt(String.valueOf(countResult.get(0).get("counter")));
		// Return result
		RowUtil.setRowNumber(data, pageSize, current);
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("total", total);
		resultData.put("data", data);
		return new Result(true, "Query successful", resultData);
	}

	public Result updateSelectedYardsStatus(Map<String, Object> paramMap) {
		// 获取选中的车场编号列表
		List<Map<String, Object>> selectedParkingLotCodes = (List<Map<String, Object>>) paramMap
				.get("selectedParkingLotCodes");
		if (selectedParkingLotCodes == null || selectedParkingLotCodes.isEmpty()) {
			return new Result(false, "请选择至少一行", null);
		}
		// 更新选中车场的状态为已停用
		StringBuilder updateSql = new StringBuilder(
				"UPDATE parking_lot_info SET parking_lot_status = '已停用' WHERE id IN (");
		List<Object> params = new ArrayList<>();
		for (int i = 0; i < selectedParkingLotCodes.size(); i++) {
			updateSql.append("?");
			if (i < selectedParkingLotCodes.size() - 1) {
				updateSql.append(", ");
			}
			params.add(selectedParkingLotCodes.get(i).get("id"));
		}
		updateSql.append(")");
		int updateCount = executeSQL(updateSql.toString(), params.toArray());
		selectedParkingLotCodes.forEach(r -> {
			addOperateRecord(Integer.parseInt(r.get("id").toString()), "更新状态", "更新状态停用");
		});
		if (updateCount > 0) {
			return new Result(true, "车场状态更新成功", null);
		} else {
			return new Result(false, "车场状态更新失败", null);
		}

	}

	public Result reuseSelectedYardsStatus(Map<String, Object> paramMap) {
		// 获取选中的车场编号列表
		List<Map<String, Object>> selectedParkingLotCodes = (List<Map<String, Object>>) paramMap
				.get("selectedParkingLotCodes");
		if (selectedParkingLotCodes == null || selectedParkingLotCodes.isEmpty()) {
			return new Result(false, "请选择至少一行", null);
		}
		// 更新选中车场的状态为已停用
		StringBuilder updateSql = new StringBuilder(
				"UPDATE parking_lot_info SET parking_lot_status = '启用' WHERE id IN (");
		List<Object> params = new ArrayList<>();
		for (int i = 0; i < selectedParkingLotCodes.size(); i++) {
			updateSql.append("?");
			if (i < selectedParkingLotCodes.size() - 1) {
				updateSql.append(", ");
			}
			params.add(selectedParkingLotCodes.get(i).get("id"));
		}
		updateSql.append(")");
		int updateCount = executeSQL(updateSql.toString(), params.toArray());
		selectedParkingLotCodes.forEach(r -> {
			addOperateRecord(Integer.parseInt(r.get("id").toString()), "更新状态", "更新状态启用");
		});
		if (updateCount > 0) {
			return new Result(true, "车场状态更新成功", null);
		} else {
			return new Result(false, "车场状态更新失败", null);
		}
	}

	public Result getYardListJGV(Map<String, Object> paramMap) {
		// 获取分页参数
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		// 查询车场列表
		StringBuilder sql = new StringBuilder("SELECT * FROM parking_lot_info WHERE 1=1");
		List<Object> params = new ArrayList<>();
		// 计算总条数
		StringBuilder countSql = new StringBuilder("SELECT COUNT(*) AS total FROM parking_lot_info WHERE 1=1");
		List<Map<String, Object>> countResult = executeSQL(countSql.toString(), params.toArray());
		int total = countResult != null && !countResult.isEmpty()
				? Integer.valueOf(String.valueOf(countResult.get(0).get("total")))
				: 0;
		// 添加分页
		sql.append(" ORDER BY create_time DESC LIMIT ?, ?");
		params.add((current - 1) * pageSize);
		params.add(pageSize);
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("total", total);
		resultData.put("data", data);
		return new Result(true, "查询成功", resultData);
	}

	public Result getYardDetails(Map<String, Object> paramMap) {
		// Extract the parking lot ID from the parameters
		Integer parkingLotId = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
		if (parkingLotId == null) {
			return new Result(false, "Parking lot ID is required", null);
		}
		// Query to get basic information
		StringBuilder basicInfoSql = new StringBuilder("SELECT * FROM parking_lot_info WHERE id = ?");
		List<Map<String, Object>> basicInfo = executeSQL(basicInfoSql.toString(), parkingLotId);
		Integer billing_rule_id = (Integer) basicInfo.get(0).get("billing_rule_id");
		// Query to get platform information
		StringBuilder platformInfoSql = new StringBuilder(
				"SELECT operating_mode, operating_company, docking_platform ,conservator FROM platform_info WHERE parking_lot_id = ?");
		List<Map<String, Object>> platformInfo = executeSQL(platformInfoSql.toString(), parkingLotId);
		// Query to get operation rules
		StringBuilder operationRulesSql = new StringBuilder("SELECT * FROM operation_rules WHERE parking_lot_id = ?");
		List<Map<String, Object>> operationRules = executeSQL(operationRulesSql.toString(), parkingLotId);
		// Query to get billing rules
		StringBuilder billingRulesSql = new StringBuilder(
				"SELECT a.id, a.rule_name, a.rule_description, a.created_time, a.creator, status,b.relation_time,b.enable_status  FROM billing_rules a join  billing_rule_parking b  on a.id=b.billing_rule_id  where b.parking_lot_info_id=?");
		List<Map<String, Object>> billingRules = executeSQL(billingRulesSql.toString(), parkingLotId);

		// Query to get booth management
		StringBuilder boothManagementSql = new StringBuilder(
				"SELECT name, phone_number, id_card FROM booth_management WHERE parking_lot_id = ?");
		List<Map<String, Object>> boothManagement = executeSQL(boothManagementSql.toString(), parkingLotId);
		// Query to get extended information
		StringBuilder extendedInfoSql = new StringBuilder("SELECT * FROM extended_info WHERE parking_lot_id = ?");
		List<Map<String, Object>> extendedInfo = executeSQL(extendedInfoSql.toString(), parkingLotId);
		// Query to get file attachments
		StringBuilder fileAttachmentsSql = new StringBuilder(
				"SELECT * FROM file_attachment_list WHERE parking_lot_id = ?");
		List<Map<String, Object>> fileAttachments = executeSQL(fileAttachmentsSql.toString(), parkingLotId);
		// Combine all the information into a single result map
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("basicInfo", basicInfo);
		resultData.put("platformInfo", platformInfo);
		resultData.put("operationRules", operationRules);
		resultData.put("billingRules", billingRules);
		resultData.put("boothManagement", boothManagement);
		resultData.put("extendedInfo", extendedInfo);
		resultData.put("fileAttachments", fileAttachments);
		return new Result(true, "Success", resultData);
	}

	public Result searchBillingRules(Map<String, Object> paramMap) {
		// Extract parameters for search
		String ruleName = paramMap.get("ruleName") != null ? String.valueOf(paramMap.get("ruleName")) : null;
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		// Build the SQL query for searching billing rules
		StringBuilder sql = new StringBuilder(
				"SELECT id, rule_name, rule_number, rule_description FROM billing_rules WHERE 1=1");
		List<Object> params = new ArrayList<>();
		if (ruleName != null && !ruleName.isEmpty()) {
			sql.append(" AND rule_name LIKE ?");
			params.add("%" + ruleName.trim() + "%");
		}
		// Add pagination
		int offset = (current - 1) * pageSize;
		sql.append(" LIMIT ? OFFSET ?");
		params.add(pageSize);
		params.add(offset);
		// Execute the query
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		// Count total records for pagination
		StringBuilder countSql = new StringBuilder("SELECT COUNT(*) FROM billing_rules WHERE 1=1");
		List<Object> countParams = new ArrayList<>(params);
		if (ruleName != null && !ruleName.isEmpty()) {
			countSql.append(" AND rule_name LIKE ?");
			countParams.add("%" + ruleName.trim() + "%");
		}
		List<Map<String, Object>> countResult = countParams.isEmpty() ? executeSQL(countSql.toString())
				: executeSQL(countSql.toString(), countParams.toArray());
		int total = countResult.isEmpty() ? 0 : Integer.parseInt(String.valueOf(countResult.get(0).get("COUNT(*)")));
		// Prepare the result
		RowUtil.setRowNumber(data, pageSize, current);
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("data", data);
		resultData.put("total", total);
		return new Result(true, "Success", resultData);
	}

	public Result addYardBillingRule(Map<String, Object> paramMap) {
		// Extract parameters
		Integer parkingLotId = paramMap.get("parkingLotId") != null
				? Integer.valueOf(String.valueOf(paramMap.get("parkingLotId")))
				: null;
		Integer ruleId = paramMap.get("ruleId") != null ? Integer.valueOf(String.valueOf(paramMap.get("ruleId")))
				: null;
		if (parkingLotId == null || ruleId == null) {
			return new Result(false, "Parking lot ID and rule ID are required", null);
		}
		// Get current user information
		String currentUserName = sdkOfGetCurrentUserName();
		// Get current time
		Date currentTime = new Date();
		// Insert the new billing rule association
		StringBuilder insertSql = new StringBuilder(
				"INSERT INTO billing_rules (parking_lot_id, rule_name, charging_scheme, rule_description, associated_time, associated_person, status) SELECT ?, rule_name, charging_scheme, rule_description, ?, ?, '待生效' FROM rule_information WHERE id = ?");
		int rowsAffected = executeSQL(insertSql.toString(), parkingLotId, currentTime, currentUserName, ruleId);
		//
		List<Map<String, Object>> ruleList = executeSQL("select * from where billing_rules=?", ruleId);
		if (ruleList != null && !ruleList.isEmpty()) {
			String rule_name = (String) ruleList.get(0).get("rule_name");
			addOperateRecord(parkingLotId, "增加规则", "增加规则:" + rule_name);
		} else {
			// addOperateRecord(parkingLotId , "增加规则","增加规则:"+ruleId);
		}
		if (rowsAffected > 0) {
			return new Result(true, "Billing rule added successfully", null);
		} else {
			return new Result(false, "Failed to add billing rule", null);
		}
	}

	public Result deleteRowData(Map<String, Object> paramMap) {
		// 从参数中获取需要删除的行的ID
		Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
		// 检查ID是否为空
		if (id == null) {
			return new Result(false, "ID不能为空", null);
		}
		// 构建删除SQL语句
		StringBuilder sql = new StringBuilder("DELETE FROM your_table_name WHERE id = ?");
		// 执行SQL语句
		int rowsAffected = executeSQL(sql.toString(), id);
		// 返回结果
		addOperateRecord(id, "删除", "删除停车场");
		if (rowsAffected > 0) {
			return new Result(true, "删除成功", null);
		} else {
			return new Result(false, "删除失败，未找到对应记录", null);
		}
	}

	public Result addPostPersonnel(Map<String, Object> paramMap) {
		// Extracting values from paramMap
		String name = paramMap.get("Namevalue2") != null ? String.valueOf(paramMap.get("Namevalue2")) : null;
		String phoneNumber = paramMap.get("Mobilephonenumbervalue2") != null
				? String.valueOf(paramMap.get("Mobilephonenumbervalue2"))
				: null;
		String idCard = paramMap.get("IdentityCardvalue2") != null ? String.valueOf(paramMap.get("IdentityCardvalue2"))
				: null;
		Integer parkingLotId = paramMap.get("parkingLotId") != null
				? Integer.valueOf(String.valueOf(paramMap.get("parkingLotId")))
				: null;
		// Getting the current username for the creator and updater fields
		String currentUsername = sdkOfGetCurrentUserName();
		// Getting the current time for the entry_time, create_time, and update_time
		// fields
		Date currentTime = new Date();
		if (StringUtils.isEmpty(idCard) || StringUtils.isEmpty(name)) {
			return new Result(false, "人员添加失败", null);
		}
		// Constructing the SQL for inserting a new post personnel record
		StringBuilder sql = new StringBuilder(
				"INSERT INTO booth_management (parking_lot_id, name, phone_number, id_card, status, entry_time, create_username, create_time, update_username, update_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		// Preparing the parameters for the SQL execution
		List<Object> params = new ArrayList<>();
		params.add(parkingLotId);
		params.add(name);
		params.add(phoneNumber);
		params.add(idCard);
		// Assuming the status is "在职" for new entries
		params.add("在职");
		params.add(currentTime);
		params.add(currentUsername);
		params.add(currentTime);
		params.add(currentUsername);
		params.add(currentTime);
		// Executing the SQL
		int rowsAffected = executeSQL(sql.toString(), params.toArray());
		// Returning the result
		addOperateRecord(parkingLotId, "添加人员", "添加人员：" + name);
		if (rowsAffected > 0) {
			return new Result(true, "人员添加成功", null);
		} else {
			return new Result(false, "人员添加失败", null);
		}
	}

	public Result deactivateRule(Map<String, Object> paramMap) {
		// 从paramMap中获取id
		Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
		// 检查id是否为空
		if (id == null) {
			return new Result(false, "ID不能为空", null);
		}
		// 构建SQL语句，将状态更新为已停用
		StringBuilder sql = new StringBuilder("UPDATE parking_lot_info SET parking_lot_status = ? WHERE id = ?");
		List<Object> params = new ArrayList<>();
		params.add("已停用");
		params.add(id);
		// 执行SQL更新操作
		int rowsAffected = executeSQL(sql.toString(), params.toArray());
		// 返回结果
		addOperateRecord(id, "停用", "停用停车场");
		if (rowsAffected > 0) {
			return new Result(true, "状态更新成功", null);
		} else {
			return new Result(false, "状态更新失败", null);
		}
	}

	private int updateDepotParkingLotInfo(Map<String, Object> paramMap) {
		String currentUserName = sdkOfGetCurrentUserName();
		// 获取当前时间
		Date currentTime = new Date();
		// 从paramMap中获取基础信息
		Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
		String parkingLotCode = paramMap.get("yardnumbervalue3") != null
				? String.valueOf(paramMap.get("yardnumbervalue3"))
				: null;
		String parkingLotName = paramMap.get("Nameofyard1value3") != null
				? String.valueOf(paramMap.get("Nameofyard1value3"))
				: null;
		String parkingLotShortName = paramMap.get("Yardabbreviationvalue3") != null
				? String.valueOf(paramMap.get("Yardabbreviationvalue3"))
				: null;
		Integer parkingSpaces = paramMap.get("Numberofparkingvalue3") != null
				? Integer.valueOf(String.valueOf(paramMap.get("Numberofparkingvalue3")))
				: null;
		Integer longTermSpaces = paramMap.get("Longtermrentalparkingspacesvalue3") != null
				? Integer.valueOf(String.valueOf(paramMap.get("Longtermrentalparkingspacesvalue3")))
				: null;
		Integer reservedSpaces = paramMap.get("Reservationofparkingspacevalue3") != null
				? Integer.valueOf(String.valueOf(paramMap.get("Reservationofparkingspacevalue3")))
				: null;
		Integer vipSpaces = paramMap.get("VIPParkingvalue3") != null
				? Integer.valueOf(String.valueOf(paramMap.get("VIPParkingvalue3")))
				: null;
		Integer chargingPiles = paramMap.get("Numberofchargingpilesvalue3") != null
				? Integer.valueOf(String.valueOf(paramMap.get("Numberofchargingpilesvalue3")))
				: null;
		String operatingCompany = paramMap.get("OperatingCompany1value3") != null
				? String.valueOf(paramMap.get("OperatingCompany1value3"))
				: null;
		String manager = paramMap.get("Personinchargevalue3") != null
				? String.valueOf(paramMap.get("Personinchargevalue3"))
				: null;
		String contactNumber = paramMap.get("ContactPhonevalue4") != null
				? String.valueOf(paramMap.get("ContactPhonevalue4"))
				: null;
		String latitudeLongitude = paramMap.get("latitudeandlongitudevalue3") != null
				? String.valueOf(paramMap.get("latitudeandlongitudevalue3"))
				: null;
		String detailedAddress = paramMap.get("Detailedaddressvalue3") != null
				? String.valueOf(paramMap.get("Detailedaddressvalue3"))
				: null;
		String parkingLotDescription = paramMap.get("YardDescriptionvalue3") != null
				? String.valueOf(paramMap.get("YardDescriptionvalue3"))
				: null;
		String parkingLotStatus = paramMap.get("yardstatus1value3") != null
				? String.valueOf(paramMap.get("yardstatus1value3"))
				: null;
		String parkingLotType = paramMap.get("Typeofyard1value3") != null
				? String.valueOf(paramMap.get("Typeofyard1value3"))
				: null;
		String region = paramMap.get("Area1value3") != null ? String.valueOf(paramMap.get("Area1value3")) : null;
		String category = paramMap.get("YardCategory1value3") != null
				? String.valueOf(paramMap.get("YardCategory1value3"))
				: null;
		String sector = paramMap.get("Plate1value3") != null ? String.valueOf(paramMap.get("Plate1value3")) : null;
		String chargingService = paramMap.get("Chargingservicevalue3") != null
				? String.valueOf(paramMap.get("Chargingservicevalue3"))
				: null;
		String additionalService = paramMap.get("AdditionalServicesvalue3") != null
				? String.valueOf(paramMap.get("AdditionalServicesvalue3"))
				: null;
		Boolean screenVisibility = paramMap.get("Whetherthelargescreenisvisiblevalue3") != null
				? "是".equals(String.valueOf(paramMap.get("Whetherthelargescreenisvisiblevalue3")))
				: null;
		String parkingLotIcon = paramMap.get("YardIconfileList1") != null
				? String.valueOf(paramMap.get("YardIconfileList1"))
				: null;
		String parkingLotPhoto = paramMap.get("YardPhotosfileList1") != null
				? String.valueOf(paramMap.get("YardPhotosfileList1"))
				: null;
		// 更新基础信息
		StringBuilder updateSql = new StringBuilder("UPDATE parking_lot_info SET ");
		List<Object> params = new ArrayList<>();
		if (parkingLotCode != null) {
			updateSql.append("parking_lot_code = ?, ");
			params.add(parkingLotCode);
		}
		if (parkingLotName != null) {
			updateSql.append("parking_lot_name = ?, ");
			params.add(parkingLotName);
		}
		if (parkingLotShortName != null) {
			updateSql.append("parking_lot_short_name = ?, ");
			params.add(parkingLotShortName);
		}
		if (parkingSpaces != null) {
			updateSql.append("parking_spaces = ?, ");
			params.add(parkingSpaces);
		}
		if (longTermSpaces != null) {
			updateSql.append("long_term_spaces = ?, ");
			params.add(longTermSpaces);
		}
		if (reservedSpaces != null) {
			updateSql.append("reserved_spaces = ?, ");
			params.add(reservedSpaces);
		}
		if (vipSpaces != null) {
			updateSql.append("vip_spaces = ?, ");
			params.add(vipSpaces);
		}
		if (chargingPiles != null) {
			updateSql.append("charging_piles = ?, ");
			params.add(chargingPiles);
		}
		if (operatingCompany != null) {
			updateSql.append("operating_company = ?, ");
			params.add(operatingCompany);
		}
		if (manager != null) {
			updateSql.append("manager = ?, ");
			params.add(manager);
		}
		if (contactNumber != null) {
			updateSql.append("contact_number = ?, ");
			params.add(contactNumber);
		}
		if (latitudeLongitude != null) {
			updateSql.append("latitude_longitude = ?, ");
			params.add(latitudeLongitude);
		}
		if (detailedAddress != null) {
			updateSql.append("detailed_address = ?, ");
			params.add(detailedAddress);
		}
		if (parkingLotDescription != null) {
			updateSql.append("parking_lot_description = ?, ");
			params.add(parkingLotDescription);
		}
		if (parkingLotStatus != null) {
			updateSql.append("parking_lot_status = ?, ");
			params.add(parkingLotStatus);
		}
		if (parkingLotType != null) {
			updateSql.append("parking_lot_type = ?, ");
			params.add(parkingLotType);
		}
		if (region != null) {
			updateSql.append("region = ?, ");
			params.add(region);
		}
		if (category != null) {
			updateSql.append("category = ?, ");
			params.add(category);
		}
		if (sector != null) {
			updateSql.append("sector = ?, ");
			params.add(sector);
		}
		if (chargingService != null) {
			updateSql.append("charging_service = ?, ");
			params.add(chargingService);
		}
		if (additionalService != null) {
			updateSql.append("additional_service = ?, ");
			params.add(additionalService);
		}
		if (screenVisibility != null) {
			updateSql.append("screen_visibility = ?, ");
			params.add(screenVisibility);
		}
		if (parkingLotIcon != null) {
			updateSql.append("parking_lot_icon = ?, ");
			params.add(parkingLotIcon);
		}
		if (parkingLotPhoto != null) {
			updateSql.append("parking_lot_photo = ?, ");
			params.add(parkingLotPhoto);
		}
		updateSql.append("update_username = ?, update_time = ? WHERE id = ?");
		params.add(currentUserName);
		params.add(currentTime);
		params.add(id);
		// 执行更新SQL
		List<Map<String, Object>> oldList = executeSQL("select * from parking_lot_info where id=?", id);
		int updateRows = executeSQL(updateSql.toString(), params.toArray());
		List<Map<String, Object>> newList = executeSQL("select * from parking_lot_info where id=?", id);
		if (!oldList.isEmpty() && !newList.isEmpty()) {
			Map<String, Object> oldMap = oldList.get(0);
			Map<String, Object> newMap = newList.get(0);
			StringBuilder strb = new StringBuilder();
			newMap.forEach((k, v) -> {
				if (!"update_time".equals(k) && !"update_username".equals(k)) {
					Object oldv = oldMap.get(k);
					if (oldv == null && v != null) {
						strb.append("新增" + mapKey2Chinese(k) + ":" + v + ",");
					} else if (oldv != null && v != null) {
						if (!oldv.equals(v)) {
							strb.append("修改" + mapKey2Chinese(k) + ":" + oldv + "->" + v + ",");
						}
					} else if (oldv != null && v == null) {
						strb.append("删除" + mapKey2Chinese(k) + ":" + oldv + ",");
					}
				}
			});
			if (strb.length() > 0) {
				addOperateRecord(id, "更新", strb.toString());
			}
		} else {
			// addOperateRecord(id , "更新","更新停车场");
		}

		return updateRows;
	}

	private int updateDepotPlatformInfo(int parkingLotId, Map<String, Object> paramMap) {
		String currentUserName = sdkOfGetCurrentUserName();
		String operatingMode = paramMap.get("Operationmodevalue3") != null
				? String.valueOf(paramMap.get("Operationmodevalue3"))
				: null;
		String operatingCompany = paramMap.get("OperatingCompanyvalue4") != null
				? String.valueOf(paramMap.get("OperatingCompanyvalue4"))
				: null;
		String dockingPlatform = paramMap.get("dockingplatformvalue3") != null
				? String.valueOf(paramMap.get("dockingplatformvalue3"))
				: null;
		String conservator=String.valueOf(paramMap.getOrDefault("conservator",null));

		StringBuilder updateSql = new StringBuilder("UPDATE platform_info SET ");
		List<Object> params = new ArrayList<>();
		if (operatingMode != null) {
			updateSql.append("operating_mode = ?, ");
			params.add(operatingMode);
		}
		if (operatingCompany != null) {
			updateSql.append("operating_company = ?, ");
			params.add(operatingCompany);
		}
		if (dockingPlatform != null) {
			updateSql.append("docking_platform = ?, ");
			params.add(dockingPlatform);
		}
		if (!StringUtils.isEmpty(conservator)) {
			updateSql.append("conservator = ?, ");
			params.add(conservator);
		}

		updateSql.append("update_username = ?, update_time = ? WHERE parking_lot_id = ?");
		params.add(currentUserName);
		params.add(new Date());
		params.add(parkingLotId);
		// 执行更新SQL

		List<Map<String, Object>> oldList = executeSQL("select * from platform_info WHERE parking_lot_id = ?",
				parkingLotId);
		int updateRows = executeSQL(updateSql.toString(), params.toArray());
		List<Map<String, Object>> newList = executeSQL("select * from platform_info WHERE parking_lot_id = ?",
				parkingLotId);
		if (!oldList.isEmpty() && !newList.isEmpty()) {
			Map<String, Object> oldMap = oldList.get(0);
			Map<String, Object> newMap = newList.get(0);
			StringBuilder strb = new StringBuilder();
			newMap.forEach((k, v) -> {
				if (!"update_time".equals(k) && !"update_username".equals(k)) {
					Object oldv = oldMap.get(k);
					if (oldv == null && v != null) {
						strb.append("新增" + mapKey2Chinese(k) + ":" + v + ",");
					} else if (oldv != null && v != null) {
						if (!oldv.equals(v)) {
							strb.append("修改" + mapKey2Chinese(k) + ":" + oldv + "->" + v + ",");
						}
					} else if (oldv != null && v == null) {
						strb.append("删除" + mapKey2Chinese(k) + ":" + oldv + ",");
					}
				}
			});
			if (strb.length() > 0) {
				addOperateRecord(parkingLotId, "更新平台信息", strb.toString());
			}
		} else {
			// addOperateRecord(parkingLotId , "更新平台信息","更新停车场平台信息");
		}

		return updateRows;
	}

	private int updateDepotOperationRules(int parkingLotId, Map<String, Object> paramMap) {
		String currentUserName = sdkOfGetCurrentUserName();
		String prepaymentOvertimeDuration = paramMap.get("PrepaidTimeoutDurationvalue3") != null
				? String.valueOf(paramMap.get("PrepaidTimeoutDurationvalue3"))
				: null;
		String overtimeExitHandling = paramMap.get("Timeoutdoesnotleaveprocessingvalue3") != null
				? String.valueOf(paramMap.get("Timeoutdoesnotleaveprocessingvalue3"))
				: null;
		String abnormalStatus = paramMap.get("Abnormalstatevalue3") != null
				? String.valueOf(paramMap.get("Abnormalstatevalue3"))
				: null;
		String abnormalHandling = paramMap.get("ExceptionHandlingvalue3") != null
				? String.valueOf(paramMap.get("ExceptionHandlingvalue3"))
				: null;
		String notification = paramMap.get("Notifyvalue7") != null ? String.valueOf(paramMap.get("Notifyvalue7"))
				: null;
		String blacklist = paramMap.get("blacklistvalue3") != null ? String.valueOf(paramMap.get("blacklistvalue3"))
				: null;
		String whitelist = paramMap.get("WhiteListvalue3") != null ? String.valueOf(paramMap.get("WhiteListvalue3"))
				: null;
		String reservedSpacesCount = paramMap.get("Reservedcarnumbervalue3") != null
				? String.valueOf(paramMap.get("Reservedcarnumbervalue3"))
				: null;
		String reservationOvertimeDuration = paramMap.get("Appointmenttimeoutdurationvalue3") != null
				? String.valueOf(paramMap.get("Appointmenttimeoutdurationvalue3"))
				: null;
		String exitScan = paramMap.get("AppearanceSweepCodevalue3") != null
				? String.valueOf(paramMap.get("AppearanceSweepCodevalue3"))
				: null;

		String abnormal_status_duplicate = paramMap.get("abnormal_status_duplicate") != null
				? String.valueOf(paramMap.get("abnormal_status_duplicate"))
				: null;
		String abnormal_status_no_in_car = paramMap.get("abnormal_status_no_in_car") != null
				? String.valueOf(paramMap.get("abnormal_status_no_in_car"))
				: null;
		String abnormal_status_force = paramMap.get("abnormal_status_force") != null
				? String.valueOf(paramMap.get("abnormal_status_force"))
				: null;
		String abnormal_status_other = paramMap.get("abnormal_status_other") != null
				? String.valueOf(paramMap.get("abnormal_status_other"))
				: null;
		String abnormal_handling_duplicate = paramMap.get("abnormal_handling_duplicate") != null
				? String.valueOf(paramMap.get("abnormal_handling_duplicate"))
				: null;
		String abnormal_handling_no_in_car = paramMap.get("abnormal_handling_no_in_car") != null
				? String.valueOf(paramMap.get("abnormal_handling_no_in_car"))
				: null;
		String abnormal_handling_force = paramMap.get("abnormal_handling_force") != null
				? String.valueOf(paramMap.get("abnormal_handling_force"))
				: null;
		String abnormal_handling_other = paramMap.get("abnormal_handling_other") != null
				? String.valueOf(paramMap.get("abnormal_handling_other"))
				: null;
		String abnormal_duplicate_notification = paramMap.get("abnormal_duplicate_notification") != null
				? String.valueOf(paramMap.get("abnormal_duplicate_notification"))
				: null;
		String abnormal_no_in_car_notification = paramMap.get("abnormal_no_in_car_notification") != null
				? String.valueOf(paramMap.get("abnormal_no_in_car_notification"))
				: null;
		String abnormal_force_notification = paramMap.get("abnormal_force_notification") != null
				? String.valueOf(paramMap.get("abnormal_force_notification"))
				: null;
		String abnormal_other_notification = paramMap.get("abnormal_other_notification") != null
				? String.valueOf(paramMap.get("abnormal_other_notification"))
				: null;
		String abnormal_duplicate_block_time = paramMap.get("abnormal_duplicate_block_time") != null
				? String.valueOf(paramMap.get("abnormal_duplicate_block_time"))
				: null;
		String abnormal_no_in_car_block_time = paramMap.get("abnormal_no_in_car_block_time") != null
				? String.valueOf(paramMap.get("abnormal_no_in_car_block_time"))
				: null;
		String abnormal_force_block_time = paramMap.get("abnormal_force_block_time") != null
				? String.valueOf(paramMap.get("abnormal_force_block_time"))
				: null;
		String abnormal_other_block_time = paramMap.get("abnormal_other_block_time") != null
				? String.valueOf(paramMap.get("abnormal_other_block_time"))
				: null;

		StringBuilder updateSql = new StringBuilder("UPDATE operation_rules SET ");
		List<Object> params = new ArrayList<>();
		// if (prepaymentOvertimeDuration != null) {
		updateSql.append("prepayment_overtime_duration = ?, ");
		params.add(prepaymentOvertimeDuration);
		// }
		// if (overtimeExitHandling != null) {
		updateSql.append("overtime_exit_handling = ?, ");
		params.add(overtimeExitHandling);
		// }
		// if (abnormalStatus != null) {
		updateSql.append("abnormal_status = ?, ");
		params.add(abnormalStatus);
		// }
		// if (abnormalHandling != null) {
		updateSql.append("abnormal_handling = ?, ");
		params.add(abnormalHandling);
		// }
		// if (notification != null) {
		updateSql.append("notification = ?, ");
		params.add(notification);
		// }
		// if (blacklist != null) {
		updateSql.append("blacklist = ?, ");
		params.add(blacklist);
		// }
		// if (whitelist != null) {
		updateSql.append("whitelist = ?, ");
		params.add(whitelist);
		// }
		// if (reservedSpacesCount != null) {
		updateSql.append("reserved_spaces_count = ?, ");
		params.add(reservedSpacesCount);
		// }
		// if (reservationOvertimeDuration != null) {
		updateSql.append("reservation_overtime_duration = ?, ");
		params.add(reservationOvertimeDuration);
		// }
		// if (exitScan != null) {
		updateSql.append("exit_scan = ?, ");
		params.add(exitScan);
		// }

		// if (abnormal_status_duplicate != null) {
		updateSql.append("abnormal_status_duplicate = ?, ");
		params.add(abnormal_status_duplicate);
		// }
		// if (abnormal_status_no_in_car != null) {
		updateSql.append("abnormal_status_no_in_car = ?, ");
		params.add(abnormal_status_no_in_car);
		// }
		// if (abnormal_status_force != null) {
		updateSql.append("abnormal_status_force = ?, ");
		params.add(abnormal_status_force);
		// }
		// if (abnormal_status_other != null) {
		updateSql.append("abnormal_status_other = ?, ");
		params.add(abnormal_status_other);
		// }
		// if (abnormal_handling_duplicate != null) {
		updateSql.append("abnormal_handling_duplicate = ?, ");
		params.add(abnormal_handling_duplicate);
		// }
		// if (abnormal_handling_no_in_car != null) {
		updateSql.append("abnormal_handling_no_in_car = ?, ");
		params.add(abnormal_handling_no_in_car);
		// }
		// if (abnormal_handling_force != null) {
		updateSql.append("abnormal_handling_force = ?, ");
		params.add(abnormal_handling_force);
		// }
		// if (abnormal_handling_other != null) {
		updateSql.append("abnormal_handling_other = ?, ");
		params.add(abnormal_handling_other);
		// }
		// if (abnormal_duplicate_notification != null) {
		updateSql.append("abnormal_duplicate_notification = ?, ");
		params.add(abnormal_duplicate_notification);
		// }
		// if (abnormal_no_in_car_notification != null) {
		updateSql.append("abnormal_no_in_car_notification = ?, ");
		params.add(abnormal_no_in_car_notification);
		// }
		// if (abnormal_force_notification != null) {
		updateSql.append("abnormal_force_notification = ?, ");
		params.add(abnormal_force_notification);
		// }
		// if (abnormal_other_notification != null) {
		updateSql.append("abnormal_other_notification = ?, ");
		params.add(abnormal_other_notification);
		// }
		// if (abnormal_duplicate_block_time != null) {
		updateSql.append("abnormal_duplicate_block_time = ?, ");
		params.add(abnormal_duplicate_block_time);
		// }
		// if (abnormal_no_in_car_block_time != null) {
		updateSql.append("abnormal_no_in_car_block_time = ?, ");
		params.add(abnormal_no_in_car_block_time);
		// }
		// if (abnormal_force_block_time != null) {
		updateSql.append("abnormal_force_block_time = ?, ");
		params.add(abnormal_force_block_time);
		// }
		// if (abnormal_other_block_time != null) {
		updateSql.append("abnormal_other_block_time = ?, ");
		params.add(abnormal_other_block_time);
		// }

		updateSql.append("update_username = ?, update_time = ? WHERE parking_lot_id = ?");
		params.add(currentUserName);
		params.add(new Date());
		params.add(parkingLotId);
		// 执行更新SQL

		List<Map<String, Object>> oldList = executeSQL("select * from operation_rules WHERE parking_lot_id = ?",
				parkingLotId);
		int updateRows = executeSQL(updateSql.toString(), params.toArray());
		List<Map<String, Object>> newList = executeSQL("select * from operation_rules WHERE parking_lot_id = ?",
				parkingLotId);
		if (!oldList.isEmpty() && !newList.isEmpty()) {
			Map<String, Object> oldMap = oldList.get(0);
			Map<String, Object> newMap = newList.get(0);
			StringBuilder strb = new StringBuilder();
			newMap.forEach((k, v) -> {
				if (!"update_time".equals(k) && !"update_username".equals(k)) {
					Object oldv = oldMap.get(k);
					if (oldv == null && v != null) {
						strb.append("新增" + mapKey2Chinese(k) + ":" + v + ",");
					} else if (oldv != null && v != null) {
						if (!oldv.equals(v)) {
							strb.append("修改" + mapKey2Chinese(k) + ":" + oldv + "->" + v + ",");
						}
					} else if (oldv != null && v == null) {
						strb.append("删除" + mapKey2Chinese(k) + ":" + oldv + ",");
					}
				}
			});
			if (strb.length() > 0) {
				addOperateRecord(parkingLotId, "更新运营规则", strb.toString());
			}
		} else {
			// addOperateRecord(parkingLotId , "更新运营规则","更新停车场运营规则");
		}

		return updateRows;
	}

	private int updateDepotBillingRules(int parkingLotId, Map<String, Object> paramMap) {
		String billRuleId = paramMap.get("BillingRulesvalue1") != null
				? String.valueOf(paramMap.get("BillingRulesvalue1"))
				: null;
		if (billRuleId == null) {
			return 0;
		}
		StringBuilder updateSql = new StringBuilder("UPDATE parking_lot_info SET  billing_rule_id=? where id =?");
		List<Object> params = new ArrayList<>();
		params.add(billRuleId);
		params.add(parkingLotId);

		List<Map<String, Object>> oldList = executeSQL("select billing_rule_id from parking_lot_info WHERE id = ?",
				parkingLotId);
		int updateRows = executeSQL(updateSql.toString(), params.toArray());
		List<Map<String, Object>> newList = executeSQL("select billing_rule_id from parking_lot_info WHERE id = ?",
				parkingLotId);
		if (!oldList.isEmpty() && !newList.isEmpty()) {
			Map<String, Object> oldMap = oldList.get(0);
			Map<String, Object> newMap = newList.get(0);
			Object odbilling_rule_id = oldMap.get("billing_rule_id");
			Object nebilling_rule_id = newMap.get("billing_rule_id");
			if (nebilling_rule_id != null && nebilling_rule_id.equals(odbilling_rule_id)) {
				addOperateRecord(parkingLotId, "更新计费规则", odbilling_rule_id + "->" + nebilling_rule_id);
			}
		}
		return updateRows;
	}

	private int updateDepotBoothManagement(int parkingLotId, Map<String, Object> paramMap) {
		String currentUserName = sdkOfGetCurrentUserName();
		String name = paramMap.get("Namevalue2") != null ? String.valueOf(paramMap.get("Namevalue2")) : null;
		String phoneNumber = paramMap.get("Mobilephonenumbervalue2") != null
				? String.valueOf(paramMap.get("Mobilephonenumbervalue2"))
				: null;
		String idCard = paramMap.get("IdentityCardvalue2") != null ? String.valueOf(paramMap.get("IdentityCardvalue2"))
				: null;
		String status = paramMap.get("status") != null ? String.valueOf(paramMap.get("status")) : null;
		String entryTime = paramMap.get("entryTime") != null ? String.valueOf(paramMap.get("entryTime")) : null;
		String resignationTime = paramMap.get("Constructiontimevalue3") != null
				? String.valueOf(paramMap.get("Constructiontimevalue3"))
				: null;
		String boothManagementId = paramMap.get("boothManagementId") != null
				? String.valueOf(paramMap.get("boothManagementId"))
				: null;

		StringBuilder updateSql = new StringBuilder("UPDATE booth_management SET ");
		List<Object> params = new ArrayList<>();
		if (name != null) {
			updateSql.append("name = ?, ");
			params.add(name);
		}
		if (phoneNumber != null) {
			updateSql.append("phone_number = ?, ");
			params.add(phoneNumber);
		}
		if (idCard != null) {
			updateSql.append("id_card = ?, ");
			params.add(idCard);
		}
		if (status != null) {
			updateSql.append("status = ?, ");
			params.add(status);
		}
		if (entryTime != null) {
			updateSql.append("entry_time = ?, ");
			params.add(entryTime);
		}
		if (resignationTime != null) {
			updateSql.append("resignation_time = ?, ");
			params.add(resignationTime);
		}

		updateSql.append("update_username = ?, update_time = ? WHERE parking_lot_id = ?");

		if (boothManagementId != null) {
			updateSql.append(" and id = ? ");
			params.add(boothManagementId);
		}
		params.add(currentUserName);
		params.add(new Date());
		params.add(parkingLotId);
		// 执行更新SQL

		List<Map<String, Object>> oldList = executeSQL("select * from booth_management WHERE parking_lot_id = ?",
				parkingLotId);
		int updateRows = executeSQL(updateSql.toString(), params.toArray());
		List<Map<String, Object>> newList = executeSQL("select * from booth_management WHERE parking_lot_id = ?",
				parkingLotId);
		if (!oldList.isEmpty() && !newList.isEmpty()) {
			Map<String, Object> oldMap = oldList.get(0);
			Map<String, Object> newMap = newList.get(0);
			StringBuilder strb = new StringBuilder();
			newMap.forEach((k, v) -> {
				if (!"update_time".equals(k) && !"update_username".equals(k)) {
					Object oldv = oldMap.get(k);
					if (oldv == null && v != null) {
						strb.append("新增" + mapKey2Chinese(k) + ":" + v + ",");
					} else if (oldv != null && v != null) {
						if (!oldv.equals(v)) {
							strb.append("修改" + mapKey2Chinese(k) + ":" + oldv + "->" + v + ",");
						}
					} else if (oldv != null && v == null) {
						strb.append("删除" + mapKey2Chinese(k) + ":" + oldv + ",");
					}
				}
			});
			if (strb.length() > 0) {
				addOperateRecord(parkingLotId, "更新岗亭管理", strb.toString());
			}
		} else {
			// addOperateRecord(parkingLotId , "更新岗亭管理","更新停车场岗亭管理");
		}
		return updateRows;
	}

	private int updateDepotExtendedInfo(int parkingLotId, Map<String, Object> paramMap) {
		String currentUserName = sdkOfGetCurrentUserName();
		String propertyUnit = paramMap.get("PropertyUnitvalue3") != null
				? String.valueOf(paramMap.get("PropertyUnitvalue3"))
				: null;
		String buildingAttribute = paramMap.get("BuildingPropertiesvalue3") != null
				? String.valueOf(paramMap.get("BuildingPropertiesvalue3"))
				: null;
		String licenseNumber = paramMap.get("LicenseNumbervalue3") != null
				? String.valueOf(paramMap.get("LicenseNumbervalue3"))
				: null;
		String businessScope = paramMap.get("BusinessScopevalue3") != null
				? String.valueOf(paramMap.get("BusinessScopevalue3"))
				: null;
		String contactPerson = paramMap.get("Contactvalue3") != null ? String.valueOf(paramMap.get("Contactvalue3"))
				: null;
		String contactPhone = paramMap.get("ContactPhonevalue6") != null
				? String.valueOf(paramMap.get("ContactPhonevalue6"))
				: null;
		String propertyDescription = paramMap.get("Expandinformationvalue3") != null
				? String.valueOf(paramMap.get("Expandinformationvalue3"))
				: null;
		String usageYears = paramMap.get("Servicelifevalue3") != null
				? String.valueOf(paramMap.get("Servicelifevalue3"))
				: null;
		String constructionTime = paramMap.get("Constructiontimevalue3") != null
				? String.valueOf(paramMap.get("Constructiontimevalue3"))
				: null;

		String validityPeriod = paramMap.get("ValidityPeriodvalue3") != null
				? String.valueOf(paramMap.get("ValidityPeriodvalue3"))
				: null;

		String attachmentUpload = paramMap.get("AttachmentUploadfileList1") != null
				? String.valueOf(paramMap.get("AttachmentUploadfileList1"))
				: null;

		StringBuilder updateSql = new StringBuilder("UPDATE extended_info SET ");
		List<Object> params = new ArrayList<>();
		if (propertyUnit != null) {
			updateSql.append("property_unit = ?, ");
			params.add(propertyUnit);
		}
		if (buildingAttribute != null) {
			updateSql.append("building_attribute = ?, ");
			params.add(buildingAttribute);
		}
		if (licenseNumber != null) {
			updateSql.append("license_number = ?, ");
			params.add(licenseNumber);
		}
		if (businessScope != null) {
			updateSql.append("business_scope = ?, ");
			params.add(businessScope);
		}
		if (contactPerson != null) {
			updateSql.append("contact_person = ?, ");
			params.add(contactPerson);
		}
		if (contactPhone != null) {
			updateSql.append("contact_phone = ?, ");
			params.add(contactPhone);
		}

		if (propertyDescription != null) {
			updateSql.append("property_description = ?, ");
			params.add(propertyDescription);
		}
		if (usageYears != null) {
			updateSql.append("usage_years = ?, ");
			params.add(usageYears);
		}

		if (constructionTime != null) {
			updateSql.append("construction_time = ?, ");
			params.add(constructionTime);
		}
		if (validityPeriod != null) {
			updateSql.append("validity_period = ?, ");
			params.add(validityPeriod);
		}
		if (attachmentUpload != null) {
			updateSql.append("attachment_upload = ?, ");
			params.add(attachmentUpload);
		}

		updateSql.append("update_username = ?, update_time = ? WHERE parking_lot_id = ?");
		params.add(currentUserName);
		params.add(new Date());
		params.add(parkingLotId);
		// 执行更新SQL

		List<Map<String, Object>> oldList = executeSQL("select * from extended_info WHERE parking_lot_id = ?",
				parkingLotId);
		int updateRows = executeSQL(updateSql.toString(), params.toArray());
		List<Map<String, Object>> newList = executeSQL("select * from extended_info WHERE parking_lot_id = ?",
				parkingLotId);
		if (!oldList.isEmpty() && !newList.isEmpty()) {
			Map<String, Object> oldMap = oldList.get(0);
			Map<String, Object> newMap = newList.get(0);
			StringBuilder strb = new StringBuilder();
			newMap.forEach((k, v) -> {
				if (!"update_time".equals(k) && !"update_username".equals(k)) {
					Object oldv = oldMap.get(k);
					if (oldv == null && v != null) {
						strb.append("新增" + mapKey2Chinese(k) + ":" + v + ",");
					} else if (oldv != null && v != null) {
						if (!oldv.equals(v)) {
							strb.append("修改" + mapKey2Chinese(k) + ":" + oldv + "->" + v + ",");
						}
					} else if (oldv != null && v == null) {
						strb.append("删除" + mapKey2Chinese(k) + ":" + oldv + ",");
					}
				}
			});
			if (strb.length() > 0) {
				addOperateRecord(parkingLotId, "更新拓展信息", strb.toString());
			}
		} else {
			// addOperateRecord(parkingLotId , "更新拓展信息","更新停车场拓展信息");
		}
		return updateRows;

	}

	private int updateDepotFileAttachmentList(int parkingLotId, Map<String, Object> paramMap) {

		String currentUserName = sdkOfGetCurrentUserName();
		String attachmentName = paramMap.get("attachmentName") != null ? String.valueOf(paramMap.get("attachmentName"))
				: null;
		String uploadTime = paramMap.get("uploadTime") != null ? String.valueOf(paramMap.get("uploadTime")) : null;
		String creator = paramMap.get("creator") != null ? String.valueOf(paramMap.get("creator")) : null;

		StringBuilder updateSql = new StringBuilder("UPDATE file_attachment_list SET ");
		List<Object> params = new ArrayList<>();
		if (attachmentName != null) {
			updateSql.append("attachment_name = ?, ");
			params.add(attachmentName);
		}
		if (uploadTime != null) {
			updateSql.append("upload_time = ?, ");
			params.add(uploadTime);
		}
		if (creator != null) {
			updateSql.append("creator = ?, ");
			params.add(creator);
		}
		updateSql.append("update_username = ?, update_time = ? WHERE parking_lot_id = ?");
		params.add(currentUserName);
		params.add(new Date());
		params.add(parkingLotId);
		// 执行更新SQL
		int updateRows = executeSQL(updateSql.toString(), params.toArray());
		return updateRows;
	}

	public Result updateYardDetails(Map<String, Object> paramMap) {
		// 获取当前用户名
		/// Map<String, Object> parkingLotInfo=(Map<String,
		// Object>)paramMap.get("parkingLotInfo");
		Integer curId = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
		if (curId == null) {
			return new Result(false, "编辑失败", null);
		}
		int updateRows = updateDepotParkingLotInfo(paramMap);
		if (updateRows <= 0) {
			return new Result(false, "编辑失败", null);
		}
		/**
		 * 其他表数据插入
		 */
		updateDepotPlatformInfo(curId, paramMap);// (Map<String, Object>)paramMap.get("platformInformation"));
		updateDepotOperationRules(curId, paramMap);// (Map<String, Object>)paramMap.get("operatingRules"));
		updateDepotBillingRules(curId, paramMap);// (Map<String, Object>)paramMap.get("billingRules"));
		updateDepotBoothManagement(curId, paramMap);// (Map<String, Object>)paramMap.get("postManagement"));
		updateDepotExtendedInfo(curId, paramMap);// (Map<String, Object>)paramMap.get("extendedInformation"));
		updateDepotFileAttachmentList(curId, paramMap);// (Map<String, Object>)paramMap.get("fileAttachmentList"));
		// 返回结果
		return new Result(true, "更新成功", null);

	}

	public Result getYardListZVO(Map<String, Object> paramMap) {
		// 获取分页参数
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		// 构建查询SQL
		StringBuilder sql = new StringBuilder("SELECT * FROM parking_lot_info WHERE 1=1");
		List<Object> params = new ArrayList<>();
		// 添加查询条件
		if (paramMap.get("parkingLotCode") != null) {
			sql.append(" AND parking_lot_code = ?");
			params.add(String.valueOf(paramMap.get("parkingLotCode")));
		}
		if (paramMap.get("parkingLotName") != null) {
			sql.append(" AND parking_lot_name LIKE ?");
			params.add("%" + String.valueOf(paramMap.get("parkingLotName")).trim() + "%");
		}
		if (paramMap.get("region") != null) {
			sql.append(" AND region = ?");
			params.add(String.valueOf(paramMap.get("region")));
		}
		if (paramMap.get("sector") != null) {
			sql.append(" AND sector = ?");
			params.add(String.valueOf(paramMap.get("sector")));
		}
		if (paramMap.get("category") != null) {
			sql.append(" AND category = ?");
			params.add(String.valueOf(paramMap.get("category")));
		}
		if (paramMap.get("parkingLotType") != null) {
			sql.append(" AND parking_lot_type = ?");
			params.add(String.valueOf(paramMap.get("parkingLotType")));
		}
		if (paramMap.get("parkingLotStatus") != null) {
			sql.append(" AND parking_lot_status = ?");
			params.add(String.valueOf(paramMap.get("parkingLotStatus")));
		}
		// 添加排序和分页
		sql.append(" ORDER BY create_time DESC LIMIT ?, ?");
		params.add((current - 1) * pageSize);
		params.add(pageSize);
		// 执行查询SQL
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		// 查询总条数
		StringBuilder countSql = new StringBuilder("SELECT COUNT(*) AS total FROM parking_lot_info WHERE 1=1");
		// 不包括分页参数
		List<Object> countParams = new ArrayList<>(params.subList(0, params.size() - 2));
		List<Map<String, Object>> countResult = countParams.isEmpty() ? executeSQL(countSql.toString())
				: executeSQL(countSql.toString(), countParams.toArray());
		Integer total = countResult.get(0) != null ? Integer.valueOf(String.valueOf(countResult.get(0).get("total")))
				: 0;
		// 返回结果
		RowUtil.setRowNumber(data, pageSize, current);
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("total", total);
		resultData.put("data", data);
		return new Result(true, "查询成功", resultData);
	}

	public Result getYardBillingRules(Map<String, Object> paramMap) {
		// This function is not required to be implemented based on the current
		// requirements.
		return null;
	}

	public Result getPaginatedYardBillingRules(Map<String, Object> paramMap) {
		// Extract pagination parameters
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		// SQL to get paginated yard billing rules
		StringBuilder sql = new StringBuilder(
				"SELECT id, rule_number, rule_name, rule_description, create_time, status FROM billing_rules WHERE 1=1");
		sql.append(" ORDER BY create_time DESC LIMIT ?, ?");
		List<Object> params = new ArrayList<>();
		params.add((current - 1) * pageSize);
		params.add(pageSize);
		// Execute SQL
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		// SQL to get total count
		String countSql = "SELECT COUNT(*) as counter FROM billing_rules";
		List<Map<String, Object>> countResult = executeSQL(countSql);
		Integer total = countResult != null && !countResult.isEmpty()
				? Integer.valueOf(String.valueOf(countResult.get(0).get("counter")))
				: 0;
		// Prepare result
		RowUtil.setRowNumber(data, pageSize, current);
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("data", data);
		resultData.put("total", total);
		return new Result(true, "Success", resultData);
	}

	public Result getYardBillingRuleByParkingId(Map<String, Object> paramMap) {
		// Extract pagination parameters
		Integer parkingLotId = paramMap.get("parkingLotId") != null
				? Integer.valueOf(String.valueOf(paramMap.get("parkingLotId")))
				: null;
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		// SQL to get paginated yard billing rules
		StringBuilder sql = new StringBuilder(
				"select a.id,a.relation_time,a.create_username as relation_username,a.enable_status,b.rule_name,b.billing_standard,b.rule_description from billing_rule_parking a join billing_rules b on a.billing_rule_id=b.id where parking_lot_info_id= ?");
		List<Object> params = new ArrayList<>();
		params.add(parkingLotId);

		sql.append(" ORDER BY a.create_time DESC LIMIT ?, ?");

		params.add((current - 1) * pageSize);
		params.add(pageSize);
		// Execute SQL
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		// SQL to get total count
		String countSql = "select count(a.id) as counter from billing_rule_parking a join billing_rules b on a.billing_rule_id=b.id where parking_lot_info_id= ?";
		List<Object> countparams = new ArrayList<>();
		countparams.add(parkingLotId);
		List<Map<String, Object>> countResult = executeSQL(countSql, countparams);
		Integer total = countResult != null && !countResult.isEmpty() && countResult.get(0).get("counter") != null
				? Integer.valueOf(String.valueOf(countResult.get(0).get("counter")))
				: 0;
		// Prepare result
		RowUtil.setRowNumber(data, pageSize, current);
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("data", data);
		resultData.put("total", total);
		return new Result(true, "Success", resultData);
	}

	public Result getFileAttachmentList(Map<String, Object> paramMap) {
		// This function is not required to be implemented based on the current
		// requirements.
		return null;
	}

	public Result getPaginatedFileAttachmentList(Map<String, Object> paramMap) {
		// Extract pagination parameters
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		// SQL to get paginated file attachment list
		StringBuilder sql = new StringBuilder("SELECT * FROM file_attachment_list WHERE 1=1");
		sql.append(" ORDER BY upload_time DESC LIMIT ?, ?");
		List<Object> params = new ArrayList<>();
		params.add((current - 1) * pageSize);
		params.add(pageSize);
		// Execute SQL
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		// SQL to get total count
		String countSql = "SELECT COUNT(*) FROM file_attachment_list";
		List<Map<String, Object>> countResult = executeSQL(countSql);
		Integer total = countResult != null && !countResult.isEmpty()
				? Integer.valueOf(String.valueOf(countResult.get(0).get("COUNT(*)")))
				: 0;
		// Prepare result
		RowUtil.setRowNumber(data, pageSize, current);
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("data", data);
		resultData.put("total", total);
		return new Result(true, "Success", resultData);
	}

	public Result getPostPersonnelList(Map<String, Object> paramMap) {
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		Integer parkingLotId = paramMap.get("parkingLotId") != null
				? Integer.valueOf(String.valueOf(paramMap.get("parkingLotId")))
				: null;
		StringBuilder sql = new StringBuilder("SELECT * FROM booth_management WHERE 1=1");
		List<Object> params = new ArrayList<>();
		if (parkingLotId != null) {
			sql.append(" AND parking_lot_id = ?");
			params.add(parkingLotId);
		}
		int total = sdkOfPaginationQueryCount(sql.toString(), params.toArray());
		sql.append(" ORDER BY entry_time DESC LIMIT ?, ?");
		params.add((current - 1) * pageSize);
		params.add(pageSize);
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		RowUtil.setRowNumber(data, pageSize, current);
		Map<String, Object> result = new HashMap<>();
		result.put("total", total);
		result.put("data", data);
		return new Result(true, "Success", result);
	}

	public Result getPaginatedPostPersonnel(Map<String, Object> paramMap) {
		// Extract pagination parameters
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		Integer parkingLotId = paramMap.get("parkingLotId") != null
				? Integer.valueOf(String.valueOf(paramMap.get("parkingLotId")))
				: null;
		// SQL to get paginated post personnel list
		StringBuilder sql = new StringBuilder(
				"SELECT id, name, phone_number, status, entry_time, resignation_time,parking_lot_id FROM booth_management WHERE 1=1");
		List<Object> params = new ArrayList<>();
		if (parkingLotId != null) {
			sql.append(" and parking_lot_id =?");
			params.add(parkingLotId);
		}

		sql.append(" ORDER BY entry_time DESC LIMIT ?, ?");

		params.add((current - 1) * pageSize);
		params.add(pageSize);
		// Execute SQL
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		// SQL to get total count
		String countSql = "SELECT COUNT(*) as ct FROM booth_management where 1=1";
		List<Object> countParams = new ArrayList<>();
		if (parkingLotId != null) {
			countSql += " and parking_lot_id =?";
			countParams.add(parkingLotId);
		}
		List<Map<String, Object>> countResult = countParams.isEmpty() ? executeSQL(countSql)
				: executeSQL(countSql, countParams);
		Integer total = countResult != null && !countResult.isEmpty()
				? Integer.valueOf(String.valueOf(countResult.get(0).get("ct")))
				: 0;
		// Prepare result
		Map<String, Object> resultData = new HashMap<>();
		RowUtil.setRowNumber(data, pageSize, current);
		resultData.put("data", data);
		resultData.put("total", total);
		return new Result(true, "Success", resultData);
	}

	public Result getAllParkingLots(Map<String, Object> paramMap) {
		// This function is not required to be implemented based on the current
		// requirements.
		return null;
	}

	public Result getPaginatedParkingLots(Map<String, Object> paramMap) {
		// Extract pagination parameters
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		// SQL to get paginated parking lots
		StringBuilder sql = new StringBuilder("SELECT * FROM parking_lot_info WHERE 1=1");
		sql.append(" ORDER BY create_time DESC LIMIT ?, ?");
		List<Object> params = new ArrayList<>();
		params.add((current - 1) * pageSize);
		params.add(pageSize);
		// Execute SQL
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		// SQL to get total count
		String countSql = "SELECT COUNT(*) FROM parking_lot_info";
		List<Map<String, Object>> countResult = executeSQL(countSql);
		Integer total = countResult != null && !countResult.isEmpty()
				? Integer.valueOf(String.valueOf(countResult.get(0).get("COUNT(*)")))
				: 0;
		// Prepare result
		RowUtil.setRowNumber(data, pageSize, current);
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("data", data);
		resultData.put("total", total);
		return new Result(true, "Success", resultData);
	}

	public Result getParkingLotDetails(Map<String, Object> paramMap) {
		// Extract parking lot ID
		Integer parkingLotId = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
		if (parkingLotId == null) {
			return new Result(false, "Parking lot ID is required", null);
		}
		// SQL to get parking lot details
		StringBuilder sql = new StringBuilder("SELECT * FROM parking_lot_info WHERE id = ?");
		List<Map<String, Object>> parkingLotDetails = executeSQL(sql.toString(), parkingLotId);
		// SQL to get platform information
		sql = new StringBuilder(
				"SELECT id, operating_mode, operating_company, docking_platform,conservator FROM platform_info WHERE parking_lot_id = ?");
		List<Map<String, Object>> platformInformation = executeSQL(sql.toString(), parkingLotId);
		// SQL to get operation rules
		sql = new StringBuilder("SELECT * FROM operation_rules WHERE parking_lot_id = ?");
		List<Map<String, Object>> operatingRules = executeSQL(sql.toString(), parkingLotId);
		// SQL to get billing rules
		sql = new StringBuilder(
				"SELECT id, rule_name, rule_description, associated_time, associated_person, status FROM billing_rules WHERE parking_lot_id = ?");
		List<Map<String, Object>> billingRules = executeSQL(sql.toString(), parkingLotId);
		// SQL to get booth management
		sql = new StringBuilder(
				"SELECT id, name, phone_number, status, entry_time, resignation_time FROM booth_management WHERE parking_lot_id = ?");
		List<Map<String, Object>> postManagement = executeSQL(sql.toString(), parkingLotId);
		// SQL to get extended information
		sql = new StringBuilder(
				"SELECT id, property_unit, building_attribute, license_number, business_scope, contact_person, contact_phone, property_description, usage_years, construction_time, validity_period,attachment_upload FROM extended_info WHERE parking_lot_id = ?");
		List<Map<String, Object>> extendedInformation = executeSQL(sql.toString(), parkingLotId);
		// SQL to get file attachment list
		sql = new StringBuilder("SELECT * FROM file_attachment_list WHERE parking_lot_id = ?");
		List<Map<String, Object>> fileAttachmentList = executeSQL(sql.toString(), parkingLotId);
		// Prepare result
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("parkingLotDetails", parkingLotDetails);
		resultData.put("platformInformation", platformInformation);
		resultData.put("operatingRules", operatingRules);
		resultData.put("billingRules", billingRules);
		resultData.put("postManagement", postManagement);
		resultData.put("extendedInformation", extendedInformation);
		resultData.put("fileAttachmentList", fileAttachmentList);
		return new Result(true, "Success", resultData);
	}

	public Result getPlatformInformation(Map<String, Object> paramMap) {
		// This function is not required to be implemented based on the current
		// requirements.
		return null;
	}

	public Result getOperatingRules(Map<String, Object> paramMap) {
		// This function is not required to be implemented based on the current
		// requirements.
		Integer parkingLotId = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
		if (parkingLotId == null) {
			return new Result(false, "Parking lot ID is required", null);
		}
		StringBuilder sql = new StringBuilder(
				"SELECT a.id,a.rule_name,a.billing_standard,a.rule_description,b.status,b.relation_time FROM billing_rules a join billing_rules_parking b WHERE b.parking_lot_id = ?");
		List<Map<String, Object>> platformInformation = executeSQL(sql.toString(), parkingLotId);
		return new Result(true, "Success", platformInformation);
	}

	public Result getBillingRules(Map<String, Object> paramMap) {
		// This function is not required to be implemented based on the current
		// requirements.

		return null;
	}

	public Result getPostManagement(Map<String, Object> paramMap) {
		// This function is not required to be implemented based on the current
		// requirements.
		return null;
	}

	public Result getExtendedInformation(Map<String, Object> paramMap) {
		// This function is not required to be implemented based on the current
		// requirements.
		return null;
	}

	public Result getParkingLotOperationRecords(Map<String, Object> paramMap) {
		// Extract parameters for pagination
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		Integer id = paramMap.get("id") == null ? null : Integer.valueOf(String.valueOf(paramMap.get("id")));
		// Calculate offset for pagination
		int offset = (current - 1) * pageSize;
		// Build SQL for fetching operation records with pagination
		List<Object> params = new ArrayList<>();
		StringBuilder sql = new StringBuilder("SELECT *  FROM parking_operation_records WHERE 1=1");
		if (id != null) {
			sql.append(" and parking_lot_id=?");
			params.add(id);
		}
		sql.append(" ORDER BY id DESC LIMIT ?, ?");
		// Parameters for SQL query
		params.add(offset);
		params.add(pageSize);
		// Execute SQL to fetch data
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		// Build SQL for counting total records
		StringBuilder countSql = new StringBuilder("SELECT COUNT(*) as total FROM parking_operation_records WHERE 1=1");
		if (id != null) {
			countSql.append(" and parking_lot_id=" + id);
		}
		List<Map<String, Object>> countResult = executeSQL(countSql.toString());
		// Extract total count
		int total = countResult != null && !countResult.isEmpty()
				? Integer.valueOf(String.valueOf(countResult.get(0).get("total")))
				: 0;
		// Prepare result
		RowUtil.setRowNumber(data, pageSize, current);
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("total", total);
		resultData.put("data", data);
		return new Result(true, "Operation records fetched successfully", resultData);
	}

	public Result getPaginatedOperationRecords(Map<String, Object> paramMap) {
		// This function can be similar to getParkingLotOperationRecords if it needs to
		// fetch paginated records
		// Assuming it has the same functionality for demonstration purposes
		// Extract parameters for pagination
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		Integer id = paramMap.get("id") == null ? null : Integer.valueOf(String.valueOf(paramMap.get("id")));
		// Calculate offset for pagination
		int offset = (current - 1) * pageSize;
		// Build SQL for fetching operation records with pagination
		List<Object> params = new ArrayList<>();
		StringBuilder sql = new StringBuilder("SELECT * FROM parking_operation_records WHERE 1=1");
		if (id != null) {
			sql.append(" and parking_lot_id=?");
			params.add(id);
		}
		sql.append(" ORDER BY id DESC LIMIT ?, ?");
		// Parameters for SQL query
		params.add(offset);
		params.add(pageSize);
		// Execute SQL to fetch data
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		// Build SQL for counting total records
		StringBuilder countSql = new StringBuilder("SELECT COUNT(*) as total FROM parking_operation_records WHERE 1=1");
		if (id != null) {
			countSql.append(" and parking_lot_id=" + id);
		}
		List<Map<String, Object>> countResult = executeSQL(countSql.toString());
		// Extract total count
		int total = countResult != null && !countResult.isEmpty()
				? Integer.valueOf(String.valueOf(countResult.get(0).get("total")))
				: 0;
		// Prepare result
		RowUtil.setRowNumber(data, pageSize, current);
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("total", total);
		resultData.put("data", data);
		return new Result(true, "Paginated operation records fetched successfully", resultData);
	}

	public Result getBillingRulesAM1(Map<String, Object> paramMap) {
		// Initialize the result object
		Result result = new Result();
		try {
			// Construct the SQL query to fetch rule names from the billing_rules table
			StringBuilder sql = new StringBuilder("SELECT rule_name FROM billing_rules WHERE 1=1");
			List<Object> params = new ArrayList<>();
			// Execute the SQL query
			List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
			// Set the result data
			RowUtil.setRowNumber(data, 100000, 1);
			result.setFlag(true);
			result.setMessage("Query successful");
			result.setData(data);
		} catch (Exception e) {
			// Handle any exceptions and set the result as failed
			result.setFlag(false);
			result.setMessage("Query failed: " + e.getMessage());
		}
		return result;
	}

	public Result validateNewYardForm(Map<String, Object> paramMap) {
		// Validate required fields
		// TODO 电话号码格式校验
		String name = paramMap.get("Nameofyard1value2") != null ? String.valueOf(paramMap.get("Nameofyard1value2"))
				: null;
		String manager = paramMap.get("Personinchargevalue2") != null
				? String.valueOf(paramMap.get("Personinchargevalue2"))
				: null;
		String contactNumber = paramMap.get("ContactPhonevalue2") != null
				? String.valueOf(paramMap.get("ContactPhonevalue2"))
				: null;
		String operatingCompany = paramMap.get("OperatingCompany1value2") != null
				? String.valueOf(paramMap.get("OperatingCompany1value2"))
				: null;
		if (StrUtil.isEmpty(name) || StrUtil.isEmpty(manager) || StrUtil.isEmpty(contactNumber)
				|| StrUtil.isEmpty(operatingCompany)) {
			return new Result(false, "必填项不能为空", null);
		}
		return new Result(true, "校验通过", null);
	}

	private int addNewDepotParkingLotInfo(Map<String, Object> paramMap) {
		// TODO 添加平台信息
		String currentUserName = sdkOfGetCurrentUserName();
		// String parkingLotCode = "PL" + System.currentTimeMillis();
		// Insert into parking_lot_info
		StringBuilder sql = new StringBuilder(
				"INSERT INTO parking_lot_info (parking_lot_code, parking_lot_name, parking_lot_short_name, parking_spaces, long_term_spaces, reserved_spaces, vip_spaces, charging_piles, operating_company, manager, contact_number, latitude_longitude, detailed_address, parking_lot_description, parking_lot_status, parking_lot_type, region, category, sector, charging_service, additional_service, screen_visibility,parking_lot_icon,parking_lot_photo,create_username,create_time,update_username,update_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		List<Object> params = new ArrayList<>();
		// params.add(parkingLotCode);
		// StringUtils.isEmpty(params)
		params.add(!StringUtils.isEmpty(paramMap.get("yardnumbervalue2"))
				? String.valueOf(paramMap.get("yardnumbervalue2"))
				: null);
		params.add(
				paramMap.get("Nameofyard1value2") != null ? String.valueOf(paramMap.get("Nameofyard1value2")) : null);
		params.add(
				paramMap.get("Yardabbreviationvalue2") != null ? String.valueOf(paramMap.get("Yardabbreviationvalue2"))
						: null);
		params.add(!StringUtils.isEmpty(paramMap.get("Numberofparkingvalue2"))
				? Integer.valueOf(String.valueOf(paramMap.get("Numberofparkingvalue2")))
				: null);
		params.add(!StringUtils.isEmpty(paramMap.get("Longtermrentalparkingspacesvalue2"))
				? Integer.valueOf(String.valueOf(paramMap.get("Longtermrentalparkingspacesvalue2")))
				: null);
		params.add(!StringUtils.isEmpty(paramMap.get("Reservationofparkingspacevalue2"))
				? Integer.valueOf(String.valueOf(paramMap.get("Reservationofparkingspacevalue2")))
				: null);
		params.add(!StringUtils.isEmpty(paramMap.get("VIPParkingvalue2"))
				? Integer.valueOf(String.valueOf(paramMap.get("VIPParkingvalue2")))
				: null);
		params.add(!StringUtils.isEmpty(paramMap.get("Numberofchargingpilesvalue2"))
				? Integer.valueOf(String.valueOf(paramMap.get("Numberofchargingpilesvalue2")))
				: null);
		params.add(paramMap.get("OperatingCompany1value2") != null
				? String.valueOf(paramMap.get("OperatingCompany1value2"))
				: null);
		params.add(paramMap.get("Personinchargevalue2") != null ? String.valueOf(paramMap.get("Personinchargevalue2"))
				: null);
		params.add(
				paramMap.get("ContactPhonevalue2") != null ? String.valueOf(paramMap.get("ContactPhonevalue2")) : null);
		params.add(paramMap.get("latitudeandlongitudevalue2") != null
				? String.valueOf(paramMap.get("latitudeandlongitudevalue2"))
				: null);
		params.add(paramMap.get("Detailedaddressvalue2") != null ? String.valueOf(paramMap.get("Detailedaddressvalue2"))
				: null);
		params.add(paramMap.get("YardDescriptionvalue2") != null ? String.valueOf(paramMap.get("YardDescriptionvalue2"))
				: null);
		params.add(
				paramMap.get("yardstatus1value2") != null ? String.valueOf(paramMap.get("yardstatus1value2")) : null);
		params.add(
				paramMap.get("Typeofyard1value2") != null ? String.valueOf(paramMap.get("Typeofyard1value2")) : null);
		params.add(paramMap.get("Area1value2") != null ? String.valueOf(paramMap.get("Area1value2")) : null);
		params.add(paramMap.get("YardCategory1value2") != null ? String.valueOf(paramMap.get("YardCategory1value2"))
				: null);
		params.add(paramMap.get("Plate1value2") != null ? String.valueOf(paramMap.get("Plate1value2")) : null);
		params.add(paramMap.get("Chargingservicevalue2") != null ? String.valueOf(paramMap.get("Chargingservicevalue2"))
				: null);
		params.add(paramMap.get("AdditionalServicesvalue2") != null
				? String.valueOf(paramMap.get("AdditionalServicesvalue2"))
				: null);
		Object Whetherthelargescreenisvisiblevalue2 = paramMap.get("Whetherthelargescreenisvisiblevalue2");
		if (Whetherthelargescreenisvisiblevalue2 == null || "".equals(Whetherthelargescreenisvisiblevalue2)) {
			params.add(Boolean.FALSE);
		} else if ("是".equals(Whetherthelargescreenisvisiblevalue2.toString())
				|| "true".equalsIgnoreCase(Whetherthelargescreenisvisiblevalue2.toString())) {
			params.add(Boolean.TRUE);
		} else if (Boolean.TRUE.equals(Whetherthelargescreenisvisiblevalue2)) {
			params.add(Boolean.TRUE);
		} else {
			params.add(Boolean.FALSE);
		}

		params.add(
				paramMap.get("YardIconfileList2") != null ? String.valueOf(paramMap.get("YardIconfileList2")) : null);
		params.add(paramMap.get("YardPhotosfileList2") != null ? String.valueOf(paramMap.get("YardPhotosfileList2"))
				: null);

		params.add(currentUserName);
		params.add(new Date());
		params.add(currentUserName);
		params.add(new Date());
		int insertRows = executeSQL(sql.toString(), params.toArray());

		return insertRows;
	}

	private int addNewDepotPlatformInfo(int parkingLotId, Map<String, Object> paramMap) {
		/*
		 * id int(11) AUTO_INCREMENT PRIMARY KEY, parking_lot_id int(11), FOREIGN KEY
		 * (parking_lot_id) REFERENCES parking_lot_info(id), operating_mode varchar(64),
		 * operating_company varchar(64), docking_platform varchar(64), create_username
		 * varchar(32), create_time datetime(0), update_username varchar(32),
		 * update_time datetime(0)
		 */
		String currentUserName = sdkOfGetCurrentUserName();
		StringBuilder sql = new StringBuilder(
				"INSERT INTO platform_info (parking_lot_id, operating_mode, operating_company, docking_platform, create_username, create_time, update_username, update_time,conservator) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)");
		List<Object> params = new ArrayList<>();
		params.add(parkingLotId);
		params.add(paramMap.get("Operationmodevalue2") != null ? String.valueOf(paramMap.get("Operationmodevalue2"))
				: null);
		params.add(
				paramMap.get("OperatingCompanyvalue3") != null ? String.valueOf(paramMap.get("OperatingCompanyvalue3"))
						: null);
		params.add(paramMap.get("dockingplatformvalue2") != null
				? String.valueOf(String.valueOf(paramMap.get("dockingplatformvalue2")))
				: null);
		params.add(currentUserName);
		params.add(new Date());
		params.add(currentUserName);
		params.add(new Date());
		params.add(paramMap.getOrDefault("conservator",null));
		int insertRows = executeSQL(sql.toString(), params.toArray());
		return insertRows;
	}

	private int addNewDepotOperationRules(int parkingLotId, Map<String, Object> paramMap) {
		// TODO 添加运营规则
		// operation_rules
		/*
		 * (id int(11) AUTO_INCREMENT PRIMARY KEY, parking_lot_id int(11), FOREIGN KEY
		 * (parking_lot_id) REFERENCES parking_lot_info(id),
		 * prepayment_overtime_duration int(11), overtime_exit_handling varchar(64),
		 * abnormal_status varchar(64), abnormal_handling varchar(64), notification
		 * boolean, blacklist text, whitelist text, reserved_spaces_count int(11),
		 * reservation_overtime_duration int(11), exit_scan boolean, create_username
		 * varchar(32), create_time datetime(0), update_username varchar(32),
		 * update_time datetime(0))
		 */

		String currentUserName = sdkOfGetCurrentUserName();
		StringBuilder sql = new StringBuilder(
				"INSERT INTO operation_rules (parking_lot_id, prepayment_overtime_duration, overtime_exit_handling, abnormal_status,abnormal_handling,notification,blacklist,whitelist,reserved_spaces_count,reservation_overtime_duration,exit_scan, create_username, create_time, update_username, update_time"
						+ ",abnormal_status_duplicate,abnormal_status_no_in_car,abnormal_status_force,abnormal_status_other,abnormal_handling_duplicate,abnormal_handling_no_in_car,abnormal_handling_force,abnormal_handling_other,abnormal_duplicate_notification,abnormal_no_in_car_notification,abnormal_force_notification,abnormal_other_notification,abnormal_duplicate_block_time,abnormal_no_in_car_block_time,abnormal_force_block_time,abnormal_other_block_time"
						+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?,?)");
		List<Object> params = new ArrayList<>();
		params.add(parkingLotId);
		params.add(!StringUtils.isEmpty(paramMap.get("PrepaidTimeoutDurationvalue2"))
				? Integer.valueOf(paramMap.get("PrepaidTimeoutDurationvalue2").toString())
				: null);
		params.add(paramMap.get("Timeoutdoesnotleaveprocessingvalue2") != null
				? String.valueOf(paramMap.get("Timeoutdoesnotleaveprocessingvalue2"))
				: null);
		params.add(paramMap.get("Abnormalstatevalue2") != null ? String.valueOf(paramMap.get("Abnormalstatevalue2"))
				: null);
		params.add(paramMap.get("ExceptionHandlingvalue2") != null
				? String.valueOf(paramMap.get("ExceptionHandlingvalue2"))
				: null);
		params.add(!StringUtils.isEmpty(paramMap.get("Notifyvalue4"))
				? Boolean.valueOf(String.valueOf(paramMap.get("Notifyvalue4")))
				: null);
		params.add(paramMap.get("blacklistvalue2") != null ? String.valueOf(paramMap.get("blacklistvalue2")) : null);
		params.add(paramMap.get("WhiteListvalue2") != null ? String.valueOf(paramMap.get("WhiteListvalue2")) : null);
		params.add(!StringUtils.isEmpty(paramMap.get("Reservedcarnumbervalue2"))
				? Integer.valueOf(paramMap.get("Reservedcarnumbervalue2").toString())
				: null);
		params.add(!StringUtils.isEmpty(paramMap.get("Appointmenttimeoutdurationvalue2"))
				? Integer.valueOf(paramMap.get("Appointmenttimeoutdurationvalue2").toString())
				: null);
		params.add(!StringUtils.isEmpty(paramMap.get("AppearanceSweepCodevalue2"))
				? String.valueOf(paramMap.get("AppearanceSweepCodevalue2"))
				: "关闭");
		params.add(currentUserName);
		params.add(new Date());
		params.add(currentUserName);
		params.add(new Date());

		params.add(
				paramMap.get("abnormal_status_duplicate") != null ? paramMap.get("abnormal_status_duplicate") : null);
		params.add(
				paramMap.get("abnormal_status_no_in_car") != null ? paramMap.get("abnormal_status_no_in_car") : null);
		params.add(paramMap.get("abnormal_status_force") != null ? paramMap.get("abnormal_status_force") : null);
		params.add(paramMap.get("abnormal_status_other") != null ? paramMap.get("abnormal_status_other") : null);
		params.add(paramMap.get("abnormal_handling_duplicate") != null ? paramMap.get("abnormal_handling_duplicate")
				: null);
		params.add(paramMap.get("abnormal_handling_no_in_car") != null ? paramMap.get("abnormal_handling_no_in_car")
				: null);
		params.add(paramMap.get("abnormal_handling_force") != null ? paramMap.get("abnormal_handling_force") : null);
		params.add(paramMap.get("abnormal_handling_other") != null ? paramMap.get("abnormal_handling_other") : null);
		params.add(paramMap.get("abnormal_duplicate_notification") != null
				? paramMap.get("abnormal_duplicate_notification")
				: null);
		params.add(paramMap.get("abnormal_no_in_car_notification") != null
				? paramMap.get("abnormal_no_in_car_notification")
				: null);
		params.add(paramMap.get("abnormal_force_notification") != null ? paramMap.get("abnormal_force_notification")
				: null);
		params.add(paramMap.get("abnormal_other_notification") != null ? paramMap.get("abnormal_other_notification")
				: null);
		params.add(paramMap.get("abnormal_duplicate_block_time") != null ? paramMap.get("abnormal_duplicate_block_time")
				: null);
		params.add(paramMap.get("abnormal_no_in_car_block_time") != null ? paramMap.get("abnormal_no_in_car_block_time")
				: null);
		params.add(
				paramMap.get("abnormal_force_block_time") != null ? paramMap.get("abnormal_force_block_time") : null);
		params.add(
				paramMap.get("abnormal_other_block_time") != null ? paramMap.get("abnormal_other_block_time") : null);

		int insertRows = executeSQL(sql.toString(), params.toArray());
		return insertRows;
	}

	private int addNewDepotBillingRules(int parkingLotId, Map<String, Object> paramMap) {
		// TODO 添加计费规则

		String RuleNamevalue1 = paramMap.get("RuleNamevalue1") != null ? String.valueOf(paramMap.get("RuleNamevalue1"))
				: null;
		Integer billRuleId = null;
		try {
			billRuleId = Integer.valueOf(RuleNamevalue1);
		} catch (Exception e) {
			{
				String sql = "select id from billing_rules where rule_name=? limit 1";
				List<Object> params = new ArrayList<>();
				params.add(RuleNamevalue1);
				List<Map<String, Object>> list = executeSQL(sql, params.toArray());
				if (list != null && !list.isEmpty() && null != list.get(0).get("id")) {
					billRuleId = (Integer) list.get(0).get("id");
				}

			}

		}
		// String billRuleId=paramMap.get("billRuleId") != null ?
		// String.valueOf(paramMap.get("billRuleId")) : null;
		StringBuilder updateSql = new StringBuilder("UPDATE parking_lot_info SET  billing_rule_id=? where id =?");
		List<Object> params = new ArrayList<>();
		params.add(billRuleId);
		params.add(parkingLotId);
		int updateRows = executeSQL(updateSql.toString(), params.toArray());

		if (billRuleId == null) {
			return updateRows;
		}
		addBillingParkingRelation(billRuleId, parkingLotId);
		addOperateRecord(parkingLotId, "新增计费规则", RuleNamevalue1);
		return updateRows;
	}

	private int addNewDepotBoothManagement(int parkingLotId, Map<String, Object> paramMap) {
		// TODO 添加岗亭管理
		/*
		 * CREATE TABLE booth_management ( id int(11) AUTO_INCREMENT PRIMARY KEY,
		 * parking_lot_id int(11), FOREIGN KEY (parking_lot_id) REFERENCES
		 * parking_lot_info(id), name varchar(64), phone_number varchar(64), id_card
		 * varchar(64), status varchar(64), entry_time datetime(0), resignation_time
		 * datetime(0), create_username varchar(32), create_time datetime(0),
		 * update_username varchar(32), update_time datetime(0));
		 */
		if (paramMap.get("IdentityCardvalue1") == null) {
			log.info("没有填写岗亭数据");
			return 0;
		}
		if (paramMap.get("Namevalue1") == null) {
			log.info("没有填写岗亭数据");
			return 0;
		}
		String Namevalue1 = String.valueOf(paramMap.get("Namevalue1")).trim();
		String IdentityCardvalue1 = String.valueOf(paramMap.get("IdentityCardvalue1")).trim();
		if (StringUtils.isEmpty(Namevalue1) || StringUtils.isEmpty(IdentityCardvalue1)) {
			log.info("没有填写岗亭数据");
			return 0;
		}
		String currentUserName = sdkOfGetCurrentUserName();
		StringBuilder sql = new StringBuilder(
				"INSERT INTO booth_management (parking_lot_id, name, phone_number, id_card,status,entry_time,resignation_time, create_username, create_time, update_username, update_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		List<Object> params = new ArrayList<>();
		params.add(parkingLotId);
		params.add(paramMap.get("Namevalue1") != null ? String.valueOf(paramMap.get("Namevalue1")) : null);
		params.add(paramMap.get("Mobilephonenumbervalue1") != null
				? String.valueOf(paramMap.get("Mobilephonenumbervalue1"))
				: null);
		params.add(
				paramMap.get("IdentityCardvalue1") != null ? String.valueOf(paramMap.get("IdentityCardvalue1")) : null);
		params.add(paramMap.get("status") != null ? String.valueOf(paramMap.get("status")) : null);
		// params.add(paramMap.get("entryTime") != null ?
		// String.valueOf(paramMap.get("entryTime")) : null);
		// params.add(paramMap.get("resignationTime") != null ?
		// String.valueOf(paramMap.get("resignationTime")) : null);
		params.add(new Date());
		params.add(new Date());
		params.add(currentUserName);
		params.add(new Date());
		params.add(currentUserName);
		params.add(new Date());
		int insertRows = executeSQL(sql.toString(), params.toArray());
		return insertRows;

	}

	private int addNewDepotExtendedInfo(int parkingLotId, Map<String, Object> paramMap) {
		// TODO 添加拓展信息
		/*
		 * CREATE TABLE extended_info (id int(11) AUTO_INCREMENT PRIMARY KEY,
		 * parking_lot_id int(11), FOREIGN KEY (parking_lot_id) REFERENCES
		 * parking_lot_info(id), property_unit varchar(64), building_attribute
		 * varchar(64), license_number varchar(64), business_scope text, contact_person
		 * varchar(64), contact_phone varchar(64), property_description text,
		 * usage_years int(11), construction_time date, validity_period date,
		 * attachment_upload varchar(255), create_username varchar(32), create_time
		 * datetime(0), update_username varchar(32), update_time datetime(0));
		 */

		String currentUserName = sdkOfGetCurrentUserName();
		StringBuilder sql = new StringBuilder(
				"INSERT INTO extended_info (parking_lot_id, property_unit, building_attribute, license_number,business_scope,contact_person,contact_phone,property_description,usage_years,construction_time,validity_period,attachment_upload     , create_username, create_time, update_username, update_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		List<Object> params = new ArrayList<>();
		params.add(parkingLotId);
		params.add(
				paramMap.get("PropertyUnitvalue2") != null ? String.valueOf(paramMap.get("PropertyUnitvalue2")) : null);
		params.add(paramMap.get("BuildingPropertiesvalue2") != null
				? String.valueOf(paramMap.get("BuildingPropertiesvalue2"))
				: null);
		params.add(paramMap.get("LicenseNumbervalue2") != null ? String.valueOf(paramMap.get("LicenseNumbervalue2"))
				: null);
		params.add(paramMap.get("BusinessScopevalue2") != null ? String.valueOf(paramMap.get("BusinessScopevalue2"))
				: null);
		params.add(paramMap.get("Contactvalue2") != null ? String.valueOf(paramMap.get("Contactvalue2")) : null);
		params.add(
				paramMap.get("ContactPhonevalue3") != null ? String.valueOf(paramMap.get("ContactPhonevalue3")) : null);
		params.add(paramMap.get("Expandinformationvalue2") != null
				? String.valueOf(paramMap.get("Expandinformationvalue2"))
				: null);
		params.add(!StringUtils.isEmpty(paramMap.get("Servicelifevalue2"))
				? Integer.valueOf(paramMap.get("Servicelifevalue2").toString())
				: null);
		params.add(!StringUtils.isEmpty(paramMap.get("Constructiontimevalue2"))
				? String.valueOf(paramMap.get("Constructiontimevalue2"))
				: null);

		params.add(
				paramMap.get("ValidityPeriodvalue2") != null ? joinValues(paramMap.get("ValidityPeriodvalue2")) : null);
		params.add(paramMap.get("AttachmentUploadfileList2") != null
				? String.valueOf(paramMap.get("AttachmentUploadfileList2"))
				: null);
		params.add(currentUserName);
		params.add(new Date());
		params.add(currentUserName);
		params.add(new Date());
		int insertRows = executeSQL(sql.toString(), params.toArray());
		return insertRows;

	}

	private int addNewDepotFileAttachmentList(int parkingLotId, Map<String, Object> paramMap) {
		// TODO 添加文件附件
		/*
		 * CREATE TABLE file_attachment_list ( id int(11) AUTO_INCREMENT PRIMARY KEY,
		 * parking_lot_id int(11), FOREIGN KEY (parking_lot_id) REFERENCES
		 * parking_lot_info(id), attachment_name varchar(64), upload_time datetime(0),
		 * creator varchar(64), create_username varchar(32), create_time datetime(0),
		 * update_username varchar(32), update_time datetime(0));
		 */

		String currentUserName = sdkOfGetCurrentUserName();
		StringBuilder sql = new StringBuilder(
				"INSERT INTO file_attachment_list (parking_lot_id, attachment_name, upload_time, creator, create_username, create_time, update_username, update_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		List<Object> params = new ArrayList<>();
		params.add(parkingLotId);
		params.add(paramMap.get("attachmentName") != null ? String.valueOf(paramMap.get("attachmentName")) : null);
		params.add(paramMap.get("uploadTime") != null ? String.valueOf(paramMap.get("uploadTime")) : null);
		params.add(paramMap.get("creator") != null ? String.valueOf(paramMap.get("creator")) : null);
		params.add(currentUserName);
		params.add(new Date());
		params.add(currentUserName);
		params.add(new Date());
		int insertRows = executeSQL(sql.toString(), params.toArray());
		return insertRows;
	}

	public Result addNewYard(Map<String, Object> paramMap) {
		// TODO 只有基本数据，其他tab数据没有
		// Generate a new parking lot code
		// Example code generation
		if (StringUtils.isEmpty(paramMap.get("Numberofparkingvalue2"))) {
			return new Result(false, "新增失败,泊车数量必填", null);
		}
		try {
			Integer.valueOf(String.valueOf(paramMap.get("Numberofparkingvalue2")));
		} catch (Exception e) {
			return new Result(false, "新增失败,泊车数量需填写数字", null);
		}
		if (paramMap.get("Longtermrentalparkingspacesvalue2") != null
				&& !"".equals(paramMap.get("Longtermrentalparkingspacesvalue2"))) {
			try {
				Integer.valueOf(String.valueOf(paramMap.get("Longtermrentalparkingspacesvalue2")));
			} catch (Exception e) {
				return new Result(false, "新增失败,长租车位需填写数字", null);
			}
		}
		if (paramMap.get("Reservationofparkingspacevalue2") != null
				&& !"".equals(paramMap.get("Reservationofparkingspacevalue2"))) {
			try {
				Integer.valueOf(String.valueOf(paramMap.get("Reservationofparkingspacevalue2")));
			} catch (Exception e) {
				return new Result(false, "新增失败,预约车位需填写数字", null);
			}
		}
		if (paramMap.get("VIPParkingvalue2") != null && !"".equals(paramMap.get("VIPParkingvalue2"))) {
			try {
				Integer.valueOf(String.valueOf(paramMap.get("VIPParkingvalue2")));
			} catch (Exception e) {
				return new Result(false, "新增失败,贵宾车位需填写数字", null);
			}
		}
		if (paramMap.get("Numberofchargingpilesvalue2") != null
				&& !"".equals(paramMap.get("Numberofchargingpilesvalue2"))) {
			try {
				Integer.valueOf(String.valueOf(paramMap.get("Numberofchargingpilesvalue2")));
			} catch (Exception e) {
				return new Result(false, "新增失败,充电桩数需填写数字", null);
			}
		}

		/// log.info("#addNewYard#");
		log.info(new JSONObject(paramMap).toJSONString());
		int result = addNewDepotParkingLotInfo(paramMap);// (Map<String, Object>)paramMap.get("parkingLotInfo"));
		if (result <= 0) {
			return new Result(false, "新增失败", null);
		}
		/**
		 * 其他表数据插入
		 */
		String currentIdsql = "select max(id) as id from parking_lot_info";
		List<Map<String, Object>> curIdResult = executeSQL(currentIdsql, null);
		Integer curId = (Integer) curIdResult.get(0).get("id");
		addNewDepotPlatformInfo(curId, paramMap);// (Map<String, Object>)paramMap.get("platformInformation"));
		addNewDepotOperationRules(curId, paramMap);// (Map<String, Object>)paramMap.get("operatingRules"));
		addNewDepotBillingRules(curId, paramMap);// (Map<String, Object>)paramMap.get("billingRules"));
		addNewDepotBoothManagement(curId, paramMap);// (Map<String, Object>)paramMap.get("postManagement"));
		addNewDepotExtendedInfo(curId, paramMap);// (Map<String, Object>)paramMap.get("extendedInformation"));
		addNewDepotFileAttachmentList(curId, paramMap);// (Map<String, Object>)paramMap.get("fileAttachmentList"));

		List<Map<String, Object>> newResult = executeSQL("select * from parking_lot_info");
		addOperateRecord(curId, "新增", "新增停车场：" + newResult.get(0).get("parking_lot_name"));
		return new Result(true, "新增成功", null);

	}

	public Result getYardListCWC(Map<String, Object> paramMap) {
		// Pagination parameters
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		// Query total count
		StringBuilder countSql = new StringBuilder("SELECT COUNT(*) AS total FROM parking_lot_info");
		List<Map<String, Object>> countResult = executeSQL(countSql.toString());
		int total = countResult.get(0).get("total") != null
				? Integer.valueOf(String.valueOf(countResult.get(0).get("total")))
				: 0;
		// Query data with pagination
		StringBuilder dataSql = new StringBuilder(
				"SELECT * FROM parking_lot_info ORDER BY create_time DESC LIMIT ?, ?");
		List<Object> dataParams = new ArrayList<>();
		dataParams.add((current - 1) * pageSize);
		dataParams.add(pageSize);
		List<Map<String, Object>> data = executeSQL(dataSql.toString(), dataParams.toArray());
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("total", total);
		resultData.put("data", data);
		return new Result(true, "查询成功", resultData);
	}

	public boolean addBillingParkingRelation(int billingRuleId, int parkingId) {
		{
			StringBuilder dataSql = new StringBuilder(
					"select id from  billing_rule_parking where billing_rule_id= ? and parking_lot_info_id= ?");
			List<Object> dataParams = new ArrayList<>();
			dataParams.add(billingRuleId);
			dataParams.add(parkingId);
			List<Map<String, Object>> li = executeSQL(dataSql.toString(), dataParams.toArray());
			if (li.size() > 0) {
				return false;
			}
		}
		String currentUserName = sdkOfGetCurrentUserName();
		{
			StringBuilder dataSql = new StringBuilder(
					"insert into billing_rule_parking (billing_rule_id, parking_lot_info_id,enable_status,relation_time,create_username,create_time,update_username,update_time) values(?,?,?,?,?,?,?,?)");
			List<Object> dataParams = new ArrayList<>();
			dataParams.add(billingRuleId);
			dataParams.add(parkingId);
			dataParams.add("未启用");
			dataParams.add(new Date());
			dataParams.add(currentUserName);
			dataParams.add(new Date());
			dataParams.add(currentUserName);
			dataParams.add(new Date());
			int x = executeSQL(dataSql.toString(), dataParams.toArray());
		}
		return true;
	}

	public Result enableBillingRule(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
		Integer billingRuleId = paramMap.get("billingRuleId") != null
				? Integer.valueOf(String.valueOf(paramMap.get("billingRuleId")))
				: null;
		Integer parking_lot_info_id = null;
		{
			// 检查是否有其他生效的规则
			StringBuilder dataSql = new StringBuilder(
					"select billing_rule_id  from billing_rule_parking where enable_status= '生效中' and parking_lot_info_id in (select parking_lot_info_id from   billing_rule_parking where id=?) ");
			List<Object> dataParams = new ArrayList<>();
			dataParams.add(id);
			List<Map<String, Object>> li = executeSQL(dataSql.toString(), dataParams.toArray());
			if (li.size() > 0) {
				return new Result(false, "启用失败。只能有一个启用的规则", null);
			}
		}
		{
			// 找到车场编号
			StringBuilder dataSql = new StringBuilder(
					"select parking_lot_info_id from   billing_rule_parking where id=? ");
			List<Object> dataParams = new ArrayList<>();
			dataParams.add(id);
			List<Map<String, Object>> li = executeSQL(dataSql.toString(), dataParams.toArray());
			if (li.size() > 0) {
				parking_lot_info_id = Integer.valueOf(li.get(0).get("parking_lot_info_id").toString());
			}

		}
		if (parking_lot_info_id != null) {
			// 禁用车场其他规则
			StringBuilder dataSql = new StringBuilder(
					"update billing_rule_parking set enable_status= '禁用' where parking_lot_info_id= ? and enable_status= '生效中' ");
			List<Object> dataParams = new ArrayList<>();
			dataParams.add(parking_lot_info_id);
			executeSQL(dataSql.toString(), dataParams.toArray());
		}
		{
			StringBuilder dataSql = new StringBuilder(
					"update billing_rule_parking set enable_status= '生效中' where id= ?");
			List<Object> dataParams = new ArrayList<>();
			dataParams.add(id);
			executeSQL(dataSql.toString(), dataParams.toArray());
		}
		{
			// 找到车场和规则编号
			List<Object> dataParams = new ArrayList<>();
			dataParams.add(id);
			List<Map<String, Object>> li = executeSQL(
					"select parking_lot_info_id,billing_rule_id from billing_rule_parking where id=?",
					dataParams.toArray());
			if (!li.isEmpty()) {
				parking_lot_info_id = (Integer) li.get(0).get("parking_lot_info_id");
				billingRuleId = (Integer) li.get(0).get("billing_rule_id");
			}
		}
		{
			// 更新车场表中的当前规则
			if (parking_lot_info_id != null) {
				StringBuilder dataSql = new StringBuilder("update parking_lot_info set billing_rule_id=? where id=?");
				// List<Object> dataParams = new ArrayList<>();
				// dataParams.add(billingRuleId);
				// dataParams.add(parking_lot_info_id);
				Object obj = executeSQL(dataSql.toString(), billingRuleId, parking_lot_info_id);
				log.info("update result:{}", obj);
				executeSQL(dataSql.toString(), billingRuleId, parking_lot_info_id);
				log.info("update result:{}", obj);
			}
			
		}
		{
			if (parking_lot_info_id != null) {
				StringBuilder dataSql = new StringBuilder("select rule_name from billing_rules where id=?");
				List<Map<String, Object>> li = executeSQL(dataSql.toString(), billingRuleId);
				String rulename="";
				if (li.size() > 0) {
					rulename = (String)li.get(0).get("rule_name");
				}
				addOperateRecord(parking_lot_info_id, "启用计费规则", rulename);
			}
		}
		return new Result(true, "更新成功", null);
	}

	public Result disableBillingRule(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
		/*Integer billingRuleId = paramMap.get("billingRuleId") != null
				? Integer.valueOf(String.valueOf(paramMap.get("billingRuleId")))
				: null;*/
		Integer parking_lot_info_id = null;
		Integer billing_rule_id =null;
		{
			StringBuilder dataSql = new StringBuilder(
					"update billing_rule_parking set enable_status= '禁用' where id= ?");
			List<Object> dataParams = new ArrayList<>();
			dataParams.add(id);
			executeSQL(dataSql.toString(), dataParams.toArray());
		}
		{
			List<Object> dataParams = new ArrayList<>();
			dataParams.add(id);
			List<Map<String, Object>> li = executeSQL("select parking_lot_info_id,billing_rule_id from billing_rule_parking where id=?",
					dataParams.toArray());
			if (!li.isEmpty()) {
				parking_lot_info_id = (Integer) li.get(0).get("parking_lot_info_id");
				billing_rule_id = (Integer) li.get(0).get("billing_rule_id");
			}
		}
		{
			if (parking_lot_info_id != null) {
				StringBuilder dataSql = new StringBuilder("select rule_name from billing_rules where id=?");
				List<Map<String, Object>> li = executeSQL(dataSql.toString(), billing_rule_id);
				String rulename="";
				if (li.size() > 0) {
					rulename = (String)li.get(0).get("rule_name");
				}
				addOperateRecord(parking_lot_info_id, "禁用计费规则", rulename);
			}
		}
		return new Result(true, "更新成功", null);
	}

	public Result addBillingRule(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		Integer parkingId = paramMap.get("parkingLotInfoId") != null
				? Integer.valueOf(String.valueOf(paramMap.get("parkingLotInfoId")))
				: null;
		Integer billingRuleId = paramMap.get("billingRuleId") != null
				? Integer.valueOf(String.valueOf(paramMap.get("billingRuleId")))
				: null;
		if (parkingId == null) {
			return new Result(false, "添加失败，停车场ID参数不能为空", null);
		}
		if (billingRuleId == null) {
			return new Result(false, "添加失败，规则ID参数不能为空", null);
		}
		boolean succ = addBillingParkingRelation(billingRuleId, parkingId);
		if (!succ) {
			return new Result(false, "计费规则重复，规则添加失败", null);
		}
		return new Result(true, "添加计费规则成功", null);
	}

	public Result updateEmployeeStatus(Map<String, Object> paramMap) {
		// 获取当前登录者的用户名
		String currentUsername = sdkOfGetCurrentUserName();
		// 获取参数中的员工ID
		Integer employeeId = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
		// 获取当前时间
		Date currentTime = new Date();
		// 构建SQL语句，将状态改为离职，并更新离职时间和最后修改者信息
		StringBuilder sql = new StringBuilder(
				"UPDATE booth_management SET status = ?, resignation_time = ?, update_username = ?, update_time = ? WHERE id = ?");
		List<Object> params = new ArrayList<>();
		params.add("离职");
		params.add(currentTime);
		params.add(currentUsername);
		params.add(currentTime);
		params.add(employeeId);
		// 执行SQL语句
		int updateRows = executeSQL(sql.toString(), params.toArray());
		// 返回结果
		Result result = new Result();
		if (updateRows > 0) {
			result.setFlag(true);
			result.setMessage("员工状态更新成功");
		} else {
			result.setFlag(false);
			result.setMessage("员工状态更新失败");
		}
		return result;
	}

	public Result getRuleList(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> countResult = executeSQL("select * from billing_rules");
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("total", countResult.size());
		resultData.put("data", countResult);
		return new Result(true, "规则列表刷新成功", resultData);
	}

	public List<Map<String, Object>> loadAll() {
		// TODO Auto-generated method stub
		return executeSQL("select * from parking_lot_info");
	}

	private String joinValues(Object mp) {
		if (mp == null) {
			return null;
		}
		if (mp instanceof Map) {
			return joinValues((Map) mp);
		} else if (mp instanceof List) {
			return joinValues((List) mp);
		} else {
			return mp.toString();
		}
	}

	private String joinValues(Map mp) {
		if (mp == null || mp.isEmpty()) {
			return "";
		}
		StringJoiner strb = new StringJoiner(",");
		mp.forEach((k, v) -> {
			strb.add(v == null ? "" : v.toString());
		});
		return strb.toString();
	}

	private String joinValues(List mp) {
		if (mp == null || mp.isEmpty()) {
			return "";
		}
		StringJoiner strb = new StringJoiner(",");
		mp.forEach(v -> {
			strb.add(v == null ? "" : v.toString());
		});
		return strb.toString();
	}

	private void multiParams(List<String> queryList, StringBuilder sql, List<Object> params, String fieldName) {
		// TODO XXXXXXXXXXXXXXX
		if (queryList != null && queryList.size() > 0) {
			if (queryList.size() == 1) {
				sql.append(" AND " + fieldName + " = ?");
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
				sql.append(" ,?)");
				if (params != null) {
					params.add(queryList.get(queryList.size() - 1));
				}
			}

		}
	}

	private void multiParamsLikeOr(List<String> queryList, StringBuilder sql, List<Object> params, String fieldName) {
		// TODO XXXXXXXXXXXXXXX
		if (queryList != null && queryList.size() > 0) {
			if (queryList.size() == 1) {
				sql.append(" AND " + fieldName + "like ? ");
				if (params != null) {
					params.add("%" + queryList.get(0) + "%");
				}
			} else {
				StringJoiner strj = new StringJoiner("|");
				queryList.forEach(r -> {
					strj.add(r.toString().replaceAll("[^a-zA-Z0-9\\u4e00-\\u9fa5]", ""));
				});
				sql.append(" AND " + fieldName + " REGEXP ? ");
				params.add(strj.toString());
			}

		}
	}

	private void multiParamsLikeOr2(List<List<String>> queryList, StringBuilder sql, List<Object> params,
			String fieldName) {
		// TODO XXXXXXXXXXXXXXX
		if (queryList == null || queryList.isEmpty()) {
			return;
		}
		if (queryList.size() == 1) {
			List<String> list = queryList.get(0);
			if (list == null || list.isEmpty()) {
				return;
			}
		}
		if (queryList.size() == 1) {
			List<String> list = queryList.get(0);
			for (int i = 0; i < list.size(); ++i) {
				sql.append(" AND " + fieldName + " like ? ");
				params.add("%" + list.get(i) + "%");
			}
			return;
		}
		for (int k = 0; k < queryList.size(); ++k) {

			if (k == 0) {
				sql.append(" AND (");
			} else {
				sql.append(" or ");
			}

			List<String> list = queryList.get(0);
			for (int i = 0; i < list.size(); ++i) {
				if (i == 0) {
					sql.append("(" + fieldName + " like ? ");
				} else if (i == list.size() - 1) {
					sql.append(" AND " + fieldName + " like ? )");
				} else {
					sql.append(" AND " + fieldName + " like ? ");
				}
				params.add("%" + list.get(i) + "%");
			}

			if (k == queryList.size() - 1) {
				sql.append(" ) ");
			}

		}

	}

	private void addOperateRecord(Integer curId, String operation_node, String operation_content) {
		String currentUserName = sdkOfGetCurrentUserName();
		StringBuilder dataSql = new StringBuilder(
				"insert into  parking_operation_records (operation_time, operation_node,operation_content,operator,parking_lot_id,create_username,create_time,update_username,update_time) values(?,?,?,?,?,?,?,?,?)");
		List<Object> dataParams = new ArrayList<>();
		dataParams.add(new Date());
		dataParams.add(operation_node);
		dataParams.add(operation_content);
		dataParams.add(currentUserName);
		dataParams.add(curId);
		dataParams.add(currentUserName);
		dataParams.add(new Date());
		dataParams.add(currentUserName);
		dataParams.add(new Date());
		int x = executeSQL(dataSql.toString(), dataParams.toArray());
	}

	/**
	 * 对英文做映射
	 * 
	 * @return
	 */
	private static final String mapKey2Chinese(String key) {
		if (key == null) {
			return "";
		}
		if (key.equals("parking_lot_code")) {
			return "车场编号";
		}
		if (key.equals("parking_lot_name")) {
			return "车场名称";
		}
		if (key.equals("parking_lot_short_name")) {
			return "车场简称";
		}
		if (key.equals("parking_spaces")) {
			return "泊车数量";
		}
		if (key.equals("long_term_spaces")) {
			return "长租车位";
		}
		if (key.equals("reserved_spaces")) {
			return "预约车位";
		}
		if (key.equals("vip_spaces")) {
			return "贵宾车位";
		}
		if (key.equals("charging_piles")) {
			return "充电桩数";
		}
		if (key.equals("operating_company")) {
			return "运营公司";
		}
		if (key.equals("manager")) {
			return "负责人";
		}
		if (key.equals("contact_number")) {
			return "联系电话";
		}
		if (key.equals("latitude_longitude")) {
			return "经纬度";
		}
		if (key.equals("detailed_address")) {
			return "详细地址";
		}
		if (key.equals("parking_lot_description")) {
			return "车场描述";
		}
		if (key.equals("parking_lot_status")) {
			return "车场状态";
		}
		if (key.equals("parking_lot_type")) {
			return "车场类型";
		}
		if (key.equals("region")) {
			return "所属区域";
		}
		if (key.equals("category")) {
			return "车场类别";
		}
		if (key.equals("sector")) {
			return "所属板块";
		}
		if (key.equals("charging_service")) {
			return "充电服务";
		}
		if (key.equals("additional_service")) {
			return "附加服务";
		}
		if (key.equals("screen_visibility")) {
			return "大屏是否可见";
		}
		if (key.equals("parking_lot_icon")) {
			return "车场图标";
		}
		if (key.equals("parking_lot_photo")) {
			return "车场照片";
		}
		if (key.equals("billing_rule_id")) {
			return "计费规则ID";
		}
		if (key.equals("create_username")) {
			return "创建者用户名称";
		}
		if (key.equals("create_time")) {
			return "创建时间";
		}
		if (key.equals("update_username")) {
			return "最后修改者用户名称";
		}
		if (key.equals("update_time")) {
			return "最后修改时间";
		}
		if (key.equals("sequence_number")) {
			return "序号";
		}
		if (key.equals("parking_lot_code")) {
			return "车场编号";
		}
		if (key.equals("parking_lot_name")) {
			return "车场名称";
		}
		if (key.equals("region")) {
			return "所属区域";
		}
		if (key.equals("sector")) {
			return "所属板块";
		}
		if (key.equals("category")) {
			return "车场类别";
		}
		if (key.equals("parking_lot_type")) {
			return "车场类型";
		}
		if (key.equals("parking_lot_status")) {
			return "车场状态";
		}
		if (key.equals("parking_spaces")) {
			return "泊车数量";
		}
		if (key.equals("operating_company")) {
			return "运营公司";
		}
		if (key.equals("manager")) {
			return "负责人";
		}
		if (key.equals("contact_number")) {
			return "联系电话";
		}
		if (key.equals("operation")) {
			return "操作";
		}
		if (key.equals("create_time")) {
			return "创建时间";
		}
		if (key.equals("update_time")) {
			return "最后修改时间";
		}
		if (key.equals("name")) {
			return "姓名";
		}
		if (key.equals("phone_number")) {
			return "手机号";
		}
		if (key.equals("id_card")) {
			return "身份证";
		}
		if (key.equals("status")) {
			return "状态";
		}
		if (key.equals("entry_time")) {
			return "入职时间";
		}
		if (key.equals("resignation_time")) {
			return "离职时间";
		}
		if (key.equals("parking_lot_id")) {
			return "车场ID";
		}
		if (key.equals("property_unit")) {
			return "产权单位";
		}
		if (key.equals("building_attribute")) {
			return "建筑属性";
		}
		if (key.equals("license_number")) {
			return "许可证编号";
		}
		if (key.equals("business_scope")) {
			return "经营范围";
		}
		if (key.equals("contact_person")) {
			return "联系人";
		}
		if (key.equals("contact_phone")) {
			return "联系电话";
		}
		if (key.equals("property_description")) {
			return "产权描述";
		}
		if (key.equals("usage_years")) {
			return "使用年限";
		}
		if (key.equals("construction_time")) {
			return "建设时间";
		}
		if (key.equals("validity_period")) {
			return "有效期";
		}
		if (key.equals("attachment_upload")) {
			return "附件上传";
		}
		if (key.equals("parking_lot_id")) {
			return "车场ID";
		}
		if (key.equals("id")) {
			return "主键";
		}
		if (key.equals("attachment_name")) {
			return "附件名称";
		}
		if (key.equals("upload_time")) {
			return "上传时间";
		}
		if (key.equals("creator")) {
			return "创建人";
		}
		if (key.equals("parking_lot_id")) {
			return "车场ID";
		}
		if (key.equals("operating_mode")) {
			return "运营模式";
		}
		if (key.equals("operating_company")) {
			return "运营公司";
		}
		if (key.equals("integration_platform")) {
			return "集成平台";
		}
		if (key.equals("parking_lot_id")) {
			return "车场ID";
		}
		if (key.equals("docking_platform")) {
			return "对接平台";
		}
		if (key.equals("prepayment_overtime_duration")) {
			return "预付超时时长";
		}
		if (key.equals("overtime_exit_handling")) {
			return "超时未离开处理";
		}
		if (key.equals("abnormal_status")) {
			return "异常状态";
		}
		if (key.equals("abnormal_handling")) {
			return "异常处理";
		}
		if (key.equals("notification")) {
			return "是否通知";
		}
		if (key.equals("blacklist")) {
			return "黑名单";
		}
		if (key.equals("whitelist")) {
			return "白名单";
		}
		if (key.equals("reserved_spaces_count")) {
			return "预约车位数";
		}
		if (key.equals("reservation_overtime_duration")) {
			return "预约超时时长";
		}
		if (key.equals("exit_scan")) {
			return "出场扫码";
		}
		if (key.equals("abnormal_status_duplicate")) {
			return "异常车状态-重复入场";
		}
		if (key.equals("abnormal_status_no_in_car")) {
			return "异常车状态-无驶入车";
		}
		if (key.equals("abnormal_status_force")) {
			return "异常车状态-强制抬杆";
		}
		if (key.equals("abnormal_status_other")) {
			return "异常车状态-其他";
		}
		if (key.equals("abnormal_handling_duplicate")) {
			return "异常车处理-重复入场";
		}
		if (key.equals("abnormal_handling_no_in_car")) {
			return "异常车处理-无驶入车";
		}
		if (key.equals("abnormal_handling_force")) {
			return "异常车处理-强制抬杆";
		}
		if (key.equals("abnormal_handling_other")) {
			return "异常车处理-强制抬杆";
		}
		if (key.equals("abnormal_duplicate_notification")) {
			return "异常车通知-重复入场";
		}
		if (key.equals("abnormal_no_in_car_notification")) {
			return "异常车通知-无驶入车";
		}
		if (key.equals("abnormal_force_notification")) {
			return "异常车通知-强制抬杆";
		}
		if (key.equals("abnormal_other_notification")) {
			return "异常车通知-其他";
		}
		if (key.equals("abnormal_duplicate_block_time")) {
			return "异常车拉黑时长-重复入场";
		}
		if (key.equals("abnormal_no_in_car_block_time")) {
			return "异常车拉黑时长-无驶入车";
		}
		if (key.equals("abnormal_force_block_time")) {
			return "异常车拉黑时长-强制抬杆";
		}
		if (key.equals("abnormal_other_block_time")) {
			return "异常车拉黑时长-其他";
		}
		return key;
	}

	/**
	 * 车场二维码列表
	 * 
	 * @param paramMap
	 * @return
	 */
	public Result getQRcodeList(Map<String, Object> paramMap) {
		Integer id = (Integer) paramMap.get("id");
		StringBuilder sql = new StringBuilder(
				"select id, cam_id,in_out,channels from barrier_gate_equipment where parking_lot_info_id=?");
		// 执行SQL语句
		List<Map<String, Object>> li = executeSQL(sql.toString(), id);
		li.forEach(mp -> {
			String in_out = (String) mp.get("in_out");
			if ("出口".equals(in_out)) {
				mp.put("qrcode_type", "扫码出场");
			} else if ("入口".equals(in_out)) {
				mp.put("qrcode_type", "无牌入场");
			} else if ("共进共出".equals(in_out)) {
				mp.put("qrcode_type", "无牌入场");
			}
		});
		Map<String, Object> tiqianjiaofei = new HashMap<>();
		tiqianjiaofei.put("cam_id", "");
		tiqianjiaofei.put("in_out", "");
		tiqianjiaofei.put("id", 999);
		tiqianjiaofei.put("qrcode_type", "提前缴费");
		tiqianjiaofei.put("channels", "");
		li.add(tiqianjiaofei);
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("total", li.size());
		resultData.put("data", li);
		return new Result(true, "查询成功", resultData);
	}

	/**
	 * 获取车场规则
	 * 
	 * @param yardId
	 * @return
	 */
	public Map<String, Object> getOperationRulesByYardId(Integer yardId) {
		StringBuilder sql = new StringBuilder(
				"select * from operation_rules where parking_lot_id=? order by id desc limit 1");
		// 执行SQL语句
		List<Map<String, Object>> li = executeSQL(sql.toString(), yardId);
		if (li == null || li.isEmpty()) {
			return null;
		}
		return li.get(0);
	}
}
