package com.gemcoder.system.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.CameraEquipmentService;

@Controller
@RequestMapping("/CameraEquipment")
public class CameraEquipmentController {
	 @Resource
	private CameraEquipmentService cameraEquipmentService;
	@RequestMapping(value = "/getCameraEquipmentList")
    @ResponseBody
    public Result getCameraEquipmentList(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return cameraEquipmentService.getCameraEquipmentList(paramMap);
    }
	@RequestMapping(value = "/getAllCameraEquipment")
	@ResponseBody
	public Result getAllCameraEquipment(@RequestBody(required = false) Map<String, Object> paramMap) {
		//如果有需要校验的入参, 请在这里补充代码进行校验
		//调用service层的代码
		return cameraEquipmentService.getAllCameraEquipment();
	}
	@RequestMapping(value = "/getAllInuseCameraEquipment")
	@ResponseBody
	public Result getAllInuseCameraEquipment(@RequestBody(required = false) Map<String, Object> paramMap) {
		//如果有需要校验的入参, 请在这里补充代码进行校验
		//调用service层的代码
		return cameraEquipmentService.getAllInuseCameraEquipment();
	}
}
