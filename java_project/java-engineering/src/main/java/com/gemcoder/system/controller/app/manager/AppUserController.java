package com.gemcoder.system.controller.app.manager;

import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.AppUserService;
import com.gemcoder.system.util.RedisUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Random;

import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;

/**
 * app用户相关接口
 *
 * @author chenjie
 */
@Controller
@RequestMapping("/appUser")
public class AppUserController {
    @Resource
    private AppUserService appUserService;
    @Resource
    private RedisUtils redisUtils;

    /**
     * 修改手机号
     */
    @RequestMapping(value = "/updatePhone")
    @ResponseBody
    public Result updatePhone(@RequestBody JSONObject jsonObject) {
        return appUserService.updatePhone(jsonObject);
    }

    /**
     * 修改密码
     */
    @RequestMapping(value = "/updatePassword")
    @ResponseBody
    public Result updatePassword(@RequestBody JSONObject jsonObject) {
        return appUserService.updatePassword(jsonObject);
    }
    /**
     * 忘记密码
     */
    @RequestMapping(value = "/forgotPassword")
    @ResponseBody
    public Result forgotPassword(@RequestBody JSONObject jsonObject) {
        return appUserService.forgotPassword(jsonObject);
    }
    /**
     * 获取验证码
     */
    @RequestMapping(value = "/getVerificationCode")
    @ResponseBody
    public Result getVerificationCode() {
        return appUserService.getVerificationCode();
    }
    /**
     * 获取验证码
     */
    @RequestMapping(value = "/getVerificationCodeByPhone")
    @ResponseBody
    public Result getVerificationCodeByPhone(@RequestParam("phone") String phone) {
        return appUserService.getVerificationCodeByPhone(phone);
    }

}
