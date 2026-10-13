package com.gemcoder.system.controller;

import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.UserSdkService;
import com.gemcoder.system.service.permission.PermissionSdkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SystemPermissionController {

    public static boolean IS_PERMISSION_ENABLED = Boolean.TRUE;

    @GetMapping("/system/permission/enablePermission")
    public Result enablePermission() {
        IS_PERMISSION_ENABLED = !IS_PERMISSION_ENABLED;
        Result result = new Result();
        result.setFlag(true);
        result.setData(IS_PERMISSION_ENABLED);
        if(IS_PERMISSION_ENABLED){
            result.setMessage("权限开关已打开");
        }else {
            result.setMessage("权限开关已关闭");
        }
        return result;
    }

    @GetMapping("/system/permission/getCurrentPageNotShowVariable")
    public Result getCurrentPageNotShowVariable(@RequestParam("pageUuid") String pageUuid) {
        Result result = new Result();

        if(IS_PERMISSION_ENABLED) {
            String currentUser = UserSdkService.sdkOfGetCurrentUserName();
            if(currentUser == null){
                result.setFlag(false);
                result.setMessage("当前用户未登录");
                result.setData(new ArrayList<String>());
                return result;
            }
            List<String> roleCodes = PermissionSdkService.getRoleCodesByUserName(currentUser);
            List<String> variables = PermissionSdkService.getNotRefListByRoleCode(roleCodes, pageUuid);
            result.setFlag(true);
            result.setMessage("查询成功");
            result.setData(variables);
            return result;
        }else {
            result.setFlag(true);
            result.setMessage("查询成功");
            result.setData(new ArrayList<String>());
            return result;
        }
    }
    @GetMapping("/system/permission/getCurrentPageNotShowRef")
    public Result getCurrentPageNotShowRef(@RequestParam("pageUuid") String pageUuid) {
        Result result = new Result();

        if(IS_PERMISSION_ENABLED) {
            String currentUser = UserSdkService.sdkOfGetCurrentUserName();
            if(currentUser == null){
                result.setFlag(false);
                result.setMessage("当前用户未登录");
                result.setData(new ArrayList<String>());
                return result;
            }
            List<String> permissionCodes = PermissionSdkService.getPermissionsByUserName(currentUser);
            List<String> variables = PermissionSdkService.getNotRefListByPermissionCodes(permissionCodes, pageUuid);
            result.setFlag(true);
            result.setMessage("查询成功");
            result.setData(variables);
            return result;
        }else {
            result.setFlag(true);
            result.setMessage("查询成功");
            result.setData(new ArrayList<String>());
            return result;
        }
    }

    @GetMapping("/system/permission/getPermissionState")
    public Result getPermissionState() {
        Result result = new Result();
        result.setFlag(true);
        result.setData(IS_PERMISSION_ENABLED);
        result.setMessage("获取权限状态成功！");
        return result;
    }
}
