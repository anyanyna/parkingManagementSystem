package com.gemcoder.system.service;

import cn.hutool.core.util.StrUtil;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.exception.ErrorCodeEnum;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import static com.gemcoder.system.datasource.JdbcTemplateUtil.sdkOfPaginationQueryCount;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserId;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;

@Service
public class PersonalcenterService {

    public Result handleTreeSelect(Map<String, Object> paramMap) {
        Result result = new Result();
        try {
            // 获取当前选中的树节点
            List<String> selectedKeys = paramMap.get("selectedKeys") != null ? (List<String>) paramMap.get("selectedKeys") : new ArrayList<>();
            if (selectedKeys.isEmpty()) {
                result.setFlag(false);
                result.setMessage("未选中任何节点");
                return result;
            }
            String selectedKey = selectedKeys.get(0);
            // 根据选中的树节点显示或隐藏相应的面板
            if ("个人信息".equals(selectedKey)) {
                // 隐藏消息列表，显示个人信息
                result.setData(Map.of("MessageListisShow2", false, "PersonalInformationFormisShow1", true));
            } else if ("个人消息".equals(selectedKey)) {
                // 隐藏个人信息，显示消息列表
                result.setData(Map.of("MessageListisShow2", true, "PersonalInformationFormisShow1", false));
            } else {
                result.setFlag(false);
                result.setMessage("未知的选项");
                return result;
            }
            result.setFlag(true);
            result.setMessage("操作成功");
        } catch (Exception e) {
            result.setFlag(false);
            result.setMessage("操作失败: " + e.getMessage());
        }
        return result;
    }

    public Result getUserMessages(Map<String, Object> paramMap) {
        // 获取当前登录用户的ID
        Integer userId = sdkOfGetCurrentUserId();
        // 构建查询SQL
        StringBuilder sql = new StringBuilder("SELECT id, status, message_content, created_at FROM message_list WHERE user_id = ? ORDER BY id desc, created_at DESC");
        List<Object> params = new ArrayList<>();
        params.add(userId);
        // 执行查询
        List<Map<String, Object>> data = executeSQL(sql.toString(), params.toArray());
        // 返回结果
        Result result = new Result();
        result.setFlag(true);
        result.setMessage("查询成功");
        result.setData(data);
        return result;
    }

    public Result getUserMessagesByPage(Map<String, Object> paramMap) {
        // 获取分页参数
        Integer current = paramMap.get("current") != null ? Integer.valueOf(String.valueOf(paramMap.get("current"))) : 1;
        Integer pageSize = paramMap.get("pageSize") != null ? Integer.valueOf(String.valueOf(paramMap.get("pageSize"))) : 10;
        // 获取当前登录用户的ID
        Integer userId = sdkOfGetCurrentUserId();
        // 构建查询SQL
        StringBuilder sql = new StringBuilder("SELECT id, status, message_content, created_at FROM message_list WHERE user_id = ? ORDER BY created_at desc, id DESC");
        List<Object> params = new ArrayList<>();
        params.add(userId);
        // 获取总条数
        int total = sdkOfPaginationQueryCount(sql.toString(), params.toArray());
        // 添加分页参数
        sql.append(" LIMIT ?, ?");
        List<Object> paginatedParams = new ArrayList<>(params);
        paginatedParams.add((current - 1) * pageSize);
        paginatedParams.add(pageSize);
        // 执行查询
        List<Map<String, Object>> data = executeSQL(sql.toString(), paginatedParams.toArray());
        // 构建返回结果
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("total", total);
        resultData.put("data", data);
        Result result = new Result();
        result.setFlag(true);
        result.setMessage("查询成功");
        result.setData(resultData);
        return result;
    }

    public Result updateAllMessagesToRead(Map<String, Object> paramMap) {
        // 获取当前登录用户的ID
        Integer userId = sdkOfGetCurrentUserId();
        // 构建SQL语句，将当前用户的所有未读消息状态改为已读
        StringBuilder sql = new StringBuilder("UPDATE message_list SET status = '已读' WHERE user_id = ? AND status = '未读'");
        // 执行SQL语句
        int updatedRows = executeSQL(sql.toString(), userId);
        // 返回结果
        Result result = new Result();
        result.setFlag(true);
        result.setMessage("所有未读消息已标记为已读");
        return result;
    }

