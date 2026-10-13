package com.gemcoder.system.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.DepotBoardService;

/**
 * 车场看板
 * @author jiang
 *
 *查询参数说明
 *sector  版块
 *parking_lot_status 状态
 *parking_lot_type 类型
 *parking_lot_name，id 车场
 */
@Controller
@RequestMapping("/DepotBoard")
public class DepotBoardController {
	@Resource
	DepotBoardService depotBoardService;
	
	/**
	 * 概要
	 * @return
	 */
	@RequestMapping(value = "/getSummary")
    @ResponseBody
	public Result getSummary(@RequestBody(required = false) Map<String, Object> paramMap) {
		return depotBoardService.getSummary(paramMap);
	}
	/**
	 * 车辆业务分析饼图
	 * @return
	 */
	@RequestMapping(value = "/getVehicleTypePie")
    @ResponseBody
	public Result getVehicleTypePie(@RequestBody(required = false) Map<String, Object> paramMap) {
		
		return depotBoardService.getVehicleTypePie(paramMap);
	}
	/**
	 * 停留时长柱状图
	 * @return
	 */
	@RequestMapping(value = "/getStatTimeBar")
    @ResponseBody
	public Result getStatTimeBar(@RequestBody(required = false) Map<String, Object> paramMap) {
		
		return depotBoardService.getStatTimeBar(paramMap);
	}
	/**
	 * 车场资源
	 * @return
	 */
	@RequestMapping(value = "/getParkResource")
    @ResponseBody
	public Result getParkResource(@RequestBody(required = false) Map<String, Object> paramMap) {
		
		return depotBoardService.getParkResource(paramMap);
	}
	/**
	 * 车辆流入流出折线图
	 * @return
	 */
	@RequestMapping(value = "/getInOutFlow")
    @ResponseBody
	public Result getInOutFlow(@RequestBody(required = false) Map<String, Object> paramMap) {
		
		return depotBoardService.getInOutFlow(paramMap);
	}
	/**
	 * 异常订单柱状图
	 * @return
	 */
	@RequestMapping(value = "/getErrorOrderBar")
    @ResponseBody
	public Result getErrorOrderBar(@RequestBody(required = false) Map<String, Object> paramMap) {
		
		return depotBoardService.getErrorOrderBar(paramMap);
	}
	
	/**
	 * 有效利用率趋势
	 * @return
	 */
	@RequestMapping(value = "/getEfficiencyRatio")
    @ResponseBody
	public Result getEfficiencyRatio(@RequestBody(required = false) Map<String, Object> paramMap) {
		
		return depotBoardService.getEfficiencyRatio(paramMap);
	}
	/**
	 * 周转率趋势
	 * @return
	 */
	@RequestMapping(value = "/getTurnoverRatio")
    @ResponseBody
	public Result getTurnoverRatio(@RequestBody(required = false) Map<String, Object> paramMap) {
		
		return depotBoardService.getTurnoverRatio(paramMap);
	}
}
