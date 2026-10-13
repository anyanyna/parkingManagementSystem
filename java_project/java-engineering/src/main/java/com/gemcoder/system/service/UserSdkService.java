package com.gemcoder.system.service;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;

@Service
public class UserSdkService {

    /**
     * 获取用户信息
     */
    public Result getUser(Map<String,Object> paramMap) {

        String username = (String) paramMap.get("user_name");
        String sql = "select * from users where user_name = ?";
        return new Result(true, "success", executeSQL(sql,username));
    }
    public Result getUserByMobile(Map<String,Object> paramMap) {

        String mobile = (String) paramMap.get("mobile");
        String sql = "select * from users where mobile = ?";
        return new Result(true, "success", executeSQL(sql,mobile));
    }
    public List<String> getUserRole(String userName) {
        JSONArray objects = JSONArray.parseArray(JSONArray.toJSONString(executeSQL("SELECT\n" +
                "\trole_code\n" +
                "FROM\n" +
                "users u left join \n" +
                "\tuser_role ur on u.id=ur.user_id\n" +
                "\tLEFT JOIN role r ON ur.role_id = r.id \n" +
                "WHERE\n" +
                "\tu.user_name=?", userName)));
        if (CollectionUtil.isEmpty(objects))return null;
        Set<String> roleCode = objects.stream().map(item -> {
            JSONObject obj = JSONObject.parseObject(JSONObject.toJSONString(item));
            return String.valueOf(obj.get("role_code"));
        }).collect(Collectors.toSet());
        return new ArrayList<>(roleCode);
    }

    /**
     * 获取当前登录用户名
     */
    public static String sdkOfGetCurrentUserName() {

        //获取当前用户名
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null; // 用户未认证
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        if(principal!=null) {
        	return principal.toString();
        }
        return null; // 无法获取用户名
    }

    /**
     * 获取当前登录用户的用户id
     */
    public static Integer sdkOfGetCurrentUserId() {

        //获取当前用户名
        String userName = sdkOfGetCurrentUserName();
        if (userName != null) {
            String sql = "select id from users where user_name = '" + userName + "' limit 1";
            List<Map<String, Object>> users = (List<Map<String, Object>>)executeSQL(sql);
            if(users==null||users.isEmpty()) {
            	return null;
            }
            Object id = users.get(0).get("id");
            return (Integer) id;
        }
        return null; // 无法获取用户名
    }



    public JSONObject getUserByMobile(String mobile) {
        String sql = "select user_name,mobile from users where mobile = '" + mobile + "' limit 1";
        List<Map<String, Object>> users = (List<Map<String, Object>>)executeSQL(sql);
        if(users==null||users.isEmpty()) {
            return null;
        }
        Object user = users.get(0);
        return JSONObject.parseObject(JSONObject.toJSONString(user));
    }

    public Result getUserByMobileOnClient(String mobile) {
        String sql = "select * from parking_lot_user where contact = ?";
        return new Result(true, "success", executeSQL(sql,mobile));
    }

    public JSONObject getUserMobileOnClient(String mobile) {
        String sql = "select * from parking_lot_user where contact = '" + mobile + "' limit 1";
        List<Map<String, Object>> users = (List<Map<String, Object>>)executeSQL(sql);
        if(users==null||users.isEmpty()) {
            return null;
        }
        Object user = users.get(0);
        return JSONObject.parseObject(JSONObject.toJSONString(user));
    }
}
