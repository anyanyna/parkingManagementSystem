package com.gemcoder.system.controller;

import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.WebOnlineinvoicingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 线上开票
 */
@Controller
@RequestMapping("/WebOnlineinvoicing")
public class WebOnlineinvoicingController {

    @Autowired
    private WebOnlineinvoicingService WebOnlineinvoicingService;

    @RequestMapping(value = "/exportTableData")
    @ResponseBody
    public ResponseEntity<Resource> exportTableData(@RequestBody Map<String, Object> paramMap) {
        return WebOnlineinvoicingService.exportTableData(paramMap);
    }

    @RequestMapping(value = "/handleInvoiceUploadChange")
    @ResponseBody
    public Result handleInvoiceUploadChange(@RequestBody Map<String, Object> paramMap) {
        /**
         *    将开票状态改为“已开票”,并将上传的文件地址写当前行发票附件字段中, 当前需求和组件(ref=ref24)有关。
         */
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return WebOnlineinvoicingService.handleInvoiceUploadChange(paramMap);
    }

    @RequestMapping(value = "/handleInvoiceUpdateChange")
    @ResponseBody
    public Result handleInvoiceUpdateChange(@RequestBody Map<String, Object> paramMap) {
        /**
         *    替换发票附件的文件地址 当前需求和组件(ref=ref25)有关。
         */
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return WebOnlineinvoicingService.handleInvoiceUpdateChange(paramMap);
    }

    @RequestMapping(value = "/generalFetchTableData")
    @ResponseBody
    public Result generalFetchTableData(@RequestBody Map<String, Object> paramMap) {
        /**
         *     该接口用于表格(ref=ref18)的数据查询操作，支持以下功能：
         * 1. 初始化表格数据：在页面加载时，自动获取并显示表格中的数据。
         * 2. 条件查询：根据搜索区域(ref=ref3)中的字段进行查询，支持订单编号(ref=ref4)、车牌号(ref=ref9)、发票抬头(ref=ref10)的模糊查询。
         * 3. 分页查询：根据分页信息(页码current，每页大小pageSize)获取对应页面的数据，并返回总条目数(total)。
         * 4. 数据刷新：在搜索条件变更或重置时，重新获取并显示表格数据。
         * 5. 数据导出：支持将表格中前1000条数据或已勾选的数据导出为.xlsx格式。
         */
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return WebOnlineinvoicingService.generalFetchTableData(paramMap);
    }
}
