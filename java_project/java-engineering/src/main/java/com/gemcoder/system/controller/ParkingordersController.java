package com.gemcoder.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;
import javax.annotation.Resource;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.ParkingordersService;
import java.util.Map;

@Controller
@RequestMapping("/Parkingorders")
public class ParkingordersController {

    @Resource
    private ParkingordersService ParkingordersService;

    @RequestMapping(value = "/getParkingOrders")
    @ResponseBody
    public Result getParkingOrders(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return ParkingordersService.getParkingOrders(paramMap);
    }

    @RequestMapping(value = "/queryParkingOrders")
    @ResponseBody
    public Result queryParkingOrders(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return ParkingordersService.queryParkingOrders(paramMap);
    }

    @RequestMapping(value = "/getOrderPaymentRecords")
    @ResponseBody
    public Result getOrderPaymentRecords(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return ParkingordersService.getOrderPaymentRecords(paramMap);
    }

    @RequestMapping(value = "/getBillingDetails")
    @ResponseBody
    public Result getBillingDetails(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return ParkingordersService.getBillingDetails(paramMap);
    }

    @RequestMapping(value = "/getOrderOperationRecords")
    @ResponseBody
    public Result getOrderOperationRecords(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return ParkingordersService.getOrderOperationRecords(paramMap);
    }

    @RequestMapping(value = "/getParkingOrdersZFS")
    @ResponseBody
    public Result getParkingOrdersZFS(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return ParkingordersService.queryParkingOrders(paramMap);
    }

    @RequestMapping(value = "/getOrderDetails")
    @ResponseBody
    public Result getOrderDetails(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return ParkingordersService.getOrderDetails(paramMap);
    }

    @RequestMapping(value = "/updateOrderPaymentStatus")
    @ResponseBody
    public Result updateOrderPaymentStatus(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return ParkingordersService.updateOrderPaymentStatus(paramMap);
    }

    @RequestMapping(value = "/updateRefundAmount")
    @ResponseBody
    public Result updateRefundAmount(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return ParkingordersService.updateRefundAmount(paramMap);
    }
    /**
     * 完成订单
     * @param paramMap
     * @return
     */
    @RequestMapping(value = "/completeOrder")
    @ResponseBody
    public Result completeOrder(@RequestBody(required = false) Map<String, Object> paramMap) {
    	//如果有需要校验的入参, 请在这里补充代码进行校验
    	//调用service层的代码
    	return ParkingordersService.completeOrder(paramMap);
    }
    /**
     * 结算订单
     * @param paramMap
     * @return
     */
    @RequestMapping(value = "/settlementOrder")
    @ResponseBody
    public Result settlementOrder(@RequestBody(required = false) Map<String, Object> paramMap) {
    	//如果有需要校验的入参, 请在这里补充代码进行校验
    	//调用service层的代码
    	return ParkingordersService.settlementOrder(paramMap);
    }
    @RequestMapping(value = "/closeOrder")
    @ResponseBody
    public Result closeOrder(@RequestBody(required = false) Map<String, Object> paramMap) {
    	//如果有需要校验的入参, 请在这里补充代码进行校验
    	//调用service层的代码
    	return ParkingordersService.closeOrder(paramMap);
    }
}
