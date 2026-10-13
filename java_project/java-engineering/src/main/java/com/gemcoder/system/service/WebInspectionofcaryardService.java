package com.gemcoder.system.service;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.gemcoder.system.bo.Result;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import static com.gemcoder.system.datasource.JdbcTemplateUtil.sdkOfPaginationQueryCount;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserId;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;

@Service
public class WebInspectionofcaryardService {

    public Result getParkingLotNames(Map<String, Object> paramMap) {
        // 构建查询SQL语句
        StringBuilder sql = new StringBuilder("SELECT id, parking_lot_name FROM parking_lot_info WHERE 1=1");
        List<Object> params = new ArrayList<>();
        // 检查paramMap中的参数并构建查询条件
        String parkingLotCode = paramMap.get("parking_lot_code") != null ? String.valueOf(paramMap.get("parking_lot_code")) : null;
        if (parkingLotCode != null && !parkingLotCode.isEmpty()) {
            sql.append(" AND parking_lot_code = ?");
            params.add(parkingLotCode);
        }
        // 执行SQL查询
        List<Map<String, Object>> result = executeSQL(sql.toString(), params.toArray());
        // 将查询结果中的id设置为组件的key值
        for (Map<String, Object> map : result) {
            map.put("key", map.get("id"));
        }
        // 返回结果
        Result response = new Result();
        response.setFlag(true);
        response.setMessage("查询成功");
        response.setData(result);
        return response;
    }

    public Result updateTableRowWithInspectionReport(Map<String, Object> paramMap) {
        // 获取当前登录用户的名称和ID
        String currentUserName = sdkOfGetCurrentUserName();
        Integer currentUserId = sdkOfGetCurrentUserId();
        // 从paramMap中获取巡检上报信息
        String inspectionNo = paramMap.get("inspectionNo1") != null ? String.valueOf(paramMap.get("inspectionNo1")) : null;
        String inspectionYard = paramMap.get("inspectionyard1") != null ? String.valueOf(paramMap.get("inspectionyard1")) : null;
        String inspectionItems = paramMap.get("inspectionitems1") != null ? String.valueOf(paramMap.get("inspectionitems1")) : null;
        String exceptionType = paramMap.get("exceptionType1") != null ? String.valueOf(paramMap.get("exceptionType1")) : null;
        Integer handlePerson = paramMap.get("handleperson") != null ? Integer.valueOf(String.valueOf(paramMap.get("handleperson"))) : null;
        String problemDescription = paramMap.get("problemDescription") != null ? String.valueOf(paramMap.get("problemDescription")) : null;
        List<String> problemPicture = paramMap.get("problempicture") != null ? (List<String>) paramMap.get("problempicture") : new ArrayList<>();
        String inspectionStatus = paramMap.get("inspectionInspectionStatus") != null ? String.valueOf(paramMap.get("inspectionInspectionStatus")) : null;
        String exceptionHandling = paramMap.get("inspectionExceptionHandling") != null ? String.valueOf(paramMap.get("inspectionExceptionHandling")) : null;
        // 更新inspection_records表中的数据
        StringBuilder updateSql = new StringBuilder("UPDATE inspection_records SET ");
        List<Object> params = new ArrayList<>();
        if (inspectionYard != null) {
            updateSql.append("inspection_site = ?, ");
            params.add(inspectionYard);
        }
        if (inspectionItems != null) {
            updateSql.append("inspection_item = ?, ");
            params.add(inspectionItems);
        }
        if (exceptionType != null) {
            updateSql.append("anomaly_type = ?, ");
            params.add(exceptionType);
        }
        if (handlePerson != null) {
            updateSql.append("handler_id = ?, ");
            params.add(handlePerson);
        }
        if (problemDescription != null) {
            updateSql.append("issue_description = ?, ");
            params.add(problemDescription);
        }
        if (!problemPicture.isEmpty()) {
            updateSql.append("issue_photo = ?, ");
            params.add(String.join(",", problemPicture));
        }
        if (inspectionStatus != null) {
            updateSql.append("inspection_status = ?, ");
            params.add(inspectionStatus);
        }
        if (exceptionHandling != null) {
            updateSql.append("anomaly_handling = ?, ");
            params.add(exceptionHandling);
        }
        // 设置更新人和更新时间
        updateSql.append("update_username = ?, update_time = NOW() WHERE inspection_number = ?");
        params.add(currentUserName);
        params.add(inspectionNo);
        // 执行更新SQL
        int updateCount = executeSQL(updateSql.toString(), params.toArray());
        // 查询更新后的数据并返回
        StringBuilder querySql = new StringBuilder("SELECT id, serial_number, inspection_number, inspection_site, inspection_date, inspection_item, inspector_id, anomaly_type, issue_photo, issue_description, inspection_status, anomaly_handling, handling_photo, handler_id, operation FROM inspection_records WHERE inspection_number = ? ORDER BY inspection_date DESC");
        List<Object> queryParams = new ArrayList<>();
        queryParams.add(inspectionNo);
        List<Map<String, Object>> updatedData = executeSQL(querySql.toString(), queryParams.toArray());
        // 返回结果
        Result result = new Result();
        result.setFlag(updateCount > 0);
        result.setMessage(updateCount > 0 ? "更新成功" : "更新失败");
        result.setData(updatedData);
        return result;
    }

