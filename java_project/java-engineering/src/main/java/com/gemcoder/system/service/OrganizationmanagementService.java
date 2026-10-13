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
import cn.hutool.core.util.StrUtil;

@Service
public class OrganizationmanagementService {

    public Result getOrganizations(Map<String, Object> paramMap) {
        // Initialize the result object
        Result result = new Result();
        try {
            // Construct SQL to fetch all organizations
            StringBuilder sql = new StringBuilder("SELECT id, name, parent_id FROM organization order by sort_order asc");
            // Execute the SQL query
            List<Map<String, Object>> organizations = executeSQL(sql.toString());
            // Prepare the data to be returned
            List<Map<String, Object>> organizationTree = new ArrayList<>();
            // Convert the result into a tree structure
            for (Map<String, Object> org : organizations) {
                Map<String, Object> treeNode = new HashMap<>();
                treeNode.put("key", org.get("id"));
                treeNode.put("label", org.get("name"));
                treeNode.put("parent_id", org.get("parent_id"));
                organizationTree.add(treeNode);
            }
            // Set the result data
            result.setFlag(true);
            result.setMessage("查询成功");
            result.setData(organizationTree);
        } catch (Exception e) {
            // Handle any exceptions
            result.setFlag(false);
            result.setMessage("查询失败: " + e.getMessage());
        }
        return result;
    }

    public Result getSystemUsers(Map<String, Object> paramMap) {
        // 构建查询SQL语句，获取所有系统用户的id和昵称
        StringBuilder sql = new StringBuilder("SELECT id, nick_name FROM users WHERE status = 0");
        List<Object> params = new ArrayList<>();
        // 执行SQL查询
        List<Map<String, Object>> result = executeSQL(sql.toString(), params.toArray());
        // 构建返回结果
        Result response = new Result();
        response.setFlag(true);
        response.setMessage("查询成功");
        response.setData(result);
        return response;
    }

    public Result addOrganization(Map<String, Object> paramMap) {
        // Extract parameters from paramMap
        Integer parentOrganizationId = paramMap.get("Parentorganizationvalue1") != null ? Integer.valueOf(String.valueOf(paramMap.get("Parentorganizationvalue1"))) : null;
        String organizationName = paramMap.get("OrganizationNamevalue1") != null ? String.valueOf(paramMap.get("OrganizationNamevalue1")) : null;
        Integer personInChargeId = paramMap.get("Personinchargeoforganizationvalue1") != null ? Integer.valueOf(String.valueOf(paramMap.get("Personinchargeoforganizationvalue1"))) : null;
        Integer sortOrder = paramMap.get("Sortvalue1") != null ? Integer.valueOf(String.valueOf(paramMap.get("Sortvalue1"))) : null;
        String remark = paramMap.get("Remarkvalue1") != null ? String.valueOf(paramMap.get("Remarkvalue1")) : null;
        // Get current user information
        String createUsername = sdkOfGetCurrentUserName();
        // Build SQL for inserting a new organization
        StringBuilder insertSql = new StringBuilder("INSERT INTO organization (name, parent_id, leader_id, sort_order, remarks, create_username, create_time) VALUES (?, ?, ?, ?, ?, ?, NOW())");
        List<Object> params = new ArrayList<>();
        params.add(organizationName);
        params.add(parentOrganizationId);
        params.add(personInChargeId);
        params.add(sortOrder);
        params.add(remark);
        params.add(createUsername);
        // Execute SQL
        int insertRows = executeSQL(insertSql.toString(), params.toArray());
        // Check if the insertion was successful
        if (insertRows > 0) {
            // Refresh organization data
            // Assuming there's a method to refresh the organization tree, which is not detailed in the provided context
            return new Result(true, "新增成功", null);
        } else {
            return new Result(false, "新增失败", null);
        }
    }

    public Result getOrganizationsCG6(Map<String, Object> paramMap) {
        // Extract pagination parameters
        Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
        Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
        // Build SQL for counting total organizations
        StringBuilder countSql = new StringBuilder("SELECT COUNT(*) AS total FROM organization WHERE 1=1");
        List<Object> countParams = new ArrayList<>();
        // Execute count SQL
        List<Map<String, Object>> countResult = executeSQL(countSql.toString(), countParams.toArray());
        int total = countResult.isEmpty() ? 0 : Integer.valueOf(String.valueOf(countResult.get(0).get("total")));
        // Build SQL for fetching organizations with pagination
        StringBuilder selectSql = new StringBuilder("SELECT id, name, parent_id, leader_id, sort_order, remarks FROM organization WHERE 1=1");
        List<Object> selectParams = new ArrayList<>();
        selectSql.append(" LIMIT ?, ?");
        selectParams.add((current - 1) * pageSize);
        selectParams.add(pageSize);
        // Execute select SQL
        List<Map<String, Object>> data = executeSQL(selectSql.toString(), selectParams.toArray());
        // Return result with total and data
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("total", total);
        resultData.put("data", data);
        return new Result(true, "Organizations fetched successfully", resultData);
    }

