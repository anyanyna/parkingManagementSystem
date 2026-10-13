package com.gemcoder.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;
import javax.annotation.Resource;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.VehiclemanagementService;
import java.util.Map;

@Controller
@RequestMapping("/Vehiclemanagement")
public class VehiclemanagementController{

  @Resource private VehiclemanagementService VehiclemanagementService;

  

	@RequestMapping(value = "/getVehicleList")
	@ResponseBody
	public Result getVehicleList(@RequestBody(required = false) Map<String,Object> paramMap) {
		
		//如果有需要校验的入参, 请在这里补充代码进行校验

    //调用service层的代码

    	return VehiclemanagementService.getVehicleList(paramMap);
	}
   

	@RequestMapping(value = "/exportVehicleList")
	@ResponseBody
	public Result exportVehicleList(@RequestBody(required = false) Map<String,Object> paramMap) {
		
		//如果有需要校验的入参, 请在这里补充代码进行校验

    //调用service层的代码

    	return VehiclemanagementService.exportVehicleList(paramMap);
	}
   

	@RequestMapping(value = "/getFilteredVehicleList")
	@ResponseBody
	public Result getFilteredVehicleList(@RequestBody(required = false) Map<String,Object> paramMap) {
		
		//如果有需要校验的入参, 请在这里补充代码进行校验

    //调用service层的代码

    	return VehiclemanagementService.getFilteredVehicleList(paramMap);
	}
   

	@RequestMapping(value = "/getAllVehicleEntries")
	@ResponseBody
	public Result getAllVehicleEntries(@RequestBody(required = false) Map<String,Object> paramMap) {
		
		//如果有需要校验的入参, 请在这里补充代码进行校验

    //调用service层的代码

    	return VehiclemanagementService.getAllVehicleEntries(paramMap);
	}
   

	@RequestMapping(value = "/getPaginatedVehicleList")
	@ResponseBody
	public Result getPaginatedVehicleList(@RequestBody(required = false) Map<String,Object> paramMap) {
		
		//如果有需要校验的入参, 请在这里补充代码进行校验

    //调用service层的代码

    	return VehiclemanagementService.getPaginatedVehicleList(paramMap);
	}
   
	//停车场列表
	@RequestMapping(value = "/getDepotList")
	@ResponseBody
	public Result getDepotList(@RequestBody(required = false) Map<String,Object> paramMap) {
		
		//如果有需要校验的入参, 请在这里补充代码进行校验

    //调用service层的代码

    	return VehiclemanagementService.getDepotList(paramMap);
	}
}