    public Result addNewEntryToTable(Map<String, Object> paramMap) {
        // 获取当前登录用户信息
        String currentUserName = sdkOfGetCurrentUserName();
        Integer currentUserId = sdkOfGetCurrentUserId();
        // 从paramMap中获取表单数据
        String inspectionNo = paramMap.get("inspectionNo1") != null ? String.valueOf(paramMap.get("inspectionNo1")) : null;
        String inspectionYard = paramMap.get("inspectionyard") != null ? String.valueOf(paramMap.get("inspectionyard")) : null;
        String inspectionItems = paramMap.get("inspectionitems") != null ? String.valueOf(paramMap.get("inspectionitems")) : null;
        Integer patrolPersonnel = paramMap.get("patrolpersonnel1") != null ? Integer.valueOf(String.valueOf(paramMap.get("patrolpersonnel1"))) : null;
        Date inspectionDate = paramMap.get("inspectiondate1") != null ? Date.valueOf(String.valueOf(paramMap.get("inspectiondate1"))) : null;
        String inspectionStatus = paramMap.get("newInspectionStatus") != null ? String.valueOf(paramMap.get("newInspectionStatus")) : "未巡检";
        // 构建插入SQL
        StringBuilder insertSql = new StringBuilder("INSERT INTO inspection_records (inspection_number, inspection_site, inspection_date, inspection_item, inspector_id, inspection_status, create_username, create_time) VALUES (?, ?, ?, ?, ?, ?, ?, NOW())");
        List<Object> params = new ArrayList<>();
        params.add(inspectionNo);
        params.add(inspectionYard);
        params.add(inspectionDate);
        params.add(inspectionItems);
        params.add(patrolPersonnel);
        params.add(inspectionStatus);
        params.add(currentUserName);
        // 执行插入操作
        int insertId = executeSQL(insertSql.toString(), params.toArray());
        // 查询表格数据
        StringBuilder querySql = new StringBuilder("SELECT ir.id, ir.serial_number, ir.inspection_number, ir.inspection_site, ir.inspection_date, ir.inspection_item, u.nick_name AS patrol_personnel, ir.anomaly_type, ir.issue_photo, ir.issue_description, ir.inspection_status, ir.anomaly_handling, ir.handling_photo, ir.handler_id, ir.operation FROM inspection_records ir LEFT JOIN users u ON ir.inspector_id = u.id ORDER BY ir.inspection_date DESC");
        List<Map<String, Object>> data = executeSQL(querySql.toString());
        // 获取总条数
        int total = sdkOfPaginationQueryCount("SELECT ir.id, ir.serial_number, ir.inspection_number, ir.inspection_site, ir.inspection_date, ir.inspection_item, u.nick_name AS patrol_personnel, ir.anomaly_type, ir.issue_photo, ir.issue_description, ir.inspection_status, ir.anomaly_handling, ir.handling_photo, ir.handler_id, ir.operation FROM inspection_records ir LEFT JOIN users u ON ir.inspector_id = u.id");
        // 返回结果
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("total", total);
        resultData.put("data", data);
        return new Result(true, "新增成功", resultData);
    }