    public Result updateOrganization(Map<String, Object> paramMap) {
        // Extract parameters from paramMap
        Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
        Integer parentOrganization = paramMap.get("Parentorganizationvalue2") != null ? Integer.valueOf(String.valueOf(paramMap.get("Parentorganizationvalue2"))) : null;
        String organizationName = paramMap.get("OrganizationNamevalue2") != null ? String.valueOf(paramMap.get("OrganizationNamevalue2")) : null;
        Integer personInCharge = paramMap.get("Personinchargeoforganizationvalue2") != null ? Integer.valueOf(String.valueOf(paramMap.get("Personinchargeoforganizationvalue2"))) : null;
        Integer sortOrder = paramMap.get("Sortvalue2") != null ? Integer.valueOf(String.valueOf(paramMap.get("Sortvalue2"))) : null;
        String remark = paramMap.get("Remarkvalue2") != null ? String.valueOf(paramMap.get("Remarkvalue2")) : null;
        String updateUsername = sdkOfGetCurrentUserName();
        // Validate required fields
        if (StrUtil.isEmpty(organizationName)) {
            return new Result(false, "组织机构名称不能为空", null);
        }
        // Build SQL for updating organization
        StringBuilder sql = new StringBuilder("UPDATE organization SET ");
        List<Object> params = new ArrayList<>();
        if (parentOrganization != null) {
            sql.append("parent_id = ?, ");
            params.add(parentOrganization);
        }
        sql.append("name = ?, ");
        params.add(organizationName);
        if (personInCharge != null) {
            sql.append("leader_id = ?, ");
            params.add(personInCharge);
        }
        if (sortOrder != null) {
            sql.append("sort_order = ?, ");
            params.add(sortOrder);
        }
        if (remark != null) {
            sql.append("remarks = ?, ");
            params.add(remark);
        }
        sql.append("update_username = ?, update_time = NOW() WHERE id = ?");
        params.add(updateUsername);
        params.add(id);
        // Execute SQL
        int rowsAffected = executeSQL(sql.toString(), params.toArray());
        if (rowsAffected > 0) {
            return new Result(true, "更新成功", null);
        } else {
            return new Result(false, "更新失败", null);
        }
    }


    public Result deleteOrganization(Map<String, Object> paramMap) {
        // 从参数中获取组织机构ID
        Integer organizationId = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
        // 检查组织机构ID是否为空
        if (organizationId == null) {
            return new Result(false, "组织机构ID不能为空", null);
        }
        // 检查是否存在子组织机构
        String checkSql = "SELECT COUNT(*) AS count FROM organization WHERE parent_id =?";
        List<Object> checkParams = new ArrayList<>();
        checkParams.add(organizationId);
        List<Map<String, Object>> checkResult = executeSQL(checkSql, checkParams.toArray());
        int count = checkResult.get(0).get("count") != null ? Integer.valueOf(String.valueOf(checkResult.get(0).get("count"))) : 0;
        if (count > 0) {
            return new Result(false, "该组织机构下存在子组织机构，无法删除", null);
        }
        // 构建删除SQL语句
        StringBuilder sql = new StringBuilder("DELETE FROM organization WHERE id = ?");
        List<Object> params = new ArrayList<>();
        params.add(organizationId);
        // 执行删除操作
        int rowsAffected = executeSQL(sql.toString(), params.toArray());
        // 返回结果

        return new Result(true, "删除成功", null);

    }

