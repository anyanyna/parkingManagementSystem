package com.gemcoder.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;
import javax.annotation.Resource;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.AppusermanagementService;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import java.util.Map;

@Controller
@RequestMapping("/Appusermanagement")
public class AppusermanagementController {

    @Resource
    private AppusermanagementService AppusermanagementService;

    @RequestMapping(value = "/exportParkingUsers")
    @ResponseBody
    public Result exportParkingUsers(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return AppusermanagementService.exportParkingUsers(paramMap);
    }

    @RequestMapping(value = "/deactivateParkingUsers")
    @ResponseBody
    public Result deactivateParkingUsers(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return AppusermanagementService.deactivateParkingUsers(paramMap);
    }

    @RequestMapping(value = "/getParkingUsers")
    @ResponseBody
    public Result getParkingUsers(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return AppusermanagementService.getParkingUsers(paramMap);
    }

    @RequestMapping(value = "/searchParkingUsers")
    @ResponseBody
    public Result searchParkingUsers(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return AppusermanagementService.searchParkingUsers(paramMap);
    }

    @RequestMapping(value = "/enableParkingUsers")
    @ResponseBody
    public Result enableParkingUsers(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return AppusermanagementService.enableParkingUsers(paramMap);
    }

    @RequestMapping(value = "/getParkingOrderDetails")
    @ResponseBody
    public Result getParkingOrderDetails(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return AppusermanagementService.getParkingOrderDetails(paramMap);
    }

    @RequestMapping(value = "/enableParkingUser")
    @ResponseBody
    public Result enableParkingUser(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return AppusermanagementService.enableParkingUser(paramMap);
    }

    @RequestMapping(value = "/getParkingUsersJK1")
    @ResponseBody
    public Result getParkingUsersJK1(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return AppusermanagementService.getParkingUsers(paramMap);
    }

    @RequestMapping(value = "/deactivateParkingUser")
    @ResponseBody
    public Result deactivateParkingUser(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return AppusermanagementService.deactivateParkingUser(paramMap);
    }

    @RequestMapping(value = "/getParkingUsersE6W")
    @ResponseBody
    public Result getParkingUsersE6W(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return AppusermanagementService.getParkingUsersE6W(paramMap);
    }
}