    public Result updateTableRowWithProcessingResult(Map<String, Object> paramMap) {
        // 从paramMap中获取处理结果数据
        String inspectionNo = paramMap.get("inspectionNo1") != null ? String.valueOf(paramMap.get("inspectionNo1")) : null;
        String inspectionYard = paramMap.get("inspectionyard1") != null ? String.valueOf(paramMap.get("inspectionyard1")) : null;
        String inspectionItems = paramMap.get("inspectionitems1") != null ? String.valueOf(paramMap.get("inspectionitems1")) : null;
        String handlers = paramMap.get("handlers") != null ? String.valueOf(paramMap.get("handlers")) : null;
        String processingPictures = paramMap.get("processingPictures") != null ? String.valueOf(paramMap.get("processingPictures")) : null;
        String processingDate = paramMap.get("processingDate") != null ? String.valueOf(paramMap.get("processingDate")) : null;
        String exceptionHandling = paramMap.get("handlingExceptionHandling") != null ? String.valueOf(paramMap.get("handlingExceptionHandling")) : null;
        Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
        // 更新inspection_records表中对应的行
        StringBuilder updateSql = new StringBuilder("UPDATE inspection_records SET ");
        List<Object> params = new ArrayList<>();
        if (inspectionNo != null) {
            updateSql.append("inspection_number = ?, ");
            params.add(inspectionNo);
        }
        if (inspectionYard != null) {
            updateSql.append("inspection_site = ?, ");
            params.add(inspectionYard);
        }
        if (inspectionItems != null) {
            updateSql.append("inspection_item = ?, ");
            params.add(inspectionItems);
        }
        if (handlers != null) {
            updateSql.append("handler_id = ?, ");
            // 确保handler_id是整数
            params.add(Integer.valueOf(handlers));
        }
        if (processingPictures != null) {
            updateSql.append("handling_photo = ?, ");
            params.add(processingPictures);
        }
        if (processingDate != null) {
            updateSql.append("handling_date = ?, ");
            // 转换为SQL Timestamp
            params.add(Timestamp.valueOf(processingDate));
        }
        if (exceptionHandling != null) {
            updateSql.append("anomaly_handling = ?, ");
            params.add(exceptionHandling);
        }
        // 去掉最后一个逗号
        if (updateSql.toString().endsWith(", ")) {
            updateSql.setLength(updateSql.length() - 2);
        }
        updateSql.append(" WHERE id = ?");
        params.add(id);
        // 执行更新SQL
        int updateCount = executeSQL(updateSql.toString(), params.toArray());
        // 查询更新后的数据并刷新表格
        StringBuilder querySql = new StringBuilder("SELECT id, serial_number, inspection_number, inspection_site, inspection_date, inspection_item, inspector_id, anomaly_type, issue_photo, issue_description, inspection_status, anomaly_handling, handling_photo, handler_id, operation FROM inspection_records ORDER BY inspection_date DESC");
        int total = sdkOfPaginationQueryCount(querySql.toString());
        querySql.append(" LIMIT ?, ?");
        // 使用新的参数列表进行查询
        List<Object> queryParams = new ArrayList<>();
        queryParams.add((paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1) - 1);
        queryParams.add(paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10);
        List<Map<String, Object>> data = executeSQL(querySql.toString(), queryParams.toArray());
        // 返回结果
        Result result = new Result();
        result.setFlag(updateCount > 0);
        result.setMessage(updateCount > 0 ? "更新成功" : "更新失败");
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("total", total);
        resultData.put("data", data);
        result.setData(resultData);
        return result;
    }

