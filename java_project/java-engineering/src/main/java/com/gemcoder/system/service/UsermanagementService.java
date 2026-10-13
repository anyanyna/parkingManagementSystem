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
import cn.hutool.core.map.MapUtil;

@Service
public class UsermanagementService {

    public Result updateUserRoles(Map<String, Object> paramMap) {
        if (paramMap.get("userId") == null) {
            return new Result(false, "缺少用户id参数", null);
        }
        Integer userId = Integer.valueOf(String.valueOf(paramMap.get("userId")));
        List<String> roleIds = (List<String>) paramMap.get("roleIds");
        String currentUserName = sdkOfGetCurrentUserName();
        // 删除用户的现有角色
        String deleteSql = "DELETE FROM user_role WHERE user_id = ?";
        executeSQL(deleteSql, userId);
        // 为用户分配新角色
        StringBuilder insertSql = new StringBuilder("INSERT INTO user_role (user_id, role_id, create_username, create_time) VALUES ");
        List<Object> params = new ArrayList<>();
        for (String roleId : roleIds) {
            insertSql.append("(?, ?, ?, NOW()),");
            params.add(userId);
            params.add(Integer.valueOf(roleId));
            params.add(currentUserName);
        }
        // Remove the last comma
        insertSql.setLength(insertSql.length() - 1);
        Object o = executeSQL(insertSql.toString(), params.toArray());
        // Refresh user list
        return new Result(true, "更新成功！",o);
    }

    public Result getUsers(Map<String, Object> paramMap) {
        String userName = paramMap.get("userName") != null ? String.valueOf(paramMap.get("userName")) : null;
        List<String> orgIds = (List<String>) paramMap.get("orgIds");
        Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
        Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
        StringBuilder sql = new StringBuilder("SELECT id, user_name, nick_name, email, mobile, phone, status FROM users WHERE status != 1");
        List<Object> params = new ArrayList<>();
        if (userName != null && !userName.isEmpty()) {
            sql.append(" AND user_name LIKE ?");
            params.add("%" + userName + "%");
        }
        if (orgIds != null && !orgIds.isEmpty()) {
            sql.append(" AND organization_id IN (");
            for (String orgId : orgIds) {
                sql.append("?,");
                params.add(Integer.valueOf(orgId));
            }
            // Remove the last comma
            sql.setLength(sql.length() - 1);
            sql.append(")");
        }
        sql.append(" ORDER BY update_time DESC LIMIT ?, ?");
        params.add((current - 1) * pageSize);
        params.add(pageSize);
        List<Map<String, Object>> users = executeSQL(sql.toString(), params.toArray());
        // Get total count
        StringBuilder countSql = new StringBuilder("SELECT COUNT(*) FROM users WHERE status != 1");
        List<Object> countParams = new ArrayList<>();
        if (userName != null && !userName.isEmpty()) {
            countSql.append(" AND user_name LIKE ?");
            countParams.add("%" + userName + "%");
        }
        if (orgIds != null && !orgIds.isEmpty()) {
            countSql.append(" AND organization_id IN (");
            for (String orgId : orgIds) {
                countSql.append("?,");
                countParams.add(Integer.valueOf(orgId));
            }
            // Remove the last comma
            countSql.setLength(countSql.length() - 1);
            countSql.append(")");
        }
        List<Map<String, Object>> countResult = executeSQL(countSql.toString(), countParams.toArray());
        Integer total = Integer.valueOf(String.valueOf(countResult.get(0).get("COUNT(*)")));
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("data", users);
        resultData.put("total", total);
        return new Result(true, "Query successful", resultData);
    }

    public Result showEditUserModal(Map<String, Object> paramMap) {
        Integer userId = Integer.valueOf(String.valueOf(paramMap.get("userId")));
        String sql = "SELECT id, user_name, nick_name, email, mobile, phone, avatar, organization_id, (select name from organization where id = u.organization_id) as org_name FROM users u WHERE id = ?";
        List<Map<String, Object>> user = executeSQL(sql, userId);
        if (user.isEmpty()) {
            return new Result(false, "User not found", null);
        }
        return new Result(true, "User data retrieved", user.get(0));
    }

    public Result deleteUser(Map<String, Object> paramMap) {
        Integer userId = Integer.valueOf(String.valueOf(paramMap.get("userId")));
        String sql = "UPDATE users SET status = 1 WHERE id = ?";
        int rowsAffected = executeSQL(sql, userId);
        if (rowsAffected > 0) {
            return new Result(true, "User deleted successfully", null);
        } else {
            return new Result(false, "User deletion failed", null);
        }
    }

