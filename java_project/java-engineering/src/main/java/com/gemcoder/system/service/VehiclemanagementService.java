package com.gemcoder.system.service;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.gemcoder.system.util.RowUtil;
import com.gemcoder.system.ws.VehicleRecord;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserId;

import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import static com.gemcoder.system.service.permission.PermissionSdkService.sdkOfgetAllPermissions;
import static com.gemcoder.system.service.permission.PermissionSdkService.sdkOfgetAllMenus;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@Service
public class VehiclemanagementService {
	@Value("${minio.echoUrl}")
	String minIoEchoUrl;

	public Result getVehicleList(Map<String, Object> paramMap) {
		// Extract parameters
		String licensePlateNumber = paramMap.get("licensePlateNumber") != null
				? String.valueOf(paramMap.get("licensePlateNumber"))
				: null;
		String licensePlateType = paramMap.get("licensePlateType") != null
				? String.valueOf(paramMap.get("licensePlateType"))
				: null;
		String user_order_id = paramMap.get("user_order_id") != null
						? String.valueOf(paramMap.get("user_order_id"))
								: null;
		String recentEntryTime = paramMap.get("recentEntryTime") != null
				? String.valueOf(paramMap.get("recentEntryTime"))
				: null;
		String recentExitTime = paramMap.get("recentExitTime") != null ? String.valueOf(paramMap.get("recentExitTime"))
				: null;
		String recentAccessToParkingLot = paramMap.get("recentAccessToParkingLot") != null
				? String.valueOf(paramMap.get("recentAccessToParkingLot"))
				: null;
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;

		// Build SQL query
		StringBuilder sql = new StringBuilder(
				"SELECT id, license_plate_number, license_plate_type, DATE_FORMAT(last_entry_time, '%Y-%m-%d %H:%i:%s') AS last_entry_time, DATE_FORMAT(last_exit_time, '%Y-%m-%d %H:%i:%s') AS last_exit_time, last_parking_lot,entry_name,exit_name,contact,entry_picture,exit_picture,certificate,berth_number FROM vehicle_entry_exit_record WHERE 1=1");
		List<Object> params = new ArrayList<>();

		if (licensePlateNumber != null && !licensePlateNumber.isEmpty()) {
			sql.append(" AND license_plate_number LIKE ?");
			params.add("%" + licensePlateNumber + "%");
		}
		if (licensePlateType != null && !licensePlateType.isEmpty()) {
			sql.append(" AND license_plate_type = ?");
			params.add(licensePlateType);
		}
		if (recentEntryTime != null && !recentEntryTime.isEmpty()) {
			String[] strings = recentEntryTime.split(",");
			if (strings.length == 2) {
				sql.append(" AND last_entry_time BETWEEN ? AND ?");
				params.add(strings[0]);
				params.add(strings[1]);
			}
		}
		if (recentExitTime != null && !recentExitTime.isEmpty()) {
			String[] strings = recentExitTime.split(",");
			if (strings.length == 2) {
				sql.append(" AND last_exit_time BETWEEN ? AND ?");
				params.add(strings[0]);
				params.add(strings[1]);
			}
		}
		if (recentAccessToParkingLot != null && !recentAccessToParkingLot.isEmpty()) {
			sql.append(" AND last_parking_lot LIKE ?");
			params.add("%" + recentAccessToParkingLot + "%");
		}
		if (user_order_id != null && !user_order_id.isEmpty()) {
			sql.append(" AND user_order_id = ?");
			params.add(Integer.parseInt(user_order_id));
		}

		// Add pagination
		sql.append(" ORDER BY id DESC, last_exit_time DESC LIMIT ?, ?");
		params.add((current - 1) * pageSize);
		params.add(pageSize);

		// Execute SQL
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());