    public Result getUserNickNames(Map<String, Object> paramMap) {
        // 从参数中获取分页信息
        Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
        Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
        // 构建查询SQL
        StringBuilder sql = new StringBuilder("SELECT id, nick_name FROM users WHERE 1=1");
        List<Object> params = new ArrayList<>();
        // 如果有其他查询条件，可以在这里添加
        String nickName = paramMap.get("nickName") != null ? String.valueOf(paramMap.get("nickName")) : null;
        if (nickName != null && !nickName.isEmpty()) {
            sql.append(" AND nick_name LIKE ?");
            params.add("%" + nickName + "%");
        }
        // 获取总条数
        int total = sdkOfPaginationQueryCount(sql.toString(), params.toArray());
        // 添加分页
        sql.append(" LIMIT ?, ?");
        params.add((current - 1) * pageSize);
        params.add(pageSize);
        // 执行查询
        List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
        // 将查询结果中的id设置为组件的key值
        for (Map<String, Object> item : data) {
            item.put("key", item.get("id"));
        }
        // 返回结果
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("total", total);
        resultData.put("data", data);
        return new Result(true, "查询成功", resultData);
    }

    public Result getParkingLotNames_xEw(Map<String, Object> paramMap) {
        // 构建查询SQL语句
        StringBuilder sql = new StringBuilder("SELECT id, parking_lot_name FROM parking_lot_info WHERE 1=1");
        List<Object> params = new ArrayList<>();
        // 执行SQL查询
        List<Map<String, Object>> result = executeSQL(sql.toString(), params.toArray());
        // 构建返回结果
        List<Map<String, Object>> parkingLotNames = new ArrayList<>();
        for (Map<String, Object> row : result) {
            Map<String, Object> parkingLot = new HashMap<>();
            // 将id设置为key
            parkingLot.put("key", row.get("id"));
            // 将车场名称设置为label
            parkingLot.put("label", row.get("parking_lot_name"));
            parkingLotNames.add(parkingLot);
        }
        // 返回结果
        return new Result(true, "查询成功", parkingLotNames);
    }

    public Result showInspectionReportRef21(Map<String, Object> paramMap) {
        // 从参数中获取巡检编号
        String inspectionNo = paramMap.get("inspectionNo1") != null ? String.valueOf(paramMap.get("inspectionNo1")) : null;
        // 从参数中获取其他可能的查询条件
        String inspectionYard = paramMap.get("inspectionyard1") != null ? String.valueOf(paramMap.get("inspectionyard1")) : null;
        String inspectionItem = paramMap.get("inspectionitems1") != null ? String.valueOf(paramMap.get("inspectionitems1")) : null;
        String exceptionType = paramMap.get("exceptionType1") != null ? String.valueOf(paramMap.get("exceptionType1")) : null;
        String handlePerson = paramMap.get("handleperson") != null ? String.valueOf(paramMap.get("handleperson")) : null;
        // 构建查询SQL
        StringBuilder sql = new StringBuilder("SELECT ir.id, ir.inspection_number, ir.parking_lot_id, ir.inspection_item, ir.anomaly_type, ir.issue_description, ir.issue_photo, ir.handler_id, ir.inspection_status, ir.anomaly_handling, pl.parking_lot_name, u.user_name AS handler_name ");
        sql.append("FROM inspection_records ir ");
        sql.append("LEFT JOIN parking_lot_info pl ON ir.parking_lot_id = pl.id ");
        sql.append("LEFT JOIN users u ON ir.handler_id = u.id ");
        sql.append("WHERE 1=1 ");
        List<Object> params = new ArrayList<>();
        // 如果巡检编号不为空，则添加到查询条件中
        if (StrUtil.isNotBlank(inspectionNo)) {
            sql.append("AND ir.inspection_number = ? ");
            params.add(inspectionNo);
        }
        // 如果巡检车场不为空，则添加到查询条件中
        if (StrUtil.isNotBlank(inspectionYard)) {
            sql.append("AND pl.parking_lot_name = ? ");
            params.add(inspectionYard);
        }
        // 如果巡检项目不为空，则添加到查询条件中
        if (StrUtil.isNotBlank(inspectionItem)) {
            sql.append("AND ir.inspection_item = ? ");
            params.add(inspectionItem);
        }
        // 如果异常类型不为空，则添加到查询条件中
        if (StrUtil.isNotBlank(exceptionType)) {
            sql.append("AND ir.anomaly_type = ? ");
            params.add(exceptionType);
        }
        // 如果处理人不为空，则添加到查询条件中
        if (StrUtil.isNotBlank(handlePerson)) {
            sql.append("AND u.user_name = ? ");
            params.add(handlePerson);
        }
        // 执行查询
        List<Map<String, Object>> result = executeSQL(sql.toString(), params.toArray());
        // 返回结果
        if (result != null && !result.isEmpty()) {
            return new Result(true, "查询成功", result);
        } else {
            return new Result(false, "未找到相关记录", null);
        }
    }

