package com.gemcoder.system.service;
import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Service;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserId;
import com.gemcoder.system.bo.Result;
import static com.gemcoder.system.service.permission.PermissionSdkService.sdkOfgetAllPermissions;
import static com.gemcoder.system.service.permission.PermissionSdkService.sdkOfgetAllMenus;
import java.sql.SQLException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class MenumanagementService {

    public Result addMenu(Map<String, Object> paramMap) {
        String menuName = paramMap.get("menuName") != null ? String.valueOf(paramMap.get("menuName")) : null;
        Integer parentId = paramMap.get("parentId") != null ? Integer.valueOf(String.valueOf(paramMap.get("parentId"))) : null;
        String icon = paramMap.get("icon") != null&& StrUtil.isNotBlank((String)paramMap.get("icon")) ? String.valueOf(paramMap.get("icon")) : null;
        String pageId = (String)paramMap.get("pageId") ;
        Integer sortOrder = paramMap.get("sortOrder") != null ? Integer.valueOf(String.valueOf(paramMap.get("sortOrder"))) : null;
        String description = paramMap.get("description") != null ? String.valueOf(paramMap.get("description")) : null;
        String path = paramMap.get("path") != null ? String.valueOf(paramMap.get("path")) : null;
        String page = paramMap.get("page") != null ? String.valueOf(paramMap.get("page")) : null;
        Integer indexStatus = paramMap.get("index_status") != null ? Integer.parseInt(String.valueOf(paramMap.get("index_status"))) : 0;
        String createUsername = sdkOfGetCurrentUserName(); // 获取当前用户

        // 构建 SQL 语句
        StringBuilder sql = new StringBuilder("INSERT INTO menus (menu_name, parent_id, icon, page_id, sort_order, create_username, create_time, description, path, page, index_status) VALUES (?, ?, ?, ?, ?, ?, NOW(), ?, ?, ?, ?)");

        // 构建参数列表
        List<Object> params = new ArrayList<>();
        params.add(menuName);
        params.add(parentId);
        params.add(icon);
        params.add(pageId);
        params.add(sortOrder);
        params.add(createUsername);
        params.add(description);
        params.add(path);
        params.add(page);
        params.add(indexStatus);

        // 执行插入操作
        int insertRows = executeSQL(sql.toString(), params.toArray());

        // 返回结果
        Result result = new Result();
        result.setFlag(insertRows > 0);
        result.setMessage(insertRows > 0 ? "新增成功" : "新增失败");
        return result;
    }

public Result searchMenus(Map<String, Object> paramMap) {
    // 获取分页参数
    Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
    Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;

    // 获取查询条件
    String menuName = paramMap.get("menuName") != null ? String.valueOf(paramMap.get("menuName")) : null;

    // 构建查询SQL
    StringBuilder sql = new StringBuilder("SELECT * FROM menus WHERE 1=1");
    List<Object> params = new ArrayList<>();

    if (menuName != null && !menuName.isEmpty()) {
        sql.append(" AND menu_name LIKE ?");
        params.add("%" + menuName + "%");
    }

    // 排序
    sql.append(" ORDER BY sort_order ASC, id desc");

    // 分页
    sql.append(" LIMIT ?, ?");
    params.add((current - 1) * pageSize);
    params.add(pageSize);

    // 执行查询
    List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());

    // 查询总条数
    StringBuilder countSql = new StringBuilder("SELECT COUNT(*) AS total FROM menus WHERE 1=1");
    List<Object> countParams = new ArrayList<>();
    if (menuName != null && !menuName.isEmpty()) {
        countSql.append(" AND menu_name LIKE ?");
        countParams.add("%" + menuName + "%");
    }
    List<Map<String, Object>> countResult = executeSQL(countSql.toString(), countParams.toArray());
    Integer total = countResult.get(0) != null ? Integer.valueOf(String.valueOf(countResult.get(0).get("total"))) : 0;

    // 返回结果
    Map<String, Object> resultData = new HashMap<>();
    resultData.put("total", total);
    resultData.put("data", data);
    return new Result(true, "查询菜单成功", resultData);
}

public Result updateMenu(Map<String, Object> paramMap) {
    // 获取更新参数
    Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;
    String menuName = paramMap.get("menuName") != null ? String.valueOf(paramMap.get("menuName")) : null;
    Integer sortOrder = paramMap.get("sortOrder") != null ? Integer.valueOf(String.valueOf(paramMap.get("sortOrder"))) : null;
    String icon = paramMap.get("icon") != null&& StrUtil.isNotBlank((String)paramMap.get("icon")) ? String.valueOf(paramMap.get("icon")) : null;
    String path = (String) paramMap.get("path");
    Integer parentId = paramMap.get("parentId") != null ? Integer.valueOf(String.valueOf(paramMap.get("parentId"))) : null;
    Integer indexStatus = paramMap.get("index_status") != null ? Integer.valueOf(String.valueOf(paramMap.get("index_status"))) : null;

    // 构建更新SQL
    StringBuilder sql = new StringBuilder("UPDATE menus SET ");
    List<Object> params = new ArrayList<>();

    if (menuName != null) {
        sql.append("menu_name = ?, ");
        params.add(menuName);
    }
    if (sortOrder != null) {
        sql.append("sort_order = ?, ");
        params.add(sortOrder);
    }
    if (StrUtil.isNotBlank(icon)) {
        sql.append("icon = ?, ");
        params.add(icon);
    }
    if (path != null) {
        sql.append("path = ?, ");
        params.add(path);
    }
    if (parentId!= null) {
        sql.append("parent_id =?, ");
        params.add(parentId);
    }
    if (indexStatus!= null){
        sql.append("index_status =?, ");
        params.add(indexStatus);
    }

    sql.append("updated_at = NOW(), update_username = ? WHERE id = ?");
    params.add(sdkOfGetCurrentUserName());
    params.add(id);

    // 如果index_status为1，则将其他index_status为1的菜单的index_status更新为0
    if (indexStatus != null && indexStatus == 1) {
        String updSql = "UPDATE menus SET index_status = 0 WHERE index_status = 1";
        executeSQL(updSql);
    }

    // 执行更新
    int updateRows = executeSQL(sql.toString(), params.toArray());

    // 返回结果
    if (updateRows > 0) {
        return new Result(true, "更新菜单成功", null);
    } else {
        return new Result(false, "更新菜单失败", null);
    }
}

public Result deleteMenu(Map<String, Object> paramMap) {
    // 获取删除参数
    Integer id = paramMap.get("id") != null ? Integer.valueOf(String.valueOf(paramMap.get("id"))) : null;

    // 构建删除SQL
    String sql = "DELETE FROM menus WHERE id = ?";
    List<Object> params = new ArrayList<>();
    params.add(id);

    // 执行删除
    int deleteRows = executeSQL(sql, params.toArray());

    // 返回结果
    if (deleteRows > 0) {
        return new Result(true, "删除菜单成功", null);
    } else {
        return new Result(false, "删除菜单失败", null);
    }
}

    public Result getAllPages(Map<String, Object> paramMap) {
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("data", sdkOfgetAllMenus());
        return new Result(true, "查询页面成功", resultData);
    }

    public Result getMenuTree() {
        StringBuilder sql = new StringBuilder("SELECT * FROM menus WHERE 1=1");
        List<Object> params = new ArrayList<>();
        // 排序
        sql.append(" ORDER BY sort_order ASC, id desc");

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
                menu.put("children", null);
            }
            tree.add(menu);
        }
        return tree;
    }

}