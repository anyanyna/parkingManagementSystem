package com.gemcoder.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.exception.ErrorCodeEnum;
import com.gemcoder.system.service.OrderUnusualService;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 异常数据  异常订单相关
 * @author xuezhonghao
 * @create 2024-12-20
 */
@Controller
@RequestMapping("/orderUnusual")
public class OrderUnusualController {

    private static final Logger log = LoggerFactory.getLogger(OrderUnusualController.class);

    @Resource
    private OrderUnusualService orderUnusualService;



    /**
     * 处理异常
     * @author XueZhongHao
     * @date 2024/12/23
     * @param jsonObject
     * @return com.gemcoder.system.bo.Result
     **/
    @PostMapping("/handleUnusual")
    @ResponseBody
    public Result handleUnusual(@RequestBody JSONObject jsonObject){
        log.info("/orderUnusual/handleUnusual=====>处理异常数据，接受参数：{}",jsonObject);
        String orderCode = jsonObject.getString("orderCode");
        String type = jsonObject.getString("type");// 0 忽略异常 1欠费追缴
        String plateNum = jsonObject.getString("plateNum");
        if(StringUtils.isEmpty(orderCode) || StringUtils.isEmpty(type) || StringUtils.isEmpty(plateNum)){
            return Result.buildError(ErrorCodeEnum.PARAMETER_MISSING);
        }
        Result result = orderUnusualService.handleUnusual(orderCode, type, plateNum);
        log.info("/orderUnusual/handleUnusual=====>处理异常数据，返回参数：{}",result);
        return result;
    }



    @PostMapping("/getPageInfo")
    @ResponseBody
    public Result getPageInfo(@RequestBody JSONObject jsonObject){
        log.info("/orderUnusual/getPageInfo=======>查询异常订单的分页数据，接收参数：{}",jsonObject);
        String userName = jsonObject.getString("userName");
        String phone = jsonObject.getString("phone");
        String plateNum = jsonObject.getString("plateNum");
        String type = jsonObject.getString("type");
        String orderType = jsonObject.getString("orderType");
        String parkingLot = jsonObject.getString("parkingLot");
        Date createTime1 = jsonObject.getDate("createTime1");
        Date createTime2 = jsonObject.getDate("createTime2");
        Integer currentPage = jsonObject.get("currentPage") != null ? jsonObject.getInteger("currentPage") : 1;
        Integer pageSize = jsonObject.get("pageSize") != null ? jsonObject.getInteger("pageSize") : 10;

        Result res = null;
        try {
            res = orderUnusualService.getPageInfo(userName,phone,plateNum,type,orderType,parkingLot,createTime1,createTime2,currentPage,pageSize);
            log.info("/orderUnusual/getPageInfo=======>查询异常订单的分页数据，返回参数：{}",res);
            return res;
        } catch (JSONException e) {
            log.info("/orderUnusual/getPageInfo=======>查询异常订单的分页数据，出错了：{}",e.getMessage());
            return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        }


    }



    /**
     * 根据车牌号查询最近5条订单
     * @author XueZhongHao
     * @date 2024/12/24
     * @param plateNum
     * @return com.gemcoder.system.bo.Result
     **/
    @GetMapping("/getFiveUserOrder")
    @ResponseBody
    public Result getFiveUserOrder(@RequestParam String plateNum){
        return orderUnusualService.getFiveUserOrderBy(plateNum);
    }


    @PostMapping("/updateRemark")
    @ResponseBody
    public Result updateUserOrderRemark(@RequestBody JSONObject jsonObject){
        String code = jsonObject.getString("orderCode");
        String remark = jsonObject.getString("remark");
        if(StringUtils.isEmpty(code) || StringUtils.isEmpty(remark)){
            return Result.buildError(ErrorCodeEnum.PARAMETER_MISSING);
        }
        return orderUnusualService.updateRemark(code,remark);
    }




}