    public Result showProcessingResultRef31(Map<String, Object> paramMap) {
        // 从参数中获取巡检编号
        String inspectionNo = paramMap.get("inspectionNo") != null ? String.valueOf(paramMap.get("inspectionNo")) : null;
        // 构建查询SQL
        StringBuilder sql = new StringBuilder("SELECT ir.id, ir.inspection_number, ir.parking_lot_id, ir.inspection_item, ir.handler_id, ir.handling_photo, ir.handling_date, ");
        sql.append("pl.parking_lot_name, u.nick_name AS handler_name ");
        sql.append("FROM inspection_records ir ");
        sql.append("LEFT JOIN parking_lot_info pl ON ir.parking_lot_id = pl.id ");
        sql.append("LEFT JOIN users u ON ir.handler_id = u.id ");
        sql.append("WHERE 1=1 ");
        List<Object> params = new ArrayList<>();
        // 如果巡检编号不为空，则添加到查询条件中
        if (inspectionNo != null && !inspectionNo.isEmpty()) {
            sql.append("AND ir.inspection_number = ? ");
            params.add(inspectionNo);
        }
        // 执行查询
        List<Map<String, Object>> result = executeSQL(sql.toString(), params.toArray());
        // 返回结果
        if (result != null && !result.isEmpty()) {
            Map<String, Object> data = result.get(0);
            return new Result(true, "查询成功", data);
        } else {
            return new Result(false, "未找到相关记录", null);
        }
    }

    public Result listenToExceptionTypeRef62(Map<String, Object> paramMap) {
        // 从参数中获取异常类型和巡检记录ID
        String exceptionType = paramMap.get("exceptionType1") != null ? String.valueOf(paramMap.get("exceptionType1")) : null;
        Integer inspectionId = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
        // 检查异常类型是否为“无异常”
        if ("无异常".equals(exceptionType) && inspectionId != null) {
            // 更新巡检状态为“无异常”
            StringBuilder updateSql = new StringBuilder("UPDATE inspection_records SET inspection_status = ? WHERE id = ?");
            List<Object> params = new ArrayList<>();
            params.add("无异常");
            params.add(inspectionId);
            // 执行更新SQL
            int updateRows = executeSQL(updateSql.toString(), params.toArray());
            // 返回结果
            if (updateRows > 0) {
                return new Result(true, "巡检状态更新成功", null);
            } else {
                return new Result(false, "巡检状态更新失败", null);
            }
        } else {
            return new Result(false, "异常类型不是“无异常”或巡检记录ID无效", null);
        }
    }

    public Result listenToExceptionTypeRef63(Map<String, Object> paramMap) {
        // 从参数中获取异常类型
        String exceptionType = paramMap.get("exceptionType1") != null ? String.valueOf(paramMap.get("exceptionType1")) : null;
        Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
        // 检查异常类型是否为“无异常”
        if ("无异常".equals(exceptionType) && id != null) {
            // 构建SQL语句，将异常处理字段更新为空值
            StringBuilder sql = new StringBuilder("UPDATE inspection_records SET anomaly_handling = ? WHERE id = ?");
            List<Object> params = new ArrayList<>();
            // 设置异常处理为空值
            params.add(null);
            params.add(id);
            // 执行SQL更新操作
            int updateRows = executeSQL(sql.toString(), params.toArray());
            // 返回结果
            if (updateRows > 0) {
                return new Result(true, "更新成功", null);
            } else {
                return new Result(false, "更新失败", null);
            }
        } else {
            return new Result(false, "异常类型不是“无异常”或ID无效", null);
        }
    }

