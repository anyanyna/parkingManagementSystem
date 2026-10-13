package com.gemcoder.system.service;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.excel.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.exception.ErrorCodeEnum;
import com.gemcoder.system.util.RedisUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.gemcoder.system.datasource.JdbcTemplateUtil.executeSQL;
import static com.gemcoder.system.service.UserSdkService.sdkOfGetCurrentUserName;

@Service
public class AppUserService {

    @Resource
    private RedisUtils redisUtils;
    @Resource
    private UserSdkService userSdkService;

    public Result updatePhone(JSONObject jsonObject) {
        String mobile = jsonObject.getString("mobile");
        String code = jsonObject.getString("code");
        String userName = sdkOfGetCurrentUserName();
        String codeRedis = redisUtils.get(mobile) == null ? "" : String.valueOf(redisUtils.get(mobile));
        if (StringUtils.isEmpty(mobile)) {
            return new Result(false, "手机号不能为空");
        }
        if (StringUtils.isEmpty(code)) {
            return new Result(false, "短信验证码不能为空");
        }
        if (StringUtils.isEmpty(codeRedis)) {
            return new Result(false, "短信验证码已过期");
        }
        if (!code.equals(codeRedis)) {
            return new Result(false, "短信验证码不正确");
        }
        String updateSql = "UPDATE `users` \n" +
                "SET \n" +
                "`mobile` = ?\n" +
                "WHERE\n" +
                "`user_name` = ?";
        Integer o = executeSQL(updateSql, mobile, userName);
        if (o != -1) {
            redisUtils.del(mobile);
            return Result.buildSuccess(true);
        } else {
            return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        }
    }

    public Result getVerificationCode() {
        String userName = sdkOfGetCurrentUserName();
        String selectSql="select * from users where user_name=?";
        Object o1 = executeSQL(selectSql, userName);
        JSONArray jsonArray = JSONArray.parseArray(JSONArray.toJSONString(o1));
        String mobile = jsonArray.getJSONObject(0).getString("mobile");
        Random random = new Random();
        Object o = redisUtils.get(mobile);
        if (o==null){
            int randomNumber = random.nextInt(900000) + 100000; // 生成100000到
            redisUtils.set(mobile,randomNumber+"",300);
            return Result.buildSuccess(randomNumber);
        }else {
            return new Result(false,"验证码还在有效期内");
        }
    }

    public Result getVerificationCodeByPhone(String phone) {
        Random random = new Random();
        Object o = redisUtils.get(phone);
        if (o==null){
            int randomNumber = random.nextInt(900000) + 100000; // 生成100000到
            redisUtils.set(phone,randomNumber+"",300);
            return Result.buildSuccess(randomNumber);
        }else {
            return new Result(false,"验证码还在有效期内");
        }
    }

    public Result updatePassword(JSONObject jsonObject) {
        String mobile = jsonObject.getString("mobile");
        String code = jsonObject.getString("code");
        String userName = sdkOfGetCurrentUserName();
        String codeRedis = redisUtils.get(mobile) == null ? "" : String.valueOf(redisUtils.get(mobile));
        String password=jsonObject.getString("password");
        String password2=jsonObject.getString("password2");
        if (!password2.equals(password)){
            return new Result(false, "两次密码不一致");
        }
        if (StringUtils.isEmpty(mobile)) {
            return new Result(false, "手机号不能为空");
        }
        if (StringUtils.isEmpty(code)) {
            return new Result(false, "短信验证码不能为空");
        }
        if (StringUtils.isEmpty(codeRedis)) {
            return new Result(false, "短信验证码已过期");
        }
        if (!code.equals(codeRedis)) {
            return new Result(false, "短信验证码不正确");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(password);
        String updateSql = "UPDATE `users` \n" +
                "SET \n" +
                "`password` = ?\n" +
                "WHERE\n" +
                "`user_name` = ?";
        Integer o = executeSQL(updateSql, encodedPassword, userName);
        if (o != -1) {
            redisUtils.del(mobile);
            return Result.buildSuccess(true);
        } else {
            return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        }
    }

    public Result forgotPassword(JSONObject jsonObject) {
        String mobile = jsonObject.getString("mobile");
        String code = jsonObject.getString("code");
        JSONObject userByMobile = userSdkService.getUserByMobile(mobile);
        if (CollectionUtil.isEmpty(userByMobile)){
            return new Result(false,"该手机号不是系统注册用户");
        }
        String userName = userByMobile.getString("user_name");
        String codeRedis = redisUtils.get(mobile) == null ? "" : String.valueOf(redisUtils.get(mobile));
        String password=jsonObject.getString("password");
        String password2=jsonObject.getString("password2");
        if (!password2.equals(password)){
            return new Result(false, "两次密码不一致");
        }
        if (StringUtils.isEmpty(mobile)) {
            return new Result(false, "手机号不能为空");
        }
        if (StringUtils.isEmpty(code)) {
            return new Result(false, "短信验证码不能为空");
        }
        if (StringUtils.isEmpty(codeRedis)) {
            return new Result(false, "短信验证码已过期");
        }
        if (!code.equals(codeRedis)) {
            return new Result(false, "短信验证码不正确");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(password);
        String updateSql = "UPDATE `users` \n" +
                "SET \n" +
                "`password` = ?\n" +
                "WHERE\n" +
                "`user_name` = ?";
        Integer o = executeSQL(updateSql, encodedPassword, userName);
        if (o != -1) {
            redisUtils.del(mobile);
            return Result.buildSuccess(true);
        } else {
            return Result.buildError(ErrorCodeEnum.SYSTEM_BUSINESS_ERROR);
        }
    }
}
