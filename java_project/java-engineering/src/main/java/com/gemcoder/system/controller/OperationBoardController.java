package com.gemcoder.system.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.DepotBoardService;
import com.gemcoder.system.service.OperationBoardService;
/**
 * 车场看板
 * @author jiang
 *
 */
@Controller
@RequestMapping("/OperationBoard")
public class OperationBoardController {
	
	@Resource
	OperationBoardService operationBoardService;
	
	/**
	 * 概要
	 * @return
	 */
	@RequestMapping(value = "/getSummary")
    @ResponseBody
	public Result getSummary(@RequestBody(required = false) Map<String, Object> paramMap) {
		return operationBoardService.getSummary(paramMap);
	}
	/**
	 * 应收金额
	 * @param paramMap
	 * @return
	 */
	@RequestMapping(value = "/getAmountReceivable")
    @ResponseBody
	public Result getAmountReceivable(@RequestBody(required = false)  Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return operationBoardService.getAmountReceivable(paramMap);
	}
	/**
	 * 实收金额
	 * @param paramMap
	 * @return
	 */
	@RequestMapping(value = "/getAmountReceived")
    @ResponseBody
	public Result getAmountReceived(@RequestBody(required = false)  Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return operationBoardService.getAmountReceived(paramMap);
	}
	/**
	 * 收缴率
	 * @param paramMap
	 * @return
	 */
	@RequestMapping(value = "/getReceiveAmountRatio")
	@ResponseBody
	public Result getReceiveAmountRatio(@RequestBody(required = false)  Map<String, Object> paramMap) {
		return operationBoardService.getReceiveAmountRatio(paramMap);
	}
	/**
	 * 服务车次
	 * @param paramMap
	 * @return
	 */
	@RequestMapping(value = "/getServVehicleCount")
	@ResponseBody
	public Result getServVehicleCount(@RequestBody(required = false)  Map<String, Object> paramMap) {
		return operationBoardService.getServVehicleCount(paramMap);
	}
	@RequestMapping(value = "/getYardList")
	@ResponseBody
	public Result getYardList(@RequestBody(required = false)  Map<String, Object> paramMap) {
		return operationBoardService.getYardList(paramMap);
	}
}
