package com.gemcoder.system.service;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.util.RowUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserId;
import com.gemcoder.system.bo.Result;
import static com.gemcoder.system.service.permission.PermissionSdkService.sdkOfgetAllPermissions;
import static com.gemcoder.system.service.permission.PermissionSdkService.sdkOfgetAllMenus;
import java.sql.SQLException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import cn.hutool.core.util.StrUtil;

@Service
public class AppusermanagementService {

    public Result exportParkingUsers(Map<String, Object> paramMap) {
        List<Map<String, Object>> data;
        StringBuilder sql = new StringBuilder("SELECT id, user_code, name, contact, main_license_plate, secondary_license_plate, DATE_FORMAT(created_at, '%Y-%m-%d %H:%i:%s') AS created_at, status FROM parking_lot_user WHERE 1=1");
        List<Object> params = new ArrayList<>();
        // Check if there are selected rows
        List<Integer> selectedIds = (List<Integer>) paramMap.get("selectedIds");
        if (selectedIds != null && !selectedIds.isEmpty()) {
            sql.append(" AND id IN (");
            for (int i = 0; i < selectedIds.size(); i++) {
                sql.append("?");
                if (i < selectedIds.size() - 1) {
                    sql.append(",");
                }
                params.add(selectedIds.get(i));
            }
            sql.append(")");
        } else {
            // If no rows are selected, export current page data
            Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
            Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
            sql.append(" ORDER BY created_at DESC LIMIT ?, ?");
            params.add((current - 1) * pageSize);
            params.add(pageSize);
        }
        data = executeSQL(sql.toString(), params.toArray());
        //设置行号
        RowUtil.setRowNumber(data,null,null);
        // Export logic here, e.g., generate .xlsx file with data
        return new Result(true, "Export successful", data);
    }

    public Result deactivateParkingUsers(Map<String, Object> paramMap) {
        List<Integer> selectedIds = (List<Integer>) paramMap.get("selectedIds");
        if (selectedIds == null || selectedIds.isEmpty()) {
            return new Result(false, "Please select at least one row", null);
        }
        StringBuilder sql = new StringBuilder("UPDATE parking_lot_user SET status = '停用' WHERE id IN (");
        List<Object> params = new ArrayList<>();
        for (int i = 0; i < selectedIds.size(); i++) {
            sql.append("?");
            if (i < selectedIds.size() - 1) {
                sql.append(",");
            }
            params.add(selectedIds.get(i));
        }
        sql.append(")");
        int updatedRows = executeSQL(sql.toString(), params.toArray());
        // Refresh data logic here
        return new Result(true, "Deactivation successful", updatedRows);
    }

    public Result getParkingUsers(Map<String, Object> paramMap) {
        StringBuilder sql = new StringBuilder("SELECT id, user_code, name, contact, main_license_plate, secondary_license_plate, DATE_FORMAT(created_at, '%Y-%m-%d %H:%i:%s') AS created_at, status FROM parking_lot_user ORDER BY id DESC, created_at DESC LIMIT ?, ?");
        List<Object> params = new ArrayList<>();
        Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
        Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
        params.add((current - 1) * pageSize);
        params.add(pageSize);
        List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
        // Get total count
        String countSql = "SELECT COUNT(*) AS total FROM parking_lot_user";
        List<Map<String, Object>> countResult = executeSQL(countSql);
        int total = Integer.valueOf(String.valueOf(countResult.get(0).get("total")));
        Map<String, Object> resultData = new HashMap<>();
        RowUtil.setRowNumber(data,pageSize,current);
        resultData.put("data", data);
        resultData.put("total", total);
        return new Result(true, "Query successful", resultData);
    }

