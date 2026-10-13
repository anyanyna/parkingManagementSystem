package com.gemcoder.system.controller.app.manager;

import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.AppHomePageService;
import com.gemcoder.system.service.DepotBoardService;
import com.gemcoder.system.service.VehicleListManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * app管理端首页
 * 
 * @author chenjie
 *
 */
@Controller
@RequestMapping("/appHomePage")
public class AppHomePageController {
	@Resource
	private VehicleListManagerService vehicleListManagerService;
	@Resource
	private DepotBoardService depotBoardService;
	@Resource
	private AppHomePageService appHomePageService;


	/**
	 * 获取停车场列表
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/getParkingList")
	@ResponseBody
	public Result getParkingList(@RequestParam(required = false ,name = "userName") String userName){
		return  vehicleListManagerService.getParkingList(userName,1);
	}

	/**
	 * 获取停车收入
	 */
	@RequestMapping(value = "/getIncome")
	@ResponseBody
	public Result getIncome(@RequestParam(required = false ,name = "parkingId") Integer parkingId){
		return  appHomePageService.getIncome(parkingId);
	}
	/**
	 * 获取订单状态
	 */
	@RequestMapping(value = "/getOrderStatus")
	@ResponseBody
	public Result getOrderStatus(@RequestParam(required = false ,name = "parkingId") Integer parkingId){
		return  appHomePageService.getOrderStatus(parkingId);
	}
	/**
	 * 获取车场流量
	 */
	@RequestMapping(value = "/getFlowRate")
	@ResponseBody
	public Result getFlowRate(@RequestParam(required = false ,name = "parkingId") Integer parkingId){
		return  appHomePageService.getFlowRate(parkingId);
	}

	/**
	 * 车场收入-收入汇总
	 */
	@RequestMapping(value = "/income/getIncomeByType")
	@ResponseBody
	public Result getIncomeByType(@RequestParam(required = false ,name = "parkingId") Integer parkingId,@RequestParam(name = "type") Integer type){
		return  appHomePageService.getIncomeByType(parkingId,type);
	}
	/**
	 * 车场收入-7日收入
	 */
	@RequestMapping(value = "/income/get7DayIncome")
	@ResponseBody
	public Result get7DayIncome(@RequestParam(required = false ,name = "parkingId") Integer parkingId){
		return  appHomePageService.get7DayIncome(parkingId);
	}
	/**
	 * 订单分析-订单汇总
	 */
	@RequestMapping(value = "/order/getOrderCount")
	@ResponseBody
	public Result getOrderCount(@RequestParam(required = false ,name = "parkingId") Integer parkingId,@RequestParam(name = "type") Integer type){
		return  appHomePageService.getOrderCount(parkingId,type);
	}
	/**
	 * 订单分析-利用率
	 */
	@RequestMapping(value = "/order/get7DayUtilizationRate")
	@ResponseBody
	public Result get7DayUtilizationRate(@RequestParam(required = false ,name = "parkingId") Integer parkingId){
		return  appHomePageService.get7DayUtilizationRate(parkingId);
	}
	/**
	 * 订单分析-利用率
	 */
	@RequestMapping(value = "/order/get7DayTurnoverRate")
	@ResponseBody
	public Result get7DayTurnoverRate(@RequestParam(required = false ,name = "parkingId") Integer parkingId){
		return  appHomePageService.get7DayTurnoverRate(parkingId);
	}
}
