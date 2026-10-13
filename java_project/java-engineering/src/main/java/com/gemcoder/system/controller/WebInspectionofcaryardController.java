package com.gemcoder.system.controller;

import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.WebInspectionofcaryardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 车场巡检
 */
@Controller
@RequestMapping("/WebInspectionofcaryard")
public class WebInspectionofcaryardController {

    @Autowired
    private WebInspectionofcaryardService WebInspectionofcaryardService;

    @RequestMapping(value = "/getParkingLotNames")
    @ResponseBody
    public Result getParkingLotNames(@RequestBody Map<String, Object> paramMap) {
        /**
         *    进入页面后,数据来源于parking_lot_info表中的parking_lot_name字段 当前需求和组件(ref=ref27)有关。
         */
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return WebInspectionofcaryardService.getParkingLotNames(paramMap);
    }

    @RequestMapping(value = "/updateTableRowWithInspectionReport")
    @ResponseBody
    public Result updateTableRowWithInspectionReport(@RequestBody Map<String, Object> paramMap) {
        /**
         *    将巡检上报(ref=ref42)填写的信息,对表格(ref=ref18)对应的行进行修改；查询表格(ref=ref18)中的数据加载到表格(ref=ref18) 当前需求和组件(ref=ref42)有关。
         */
        // 校验异常类型是否为空
        if (paramMap.get("exceptionType1") == null || String.valueOf(paramMap.get("exceptionType1")).trim().isEmpty()) {
            return new Result(false, "异常类型必填", null);
        }
        // 校验处理人ID是否为空
        if (paramMap.get("handleperson") == null) {
            return new Result(false, "处理人ID必填", null);
        }
        //调用service层的代码
        return WebInspectionofcaryardService.updateTableRowWithInspectionReport(paramMap);
    }

    @RequestMapping(value = "/addNewEntryToTable")
    @ResponseBody
    public Result addNewEntryToTable(@RequestBody Map<String, Object> paramMap) {
        /**
         *    将新增弹窗(ref=ref33)内的数据添加到表格(ref=ref18)中；查询表格(ref=ref18)的数据加载到表格(ref=ref18)中 当前需求和组件(ref=ref33)有关。
         */
        // 校验巡检场地
        if (paramMap.get("inspectionyard") == null || String.valueOf(paramMap.get("inspectionyard")).trim().isEmpty()) {
            return new Result(false, "巡检场地必填!", null);
        }
        // 校验巡检项目
        if (paramMap.get("inspectionitems") == null || String.valueOf(paramMap.get("inspectionitems")).trim().isEmpty()) {
            return new Result(false, "巡检项目必填!", null);
        }
        // 校验巡检人员ID
        if (paramMap.get("patrolpersonnel1") == null) {
            return new Result(false, "巡检人员ID必填!", null);
        }
        // 校验巡检日期
        if (paramMap.get("inspectiondate1") == null) {
            return new Result(false, "巡检日期必填!", null);
        }
        //调用service层的代码
        return WebInspectionofcaryardService.addNewEntryToTable(paramMap);
    }

    @RequestMapping(value = "/updateTableRowWithProcessingResult")
    @ResponseBody
    public Result updateTableRowWithProcessingResult(@RequestBody Map<String, Object> paramMap) {
        /**
         *    将处理结果(ref=ref52)填写的数据,对表格(ref=ref18)中对应的行进行修改,查询表格(ref=ref18)中的数据加载到表格(ref=ref18)中 当前需求和组件(ref=ref52)有关。
         */
        // 校验处理人ID是否为空
        if (paramMap.get("handlers") == null || String.valueOf(paramMap.get("handlers")).trim().isEmpty()) {
            return new Result(false, "处理人ID为必填项!", null);
        }
        //调用service层的代码
        return WebInspectionofcaryardService.updateTableRowWithProcessingResult(paramMap);
    }

    @RequestMapping(value = "/getUserNickNames")
    @ResponseBody
    public Result getUserNickNames(@RequestBody Map<String, Object> paramMap) {
        /**
         *    进入页面后,数据来源于users表中的nick_name字段 当前需求和组件(ref=ref38)有关。
         */
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return WebInspectionofcaryardService.getUserNickNames(paramMap);
    }