    public Result searchParkingUsers(Map<String, Object> paramMap) {
        StringBuilder sql = new StringBuilder("SELECT id, user_code, name, contact, main_license_plate, secondary_license_plate, DATE_FORMAT(created_at, '%Y-%m-%d %H:%i:%s') AS created_at, status FROM parking_lot_user WHERE 1=1");
        List<Object> params = new ArrayList<>();
        String name = paramMap.get("name") != null ? String.valueOf(paramMap.get("name")) : null;
        String identityCard = paramMap.get("identityCard") != null ? String.valueOf(paramMap.get("identityCard")) : null;
        String contact = paramMap.get("contact") != null ? String.valueOf(paramMap.get("contact")) : null;
        String mainLicensePlate = paramMap.get("mainLicensePlate") != null ? String.valueOf(paramMap.get("mainLicensePlate")) : null;
        String secondaryLicensePlate = paramMap.get("secondaryLicensePlate") != null ? String.valueOf(paramMap.get("secondaryLicensePlate")) : null;
        String status = paramMap.get("status") != null ? String.valueOf(paramMap.get("status")) : null;
        List<String> creationTime = paramMap.get("creationTime") != null ? (List<String>) paramMap.get("creationTime") : null;
        if (name != null && !name.isEmpty()) {
            sql.append(" AND name LIKE ?");
            params.add("%" + name + "%");
        }
        if (identityCard != null && !identityCard.isEmpty()) {
            sql.append(" AND identity_card LIKE ?");
            params.add("%" + identityCard + "%");
        }
        if (contact != null && !contact.isEmpty()) {
            sql.append(" AND contact LIKE ?");
            params.add("%" + contact + "%");
        }
        if (mainLicensePlate != null && !mainLicensePlate.isEmpty()) {
            sql.append(" AND main_license_plate LIKE ?");
            params.add("%" + mainLicensePlate + "%");
        }
        if (secondaryLicensePlate != null && !secondaryLicensePlate.isEmpty()) {
            sql.append(" AND secondary_license_plate LIKE ?");
            params.add("%" + secondaryLicensePlate + "%");
        }
        if (status != null && !status.isEmpty()) {
            sql.append(" AND status = ?");
            params.add(status);
        }
        if (creationTime != null && creationTime.size()>1) {
            sql.append(" AND created_at BETWEEN ? AND ?");
            params.add(creationTime.get(0));
            params.add(creationTime.get(1));
        }
        sql.append(" ORDER BY id DESC, created_at DESC LIMIT ?, ?");
        Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
        Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
        params.add((current - 1) * pageSize);
        params.add(pageSize);
        List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
        // Get total count
        List<Object> countParams = new ArrayList<>();
        StringBuilder countSql = new StringBuilder("SELECT COUNT(*) AS total FROM parking_lot_user WHERE 1=1");
        if (name != null && !name.isEmpty()) {
            countSql.append(" AND name LIKE ?");
            countParams.add("%" + name + "%");
        }
        if (identityCard != null && !identityCard.isEmpty()) {
            countSql.append(" AND identity_card LIKE ?");
            countParams.add("%" + identityCard + "%");
        }
        if (contact != null && !contact.isEmpty()) {
            countSql.append(" AND contact LIKE ?");
            countParams.add("%" + contact + "%");
        }
        if (mainLicensePlate != null && !mainLicensePlate.isEmpty()) {
            countSql.append(" AND main_license_plate LIKE ?");
            countParams.add("%" + mainLicensePlate + "%");
        }
        if (secondaryLicensePlate != null && !secondaryLicensePlate.isEmpty()) {
            countSql.append(" AND secondary_license_plate LIKE ?");
            countParams.add("%" + secondaryLicensePlate + "%");
        }
        if (status != null && !status.isEmpty()) {
            countSql.append(" AND status = ?");
            countParams.add(status);
        }
        if (creationTime != null && creationTime.size()>1) {
            countSql.append(" AND created_at BETWEEN ? AND ?");
            countParams.add(creationTime.get(0));
            countParams.add(creationTime.get(1));
        }
        List<Map<String, Object>> countResult = executeSQL(countSql.toString(), countParams.toArray());
        int total = Integer.valueOf(String.valueOf(countResult.get(0).get("total")));
        Map<String, Object> resultData = new HashMap<>();
        //设置行号
        RowUtil.setRowNumber(data,pageSize,current);
        resultData.put("data", data);
        resultData.put("total", total);
        return new Result(true, "Search successful", resultData);
    }

    public Result enableParkingUsers(Map<String, Object> paramMap) {
        List<Integer> selectedIds = (List<Integer>) paramMap.get("selectedIds");
        if (selectedIds == null || selectedIds.isEmpty()) {
            return new Result(false, "Please select at least one row", null);
        }
        StringBuilder sql = new StringBuilder("UPDATE parking_lot_user SET status = '启用' WHERE id IN (");
        List<Object> params = new ArrayList<>();
        for (int i = 0; i < selectedIds.size(); i++) {
            sql.append("?");
            if (i < selectedIds.size() - 1) {
                sql.append(",");
            }
            params.add(selectedIds.get(i));
        }
        sql.append(")");
        int updatedRows = executeSQL(sql.toString(), params.toArray());
        // Refresh data logic here
        return new Result(true, "Enable successful", updatedRows);
    }

