package com.gemcoder.system.security.sms;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.excel.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.gemcoder.system.security.CustomAuthenticationFailureHandler;
import com.gemcoder.system.service.UserSdkService;
import com.gemcoder.system.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证码校验过滤器
 */
@Component
public class SmsCodeValidateFilter extends OncePerRequestFilter {

    @Resource
    private RedisUtils redisUtils;
    @Autowired
    private UserSdkService userService;
    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = httpServletRequest.getRequestURI();
        String method = httpServletRequest.getMethod();
        if (StringUtils.equals("/loginBySms", requestURI) && StringUtils.equals(method, "POST")) {
            //验证手机号、验证码等信息，同样需要对输入的手机号进行查库校验是否是注册的手机号
            try {
                String mobile = httpServletRequest.getParameter("mobile");
                String codeRequest = httpServletRequest.getParameter("code");
                String codeRedis = redisUtils.get(mobile) == null ? "" : String.valueOf(redisUtils.get(mobile));
                JSONObject userByMobile = userService.getUserByMobile(mobile);
                if (CollectionUtil.isEmpty(userByMobile)) {
                    throw new SessionAuthenticationException("该手机号不是系统注册用户");
                }
                if (StringUtils.isEmpty(mobile)) {
                    throw new SessionAuthenticationException("手机号不能为空");
                }
                if (StringUtils.isEmpty(codeRequest)) {
                    throw new SessionAuthenticationException("短信验证码不能为空");
                }
                if (StringUtils.isEmpty(codeRedis)) {
                    throw new SessionAuthenticationException("短信验证码已过期");
                }
                if (!codeRequest.equals(codeRedis)) {
                    throw new SessionAuthenticationException("短信验证码不正确");
                } else {
                    redisUtils.del(mobile);
                }
            } catch (SessionAuthenticationException e) {
                customAuthenticationFailureHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
                return;
            }
        }
        //验证成功后继续后续的过滤器链
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}

