package com.gemcoder.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;
import javax.annotation.Resource;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.MenumanagementService;
import java.util.Map;

@Controller
@RequestMapping("/Menumanagement")
public class MenumanagementController{

  @Resource private MenumanagementService MenumanagementService;



	@RequestMapping(value = "/addMenu")
	@ResponseBody
	public Result addMenu(@RequestBody(required = false) Map<String,Object> paramMap) {

		//如果有需要校验的入参, 请在这里补充代码进行校验

		//调用service层的代码

		return MenumanagementService.addMenu(paramMap);
	}

	@RequestMapping(value = "/getAllPages")
	@ResponseBody
	public Result getAllPages(@RequestBody(required = false) Map<String,Object> paramMap) {

		//如果有需要校验的入参, 请在这里补充代码进行校验

		//调用service层的代码

		return MenumanagementService.getAllPages(paramMap);
	}

  

	@RequestMapping(value = "/getMenus")
	@ResponseBody
	public Result getMenus(@RequestBody(required = false) Map<String,Object> paramMap) {
		
		//如果有需要校验的入参, 请在这里补充代码进行校验

    //调用service层的代码

    	return MenumanagementService.searchMenus(paramMap);
	}
	@RequestMapping(value = "/getMenuTree")
	@ResponseBody
	public Result getMenuTree() {

		//如果有需要校验的入参, 请在这里补充代码进行校验

    //调用service层的代码

    	return MenumanagementService.getMenuTree();
	}
   

	@RequestMapping(value = "/searchMenus")
	@ResponseBody
	public Result searchMenus(@RequestBody(required = false) Map<String,Object> paramMap) {
		
		//如果有需要校验的入参, 请在这里补充代码进行校验

    //调用service层的代码

    	return MenumanagementService.searchMenus(paramMap);
	}
   

	@RequestMapping(value = "/updateMenu")
	@ResponseBody
	public Result updateMenu(@RequestBody(required = false) Map<String,Object> paramMap) {
		
		// 校验 menuName 是否存在
    if (paramMap.get("menuName") == null || String.valueOf(paramMap.get("menuName")).trim().isEmpty()) {
        return new Result(false, "菜单名称必填!", null);
    }
    
    // 校验 sortOrder 是否存在
    if (paramMap.get("sortOrder") == null) {
        return new Result(false, "排序必填!", null);
    }

    //调用service层的代码

    	return MenumanagementService.updateMenu(paramMap);
	}
   

	@RequestMapping(value = "/deleteMenu")
	@ResponseBody
	public Result deleteMenu(@RequestBody(required = false) Map<String,Object> paramMap) {
		
		//如果有需要校验的入参, 请在这里补充代码进行校验

    //调用service层的代码

    	return MenumanagementService.deleteMenu(paramMap);
	}
   

}