    public Result getParkingOrderDetails(Map<String, Object> paramMap) {
        // 获取当前页码和每页大小
        Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
        Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
        // 获取车牌号（主）和车牌号（副）
        String mainLicensePlate = paramMap.get("mainLicensePlate") != null ? String.valueOf(paramMap.get("mainLicensePlate")) : null;
        String secondaryLicensePlate = paramMap.get("secondaryLicensePlate") != null ? String.valueOf(paramMap.get("secondaryLicensePlate")) : null;
        // 构建查询SQL
        StringBuilder sql = new StringBuilder("SELECT id, order_code, license_plate, parking_lot, order_status, payment_status, entry_time, exit_time, parking_duration, order_amount, discount_amount, receivable_amount, received_amount, refund_amount, payment_channel, discount_channel, cashier FROM user_order WHERE 1=1");
        List<Object> params = new ArrayList<>();
        // 根据车牌号（主）和车牌号（副）进行查询
		/*
		 * if (mainLicensePlate != null && !mainLicensePlate.isEmpty()) {
		 * sql.append(" AND license_plate = ?"); params.add(mainLicensePlate); } else if
		 * (secondaryLicensePlate != null && !secondaryLicensePlate.isEmpty()) {
		 * sql.append(" AND license_plate = ?"); params.add(secondaryLicensePlate); }
		 */
        if (!StringUtils.isEmpty(mainLicensePlate)  &&StringUtils.isEmpty(secondaryLicensePlate)) {
        	sql.append(" AND license_plate = ?");
        	params.add(mainLicensePlate);
        } else if (StringUtils.isEmpty(mainLicensePlate)  &&!StringUtils.isEmpty(secondaryLicensePlate)) {
        	sql.append(" and license_plate = ?");
        	params.add(secondaryLicensePlate);
        }else if(!StringUtils.isEmpty(mainLicensePlate)  &&!StringUtils.isEmpty(secondaryLicensePlate)) {
        	sql.append(" AND (license_plate = ?");
        	params.add(mainLicensePlate);
             sql.append(" or license_plate = ?)");
             params.add(secondaryLicensePlate);
        }
        
        
        // 按创建时间倒序排序
        sql.append(" ORDER BY create_time DESC");
        // 分页查询
        int offset = (current - 1) * pageSize;
        sql.append(" LIMIT ?, ?");
        params.add(offset);
        params.add(pageSize);
        // 执行查询SQL
        List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
        // 查询总条数
        StringBuilder countSql = new StringBuilder("SELECT COUNT(*) FROM user_order WHERE 1=1");
        List<Object> countParams = new ArrayList<>();
        if (!StringUtils.isEmpty(mainLicensePlate)  &&StringUtils.isEmpty(secondaryLicensePlate)) {
            countSql.append(" AND license_plate = ?");
            countParams.add(mainLicensePlate);
        } else if (StringUtils.isEmpty(mainLicensePlate)  &&!StringUtils.isEmpty(secondaryLicensePlate)) {
            countSql.append(" and license_plate = ?");
            countParams.add(secondaryLicensePlate);
        }else if(!StringUtils.isEmpty(mainLicensePlate)  &&!StringUtils.isEmpty(secondaryLicensePlate)) {
        	 countSql.append(" AND (license_plate = ?");
             countParams.add(mainLicensePlate);
             countSql.append(" or license_plate = ?)");
             countParams.add(secondaryLicensePlate);
        }
        List<Map<String, Object>> countResult = executeSQL(countSql.toString(), countParams.toArray());
        int total = countResult.isEmpty() ? 0 : Integer.valueOf(String.valueOf(countResult.get(0).get("COUNT(*)")));
        // 返回结果
        Map<String, Object> resultData = new HashMap<>();
        //设置行号
        RowUtil.setRowNumber(data,pageSize,current);
        resultData.put("total", total);
        resultData.put("data", data);
        return new Result(true, "查询成功", resultData);
    }

    public Result enableParkingUser(Map<String, Object> paramMap) {
        // 获取用户ID
        Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
        // 检查ID是否为空
        if (id == null) {
            return new Result(false, "用户ID不能为空", null);
        }
        // 更新用户状态为启用
        StringBuilder sql = new StringBuilder("UPDATE parking_lot_user SET status = '启用' WHERE id = ?");
        int updateRows = executeSQL(sql.toString(), id);
        // 检查更新结果
        if (updateRows > 0) {
            return new Result(true, "用户状态已更新为启用", null);
        } else {
            return new Result(false, "更新失败，用户可能不存在", null);
        }
    }

    public Result deactivateParkingUser(Map<String, Object> paramMap) {
        // 获取用户ID
        Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
        // 检查ID是否为空
        if (id == null) {
            return new Result(false, "用户ID不能为空", null);
        }
        // 更新用户状态为停用
        StringBuilder sql = new StringBuilder("UPDATE parking_lot_user SET status = '停用' WHERE id = ?");
        int updateRows = executeSQL(sql.toString(), id);
        // 检查更新结果
        if (updateRows > 0) {
            return new Result(true, "用户已停用", null);
        } else {
            return new Result(false, "用户停用失败", null);
        }
    }

    public Result getParkingUsersE6W(Map<String, Object> paramMap) {
        // 获取分页参数
        Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
        Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
        // 计算分页起始位置
        int offset = (current - 1) * pageSize;
        // 查询用户信息
        StringBuilder sql = new StringBuilder("SELECT id, user_name, nick_name, email, mobile, phone, status FROM users WHERE status = 0 LIMIT ?, ?");
        List<Object> params = new ArrayList<>();
        params.add(offset);
        params.add(pageSize);
        List<Map<String, Object>> users = executeSQL(sql.toString(), params.toArray());
        // 查询总条数
        StringBuilder countSql = new StringBuilder("SELECT COUNT(*) AS total FROM users WHERE status = 0");
        List<Map<String, Object>> countResult = executeSQL(countSql.toString());
        int total = countResult.get(0).get("total") != null ? Integer.valueOf(String.valueOf(countResult.get(0).get("total"))) : 0;
        // 返回结果
        Map<String, Object> resultData = new HashMap<>();
        RowUtil.setRowNumber(users,pageSize,current);
        resultData.put("total", total);
        resultData.put("data", users);
        return new Result(true, "查询成功", resultData);
    }
}
