package com.gemcoder.system.controller.app.user;

import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.exception.ErrorCodeEnum;
import com.gemcoder.system.service.AppCarOwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;

/**
 * App 车主端接口
 * @author xuezhonghao
 * @create 2024-12-20
 */
@Controller
@RequestMapping("/carOwner")
public class AppCarOwnerController {

    private static final Logger log = LoggerFactory.getLogger(AppCarOwnerController.class);

    @Resource
    private AppCarOwnerService appCarOwnerService;





    /**
     * 我的历史欠费
     * @author XueZhongHao
     * @date 2024/12/30
     * @return com.gemcoder.system.bo.Result
     **/
    @GetMapping("/getArrearsRecord")
    @ResponseBody
    public Result getArrearsRecord(){
        String userName = sdkOfGetCurrentUserName();
        return appCarOwnerService.getArrearsRecord(userName);
    }



    /**
     * 查询我的车辆列表
     * @author XueZhongHao
     * @date 2024/12/25
     * @return com.gemcoder.system.bo.Result
     **/
    @GetMapping("/vehicle/getMyCar")
    @ResponseBody
    public Result getMyCar(){
        String userName = sdkOfGetCurrentUserName();
        log.info("/appUser/getMyCar=======>车主端，查看自己的车辆，userName：{}",userName);
        return appCarOwnerService.getMyCar(userName);

    }


    /**
     * 新增车辆
     * @author XueZhongHao
     * @date 2024/12/25
     * @param jsonObject
     * @return com.gemcoder.system.bo.Result
     **/
    @PostMapping("/vehicle/addVehicle")
    @ResponseBody
    public Result addVehicle(@RequestBody JSONObject jsonObject){

        String userName = sdkOfGetCurrentUserName();
        String plateNum = jsonObject.getString("plateNum");
        String plateType = jsonObject.getString("plateType");
        String mainType = jsonObject.getString("mainType");
        String img = jsonObject.getString("img");
        return appCarOwnerService.addVehicle(userName,plateNum,plateType,mainType,img);
    }




    @PostMapping("/vehicle/unbind")
    @ResponseBody
    public Result unbind(@RequestParam String plateNum){
        // 主车主车解绑后就空着
        String userName = sdkOfGetCurrentUserName();
        // 有欠费不能解绑
        return appCarOwnerService.unbindVehicle(userName, plateNum);

    }


    // 清欠









    // 长租相关---这个暂时不做



    @PostMapping("/parkRecord/myRecord")
    public Result getMyParkRecord(@RequestBody JSONObject jsonObject){
        log.info("/carOwner/parkRecord/myRecord=======>车主端，查看自己的停车记录，接收参数：{}",jsonObject);
        String userName = sdkOfGetCurrentUserName();
        String selectType = jsonObject.getString("selectType");

        Integer currentPage = jsonObject.get("currentPage") != null ? jsonObject.getInteger("currentPage") : 1;
        Integer pageSize = jsonObject.get("pageSize") != null ? jsonObject.getInteger("pageSize") : 10;
        if(StringUtils.isEmpty(selectType)){
            return Result.buildError(ErrorCodeEnum.PARAMETER_MISSING);
        }
        Result myParkRecord = appCarOwnerService.getMyParkRecord(userName, selectType, currentPage, pageSize);
        log.info("/carOwner/parkRecord/myRecord=======>车主端，查看自己的停车记录，返回参数：{}",myParkRecord.data);
        return myParkRecord;
    }




    /**
     *
     * 订单明细
     * @author XueZhongHao
     * @date 2024/12/30
     * @param orderCode
     * @return com.gemcoder.system.bo.Result
     **/
    @PostMapping("/parkRecord/myOrderInfo")
    @ResponseBody
    public Result getMyOrderInfo(@RequestParam String orderCode){
        return appCarOwnerService.getMyOrderInfo(orderCode);
    }


    /**
     * 计费详情  计费计算条目 计费计算详情
     * @author XueZhongHao
     * @date 2024/12/30
     * @return com.gemcoder.system.bo.Result
     **/
    @ResponseBody
    @PostMapping("/parkRecord/chargeDetails")
    public Result chargeInfoByOrder(@RequestBody JSONObject jsonObject){
        Integer currentPage = jsonObject.get("currentPage") != null ? jsonObject.getInteger("currentPage") : 1;
        Integer pageSize = jsonObject.get("pageSize") != null ? jsonObject.getInteger("pageSize") : 10;
        Integer orderId = jsonObject.getInteger("orderId");
        return appCarOwnerService.getChargeDetails(currentPage,pageSize,orderId);
    }





    @ResponseBody
    @PostMapping("/saveSuggest")
    public Result saveSuggest(@RequestBody JSONObject jsonObject){
        log.info("/carOwner/saveSuggest=======>车主端，提交意见反馈，接收参数：{}",jsonObject);
        String content = jsonObject.getString("content");
        String pic = jsonObject.getString("pic");
        String userName = sdkOfGetCurrentUserName();
        Result result = appCarOwnerService.saveSuggest(userName, content, pic);
        log.info("/carOwner/saveSuggest=======>车主端，提交意见反馈，返回参数：{}",result);
        return result;
    }






}
