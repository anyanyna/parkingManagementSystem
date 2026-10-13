package com.gemcoder.system.controller.app.manager;

import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.AppPlateCorrectionService;
import com.gemcoder.system.util.RedisUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 车牌修正模块
 *
 * @author chenjie
 */
@Controller
@RequestMapping("/appPlateCorrection")
public class AppPlateCorrectionController {
    @Resource
    private AppPlateCorrectionService appPlateCorrectionService;
    @Resource
    private RedisUtils redisUtils;

    /**
     * 获取车牌修正列表
     */
    @RequestMapping(value = "/getList")
    @ResponseBody
    public Result getList(@RequestBody JSONObject jsonObject) {
        return appPlateCorrectionService.getList(jsonObject);
    }

    /**
     * 获取订单详情
     */
    @RequestMapping(value = "/getDetail")
    @ResponseBody
    public Result getDetail(@RequestParam("id") Integer id) {
        return appPlateCorrectionService.getDetail(id);
    }

    /**
     * 获取订单详情
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Result update(@RequestParam("file") MultipartFile file, @RequestParam("vid") Integer vid) {
        return appPlateCorrectionService.update(file, vid);
    }
}
