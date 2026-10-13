package com.gemcoder.system.controller.app.manager;

import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.AppPatrolInspectionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * app车场巡检
 */
@Controller
@RequestMapping("/appPatrolInspection")
public class AppPatrolInspectionController {
    @Resource
    private AppPatrolInspectionService appPatrolInspectionService;
    /**
     * 获取巡检列表
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/getList")
    @ResponseBody
    public Result getList(@RequestBody JSONObject jsonObject){
        return  appPatrolInspectionService.getList(jsonObject);
    }
    /**
     * 巡检
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/check")
    @ResponseBody
    public Result check(@RequestBody JSONObject jsonObject){
        return  appPatrolInspectionService.check(jsonObject);
    }
    /**
     * 处理
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/processing")
    @ResponseBody
    public Result processing(@RequestBody JSONObject jsonObject){
        return  appPatrolInspectionService.processing(jsonObject);
    }
    /**
     * 上传图片
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/uploadPic")
    @ResponseBody
    public Result uploadPic(@RequestParam("file") MultipartFile file){
        return appPatrolInspectionService.uploadPic(file);
    }

}