    public Result addUser(Map<String, Object> paramMap) {
        String userName = paramMap.get("userName") != null ? String.valueOf(paramMap.get("userName")) : null;
        String nickName = paramMap.get("nickName") != null ? String.valueOf(paramMap.get("nickName")) : null;
        String email = paramMap.get("email") != null ? String.valueOf(paramMap.get("email")) : null;
        String mobile = paramMap.get("mobile") != null ? String.valueOf(paramMap.get("mobile")) : null;
        String phone = paramMap.get("phone") != null ? String.valueOf(paramMap.get("phone")) : null;
        String password = paramMap.get("password") != null ? String.valueOf(paramMap.get("password")) : null;
        String avatar = paramMap.get("avatar") != null ? String.valueOf(paramMap.get("avatar")) : null;
        Integer orgId = paramMap.get("orgId") != null ? Integer.valueOf(String.valueOf(paramMap.get("orgId"))) : null;
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(password);
        String sql = "INSERT INTO users (user_name, nick_name, email, mobile, phone, password, avatar, status, create_time, organization_id) VALUES (?, ?, ?, ?, ?, ?, ?, 0, NOW(), ?)";
        int rowsAffected = executeSQL(sql, userName, nickName, email, mobile, phone, encodedPassword, avatar, orgId);
        if (rowsAffected > 0) {
            return new Result(true, "User added successfully", null);
        } else {
            return new Result(false, "User addition failed", null);
        }
    }

    public Result updateUser(Map<String, Object> paramMap) {
        // 获取ID，如果没有ID则直接返回错误结果
        Integer userId = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
        if (userId == null) {
            return new Result(false, "User ID is required", null);
        }

        // 获取可能需要更新的字段值
        String userName = paramMap.get("userName") != null ? String.valueOf(paramMap.get("userName")) : null;
        String nickName = paramMap.get("nickName") != null ? String.valueOf(paramMap.get("nickName")) : null;
        String email = paramMap.get("email") != null ? String.valueOf(paramMap.get("email")) : null;
        String mobile = paramMap.get("mobile") != null ? String.valueOf(paramMap.get("mobile")) : null;
        String phone = paramMap.get("phone") != null ? String.valueOf(paramMap.get("phone")) : null;
        String avatar = paramMap.get("avatar") != null ? String.valueOf(paramMap.get("avatar")) : null;
        Integer orgId = paramMap.get("orgId") != null ? Integer.valueOf(String.valueOf(paramMap.get("orgId"))) : null;

        // 构建SQL和参数列表，动态更新有传递的字段
        StringBuilder sql = new StringBuilder("UPDATE users SET ");
        List<Object> params = new ArrayList<>();

        if (userName != null) {
            sql.append("user_name = ?, ");
            params.add(userName);
        }
        if (nickName != null) {
            sql.append("nick_name = ?, ");
            params.add(nickName);
        }
        if (email != null) {
            sql.append("email = ?, ");
            params.add(email);
        }
        if (mobile != null) {
            sql.append("mobile = ?, ");
            params.add(mobile);
        }
        if (phone != null) {
            sql.append("phone = ?, ");
            params.add(phone);
        }
        if (avatar != null) {
            sql.append("avatar = ?, ");
            params.add(avatar);
        }
        if (orgId != null) {
            sql.append("organization_id = ?, ");
            params.add(orgId);
        }

        // 移除最后一个逗号和空格
        if (params.size() > 0) {
            sql.setLength(sql.length() - 2);
        } else {
            return new Result(false, "No fields to update", null);
        }

        // 添加WHERE子句
        sql.append(" WHERE id = ?");
        params.add(userId);

        // 执行更新
        int rowsAffected = executeSQL(sql.toString(), params.toArray());
        if (rowsAffected > 0) {
            return new Result(true, "User updated successfully", null);
        } else {
            return new Result(false, "User update failed", null);
        }
    }


    public Result resetUserPassword(Map<String, Object> paramMap) {
        Integer userId = Integer.valueOf(String.valueOf(paramMap.get("userId")));
        String newPassword = paramMap.get("newPassword") != null ? String.valueOf(paramMap.get("newPassword")) : null;
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(newPassword);
        String sql = "UPDATE users SET password = ? WHERE id = ?";
        int rowsAffected = executeSQL(sql, encodedPassword, userId);
        if (rowsAffected > 0) {
            return new Result(true, "Password reset successfully", null);
        } else {
            return new Result(false, "Password reset failed", null);
        }
    }