    public Result generalQueryInspectionTableData(Map<String, Object> paramMap) {
        // 获取分页参数
        Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
        Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
        // 获取查询条件
        String inspectionNo = paramMap.get("inspectionNo") != null ? String.valueOf(paramMap.get("inspectionNo")) : null;
        String patrolPersonnel = paramMap.get("patrolPersonnel") != null ? String.valueOf(paramMap.get("patrolPersonnel")) : null;
        String inspectionStatus = paramMap.get("inspectionStatus") != null ? String.valueOf(paramMap.get("inspectionStatus")) : null;
        String inspectionYard = paramMap.get("inspectionYard") != null ? String.valueOf(paramMap.get("inspectionYard")) : null;
        String exceptionType = paramMap.get("exceptionType") != null ? String.valueOf(paramMap.get("exceptionType")) : null;
        String exceptionHandling = paramMap.get("exceptionHandling") != null ? String.valueOf(paramMap.get("exceptionHandling")) : null;
        String inspectionItems = paramMap.get("inspectionItems") != null ? String.valueOf(paramMap.get("inspectionItems")) : null;
        // 构建查询SQL
        StringBuilder sql = new StringBuilder("SELECT ir.id, ir.inspection_number, ir.parking_lot_id, ir.inspection_date, ir.inspection_item, ir.inspector_id, ir.anomaly_type, ir.issue_description, ir.inspection_status, ir.anomaly_handling, ir.handler_id, ir.handling_date, pl.parking_lot_name, u.nick_name AS inspector_name, uh.nick_name AS handler_name FROM inspection_records ir LEFT JOIN parking_lot_info pl ON ir.parking_lot_id = pl.id LEFT JOIN users u ON ir.inspector_id = u.id LEFT JOIN users uh ON ir.handler_id = uh.id WHERE 1=1");
        List<Object> params = new ArrayList<>();
        // 添加查询条件
        if (inspectionNo != null && !inspectionNo.isEmpty()) {
            sql.append(" AND ir.inspection_number LIKE ?");
            params.add("%" + inspectionNo + "%");
        }
        if (patrolPersonnel != null && !patrolPersonnel.isEmpty()) {
            sql.append(" AND u.nick_name LIKE ?");
            params.add("%" + patrolPersonnel + "%");
        }
        if (inspectionStatus != null && !inspectionStatus.isEmpty()) {
            sql.append(" AND ir.inspection_status = ?");
            params.add(inspectionStatus);
        }
        if (inspectionYard != null && !inspectionYard.isEmpty()) {
            sql.append(" AND pl.parking_lot_name = ?");
            params.add(inspectionYard);
        }
        if (exceptionType != null && !exceptionType.isEmpty()) {
            sql.append(" AND ir.anomaly_type = ?");
            params.add(exceptionType);
        }
        if (exceptionHandling != null && !exceptionHandling.isEmpty()) {
            sql.append(" AND ir.anomaly_handling = ?");
            params.add(exceptionHandling);
        }
        if (inspectionItems != null && !inspectionItems.isEmpty()) {
            sql.append(" AND ir.inspection_item = ?");
            params.add(inspectionItems);
        }
        // 按照巡检时间倒序排序
        sql.append(" ORDER BY ir.inspection_date DESC");
        // 查询总条数
        int total = sdkOfPaginationQueryCount(sql.toString(), params.toArray());
        // 添加分页
        sql.append(" LIMIT ?, ?");
        List<Object> paginationParams = new ArrayList<>(params);
        paginationParams.add((current - 1) * pageSize);
        paginationParams.add(pageSize);
        // 执行查询
        List<Map<String, Object>> data = executeSQL(sql.toString(), paginationParams.toArray());
        // 返回结果
        Result result = new Result();
        result.setFlag(true);
        result.setMessage("查询成功");
        result.setData(MapUtil.builder().put("current", current).put("pageSize", pageSize).put("total", total).put("data", data).build());
        return result;
    }
}
