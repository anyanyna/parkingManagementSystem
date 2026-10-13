package com.gemcoder.system.controller;

import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.WebFundmanagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 资金管理
 */
@Controller
@RequestMapping("/WebFundmanagement")
public class WebFundmanagementController {

    @Autowired
    private WebFundmanagementService WebFundmanagementService;

    @RequestMapping(value = "/initializePaymentLogData")
    @ResponseBody
    public Result initializePaymentLogData(@RequestBody Map<String, Object> paramMap) {
        /**
         *    清空搜索区域-支付日志(ref=ref114)中的数据,并初始化支付日志表(ref=ref124) 当前需求和组件(ref=ref116)有关。
         */
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return WebFundmanagementService.initializePaymentLogData(paramMap);
    }

    @RequestMapping(value = "/initializeTransactionQueryData")
    @ResponseBody
    public Result initializeTransactionQueryData(@RequestBody Map<String, Object> paramMap) {
        /**
         *    清空搜索区域-交易查询(ref=ref89)中的数据,并初始化交易查询表(ref=ref99) 当前需求和组件(ref=ref91)有关。
         */
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return WebFundmanagementService.initializeTransactionQueryData(paramMap);
    }

    @RequestMapping(value = "/initializeIncomeFlowData")
    @ResponseBody
    public Result initializeIncomeFlowData(@RequestBody Map<String, Object> paramMap) {
        /**
         *    清空搜索区域-收入流水(ref=ref79)中的数据,并初始化收入流水表(ref=ref88)中的数据 当前需求和组件(ref=ref81)有关。
         */
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return WebFundmanagementService.initializeIncomeFlowData(paramMap);
    }

    @RequestMapping(value = "/generalQueryIncomeFlowList")
    @ResponseBody
    public Result generalQueryIncomeFlowList(@RequestBody Map<String, Object> paramMap) {
        /**
         *    根据搜索区域-收入流水(ref=ref79)中的查询条件，查询收入流水表(ref=ref88)中对应的数据。支持手机号(ref=ref80)、车牌号(ref=ref84)、第三方流水号(ref=ref112)、平台流水号(ref=ref113)的模糊查询。查询结果需要支持分页功能，包括页码(current)、每页大小(pageSize)、返回的总条目数(total)。
         */
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return WebFundmanagementService.generalQueryIncomeFlowList(paramMap);
    }

    @RequestMapping(value = "/generalQueryTransactionListData")
    @ResponseBody
    public Result generalQueryTransactionListData(@RequestBody Map<String, Object> paramMap) {
        /**
         *    根据搜索区域-交易查询(ref=ref89)中的查询条件，查询交易查询表(ref=ref99)中的数据。支持模糊查询的字段包括车牌号(ref=ref90)和平台流水号(ref=ref128)。查询结果需要支持分页功能，包括页码(current)、每页大小(pageSize)和返回的总条目数(total)。此外，接口还需支持数据的初始化和刷新操作。
         */
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return WebFundmanagementService.generalQueryTransactionListData(paramMap);
    }

    @RequestMapping(value = "/generalQueryPaymentLogList")
    @ResponseBody
    public Result generalQueryPaymentLogList(@RequestBody Map<String, Object> paramMap) {
        /**
         *    根据支付日志表(ref=ref124)中的查询条件，查询支付日志表中的数据。支持模糊查询的字段包括：车牌号、平台流水号、第三方流水号。查询时需要支持分页功能，包括页码(current)、每页大小(pageSize)、返回的总条目数(total)。此外，查询条件还包括来源端、交易时间、车场名称、业务类型等。
         */
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return WebFundmanagementService.generalQueryPaymentLogList(paramMap);
    }
}
