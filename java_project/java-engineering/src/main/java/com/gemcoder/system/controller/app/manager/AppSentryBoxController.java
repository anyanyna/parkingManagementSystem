package com.gemcoder.system.controller.app.manager;

import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.AppSentryBoxService;
import com.gemcoder.system.service.ParkingRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 岗亭控制、移动岗亭
 */
@Controller
@RequestMapping("/appSentryBoxControl")
public class AppSentryBoxController {
    @Resource
    private AppSentryBoxService appSentryBoxService;
    @Resource
    private ParkingRecordService parkingRecordService;
    /**
     * 开闸
     */
    @RequestMapping(value = "/open")
    @ResponseBody
    public Result open(@RequestParam("camId") String camId) {
        return appSentryBoxService.open(camId);
    }
    /**
     * 关闸
     */
    @RequestMapping(value = "/close")
    @ResponseBody
    public Result close(@RequestParam("camId") String camId) {
        return appSentryBoxService.close(camId);
    }
    /**
     * 抓拍
     */
    @RequestMapping(value = "/capPicture")
    @ResponseBody
    public Result capPicture(@RequestParam("camId") String camId) {
        return appSentryBoxService.capPicture(camId);
    }
    /**
     * 获取抓拍图片
     */
    @RequestMapping(value = "/getPic")
    @ResponseBody
    public Result getPic(@RequestParam("camId") String camId) {
        return appSentryBoxService.getPic(camId);
    }
    /**
     * 获取停车场道口
     */
    @RequestMapping(value = "/getSelect")
    @ResponseBody
    public Result getSelect(@RequestParam("parkingId") Integer parkingId) {
        return appSentryBoxService.getSelect(parkingId);
    }
    /**
     * 获取车牌是否为黑名单生效时间
     */
    @RequestMapping(value = "/getPlateIsBlacklist")
    @ResponseBody
    public Result getPlateIsBlacklist(@RequestParam("plateNum") String plateNum,@RequestParam("parkingId") Integer parkingId) {
        return appSentryBoxService.getPlateIsBlacklist(plateNum,parkingId);
    }
    /**
     * 根据车牌获取订单
     */
    @RequestMapping(value = "/getOrderByPlateNum")
    @ResponseBody
    public Result getOrderByPlateNum(@RequestParam("plateNum") String plateNum,@RequestParam("parkingId") Integer parkingId) {
        return appSentryBoxService.getOrderByPlateNum(plateNum,parkingId);
    }
    /**
     * 获取停车场入口车道
     */
    @RequestMapping(value = "/getChannelIn")
    @ResponseBody
    public Result getChannelIn(@RequestParam("parkingId") Integer parkingId) {
        return appSentryBoxService.getChannelSelect(parkingId,"入口");
    }
    /**
     * 获取停车场出口车道
     */
    @RequestMapping(value = "/getChannelOut")
    @ResponseBody
    public Result getChannelOut(@RequestParam("parkingId") Integer parkingId) {
        return appSentryBoxService.getChannelSelect(parkingId,"出口");
    }

    /**
     * 获取订单详情
     *
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/getDetail")
    @ResponseBody
    public Result getDetail(@RequestParam("orderId") Integer orderId) {
        return parkingRecordService.getDetail(orderId);
    }

    /**
     * 获取岗亭记录
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/getList")
    @ResponseBody
    public Result getList(@RequestBody JSONObject jsonObject) {
        return appSentryBoxService.getList(jsonObject);
    }

    /**
     * 车辆入场
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/saveOrderCar")
    @ResponseBody
    public Result saveOrderCar(@RequestBody JSONObject jsonObject){
        return appSentryBoxService.saveOrderCar(jsonObject,false);
    }
    /**
     * 车辆出场
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/orderSettlement")
    @ResponseBody
    public Result orderSettlement(@RequestBody JSONObject jsonObject){
        return appSentryBoxService.orderSettlement(jsonObject,false);
    }
    /**
     * 车辆出场并抬杆
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/orderSettlementAndOpen")
    @ResponseBody
    public Result orderSettlementAndOpen(@RequestBody JSONObject jsonObject){
        return appSentryBoxService.orderSettlement(jsonObject,true);
    }
    /**
     * 上传图片
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/updatePic")
    @ResponseBody
    public Result uploadCamPic(@RequestParam("file") MultipartFile file, @RequestParam("camId") String camId, @RequestParam("plateNum") String plateNum){
        return appSentryBoxService.uploadCamPic(file,camId,plateNum);
    }
    /**
     * 车辆入场并抬杆
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/saveOrderCarAndOpen")
    @ResponseBody
    public Result saveOrderCarAndOpen(@RequestBody JSONObject jsonObject){
        return appSentryBoxService.saveOrderCar(jsonObject,true);
    }
}