    public Result getUserInformation(Map<String, Object> paramMap) {
        // 获取当前登录用户的ID
        Integer userId = sdkOfGetCurrentUserId();
        if(userId == null){
            return Result.buildError(ErrorCodeEnum.NO_LOGIN);
        }
        // 构建查询用户信息的SQL
        StringBuilder sql = new StringBuilder("SELECT id, user_name, nick_name, email, mobile, phone FROM users WHERE id = ?");
        List<Object> params = new ArrayList<>();
        params.add(userId);
        // 执行SQL查询
        List<Map<String, Object>> result = executeSQL(sql.toString(), params.toArray());
        // 检查查询结果
        if (result == null || result.isEmpty()) {
            return new Result(false, "用户信息未找到", null);
        }
        // 获取用户信息
        Map<String, Object> userInfo = result.get(0);
        // 构建返回数据
        Map<String, Object> data = new HashMap<>();
        data.put("AccountNumbervalue1", userInfo.get("user_name") != null ? String.valueOf(userInfo.get("user_name")) : "");
        data.put("Nicknamevalue1", userInfo.get("nick_name") != null ? String.valueOf(userInfo.get("nick_name")) : "");
        data.put("Emailvalue1", userInfo.get("email") != null ? String.valueOf(userInfo.get("email")) : "");
        data.put("Mobilephonenumbervalue1", userInfo.get("mobile") != null ? String.valueOf(userInfo.get("mobile")) : "");
        data.put("Telephonevalue1", userInfo.get("phone") != null ? String.valueOf(userInfo.get("phone")) : "");
        // 返回结果
        return new Result(true, "用户信息获取成功", data);
    }

    public Result updateUserInformation(Map<String, Object> paramMap) {
        // 获取当前登录用户的ID和用户名
        Integer userId = sdkOfGetCurrentUserId();
        String currentUserName = sdkOfGetCurrentUserName();
        // 从paramMap中获取表单数据
        String accountNumber = paramMap.get("AccountNumbervalue1") != null ? String.valueOf(paramMap.get("AccountNumbervalue1")) : null;
        String nickname = paramMap.get("Nicknamevalue1") != null ? String.valueOf(paramMap.get("Nicknamevalue1")) : null;
        String password = paramMap.get("Passwordvalue1") != null && StrUtil.isNotBlank(String.valueOf(paramMap.get("Passwordvalue1"))) ? String.valueOf(paramMap.get("Passwordvalue1")) : null;
        String email = paramMap.get("Emailvalue1") != null ? String.valueOf(paramMap.get("Emailvalue1")) : null;
        String mobile = paramMap.get("Mobilephonenumbervalue1") != null ? String.valueOf(paramMap.get("Mobilephonenumbervalue1")) : null;
        String phone = paramMap.get("Telephonevalue1") != null ? String.valueOf(paramMap.get("Telephonevalue1")) : null;
        // 构建更新SQL
        StringBuilder sql = new StringBuilder("UPDATE users SET ");
        List<Object> params = new ArrayList<>();
        if (accountNumber != null) {
            sql.append("user_name = ?, ");
            params.add(accountNumber);
        }
        if (nickname != null) {
            sql.append("nick_name = ?, ");
            params.add(nickname);
        }
        if (password != null) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword =  encoder.encode(password);
            sql.append("password = ?, ");
            params.add(encodedPassword);
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
        // 移除最后一个逗号和空格
        if (sql.toString().endsWith(", ")) {
            sql.setLength(sql.length() - 2);
        }
        // 设置最后修改时间和最后修改者用户名
        sql.append(" , update_time = NOW(), update_username = ? WHERE id = ?");
        params.add(currentUserName);
        params.add(userId);
        // 执行更新SQL
        int updateRows = executeSQL(sql.toString(), params.toArray());
        // 返回结果
        if (updateRows > 0) {
            return new Result(true, "用户信息更新成功", null);
        } else {
            return new Result(false, "用户信息更新失败", null);
        }
    }
}
