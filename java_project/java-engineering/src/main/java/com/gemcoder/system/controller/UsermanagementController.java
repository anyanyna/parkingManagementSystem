package com.gemcoder.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;
import javax.annotation.Resource;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.UsermanagementService;
import cn.hutool.core.util.StrUtil;
import java.util.Map;
import cn.hutool.core.util.ObjectUtil;

@Controller
@RequestMapping("/Usermanagement")
public class UsermanagementController {

    @Resource
    private UsermanagementService UsermanagementService;

    @RequestMapping(value = "/updateUserRoles")
    @ResponseBody
    public Result updateUserRoles(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return UsermanagementService.updateUserRoles(paramMap);
    }

    @RequestMapping(value = "/getUsers")
    @ResponseBody
    public Result getUsers(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return UsermanagementService.getUsers(paramMap);
    }

    @RequestMapping(value = "/showEditUserModal")
    @ResponseBody
    public Result showEditUserModal(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return UsermanagementService.showEditUserModal(paramMap);
    }

    @RequestMapping(value = "/deleteUser")
    @ResponseBody
    public Result deleteUser(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return UsermanagementService.deleteUser(paramMap);
    }

    @RequestMapping(value = "/addUser")
    @ResponseBody
    public Result addUser(@RequestBody(required = false) Map<String, Object> paramMap) {
        // 校验 nickName 是否必填
        if (paramMap.get("nickName") == null || String.valueOf(paramMap.get("nickName")).trim().isEmpty()) {
            return new Result(false, "昵称必填", null);
        }
        // 校验 password 是否必填
        if (paramMap.get("password") == null || String.valueOf(paramMap.get("password")).trim().isEmpty()) {
            return new Result(false, "密码必填", null);
        }
        //调用service层的代码
        return UsermanagementService.addUser(paramMap);
    }

    @RequestMapping(value = "/updateUser")
    @ResponseBody
    public Result updateUser(@RequestBody(required = false) Map<String, Object> paramMap) {
        //调用service层的代码
        return UsermanagementService.updateUser(paramMap);
    }

    @RequestMapping(value = "/resetUserPassword")
    @ResponseBody
    public Result resetUserPassword(@RequestBody(required = false) Map<String, Object> paramMap) {
        // 校验 newPassword 是否必填
        if (paramMap.get("newPassword") == null || String.valueOf(paramMap.get("newPassword")).trim().isEmpty()) {
            return new Result(false, "新密码必填", null);
        }
        //调用service层的代码
        return UsermanagementService.resetUserPassword(paramMap);
    }

    @RequestMapping(value = "/getOrgTreeData")
    @ResponseBody
    public Result getOrgTreeData(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return UsermanagementService.getOrgTreeData(paramMap);
    }

    @RequestMapping(value = "/toggleUserStatus")
    @ResponseBody
    public Result toggleUserStatus(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return UsermanagementService.toggleUserStatus(paramMap);
    }

    @RequestMapping(value = "/getUsersL12")
    @ResponseBody
    public Result getUsersL12(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return UsermanagementService.getUsers(paramMap);
    }

    @RequestMapping(value = "/getUserRoles")
    @ResponseBody
    public Result getUserRoles(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return UsermanagementService.getUserRoles(paramMap);
    }

    @RequestMapping(value = "/getAllRoles")
    @ResponseBody
    public Result getAllRoles(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return UsermanagementService.getAllRoles(paramMap);
    }

    @RequestMapping(value = "/showResetPasswordModal")
    @ResponseBody
    public Result showResetPasswordModal(@RequestBody(required = false) Map<String, Object> paramMap) {
        // 校验NewPasswordvalue1字段是否存在且不为空
        if (paramMap.get("NewPasswordvalue1") == null || String.valueOf(paramMap.get("NewPasswordvalue1")).trim().isEmpty()) {
            return new Result(false, "必填", null);
        }
        // 调用service层的代码
        return UsermanagementService.showResetPasswordModal(paramMap);
    }
}
