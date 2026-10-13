package com.gemcoder.system.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemcoder.system.bo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final Logger logger = LoggerFactory.getLogger(CustomAuthenticationFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        Result results = new Result();
        if (exception instanceof UsernameNotFoundException) {
            results.failMessage("用户不存在！请重试！");
        } else if (exception instanceof BadCredentialsException) {
            results.failMessage("密码错误！请重试！");
        } else if (exception instanceof LockedException) {
            results.failMessage("账户被锁定，请联系管理员!");
        } else if (exception instanceof CredentialsExpiredException) {
            results.failMessage("证书过期，请联系管理员!");
        } else if (exception instanceof AccountExpiredException) {
            results.failMessage("账户过期，请联系管理员!");
        } else if (exception instanceof DisabledException) {
            results.failMessage("账户被删除，请联系管理员!");
        } else if(exception instanceof SessionAuthenticationException){
            results.failMessage(exception.getMessage());
        }else {
            logger.error("登录失败：", exception);
            results.failMessage("登录失败!");
        }
        response.setContentType("application/json;charset=UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(results));
    }
}