    public Result getRootOrganizations(Map<String, Object> paramMap) {
        // SQL to get root organizations (organizations without a parent)
        StringBuilder sql = new StringBuilder("SELECT id, parent_id, (SELECT name FROM organization WHERE id = o.parent_id) AS parent_name, name, sort_order, leader_id, remarks FROM organization o WHERE parent_id IS NULL order by sort_order asc");
        List<Object> params = new ArrayList<>();
        // Pagination parameters
        Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
        Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
        int offset = (current - 1) * pageSize;
        // Count total records
        StringBuilder countSql = new StringBuilder("SELECT COUNT(*) AS total FROM organization WHERE parent_id IS NULL");
        List<Map<String, Object>> countResult = executeSQL(countSql.toString());
        int total = countResult.isEmpty() ? 0 : Integer.valueOf(String.valueOf(countResult.get(0).get("total")));
        // Add pagination to SQL
        sql.append(" LIMIT ? OFFSET ?");
        params.add(pageSize);
        params.add(offset);
        // Execute SQL
        List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
        // Prepare result
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("total", total);
        resultData.put("data", data);
        return new Result(true, "查询成功", resultData);
    }

    public Result getChildOrganizations(Map<String, Object> paramMap) {
        // Get the parent organization ID from parameters
        Integer parentId = paramMap.get("parentId") != null ? Integer.valueOf(String.valueOf(paramMap.get("parentId"))) : null;
        if (parentId == null) {
            return this.getRootOrganizations(paramMap);
        }
        // SQL to get child organizations of the given parent
        StringBuilder sql = new StringBuilder("SELECT id, parent_id, (SELECT name FROM organization WHERE id = o.parent_id) AS parent_name, name, sort_order, leader_id, remarks FROM organization o WHERE parent_id = ? order by sort_order asc");
        List<Object> params = new ArrayList<>();
        params.add(parentId);
        // Pagination parameters
        Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
        Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
        int offset = (current - 1) * pageSize;
        // Count total records
        StringBuilder countSql = new StringBuilder("SELECT COUNT(*) AS total FROM organization WHERE parent_id = ?");
        List<Object> countParams = new ArrayList<>();
        countParams.add(parentId);
        List<Map<String, Object>> countResult = executeSQL(countSql.toString(), countParams.toArray());
        int total = countResult.isEmpty() ? 0 : Integer.valueOf(String.valueOf(countResult.get(0).get("total")));
        // Add pagination to SQL
        sql.append(" LIMIT ? OFFSET ?");
        params.add(pageSize);
        params.add(offset);
        // Execute SQL
        List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
        // Prepare result
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("total", total);
        resultData.put("data", data);
        return new Result(true, "查询成功", resultData);
    }

    public Result getOrganizationsRTB(Map<String, Object> paramMap) {
        // 构建SQL查询语句，获取所有组织结构的数据
        StringBuilder sql = new StringBuilder("SELECT id, name, parent_id FROM organization order by sort_order asc");
        // 执行SQL查询
        List<Map<String, Object>> result = executeSQL(sql.toString());
        // 检查查询结果是否为空，避免空指针异常
        if (result == null) {
            result = new ArrayList<>();
        }

        // 构建一个id到节点的映射
        Map<Object, Map<String, Object>> idToNodeMap = new HashMap<>();
        for (Map<String, Object> node : result) {
            node.put("children", new ArrayList<>()); // 初始化每个节点的子节点列表
            idToNodeMap.put(node.get("id"), node);
        }

        // 构建树形结构
        List<Map<String, Object>> tree = new ArrayList<>();
        for (Map<String, Object> node : result) {
            Object parentId = node.get("parent_id");
            if (parentId == null) {
                // 如果parent_id为空，说明这是根节点
                tree.add(node);
            } else {
                // 否则将该节点添加到其父节点的children列表中
                Map<String, Object> parent = idToNodeMap.get(parentId);
                if (parent != null) {
                    List<Map<String, Object>> children = (List<Map<String, Object>>) parent.get("children");
                    children.add(node);
                }
            }
        }

        // 构建返回结果
        Result response = new Result();
        response.setFlag(true);
        response.setMessage("组织结构树数据加载成功");
        response.setData(tree);
        return response;
    }


    public Result getSystemUsersDB2(Map<String, Object> paramMap) {
        // Initialize the SQL query to select necessary fields from the users table
        StringBuilder sql = new StringBuilder("SELECT id, user_name, nick_name, email, mobile, phone, status, avatar FROM users WHERE status = 0");
        List<Object> params = new ArrayList<>();
        // Execute the SQL query using the provided executeSQL function
        List<Map<String, Object>> result = executeSQL(sql.toString(), params.toArray());
        // Prepare the response using the Result class
        Result response = new Result();
        response.setFlag(true);
        response.setMessage("成功");
        response.setData(result);
        return response;
    }
}
