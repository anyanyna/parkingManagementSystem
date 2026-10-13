package com.gemcoder.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.exception.ErrorCodeEnum;
import com.gemcoder.system.service.VehicleArrearsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 车辆欠费相关
 * @author xuezhonghao
 * @create 2024-12-20
 */
@Controller
@RequestMapping("/VehicleArrears")
public class VehicleArrearsController {

    private static final Logger log = LoggerFactory.getLogger(VehicleArrearsController.class);

    @Resource
    private VehicleArrearsService vehicleArrearsService;


    @PostMapping("/getPageBy")
    @ResponseBody
    public Result getPageBy(@RequestBody JSONObject jsonObject){
        log.info("/VehicleArrears/getPageBy=======>查询欠费记录的分页数据，接收参数：{}",jsonObject);
        String phone = jsonObject.getString("phone");
        String plateNum = jsonObject.getString("plateNum");
        String status = jsonObject.getString("status");
        String overDay = jsonObject.getString("overDay");// 0 1 2 单个数字精确查   1-2  2-4  横杠连接就查询范围
        if(!StringUtils.isEmpty(overDay)){
            if(overDay.contains("-")){
                String regex = "^\\d+-\\d+$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(overDay);
                if (!matcher.find()) {
                    return Result.buildError(ErrorCodeEnum.DATA_UNKNOWN_ERROR);
                }
            }
        }
        Date startTime1 = jsonObject.getDate("startTime1");
        Date startTime2 = jsonObject.getDate("startTime2");
        Integer currentPage = jsonObject.get("currentPage") != null ? jsonObject.getInteger("currentPage") : 1;
        Integer pageSize = jsonObject.get("pageSize") != null ? jsonObject.getInteger("pageSize") : 10;
        try {
            Result res = vehicleArrearsService.getPageBy(phone, plateNum, status, overDay, startTime1, startTime2, currentPage, pageSize);
            log.info("/VehicleArrears/getPageBy=======>查询欠费记录的分页数据，返回参数：{}",res);
            return res;
        } catch (Exception e) {
            log.info("/VehicleArrears/getPageBy=======>查询欠费记录的分页数据，出错了：{}",e.getMessage());
            return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        }
    }


    /**
     * 追缴
     * @author XueZhongHao
     * @date 2024/12/20
     * @return com.gemcoder.system.bo.Result
     **/
    @PostMapping("/saveRecovery")
    @ResponseBody
    public Result saveRecovery(@RequestBody JSONObject jsonObject){
        log.info("/VehicleArrears/getPageBy=======>保存追缴记录，接收参数：{}",jsonObject);
        String code = jsonObject.getString("code");
        BigDecimal recoveryNum = jsonObject.getBigDecimal("recoveryNum");
        String type = jsonObject.getString("type");
        if(StringUtils.isEmpty(code) || StringUtils.isEmpty(type) || Objects.isNull(recoveryNum)){
            return Result.buildError(ErrorCodeEnum.PARAMETER_MISSING);
        }
        Result res = vehicleArrearsService.saveRecovery(code, recoveryNum, type);
        log.info("/VehicleArrears/getPageBy=======>保存追缴记录，返回参数：{}",res);
        return res;
    }


    /**
     * 根据编号移除一个
     * @author XueZhongHao
     * @date 2024/12/20
     * @param code
     * @return com.gemcoder.system.bo.Result
     **/
    @PostMapping("/removeOne")
    @ResponseBody
    public Result removeOne(@RequestParam String code){
        log.info("/VehicleArrears/removeOne=======>移除一个记录，接收参数：{}",code);
        Result res = vehicleArrearsService.removeOneByCode(code);
        log.info("/VehicleArrears/removeOne=======>移除一个记录，返回参数：{}",res);
        return res;
    }

    /**
     * 导出
     * @author XueZhongHao
     * @date 2024/12/20
     * @param response
     * @param jsonObject
     **/
    @PostMapping("/download")
    @ResponseBody
    public void download(HttpServletResponse response,@RequestBody JSONObject jsonObject){
        log.info("/VehicleArrears/download=======>导出数据，接收参数：{}",jsonObject);
        String phone = jsonObject.getString("phone");
        String plateNum = jsonObject.getString("plateNum");
        String status = jsonObject.getString("status");
        String overDay = jsonObject.getString("overDay");// 0 1 2 单个数字精确查   1-2  2-4  横杠连接就查询范围
        if(!StringUtils.isEmpty(overDay)){
            if(overDay.contains("-")){
                String regex = "^\\d+-\\d+$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(overDay);
                if (!matcher.find()) {
                    return ;
                }
            }
        }
        Date startTime1 = jsonObject.getDate("startTime1");
        Date startTime2 = jsonObject.getDate("startTime2");
        try {
            vehicleArrearsService.download(response,phone, plateNum, status, overDay, startTime1, startTime2);
        } catch (IOException e) {
            log.info("/VehicleArrears/download=======>导出数据，出错了：{}",e.getMessage());
        }
    }



    /**
     * 查看对应车牌的欠费状态订单
     * @author XueZhongHao
     * @date 2024/12/20
     * @param code
     * @return com.gemcoder.system.bo.Result
     **/
    @GetMapping("/getRecordByCode")
    @ResponseBody
    public Result getRecordByCode(@RequestParam String code){
        log.info("/VehicleArrears/getRecordByCode=======>移除一个记录，接收参数：{}",code);
        Result res = vehicleArrearsService.getRecordByCode(code);
        log.info("/VehicleArrears/getRecordByCode=======>移除一个记录，返回参数：{}",res);
        return res;
}












}
