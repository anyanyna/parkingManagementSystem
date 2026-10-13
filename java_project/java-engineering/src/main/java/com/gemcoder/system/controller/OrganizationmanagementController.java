package com.gemcoder.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;
import javax.annotation.Resource;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.OrganizationmanagementService;
import cn.hutool.core.util.StrUtil;
import java.util.Map;

@Controller
@RequestMapping("/Organizationmanagement")
public class OrganizationmanagementController {

    @Resource
    private OrganizationmanagementService OrganizationmanagementService;

    @RequestMapping(value = "/getOrganizations")
    @ResponseBody
    public Result getOrganizations(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return OrganizationmanagementService.getOrganizations(paramMap);
    }

    @RequestMapping(value = "/getSystemUsers")
    @ResponseBody
    public Result getSystemUsers(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return OrganizationmanagementService.getSystemUsers(paramMap);
    }

    @RequestMapping(value = "/addOrganization")
    @ResponseBody
    public Result addOrganization(@RequestBody(required = false) Map<String, Object> paramMap) {
        // 校验 OrganizationNamevalue1 是否存在且不为空
        if (paramMap.get("OrganizationNamevalue1") == null || String.valueOf(paramMap.get("OrganizationNamevalue1")).trim().isEmpty()) {
            return new Result(false, "组织机构名称必填", null);
        }
        // 校验 Sortvalue1 是否存在且不为空
        if (paramMap.get("Sortvalue1") == null || String.valueOf(paramMap.get("Sortvalue1")).trim().isEmpty()) {
            return new Result(false, "排序必填", null);
        }
        // 调用service层的代码
        return OrganizationmanagementService.addOrganization(paramMap);
    }

    @RequestMapping(value = "/getOrganizationsCG6")
    @ResponseBody
    public Result getOrganizationsCG6(@RequestBody(required = false) Map<String, Object> paramMap) {
        // 该接口没有需要校验的参数
        // 调用service层的代码
        return OrganizationmanagementService.getOrganizationsCG6(paramMap);
    }

    @RequestMapping(value = "/getOrganizationsUVU")
    @ResponseBody
    public Result getOrganizationsUVU(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return OrganizationmanagementService.getOrganizationsRTB(paramMap);
    }

    @RequestMapping(value = "/updateOrganization")
    @ResponseBody
    public Result updateOrganization(@RequestBody(required = false) Map<String, Object> paramMap) {
        // 校验组织机构名称是否为空
        if (paramMap.get("OrganizationNamevalue2") == null || String.valueOf(paramMap.get("OrganizationNamevalue2")).trim().isEmpty()) {
            return new Result(false, "组织机构名称必填", null);
        }
        // 校验排序是否为空
        if (paramMap.get("Sortvalue2") == null || String.valueOf(paramMap.get("Sortvalue2")).trim().isEmpty()) {
            return new Result(false, "排序必填", null);
        }
        // 调用service层的代码
        return OrganizationmanagementService.updateOrganization(paramMap);
    }


    @RequestMapping(value = "/deleteOrganization")
    @ResponseBody
    public Result deleteOrganization(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return OrganizationmanagementService.deleteOrganization(paramMap);
    }

    @RequestMapping(value = "/getRootOrganizations")
    @ResponseBody
    public Result getRootOrganizations(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return OrganizationmanagementService.getRootOrganizations(paramMap);
    }

    @RequestMapping(value = "/getChildOrganizations")
    @ResponseBody
    public Result getChildOrganizations(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return OrganizationmanagementService.getChildOrganizations(paramMap);
    }

    @RequestMapping(value = "/getOrganizationsRTB")
    @ResponseBody
    public Result getOrganizationsRTB(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return OrganizationmanagementService.getOrganizationsRTB(paramMap);
    }

    @RequestMapping(value = "/getSystemUsersDB2")
    @ResponseBody
    public Result getSystemUsersDB2(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return OrganizationmanagementService.getSystemUsersDB2(paramMap);
    }
}
