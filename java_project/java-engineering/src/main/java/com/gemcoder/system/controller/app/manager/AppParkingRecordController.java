package com.gemcoder.system.controller.app.manager;

import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.ParkingRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 停车记录
 *
 * @author chenjie
 */
@Controller
@RequestMapping("/appParkingRecord")
public class AppParkingRecordController {
    @Resource
    private ParkingRecordService parkingRecordService;

    /**
     * 获取停车场列表
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/getList")
    @ResponseBody
    public Result getList(@RequestBody JSONObject jsonObject) {
        return parkingRecordService.getList(jsonObject);
    }

    /**
     * 获取订单详情
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/getOrderDetail")
    @ResponseBody
    public Result getOrderDetail(@RequestParam("orderId") Integer id) {
        return parkingRecordService.getDetail(id);
    }
    /**
     * 获取计费明细
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/getBillingDetail")
    @ResponseBody
    public Result getBillingDetail(@RequestBody JSONObject jsonObject) {
        return parkingRecordService.getBillingDetail(jsonObject);
    }
}
