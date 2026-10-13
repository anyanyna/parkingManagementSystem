package com.gemcoder.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.Map;
import javax.annotation.Resource;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.BusinesslogicService;
import java.util.Map;

@Controller
@RequestMapping("/Businesslogic")
public class BusinesslogicController {

    @Resource
    private BusinesslogicService BusinesslogicService;

    @RequestMapping(value = "/generateLicensePlate")
    @ResponseBody
    public Result generateLicensePlate(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BusinesslogicService.generateLicensePlate(paramMap);
    }

    @RequestMapping(value = "/createParkingOrder")
    @ResponseBody
    public Result createParkingOrder(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
    	
    	//测试代码
    	if(paramMap.get("parking_lot")==null) {
    		paramMap.put("parking_lot","测试停车场");
    	}
    	if(paramMap.get("parking_lot_id")==null) {
    		paramMap.put("parking_lot_id",3);
    	}
    	if(paramMap.get("license_plate_type")==null) {
    		paramMap.put("license_plate_type","蓝牌");
    	}
    	if(paramMap.get("entry_name")==null) {
    		paramMap.put("entry_name","入口1");
    	}
        return BusinesslogicService.createParkingOrder(paramMap);
    }

    @RequestMapping(value = "/queryVehicleOrder")
    @ResponseBody
    public Result queryVehicleOrder(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BusinesslogicService.queryVehicleOrder(paramMap);
    }

    @RequestMapping(value = "/updatePaymentStatus")
    @ResponseBody
    public Result updatePaymentStatus(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return BusinesslogicService.updatePaymentStatus(paramMap);
    }
    
    /**
     * 车辆进入
     * @param paramMap
     * @return
     */
    @RequestMapping(value = "/enterVehicle")
    @ResponseBody
    public Result enterVehicle(@RequestBody(required = false) Map<String, Object> paramMap) {
    	return null;
    }
    /**
     * 车辆离开
     * @param paramMap
     * @return
     */
    @RequestMapping(value = "/exitVehicle")
    @ResponseBody
    public Result exitVehicle(@RequestBody(required = false) Map<String, Object> paramMap) {
    	return null;
    }
    
    
}
