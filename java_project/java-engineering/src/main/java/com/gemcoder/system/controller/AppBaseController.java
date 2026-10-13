package com.gemcoder.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.AppBaseService;
import com.gemcoder.system.service.ParkingordersService;
import com.gemcoder.system.service.PayQueryService;
import com.gemcoder.system.util.OrderPaymentChannelConstant;

/**
 * 应用基本接口
 * 
 * @author jiang
 *
 */
@Controller
@RequestMapping("/AppBase")
public class AppBaseController {
	@Resource
	AppBaseService appBaseService;
	@Resource
	ParkingordersService parkingordersService;
	@Resource
	PayQueryService payQueryService;

	/**
	 * 返回当前车牌 ;入参 cam_id （道闸编号）
	 * 
	 * @param paramMap
	 * @return
	 */
	//@CrossOrigin
	@RequestMapping(value = "/currentPlate")
	@ResponseBody
	public Result currentPlate(@RequestBody(required = false) Map<String, Object> paramMap) {
		String cam_id = (String) paramMap.get("cam_id");
		if (cam_id == null) {
			return new Result(false, "道闸编号必填!", null);
		}
		return appBaseService.currentPlate(cam_id);
	}

	/**
	 * 返回车场详情 ;入参 id （车场id）
	 * 
	 * @param paramMap
	 * @return
	 */
	//@CrossOrigin
	@RequestMapping(value = "/yardDetail")
	@ResponseBody
	public Result yardDetail(@RequestBody(required = false) Map<String, Object> paramMap) {
		Integer yardId = (Integer) paramMap.get("id");
		if (yardId == null) {
			return new Result(false, "车场ID必填!", null);
		}
		return appBaseService.yardDetail(yardId);
	}

	/**
	 * 返回车辆进场成功或失败，后台创建订单;入参 id （车场id），cam_id（道闸编号），plate_num （车牌）
	 * TODO 拍到车牌自动进场的流程
	 * @param paramMap
	 * @return
	 */
	//@CrossOrigin
	@RequestMapping(value = "/vehicleInYard")
	@ResponseBody
	public Result vehicleInYard(@RequestBody(required = false) Map<String, Object> paramMap) {
		Integer yardId = (Integer) paramMap.get("id");
		if (yardId == null) {
			return new Result(false, "车场ID必填!", null);
		}
		String cam_id = (String) paramMap.get("cam_id");
		if (cam_id == null) {
			return new Result(false, "道闸编号必填!", null);
		}
		String plate_num = (String) paramMap.get("plate_num");
		if (plate_num == null) {
			return new Result(false, "车牌必填!", null);
		}
		return appBaseService.vehicleInYard(yardId, cam_id, plate_num,"蓝牌");
	}

	/**
	 * 返回订单信息;入参 id （车场id），plate_num （车牌
	 * 
	 * @param paramMap
	 * @return
	 */
	//@CrossOrigin
	@RequestMapping(value = "/userOrderOutYard")
	@ResponseBody
	public Result userOrderOutYard(@RequestBody(required = false) Map<String, Object> paramMap) {
		Integer yardId = (Integer) paramMap.get("id");
		if (yardId == null) {
			return new Result(false, "车场ID必填!", null);
		}
		String plate_num = (String) paramMap.get("plate_num");
		if (plate_num == null) {
			return new Result(false, "车牌必填!", null);
		}
		return appBaseService.userOrderOutYard(yardId, plate_num);
	}

	/**
	 * 返回结算后的订单信息，后台根基传参进行订单结算;入参 id （订单id）
	 * 
	 * @param paramMap
	 * @return
	 */
	//@CrossOrigin
	@RequestMapping(value = "/settlement")
	@ResponseBody
	public Result settlement(@RequestBody(required = false) Map<String, Object> paramMap) {
		Integer orderId = (Integer) paramMap.get("id");
		if (orderId == null) {
			return new Result(false, "订单ID必填!", null);
		}
		return appBaseService.settlement(orderId, OrderPaymentChannelConstant.online);
	}
	//@CrossOrigin
	@RequestMapping(value = "/advanceSettlement")
	@ResponseBody
	public Result advanceSettlement(@RequestBody(required = false) Map<String, Object> paramMap) {
		Integer orderId = (Integer) paramMap.get("id");
		if (orderId == null) {
			return new Result(false, "订单ID必填!", null);
		}
		return appBaseService.settlement(orderId, OrderPaymentChannelConstant.onlineAdvance);
	}
	
	/**
	 * 出场抬杆
	 * @param paramMap
	 * @return
	 */
	//@CrossOrigin
	@RequestMapping(value = "/openOutBarier")
	@ResponseBody
	public Result openOutBarier(@RequestBody(required = false) Map<String, Object> paramMap) {
		String plate_num = (String) paramMap.get("plate_num");
		String cam_id = (String) paramMap.get("cam_id");
		if (plate_num == null) {
			return new Result(false, "车牌，必填!", null);
		}
		if (cam_id == null) {
			return new Result(false, "道闸，必填!", null);
		}
		Integer orderId = (Integer) paramMap.get("id");
		if (orderId == null) {
			return new Result(false, "订单ID必填!", null);
		}
		return appBaseService.openOutBarier(orderId,plate_num, cam_id);
	}
	
	//@CrossOrigin
	@RequestMapping(value = "/openOrderStatus")
	@ResponseBody
	public Result openOrderStatus(@RequestBody(required = false) Map<String, Object> paramMap) {
		Integer orderId = (Integer) paramMap.get("id");
		if (orderId == null) {
			return new Result(false, "订单ID必填!", null);
		}
		boolean b= payQueryService.queryPayStatusByOrderId(orderId);
		if(b) {
			return new Result(true, "支付完成。", "支付完成。");
		}else {
			return new Result(true, "支付未完成。", "支付未完成。");
		}
	}
	
}