    public Result getOrgTreeData(Map<String, Object> paramMap) {
        // 构建查询组织机构树的SQL
        StringBuilder sql = new StringBuilder("SELECT id, name, parent_id FROM organization WHERE 1=1");
        List<Object> params = new ArrayList<>();
        // 执行SQL查询
        List<Map<String, Object>> result = executeSQL(sql.toString(), params.toArray());
        // 构建组织机构树数据
        List<Map<String, Object>> orgTreeData = new ArrayList<>();
        Map<Integer, Map<String, Object>> orgMap = new HashMap<>();
        for (Map<String, Object> org : result) {
            Integer id = org.get("id") != null ? Integer.valueOf(String.valueOf(org.get("id"))) : null;
            String name = org.get("name") != null ? String.valueOf(org.get("name")) : null;
            Integer parentId = org.get("parent_id") != null ? Integer.valueOf(String.valueOf(org.get("parent_id"))) : null;
            if (id != null && name != null) {
                Map<String, Object> orgNode = new HashMap<>();
                orgNode.put("key", id);
                orgNode.put("title", name);
                orgNode.put("children", new ArrayList<>());
                orgMap.put(id, orgNode);
                if (parentId == null) {
                    orgTreeData.add(orgNode);
                } else {
                    Map<String, Object> parentNode = orgMap.get(parentId);
                    if (parentNode != null) {
                        List<Map<String, Object>> children = (List<Map<String, Object>>) parentNode.get("children");
                        children.add(orgNode);
                    }
                }
            }
        }
        // 返回结果
        Result resultData = new Result();
        resultData.setFlag(true);
        resultData.setMessage("组织机构树数据获取成功");
        resultData.setData(orgTreeData);
        return resultData;
    }

    public Result toggleUserStatus(Map<String, Object> paramMap) {
        // 获取用户ID
        Integer userId = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
        if (userId == null) {
            return new Result(false, "用户ID不能为空", null);
        }
        // 查询当前用户状态
        StringBuilder querySql = new StringBuilder("SELECT status FROM users WHERE id = ?");
        List<Map<String, Object>> queryResult = executeSQL(querySql.toString(), userId);
        if (queryResult.isEmpty()) {
            return new Result(false, "用户不存在", null);
        }
        // 获取当前状态
        Integer currentStatus = Integer.valueOf(String.valueOf(queryResult.get(0).get("status")));
        // 切换状态
        Integer newStatus = (currentStatus == 0) ? 2 : 0;
        // 更新用户状态
        StringBuilder updateSql = new StringBuilder("UPDATE users SET status = ? WHERE id = ?");
        int updateResult = executeSQL(updateSql.toString(), newStatus, userId);
        if (updateResult > 0) {
            return new Result(true, "用户状态更新成功", null);
        } else {
            return new Result(false, "用户状态更新失败", null);
        }
    }

    public Result getUserRoles(Map<String, Object> paramMap) {
        // 获取用户ID
        Integer userId = paramMap.get("userId") != null ? Integer.valueOf(String.valueOf(paramMap.get("userId"))) : null;
        if (userId == null) {
            return new Result(false, "用户ID不能为空", null);
        }
        // 查询用户拥有的角色
        StringBuilder sql = new StringBuilder("SELECT r.id, r.role_name FROM role r ");
        sql.append("JOIN user_role ur ON r.id = ur.role_id ");
        sql.append("WHERE ur.user_id = ?");
        List<Map<String, Object>> userRoles = executeSQL(sql.toString(), userId);
        return new Result(true, "查询成功", userRoles);
    }

    public Result getAllRoles(Map<String, Object> paramMap) {
        // 查询所有角色
        StringBuilder sql = new StringBuilder("SELECT id, role_name FROM role");
        List<Map<String, Object>> allRoles = executeSQL(sql.toString());
        return new Result(true, "查询成功", allRoles);
    }

    public Result showResetPasswordModal(Map<String, Object> paramMap) {
        // 获取当前行用户的ID
        Integer userId = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
        String newPassword = paramMap.get("NewPasswordvalue1") != null ? String.valueOf(paramMap.get("NewPasswordvalue1")) : null;
        // 检查用户ID和新密码是否为空
        if (userId == null || newPassword == null || newPassword.isEmpty()) {
            return new Result(false, "用户ID或新密码不能为空", null);
        }
        // 使用BCryptPasswordEncoder加密新密码
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(newPassword);
        // 更新用户密码
        StringBuilder sql = new StringBuilder("UPDATE users SET password = ?, update_time = NOW() WHERE id = ?");
        List<Object> params = new ArrayList<>();
        params.add(encodedPassword);
        params.add(userId);
        int updateRows = executeSQL(sql.toString(), params.toArray());
        // 检查更新结果
        if (updateRows > 0) {
            return new Result(true, "密码重置成功", null);
        } else {
            return new Result(false, "密码重置失败，用户不存在", null);
        }
    }
}
