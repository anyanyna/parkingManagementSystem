package com.gemcoder.system.service;
import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.gemcoder.system.exception.ErrorCodeEnum;
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
public class NavigationpageService {

    public Result getUserMenuPermissions(Map<String, Object> paramMap) {
        // 获取当前登录用户的ID
        Integer userId = sdkOfGetCurrentUserId();
        if (userId == null) {
            return Result.buildError(ErrorCodeEnum.NO_LOGIN);
        }

        // 构建SQL查询语句，获取当前用户角色对应的菜单权限
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT m.id, m.menu_name, m.description, m.icon, m.parent_id, m.sort_order, m.path ")
           .append("FROM menus m ")
           .append("JOIN role_menu rm ON m.id = rm.menu_id ")
           .append("JOIN user_role ur ON rm.role_id = ur.role_id ")
           .append("WHERE ur.user_id = ? ")
           .append("ORDER BY m.sort_order ASC");

        // 执行SQL查询
        List<Map<String, Object>> menuPermissions = executeSQL(sql.toString(), userId);

        // 返回结果
        Map<Integer, Map<String, Object>> menuMap = new HashMap<>();
        List<Map<String, Object>> roots = new ArrayList<>();
        // 将所有菜单项存储到Map中，方便后续查找
        for (Map<String, Object> menu : menuPermissions) {
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

    public Result getUserInfo(Map<String, Object> paramMap) {
        // 获取当前登录用户的ID和用户名
        Integer userId = sdkOfGetCurrentUserId();
        // 定义返回结果
        Result result = new Result();
        result.setFlag(false);
        try {
            // 查询个人中心信息
            StringBuilder sql = new StringBuilder("SELECT id, user_name, nick_name, email, mobile, phone, avatar, organization_id, (select name from organization where id = u.organization_id) as org_name FROM users u WHERE id = ?");
            List<Object> params = new ArrayList<>();
            params.add(userId);
            List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
            // 检查是否查询到数据
            if (data != null && !data.isEmpty()) {
                // 设置返回结果
                result.setFlag(true);
                result.setMessage("查询成功");
                result.setData(data.get(0));
            } else {
                result.setMessage("未查询到个人中心信息");
            }
        } catch (Exception e) {
            result.setMessage("查询个人中心信息时发生错误: " + e.getMessage());
        }
        return result;
    }

    public Result getIndexMenu() {
        List<Map<String, Object>> data = executeSQL("SELECT * FROM menus WHERE index_status = 1 limit 1");
        if (data == null || data.isEmpty()) {
            //未设置首页返回排序最靠前的菜单
            return Result.buildSuccess(executeSQL("SELECT * FROM menus order by sort_order asc limit 1"));
        }
        return Result.buildSuccess(data);
    }
}