package com.gemcoder.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;
import javax.annotation.Resource;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.RolemanagementService;
import java.util.Map;

@Controller
@RequestMapping("/Rolemanagement")
public class RolemanagementController{

  @Resource private RolemanagementService RolemanagementService;

  

	@RequestMapping(value = "/getRoles")
	@ResponseBody
	public Result getRoles(@RequestBody(required = false) Map<String,Object> paramMap) {
		
		//如果有需要校验的入参, 请在这里补充代码进行校验

    //调用service层的代码

    	return RolemanagementService.searchRolesByName(paramMap);
	}
   

	@RequestMapping(value = "/getRolesByPage")
	@ResponseBody
	public Result getRolesByPage(@RequestBody(required = false) Map<String,Object> paramMap) {
		
		//如果有需要校验的入参, 请在这里补充代码进行校验

    //调用service层的代码

    	return RolemanagementService.searchRolesByName(paramMap);
	}
   

	@RequestMapping(value = "/searchRolesByName")
	@ResponseBody
	public Result searchRolesByName(@RequestBody(required = false) Map<String,Object> paramMap) {
		
		//如果有需要校验的入参, 请在这里补充代码进行校验

    //调用service层的代码

    	return RolemanagementService.searchRolesByName(paramMap);
	}
   

	@RequestMapping(value = "/addRole")
	@ResponseBody
	public Result addRole(@RequestBody(required = false) Map<String,Object> paramMap) {
		
		// 校验 roleName 是否存在
    if (paramMap.get("roleName") == null || String.valueOf(paramMap.get("roleName")).trim().isEmpty()) {
        return new Result(false, "角色名称必填!", null);
    }
    // 校验 roleCode 是否存在
    if (paramMap.get("roleCode") == null || String.valueOf(paramMap.get("roleCode")).trim().isEmpty()) {
        return new Result(false, "角色代号必填!", null);
    }

    //调用service层的代码

    	return RolemanagementService.addRole(paramMap);
	}
   

	@RequestMapping(value = "/updateRole")
	@ResponseBody
	public Result updateRole(@RequestBody(required = false) Map<String,Object> paramMap) {
		
		// 校验 roleName 是否存在
    if (paramMap.get("roleName") == null || String.valueOf(paramMap.get("roleName")).trim().isEmpty()) {
        return new Result(false, "角色名称必填!", null);
    }

    //调用service层的代码

    	return RolemanagementService.updateRole(paramMap);
	}
   

	@RequestMapping(value = "/showEditRoleModal")
	@ResponseBody
	public Result showEditRoleModal(@RequestBody(required = false) Map<String,Object> paramMap) {
		
		//如果有需要校验的入参, 请在这里补充代码进行校验

    //调用service层的代码

    	return RolemanagementService.showEditRoleModal(paramMap);
	}
   

	@RequestMapping(value = "/deleteRole")
	@ResponseBody
	public Result deleteRole(@RequestBody(required = false) Map<String,Object> paramMap) {
		
		//如果有需要校验的入参, 请在这里补充代码进行校验

    //调用service层的代码

    	return RolemanagementService.deleteRole(paramMap);
	}
   

	@RequestMapping(value = "/getAllPermissions")
	@ResponseBody
	public Result getAllPermissions(@RequestBody(required = false) Map<String,Object> paramMap) {
		
		//如果有需要校验的入参, 请在这里补充代码进行校验

    //调用service层的代码

    	return RolemanagementService.getAllPermissions(paramMap);
	}

	@RequestMapping(value = "/getRolePermissions")
	@ResponseBody
	public Result getRolePermissions(@RequestBody(required = false) Map<String,Object> paramMap) {

		//如果有需要校验的入参, 请在这里补充代码进行校验

		//调用service层的代码

		return RolemanagementService.getRolePermissions(paramMap);
	}
   

	@RequestMapping(value = "/updateRolePermissions")
	@ResponseBody
	public Result updateRolePermissions(@RequestBody(required = false) Map<String,Object> paramMap) {
		
		//如果有需要校验的入参, 请在这里补充代码进行校验

    //调用service层的代码

    	return RolemanagementService.updateRolePermissions(paramMap);
	}
   

	@RequestMapping(value = "/getAllMenus")
	@ResponseBody
	public Result getAllMenus() {
		
		//如果有需要校验的入参, 请在这里补充代码进行校验

    //调用service层的代码

    	return RolemanagementService.getAllMenus();
	}
	@RequestMapping(value = "/getRoleMenus")
	@ResponseBody
	public Result getRoleMenus(@RequestBody(required = false) Map<String,Object> paramMap) {

		//如果有需要校验的入参, 请在这里补充代码进行校验

    //调用service层的代码

    	return RolemanagementService.getRoleMenus(paramMap);
	}
   

	@RequestMapping(value = "/updateRoleMenus")
	@ResponseBody
	public Result updateRoleMenus(@RequestBody(required = false) Map<String,Object> paramMap) {
		
		//如果有需要校验的入参, 请在这里补充代码进行校验

    //调用service层的代码

    	return RolemanagementService.updateRoleMenus(paramMap);
	}
   

}