		// Get total count
		StringBuilder countSql = new StringBuilder("SELECT COUNT(*) FROM vehicle_entry_exit_record WHERE 1=1");
		List<Object> countParams = new ArrayList<>();
		if (licensePlateNumber != null && !licensePlateNumber.isEmpty()) {
			countSql.append(" AND license_plate_number LIKE ?");
			countParams.add("%" + licensePlateNumber + "%");
		}
		if (licensePlateType != null && !licensePlateType.isEmpty()) {
			countSql.append(" AND license_plate_type = ?");
			countParams.add(licensePlateType);
		}
		if (recentEntryTime != null && !recentEntryTime.isEmpty()) {
			String[] strings = recentEntryTime.split(",");
			if (strings.length == 2) {
				countSql.append(" AND last_entry_time BETWEEN ? AND ?");
				countParams.add(strings[0]);
				countParams.add(strings[1]);
			}
		}
		if (recentExitTime != null && !recentExitTime.isEmpty()) {
			String[] strings = recentExitTime.split(",");
			if (strings.length == 2) {
				countSql.append(" AND last_exit_time BETWEEN ? AND ?");
				countParams.add(strings[0]);
				countParams.add(strings[1]);
			}
		}
		if (recentAccessToParkingLot != null && !recentAccessToParkingLot.isEmpty()) {
			countSql.append(" AND last_parking_lot LIKE ?");
			countParams.add("%" + recentAccessToParkingLot + "%");
		}
		List<Map<String, Object>> countResult = executeSQL(countSql.toString(), countParams.toArray());
		int total = countResult.isEmpty() ? 0 : Integer.parseInt(String.valueOf(countResult.get(0).get("COUNT(*)")));
		RowUtil.setRowNumber(data, pageSize, current);
		// Return result
		Result result = new Result();
		result.setFlag(true);
		result.setMessage("Success");
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("total", total);
		
