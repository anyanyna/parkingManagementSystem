package com.gemcoder.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.PersonalcenterService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;

@Controller
@RequestMapping("/Personalcenter")
public class PersonalcenterController {

    @Autowired
    private PersonalcenterService PersonalcenterService;

    @RequestMapping(value = "/handleTreeSelect")
    @ResponseBody
    public Result handleTreeSelect(@RequestBody Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return PersonalcenterService.handleTreeSelect(paramMap);
    }

    @RequestMapping(value = "/getUserMessages")
    @ResponseBody
    public Result getUserMessages(@RequestBody Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return PersonalcenterService.getUserMessages(paramMap);
    }

    @RequestMapping(value = "/getUserMessagesByPage")
    @ResponseBody
    public Result getUserMessagesByPage(@RequestBody Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return PersonalcenterService.getUserMessagesByPage(paramMap);
    }

    @RequestMapping(value = "/updateAllMessagesToRead")
    @ResponseBody
    public Result updateAllMessagesToRead(@RequestBody Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return PersonalcenterService.updateAllMessagesToRead(paramMap);
    }

    @RequestMapping(value = "/getUserInformation")
    @ResponseBody
    public Result getUserInformation(@RequestBody Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return PersonalcenterService.getUserInformation(paramMap);
    }

    @RequestMapping(value = "/updateUserInformation")
    @ResponseBody
    public Result updateUserInformation(@RequestBody Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return PersonalcenterService.updateUserInformation(paramMap);
    }
}
