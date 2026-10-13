package com.gemcoder.system.service;
import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;

import java.util.*;

import com.gemcoder.system.bo.PagePermissionBo;
import org.springframework.stereotype.Service;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserId;
import static com.gemcoder.system.service.permission.PermissionSdkService.*;

import com.gemcoder.system.bo.Result;

import java.sql.SQLException;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolemanagementService {

public Result searchRolesByName(Map<String,Object> paramMap){
    // 获取分页参数
    Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
    Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
    String roleName = paramMap.get("roleName") != null ? String.valueOf(paramMap.get("roleName")) : null;
    
    // 计算分页起始位置
    int offset = (current - 1) * pageSize;
    
    // 查询角色列表，按创建时间倒序排序
    StringBuilder sql = new StringBuilder("SELECT id, role_name, role_code, description FROM role WHERE 1=1");
    List<Object> params = new ArrayList<>();
    
    if (roleName != null && !roleName.isEmpty()) {
        sql.append(" AND role_name LIKE ?");
        params.add("%" + roleName + "%");
    }
    
    sql.append(" ORDER BY create_time DESC LIMIT ?, ?");
    params.add(offset);
    params.add(pageSize);
    
    List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
    
    // 查询总条数
    StringBuilder countSql = new StringBuilder("SELECT COUNT(*) AS total FROM role WHERE 1=1");
    List<Object> countParams = new ArrayList<>();
    
    if (roleName != null && !roleName.isEmpty()) {
        countSql.append(" AND role_name LIKE ?");
        countParams.add("%" + roleName + "%");
    }
    
    List<Map<String, Object>> countResult = executeSQL(countSql.toString(), countParams.toArray());
    int total = countResult.get(0).get("total") != null ? Integer.valueOf(String.valueOf(countResult.get(0).get("total"))) : 0;
    
    // 返回结果
    Result result = new Result();
    result.setFlag(true);
    result.setData(Map.of("total", total, "data", data));
    return result;
}

public Result addRole(Map<String,Object> paramMap){
    String roleName = paramMap.get("roleName") != null ? String.valueOf(paramMap.get("roleName")) : null;
    String roleCode = paramMap.get("roleCode") != null ? String.valueOf(paramMap.get("roleCode")) : null;
    String description = paramMap.get("description") != null ? String.valueOf(paramMap.get("description")) : null;
    String createUsername = sdkOfGetCurrentUserName();
    
    StringBuilder sql = new StringBuilder("INSERT INTO role (role_name, role_code, description, create_username, create_time) VALUES (?, ?, ?, ?, NOW())");
    List<Object> params = new ArrayList<>();
    params.add(roleName);
    params.add(roleCode);
    params.add(description);
    params.add(createUsername);
    
    int insertRows = executeSQL(sql.toString(), params.toArray());
    
    Result result = new Result();
    result.setFlag(insertRows > 0);
    result.setMessage(insertRows > 0 ? "新增成功" : "新增失败");
    return result;
}

public Result updateRole(Map<String,Object> paramMap){
    Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
    String roleName = paramMap.get("roleName") != null ? String.valueOf(paramMap.get("roleName")) : null;
    String description = paramMap.get("description") != null ? String.valueOf(paramMap.get("description")) : null;
    String updateUsername = sdkOfGetCurrentUserName();
    
    StringBuilder sql = new StringBuilder("UPDATE role SET role_name = ?, description = ?, update_username = ?, update_time = NOW() WHERE id = ?");
    List<Object> params = new ArrayList<>();
    params.add(roleName);
    params.add(description);
    params.add(updateUsername);
    params.add(id);
    
    int updateRows = executeSQL(sql.toString(), params.toArray());
    
    Result result = new Result();
    result.setFlag(updateRows > 0);
    result.setMessage(updateRows > 0 ? "更新成功" : "更新失败");
    return result;
}

public Result showEditRoleModal(Map<String,Object> paramMap){
    Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
    
    StringBuilder sql = new StringBuilder("SELECT id, role_name, description FROM role WHERE id = ?");
    List<Object> params = new ArrayList<>();
    params.add(id);
    
    List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
    
    Result result = new Result();
    result.setFlag(!data.isEmpty());
    result.setData(data.isEmpty() ? null : data.get(0));
    return result;
}

public Result deleteRole(Map<String,Object> paramMap){
    Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
    
    StringBuilder sql = new StringBuilder("DELETE FROM role WHERE id = ?");
    List<Object> params = new ArrayList<>();
    params.add(id);
    
    int deleteRows = executeSQL(sql.toString(), params.toArray());
    
    Result result = new Result();
    result.setFlag(deleteRows > 0);
    result.setMessage(deleteRows > 0 ? "删除成功" : "删除失败");
    return result;
}

public Result getAllPermissions(Map<String,Object> paramMap){
    List<Map<String, Object>> maps = sdkOfgetAllPermissions();
    List<PagePermissionBo> pageMap = castToPageMap(maps);
    Result result = new Result();
    result.setFlag(true);
    result.setData(pageMap);
    return result;
}

public static List<PagePermissionBo> castToPageMap(List<Map<String, Object>> maps) {
    HashMap<String, PagePermissionBo> pageMap = new HashMap<>();
    maps.forEach(item -> {
        String pageUuid = (String) item.get("pageUuid");
        String pageName = (String) item.get("pageName");
        PagePermissionBo pagePermissionBo = pageMap.get(pageUuid);
        if (pagePermissionBo == null) {
            List<Map<String, Object>> list = new ArrayList<>();
            list.add(item);
            pagePermissionBo = new PagePermissionBo(pageName, pageUuid, list);
            pageMap.put(pageUuid, pagePermissionBo);
        } else {
            pagePermissionBo.getPermissionList().add(item);
        }
    });
    return new ArrayList<>(pageMap.values());
}

    public Result updateRolePermissions(Map<String,Object> paramMap){
    Integer roleId = paramMap.get("roleId") != null ? Integer.valueOf(String.valueOf(paramMap.get("roleId"))) : null;
    List<String> permissionIds = paramMap.get("permissionIds") != null ? (List<String>) paramMap.get("permissionIds") : new ArrayList<>();
    String updateUsername = sdkOfGetCurrentUserName();
    
    // 删除旧的权限
    String deleteSql = "DELETE FROM role_permission WHERE role_id = ?";
    executeSQL(deleteSql, roleId);
    String selectSql = "SELECT role_code FROM role WHERE id =?";
    List<Map<String, Object>> data = executeSQL(selectSql, roleId);
    String roleCode = data.get(0).get("role_code")!= null? String.valueOf(data.get(0).get("role_code")) : null;

    // 插入新的权限
    StringBuilder insertSql = new StringBuilder("INSERT INTO role_permission (role_id, permission_code, create_username, create_time, role_code) VALUES (?, ?, ?, NOW(), ?)");
    for (String permissionId : permissionIds) {
        executeSQL(insertSql.toString(), roleId, permissionId, updateUsername,roleCode);
    }
    
    Result result = new Result();
    result.setFlag(true);
    result.setMessage("权限更新成功");
    return result;
}

    public Result getAllMenus() {
        StringBuilder sql = new StringBuilder("SELECT * FROM menus WHERE 1=1");
        List<Object> params = new ArrayList<>();
        // 排序
        sql.append(" ORDER BY updated_at DESC");

        // 执行查询
        List<Map<String, Object>> menus = executeSQL(sql.toString(), params.toArray());
        Map<Integer, Map<String, Object>> menuMap = new HashMap<>();
        List<Map<String, Object>> roots = new ArrayList<>();
        // 将所有菜单项存储到Map中，方便后续查找
        for (Map<String, Object> menu : menus) {
            menuMap.put((Integer) menu.get("id"), menu);
            // 如果父ID为0，则认为是根菜单
            if (menu.get("parent_id")==null) {
                roots.add(menu);
            }
        }

        // 构建树形结构
        List<Map<String, Object>> menuTree = buildMenuTree(roots, menuMap);

        return new Result(true, "", menuTree);
    }

    private static List<Map<String, Object>> buildMenuTree(List<Map<String, Object>> menus, Map<Integer, Map<String, Object>> menuMap) {
        List<Map<String, Object>> tree = new ArrayList<>();
        for (Map<String, Object> menu : menus) {
            List<Map<String, Object>> children = new ArrayList<>();
            int menuId = (Integer) menu.get("id");
            for (Map.Entry<Integer, Map<String, Object>> entry : menuMap.entrySet()) {
                if (entry.getValue().get("parent_id")!=null && (Integer) entry.getValue().get("parent_id") == menuId) {
                    children.add(entry.getValue());
                }
            }
            if (!children.isEmpty()) {
                menu.put("children", buildMenuTree(children, menuMap));
            } else {
                menu.put("children", new ArrayList<>());
            }
            tree.add(menu);
        }
        return tree;
    }

@Transactional(rollbackFor = Exception.class)
public Result updateRoleMenus(Map<String,Object> paramMap){
    Integer roleId = paramMap.get("roleId") != null ? Integer.valueOf(String.valueOf(paramMap.get("roleId"))) : null;
    List<Integer> menuIds = paramMap.get("menuIds") != null ? (List<Integer>) paramMap.get("menuIds") : new ArrayList<>();
    String updateUsername = sdkOfGetCurrentUserName();
    // 删除旧的菜单
    String deleteSql = "DELETE FROM role_menu WHERE role_id = ?";
    executeSQL(deleteSql, roleId);
    
    // 插入新的菜单
    StringBuilder insertSql = new StringBuilder("INSERT INTO role_menu (role_id, menu_id, create_username, create_time) VALUES (?, ?, ?, NOW())");
    for (Integer menuId : menuIds) {
        executeSQL(insertSql.toString(), roleId, menuId, updateUsername);
    }
    
    Result result = new Result();
    result.setFlag(true);
    result.setMessage("菜单更新成功");
    return result;
}

    public Result getRoleMenus(Map<String, Object> paramMap) {
        Integer roleId = paramMap.get("roleId") != null ? Integer.valueOf(String.valueOf(paramMap.get("roleId"))) : null;
        String sql = "SELECT menu_id as id FROM role_menu WHERE role_id = ?";
        List<Object> params = new ArrayList<>();
        params.add(roleId);
        List<Map<String, Object>> data = executeSQL(sql, params.toArray());
        return new Result(true, "", data);
    }

    public Result getRolePermissions(Map<String, Object> paramMap) {
        Integer roleId = paramMap.get("roleId") != null ? Integer.valueOf(String.valueOf(paramMap.get("roleId"))) : null;
        if (roleId == null){
            return new Result(false, "roleId不能为空", null);
        }
        String sql ="select role_code from role where id =?";
        List<Object> params = new ArrayList<>();
        params.add(roleId);
        List<Map<String, Object>> data = executeSQL(sql, params.toArray());
        String roleCode = data.get(0).get("role_code")!= null? String.valueOf(data.get(0).get("role_code")) : null;
        if (roleCode == null){
            return new Result(false, "角色roleCode不存在，角色id："+roleId, null);
        }
        List<Map<String, Object>> permissionsByRole = getPermissionsByRole(List.of(roleCode));
        return new Result(true, "成功", permissionsByRole);
    }
}