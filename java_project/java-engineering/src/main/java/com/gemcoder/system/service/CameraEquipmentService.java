package com.gemcoder.system.service;

import org.springframework.stereotype.Service;
import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserId;
import com.gemcoder.system.bo.Result;
import static com.gemcoder.system.service.permission.PermissionSdkService.sdkOfgetAllPermissions;
import static com.gemcoder.system.service.permission.PermissionSdkService.sdkOfgetAllMenus;
import java.sql.SQLException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import cn.hutool.core.util.RandomUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 监控摄像头设备管理
 * 
 * @author jiang
 *
 */
@Service
public class CameraEquipmentService {
	public int insertCameraEquipment(Map<String, Object> paramMap) {
		return 0;
	}

	public int updateCameraEquipment(Map<String, Object> paramMap) {
		return 0;
	}

	public int deleteCameraEquipment(Map<String, Object> paramMap) {
		Object id = paramMap.get("id");
		return executeSQL("delete from camera_equipment where id=" + id);
	}

	public Result getCameraEquipmentList(Map<String, Object> paramMap) {
		Integer parking_lot_info_id = paramMap.get("parking_lot_info_id") != null
				? Integer.valueOf(String.valueOf(paramMap.get("parking_lot_info_id")))
				: null;
		Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current")))
				: 1;
		Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize")))
				: 10;
		int offset = (current - 1) * pageSize;
		StringBuilder sql = new StringBuilder(
				"SELECT * FROM camera_equipment WHERE parking_lot_info_id = ?  LIMIT ?, ?");
		List<Object> params = new ArrayList<>();
		params.add(parking_lot_info_id);
		params.add(offset);
		params.add(pageSize);
		List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
		String countSql = "SELECT COUNT(*) as total FROM camera_equipment WHERE parking_lot_info_id = ?";
		List<Map<String, Object>> countResult = executeSQL(countSql, parking_lot_info_id);
		int total = countResult.get(0).get("total") != null
				? Integer.valueOf(String.valueOf(countResult.get(0).get("total")))
				: 0;
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("data", data);
		resultData.put("total", total);
		return new Result(true, "Success", resultData);
	}

	public Result getAllCameraEquipment() {
		List<Map<String, Object>> data = executeSQL("select * from camera_equipment");
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("data", data);
		resultData.put("total", data.size());
		return new Result(true, "Success", resultData);
	}

	public Result getAllInuseCameraEquipment() {
		List<Map<String, Object>> data = executeSQL("select * from camera_equipment where status!='离线'");
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("data", data);
		resultData.put("total", data.size());
		return new Result(true, "Success", resultData);
	}

}
