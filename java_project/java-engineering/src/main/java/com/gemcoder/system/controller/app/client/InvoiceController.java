package com.gemcoder.system.controller.app.client;

import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.InvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 我的发票
 *
 * @author chenjie
 */
@Controller
@RequestMapping("/invoice")
public class InvoiceController {
    @Resource
    private InvoiceService invoiceService;

    /**
     * 获取我的发票
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getList")
    @ResponseBody
    public Result getList(@RequestBody JSONObject jsonObject) {
        return invoiceService.getList(jsonObject);
    }
    /**
     * 获取个人抬头信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getHeadUpList")
    @ResponseBody
    public Result getHeadUpList() {
        return invoiceService.getHeadUpList();
    }
    /**
     * 新增个人抬头信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/insertHeadUp")
    @ResponseBody
    public Result insertHeadUp(@RequestBody JSONObject jsonObject) {
        return invoiceService.insertHeadUp(jsonObject);
    }
    /**
     * 删除个人抬头信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/deleteHeadUp")
    @ResponseBody
    public Result deleteHeadUp(@RequestParam("id") Integer id) {
        return invoiceService.deleteHeadUp(id);
    }

    /**
     * 申请开票
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/applyInvoice")
    @ResponseBody
    public Result applyInvoice(@RequestBody JSONObject jsonObject) {
        return invoiceService.applyInvoice(jsonObject);
    }
    /**
     * 上传更新发票
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/uploadFile")
    @ResponseBody
    public Result uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("id") Integer id) {
        return invoiceService.uploadFile(file,id);
    }

}
