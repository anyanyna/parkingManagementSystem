package com.gemcoder.system.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.bo.VehicleBlockListBo;
import com.gemcoder.system.exception.ErrorCodeEnum;
import com.gemcoder.system.service.VehicleListManagerService;
import com.gemcoder.system.util.ExcelUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/vehicleListManager")
public class VehicleListManagerController {
    @Resource
    private VehicleListManagerService vehicleListManagerService;

    /**
     * 获取所有名单类型下拉
     * @return
     */

    @RequestMapping(value = "/getList")
    @ResponseBody
    public Result getList() {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return vehicleListManagerService.getList();
    }

    /**
     * 获取计费规则数据
     * @return
     */

    @RequestMapping(value = "/getBillingRulesSelect")
    @ResponseBody
    public Result getBillingRulesSelect() {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return vehicleListManagerService.getBillingRulesSelect();
    }

    /**
     * 删除名单类型
     * @param code
     * @return
     */
    @RequestMapping(value = "/deleteVehicleList")
    @ResponseBody
    public Result deleteVehicleList(@RequestParam("code") String code) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        if (StringUtils.isEmpty(code)) {
            return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        } else {
            return vehicleListManagerService.deleteVehicleList(code);
        }
    }

    /**
     * 新增名单类型
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/insertVehicleList")
    @ResponseBody
    public Result insertVehicleList(@RequestBody JSONObject jsonObject) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        if (StringUtils.isEmpty(jsonObject.getString("ruleNumber")) || StringUtils.isEmpty(jsonObject.getString("typeName")) ) {
            return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        } else {
            return vehicleListManagerService.insertVehicleList(jsonObject);
        }
    }

    /**
     * 黑白名单列表查询
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/selectList")
    @ResponseBody
    public Result selectList(@RequestBody JSONObject jsonObject) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return  vehicleListManagerService.selectList(jsonObject);
    }

    /**
     * 获取停车场列表
     * @param userName
     * @return
     */
    @RequestMapping(value = "/getParkingList")
    @ResponseBody
    public Result getParkingList(@RequestParam(required = false ,name = "userName") String userName){
        return  vehicleListManagerService.getParkingList(userName,0);
    }
    /**
     * insert
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/insert")
    @ResponseBody
    public Result insert(@RequestBody JSONObject jsonObject){
        return  vehicleListManagerService.insert(jsonObject);
    }  /**
     * update
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Result update(@RequestBody JSONObject jsonObject){
        return  vehicleListManagerService.update(jsonObject);
    }
    /**
     * approval
     * @param jsonArray
     * @return
     */
    @RequestMapping(value = "/approval")
    @ResponseBody
    public Result approval(@RequestBody JSONArray jsonArray){
        return  vehicleListManagerService.approval(jsonArray);
    }
    /**
     * delete
     * @param jsonArray
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Result delete(@RequestBody JSONArray jsonArray){
        return  vehicleListManagerService.delete(jsonArray);
    }
    /**
     * download
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/download")
    @ResponseBody
    public void download(HttpServletResponse response, @RequestBody JSONObject jsonObject) throws IOException {
          vehicleListManagerService.download(response,jsonObject);
    }
    /**
     * downloadTemp
     * @param
     * @return
     */
    @RequestMapping(value = "/downloadTemp")
    @ResponseBody
    public void downloadTemp(HttpServletResponse response) throws IOException {
        VehicleBlockListBo bo=new VehicleBlockListBo();
        bo.setParkingLotId("xxx停车场,xxx停车场,xxx停车场,请用英文逗号隔开");
        bo.setPlateNum("XAaaaaa");
        bo.setVehicleListCode("黑名单");
        bo.setRemark("使用时请删除第一行");
        bo.setEndTime(LocalDateTime.now());
        bo.setStartTime(LocalDateTime.now());
        bo.setPlateType("黑色");
        ExcelUtils.write(response,"黑白名单模板.xlsx","sheet1", VehicleBlockListBo.class, Arrays.asList(bo),new int[]{});
    }
    /**
     * importExcel
     * @param
     * @return
     */
    @RequestMapping(value = "/importExcel")
    @ResponseBody
    public Result importExcel(@RequestParam("file") MultipartFile file,@RequestParam(required = false,name = "userName") String userName) throws IOException {
        return vehicleListManagerService.importExcel(file,userName);
    }
}