    @RequestMapping(value = "/getParkingLotNames_xEw")
    @ResponseBody
    public Result getParkingLotNames_xEw(@RequestBody Map<String, Object> paramMap) {
        /**
         *    进入页面后,数据来源于parking_lot_info表中的parking_lot_name字段 当前需求和组件(ref=ref36)有关。
         */
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return WebInspectionofcaryardService.getParkingLotNames_xEw(paramMap);
    }

    @RequestMapping(value = "/showInspectionReportRef21")
    @ResponseBody
    public Result showInspectionReportRef21(@RequestBody Map<String, Object> paramMap) {
        /**
         *    显示巡检上报(ref=ref42),并将当前行数据加载到巡检上报(ref=ref42)中 当前需求和组件(ref=ref21)有关。
         */
        // 校验异常类型是否为空
        if (paramMap.get("exceptionType1") == null || String.valueOf(paramMap.get("exceptionType1")).trim().isEmpty()) {
            return new Result(false, "异常类型必填", null);
        }
        // 校验处理人名称是否为空
        if (paramMap.get("handleperson") == null || String.valueOf(paramMap.get("handleperson")).trim().isEmpty()) {
            return new Result(false, "处理人名称必填", null);
        }
        //调用service层的代码
        return WebInspectionofcaryardService.showInspectionReportRef21(paramMap);
    }

    @RequestMapping(value = "/showProcessingResultRef31")
    @ResponseBody
    public Result showProcessingResultRef31(@RequestBody Map<String, Object> paramMap) {
        /**
         *    显示处理结果(ref=ref52),并将当前行数据加载到处理结果(ref=ref52)中 当前需求和组件(ref=ref31)有关。
         */
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return WebInspectionofcaryardService.showProcessingResultRef31(paramMap);
    }

    @RequestMapping(value = "/listenToExceptionTypeRef62")
    @ResponseBody
    public Result listenToExceptionTypeRef62(@RequestBody Map<String, Object> paramMap) {
        /**
         *    当异常类型(ref=ref46)中为“无异常”时,巡检-巡检状态(ref=ref62)改为“无异常” 当前需求和组件(ref=ref62)有关。当前需求是个监听类型需求。
         */
        // 校验异常类型是否存在
        if (paramMap.get("exceptionType1") == null || String.valueOf(paramMap.get("exceptionType1")).trim().isEmpty()) {
            return new Result(false, "异常类型必填", null);
        }
        //调用service层的代码
        return WebInspectionofcaryardService.listenToExceptionTypeRef62(paramMap);
    }

    @RequestMapping(value = "/listenToExceptionTypeRef63")
    @ResponseBody
    public Result listenToExceptionTypeRef63(@RequestBody Map<String, Object> paramMap) {
        /**
         *    当异常类型(ref=ref46)中为“无异常”时,巡检-异常处理(ref=ref63)改为空值 当前需求和组件(ref=ref63)有关。当前需求是个监听类型需求。
         */
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return WebInspectionofcaryardService.listenToExceptionTypeRef63(paramMap);
    }

    @RequestMapping(value = "/generalQueryInspectionTableData")
    @ResponseBody
    public Result generalQueryInspectionTableData(@RequestBody Map<String, Object> paramMap) {
        /**
         *     该接口用于查询巡检表格(ref=ref18)中的数据，支持以下功能：
         * 1. 初始化表格数据：在页面加载时，获取并显示表格的初始数据。
         * 2. 分页查询：支持根据页码(current)和每页大小(pageSize)进行分页查询，并返回总条目数(total)。
         * 3. 条件查询：根据搜索区域(ref=ref3)中的字段进行条件查询，支持巡检编号和巡检人员的模糊查询。
         * 4. 数据刷新：在数据更新(如删除、添加、修改)后，重新查询并刷新表格数据。
         * 5. 排序：查询结果按照巡检时间倒序显示。
         * 6. 数据导出：支持导出表格中前1000条数据为.xlsx格式。
         */
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return WebInspectionofcaryardService.generalQueryInspectionTableData(paramMap);
    }
}
