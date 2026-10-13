package com.gemcoder.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;
import javax.annotation.Resource;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.DatadictionaryService;
import java.util.Map;
import cn.hutool.core.util.*;
import cn.hutool.core.map.MapUtil;

@Controller
@RequestMapping("/Datadictionary")
public class DatadictionaryController {

    @Resource
    private DatadictionaryService DatadictionaryService;

    @RequestMapping(value = "/getBusinessDictionaries")
    @ResponseBody
    public Result getBusinessDictionaries(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return DatadictionaryService.searchBusinessDictionaries(paramMap);
    }

    @RequestMapping(value = "/getDictionaryDetails")
    @ResponseBody
    public Result getDictionaryDetails(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return DatadictionaryService.getDictionaryDetails(paramMap);
    }

    @RequestMapping(value = "/searchBusinessDictionaries")
    @ResponseBody
    public Result searchBusinessDictionaries(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return DatadictionaryService.searchBusinessDictionaries(paramMap);
    }

    @RequestMapping(value = "/saveBusinessDictionary")
    @ResponseBody
    public Result saveBusinessDictionary(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return DatadictionaryService.saveBusinessDictionary(paramMap);
    }

    @RequestMapping(value = "/addBusinessDictionary")
    @ResponseBody
    public Result addBusinessDictionary(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return DatadictionaryService.saveBusinessDictionary(paramMap);
    }

    @RequestMapping(value = "/saveDictionaryDetail")
    @ResponseBody
    public Result saveDictionaryDetail(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return DatadictionaryService.saveDictionaryDetail(paramMap);
    }

    @RequestMapping(value = "/updateBusinessDictionary")
    @ResponseBody
    public Result updateBusinessDictionary(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return DatadictionaryService.updateBusinessDictionary(paramMap);
    }

    @RequestMapping(value = "/updateDictionaryDetail")
    @ResponseBody
    public Result updateDictionaryDetail(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return DatadictionaryService.updateDictionaryDetail(paramMap);
    }

    @RequestMapping(value = "/deleteBusinessDictionary")
    @ResponseBody
    public Result deleteBusinessDictionary(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return DatadictionaryService.deleteBusinessDictionary(paramMap);
    }

    @RequestMapping(value = "/deleteDictionaryDetail")
    @ResponseBody
    public Result deleteDictionaryDetail(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return DatadictionaryService.deleteDictionaryDetail(paramMap);
    }

    @RequestMapping(value = "/showEditModalWithData")
    @ResponseBody
    public Result showEditModalWithData(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return DatadictionaryService.showEditModalWithData(paramMap);
    }

    @RequestMapping(value = "/showEditModal")
    @ResponseBody
    public Result showEditModal(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return DatadictionaryService.showEditModalWithData(paramMap);
    }

    @RequestMapping(value = "/showEditDetailModal")
    @ResponseBody
    public Result showEditDetailModal(@RequestBody(required = false) Map<String, Object> paramMap) {
        //如果有需要校验的入参, 请在这里补充代码进行校验
        //调用service层的代码
        return DatadictionaryService.showEditModalWithDataForDetail(paramMap);
    }
}
