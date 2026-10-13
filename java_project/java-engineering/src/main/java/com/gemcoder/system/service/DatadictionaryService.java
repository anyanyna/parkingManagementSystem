package com.gemcoder.system.service;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserId;
import com.gemcoder.system.bo.Result;
import static com.gemcoder.system.service.permission.PermissionSdkService.sdkOfgetAllPermissions;
import static com.gemcoder.system.service.permission.PermissionSdkService.sdkOfgetAllMenus;
import java.sql.SQLException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class DatadictionaryService {

    public Result getDictionaryDetails(Map<String, Object> paramMap) {
        Integer businessDictionaryId = paramMap.get("businessDictionaryId") != null ? Integer.valueOf(String.valueOf(paramMap.get("businessDictionaryId"))) : null;
        Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
        Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
        int offset = (current - 1) * pageSize;
        StringBuilder sql = new StringBuilder("SELECT id, `order`, `key`, `name`, `operation` FROM dictionary_detail WHERE business_dictionary_id = ? ORDER BY `order` LIMIT ?, ?");
        List<Object> params = new ArrayList<>();
        params.add(businessDictionaryId);
        params.add(offset);
        params.add(pageSize);
        List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
        String countSql = "SELECT COUNT(*) as total FROM dictionary_detail WHERE business_dictionary_id = ?";
        List<Map<String, Object>> countResult = executeSQL(countSql, businessDictionaryId);
        int total = countResult.get(0).get("total") != null ? Integer.valueOf(String.valueOf(countResult.get(0).get("total"))) : 0;
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("data", data);
        resultData.put("total", total);
        return new Result(true, "Success", resultData);
    }

    public Result searchBusinessDictionaries(Map<String, Object> paramMap) {
        String keyValue = paramMap.get("keyValue") != null ? String.valueOf(paramMap.get("keyValue")) : null;
        Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
        Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
        int offset = (current - 1) * pageSize;
        StringBuilder sql = new StringBuilder("SELECT id, `order`, `key`, `name`, `operation` FROM business_dictionary WHERE 1=1");
        List<Object> params = new ArrayList<>();
        if (keyValue != null && !keyValue.isEmpty()) {
            sql.append(" AND `key` LIKE ?");
            params.add("%" + keyValue + "%");
            sql.append(" OR `name` LIKE ?");
            params.add("%" + keyValue + "%");
        }
        sql.append(" ORDER BY `order` asc, id desc  LIMIT ?, ?");
        params.add(offset);
        params.add(pageSize);
        List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
        StringBuilder countSql = new StringBuilder("SELECT COUNT(*) as total FROM business_dictionary WHERE 1=1");
        List<Object> countParams = new ArrayList<>();
        if (keyValue != null && !keyValue.isEmpty()) {
            countSql.append(" AND `key` LIKE ?");
            countParams.add("%" + keyValue + "%");
            countSql.append(" OR `name` LIKE ?");
            countParams.add("%" + keyValue + "%");
        }
        List<Map<String, Object>> countResult = executeSQL(countSql.toString(), countParams.toArray());
        int total = countResult.get(0).get("total") != null ? Integer.valueOf(String.valueOf(countResult.get(0).get("total"))) : 0;
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("data", data);
        resultData.put("total", total);
        return new Result(true, "Success", resultData);
    }

    public Result saveBusinessDictionary(Map<String, Object> paramMap) {
        String keyValue = paramMap.get("keyValue") != null ? String.valueOf(paramMap.get("keyValue")) : null;
        String name = paramMap.get("name") != null ? String.valueOf(paramMap.get("name")) : null;
        Integer order = paramMap.get("orderNumber") != null ? Integer.valueOf(String.valueOf(paramMap.get("orderNumber"))) : null;
        String createUsername = sdkOfGetCurrentUserName();
        StringBuilder sql = new StringBuilder("INSERT INTO business_dictionary (`key`, `name`, `order`, create_username, create_time) VALUES (?, ?, ?, ?, NOW())");
        List<Object> params = new ArrayList<>();
        params.add(keyValue);
        params.add(name);
        params.add(order);
        params.add(createUsername);
        int rows = executeSQL(sql.toString(), params.toArray());
        return new Result(rows > 0, rows > 0 ? "Insert successful" : "Insert failed", null);
    }

    public Result saveDictionaryDetail(Map<String, Object> paramMap) {
        Integer businessDictionaryId = paramMap.get("businessDictionaryId") != null ? Integer.valueOf(String.valueOf(paramMap.get("businessDictionaryId"))) : null;
        String keyValue = paramMap.get("keyValue") != null ? String.valueOf(paramMap.get("keyValue")) : null;
        String name = paramMap.get("name") != null ? String.valueOf(paramMap.get("name")) : null;
        Integer order = paramMap.get("order") != null ? Integer.valueOf(String.valueOf(paramMap.get("order"))) : null;
        String createUsername = sdkOfGetCurrentUserName();
        StringBuilder sql = new StringBuilder("INSERT INTO dictionary_detail (business_dictionary_id, `key`, `name`, `order`, create_username, create_time) VALUES (?, ?, ?, ?, ?, NOW())");
        List<Object> params = new ArrayList<>();
        params.add(businessDictionaryId);
        params.add(keyValue);
        params.add(name);
        params.add(order);
        params.add(createUsername);
        int rows = executeSQL(sql.toString(), params.toArray());
        return new Result(rows > 0, rows > 0 ? "Insert successful" : "Insert failed", null);
    }

    public Result updateBusinessDictionary(Map<String, Object> paramMap) {
        Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
        String keyValue = paramMap.get("keyValue") != null ? String.valueOf(paramMap.get("keyValue")) : null;
        String name = paramMap.get("name") != null ? String.valueOf(paramMap.get("name")) : null;
        Integer order = paramMap.get("orderNumber") != null ? Integer.valueOf(String.valueOf(paramMap.get("orderNumber"))) : null;
        String updateUsername = sdkOfGetCurrentUserName();
        StringBuilder sql = new StringBuilder("UPDATE business_dictionary SET `key` = ?, `name` = ?, `order` = ?, update_username = ?, update_time = NOW() WHERE id = ?");
        List<Object> params = new ArrayList<>();
        params.add(keyValue);
        params.add(name);
        params.add(order);
        params.add(updateUsername);
        params.add(id);
        int rows = executeSQL(sql.toString(), params.toArray());
        return new Result(rows > 0, rows > 0 ? "Update successful" : "Update failed", null);
    }

    public Result updateDictionaryDetail(Map<String, Object> paramMap) {
        Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
        String keyValue = paramMap.get("keyValue") != null ? String.valueOf(paramMap.get("keyValue")) : null;
        String name = paramMap.get("name") != null ? String.valueOf(paramMap.get("name")) : null;
        Integer order = paramMap.get("order") != null ? Integer.valueOf(String.valueOf(paramMap.get("order"))) : null;
        String updateUsername = sdkOfGetCurrentUserName();
        StringBuilder sql = new StringBuilder("UPDATE dictionary_detail SET `key` = ?, `name` = ?, `order` = ?, update_username = ?, update_time = NOW() WHERE id = ?");
        List<Object> params = new ArrayList<>();
        params.add(keyValue);
        params.add(name);
        params.add(order);
        params.add(updateUsername);
        params.add(id);
        int rows = executeSQL(sql.toString(), params.toArray());
        return new Result(rows > 0, rows > 0 ? "Update successful" : "Update failed", null);
    }

    public Result deleteBusinessDictionary(Map<String, Object> paramMap) {
        Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
        StringBuilder sql = new StringBuilder("DELETE FROM business_dictionary WHERE id = ?");
        int rows = executeSQL(sql.toString(), id);
        return new Result(rows > 0, rows > 0 ? "Delete successful" : "Delete failed", null);
    }

    public Result deleteDictionaryDetail(Map<String, Object> paramMap) {
        Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
        StringBuilder sql = new StringBuilder("DELETE FROM dictionary_detail WHERE id = ?");
        int rows = executeSQL(sql.toString(), id);
        return new Result(rows > 0, rows > 0 ? "Delete successful" : "Delete failed", null);
    }

    public Result showEditModalWithData(Map<String, Object> paramMap) {
        // Extract the ID from the paramMap
        Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
        // Initialize the result object
        Result result = new Result();
        // Check if the ID is provided
        if (id == null) {
            result.setFlag(false);
            result.setMessage("ID is required to fetch the data.");
            return result;
        }
        // Prepare the SQL query to fetch the data for the given ID
        StringBuilder sql = new StringBuilder("SELECT id, `order`, `key`, `name`, operation FROM business_dictionary WHERE id = ?");
        List<Object> params = new ArrayList<>();
        params.add(id);
        // Execute the SQL query
        List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
        // Check if data is found
        if (data.isEmpty()) {
            result.setFlag(false);
            result.setMessage("No data found for the given ID.");
        } else {
            // Set the result data
            result.setFlag(true);
            // Assuming only one record is fetched
            result.setData(data.get(0));
        }
        return result;
    }

    public Result showEditModalWithDataForDetail(Map<String, Object> paramMap) {
        // 从参数中获取当前行的ID
        Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
        // 检查ID是否为空
        if (id == null) {
            return new Result(false, "ID不能为空", null);
        }
        // 构建查询SQL语句
        StringBuilder sql = new StringBuilder("SELECT id, `order`, `key`, `name`, operation FROM dictionary_detail WHERE id = ?");
        List<Object> params = new ArrayList<>();
        params.add(id);
        // 执行SQL查询
        List<Map<String, Object>> result = executeSQL(sql.toString(), params.toArray());
        // 检查查询结果
        if (result.isEmpty()) {
            return new Result(false, "未找到对应的数据", null);
        }
        // 返回查询结果
        return new Result(true, "查询成功", result.get(0));
    }
}