		///转换地址
		data.forEach(mp->{
			Object enp=mp.get("entry_picture");
			Object exp=mp.get("exit_picture");
			if(enp!=null&&!StringUtils.isEmpty(enp)) {
				String enpStr=minIoEchoUrl+enp.toString();
				mp.put("entry_picture", enpStr);
			}
			if(exp!=null&&!StringUtils.isEmpty(exp)) {
				String expStr=minIoEchoUrl+exp.toString();
				mp.put("exit_picture", expStr);
			}
		});
		resultData.put("data", data);
		result.setData(resultData);
		return result;
	}

	public Result exportVehicleList(Map<String, Object> paramMap) {
		// Extract parameters
		List<Integer> selectedIds = paramMap.get("selectedIds") != null ? (List<Integer>) paramMap.get("selectedIds")
				: new ArrayList<>();
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;

		// Build SQL query
		StringBuilder sql = new StringBuilder(
				"SELECT id, license_plate_number, license_plate_type, DATE_FORMAT(last_entry_time, '%Y-%m-%d %H:%i:%s') AS last_entry_time, DATE_FORMAT(last_exit_time, '%Y-%m-%d %H:%i:%s') AS last_exit_time, last_parking_lot FROM vehicle_entry_exit_record WHERE 1=1");
		List<Object> params = new ArrayList<>();

		if (!selectedIds.isEmpty()) {
			sql.append(" AND id IN (");
			for (int i = 0; i < selectedIds.size(); i++) {
				sql.append("?");
				if (i < selectedIds.size() - 1) {
					sql.append(", ");
				}
				params.add(selectedIds.get(i));
			}
			sql.append(")");
		} else {
			sql.append(" ORDER BY last_exit_time DESC LIMIT ?, ?");
			params.add((current - 1) * pageSize);
			params.add(pageSize);
		}

		// Execute SQL
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		RowUtil.setRowNumber(data, pageSize, current);
		// Return result
		Result result = new Result();
		result.setFlag(true);
		result.setMessage("Export successful");
		result.setData(data);
		return result;
	}

	public Result getFilteredVehicleList(Map<String, Object> paramMap) {
		// This function can be similar to getVehicleList, but with different filtering
		// logic if needed
		return getVehicleList(paramMap);
	}

	public Result getAllVehicleEntries(Map<String, Object> paramMap) {
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		// Build SQL query
		StringBuilder sql = new StringBuilder(
				"SELECT id, license_plate_number, license_plate_type, DATE_FORMAT(last_entry_time, '%Y-%m-%d %H:%i:%s') AS last_entry_time, DATE_FORMAT(last_exit_time, '%Y-%m-%d %H:%i:%s') AS last_exit_time, last_parking_lot,entry_name,exit_name,contact,entry_picture,exit_picture,certificate,berth_number FROM vehicle_entry_exit_record ORDER BY id DESC, last_exit_time DESC LIMIT ?, ?");
		List<Object> params = new ArrayList<>();
		params.add((current - 1) * pageSize);
		params.add(pageSize);
		// Execute SQL
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		RowUtil.setRowNumber(data, pageSize, current);
		// Return result
		Result result = new Result();
		result.setFlag(true);
		result.setMessage("Success");
		result.setData(data);
		return result;
	}

	public Result getPaginatedVehicleList(Map<String, Object> paramMap) {
		// This function can be similar to getVehicleList, but specifically for
		// pagination logic
		return getVehicleList(paramMap);
	}

	public Result getDepotList(Map<String, Object> paramMap) {
		// Build SQL query
		StringBuilder sql = new StringBuilder("SELECT * FROM parking_lot_info ");
		List<Object> params = new ArrayList<>();
		// Execute SQL
		List<Map<String, Object>> data = executeSQL(sql.toString());
		// RowUtil.setRowNumber(data);
		// Return result
		Result result = new Result();
		result.setFlag(true);
		result.setMessage("Success");
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("total", data.size());
		resultData.put("data", data);
		result.setData(resultData);
		return result;
	}
	
	/**
	 * 车辆扫码进场记录
	 * @param yardId
	 * @param cam_id
	 * @param plate_num
	 * @param plateType
	 * @return
	 */
	public int saveVehicleScanQRcodeInRecord( String cam_id, String plate_num, String plateType) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		StringBuilder insertSql = new StringBuilder(
				" insert into vehicle_raw_inout_record (cam_id,type,plate_num,plate_color,plate_type,plate_val,confidence,car_logo,car_color,vehicle_type,utc_ts,local_time,in_out,is_whitelist,trigger_type,encrypt_verify,full_pic_path,full_pic_len,plate_pic_path,full_pic,plate_pic_len,plate_pic,create_time ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		List<Object> params = new ArrayList<>();
		//params.add(yardId);
		params.add(cam_id);
		params.add(null);
		params.add(plate_num);
		params.add(null);
		params.add(plateType);
		params.add(null);
		params.add(null);
		params.add(null);
		params.add(null);
		params.add("扫码车");
		params.add(Instant.now().getEpochSecond());
		params.add(sdf.format(new Date()));
		params.add("in");
		params.add(null);
		params.add(null);
		params.add(null);
		params.add(null);
		params.add(null);
		params.add(null);
		params.add(null);
		params.add(null);
		params.add(null);
		params.add(new Date());
		int insertRows = executeSQL(insertSql.toString(), params.toArray());
		return insertRows;
	}
	/**
	 * 保存原始过车记录
	 * @param vr
	 * @return
	 */
	public int saveVehicleRawInoutRecord(VehicleRecord vr) {
		StringBuilder insertSql = new StringBuilder(
				" insert into vehicle_raw_inout_record (cam_id,type,plate_num,plate_color,plate_type,plate_val,confidence,car_logo,car_color,vehicle_type,utc_ts,local_time,in_out,is_whitelist,trigger_type,encrypt_verify,full_pic_path,full_pic_len,plate_pic_path,full_pic,plate_pic_len,plate_pic,create_time ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		List<Object> params = new ArrayList<>();
		JSONObject json=vr.getMsgBody();
		params.add(vr.getCam_id());
		params.add(json.get("type"));
		params.add(json.get("plate_num"));
		params.add(json.get("plate_color"));
		params.add(json.get("plate_type"));
		params.add(json.get("plate_val"));
		params.add(json.get("confidence"));
		params.add(json.get("car_logo"));
		params.add(json.get("car_color"));
		params.add(json.get("vehicle_type"));
		params.add(json.get("utc_ts"));
		params.add(json.get("local_time"));
		params.add(json.get("inout"));
		params.add(json.get("is_whitelist"));
		params.add(json.get("trigger_type"));
		params.add(json.get("encrypt_verify"));
		params.add(json.get("full_pic_path"));
		params.add(json.get("full_pic_len"));
		params.add(json.get("plate_pic_path"));
		//params.add(json.get("full_pic"));
		params.add(null);
		params.add(json.get("plate_pic_len"));
		//params.add(json.get("plate_pic"));
		params.add(null);
		params.add(new Date());
		int insertRows = executeSQL(insertSql.toString(), params.toArray());
		return insertRows;
	}
}