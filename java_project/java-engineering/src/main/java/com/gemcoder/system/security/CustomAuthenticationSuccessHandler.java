package com.gemcoder.system.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemcoder.system.bo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);
    public static final String LOGIN_SUCCESS = "登录成功";

    private String redirectUrl;

    public CustomAuthenticationSuccessHandler(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        logger.info(LOGIN_SUCCESS);
        // 重定向到首页
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Result result = new Result(true, LOGIN_SUCCESS, redirectUrl.replace("/#",""));
        response.setContentType("application/json;charset=UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }

}
