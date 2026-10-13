package com.gemcoder.system.security.sms;

import com.gemcoder.system.security.CustomAuthenticationFailureHandler;
import com.gemcoder.system.security.CustomAuthenticationSuccessHandler;
import com.gemcoder.system.security.YtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Component;

/**
 * 短信登录配置类
 */
@Component
public class SmsCodeSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private YtUserDetailsService userDetailsService;
    @Autowired
    private SmsCodeValidateFilter smsCodeValidateFilter;
    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Value("${security.url.login}")
    private String loginUrl;

    @Value("${security.url.permit}")
    private String[] permitUrl;

    @Value("${security.url.index}")
    private String indexUrl;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //1、配置过滤器
        SmsCodeAuthenticationFilter smsCodeAuthenticationFilter = new SmsCodeAuthenticationFilter();
        smsCodeAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        //成功和失败的处理器，需要自己处理
        smsCodeAuthenticationFilter.setAuthenticationSuccessHandler(new CustomAuthenticationSuccessHandler(indexUrl));
        smsCodeAuthenticationFilter.setAuthenticationFailureHandler(customAuthenticationFailureHandler);
        //成功和失败的处理器，需要自己处理
        //2、配置provider
        SmsCodeAuthenticationProvider smsCodeAuthenticationProvider = new SmsCodeAuthenticationProvider();
        smsCodeAuthenticationProvider.setUserDetailsService(userDetailsService);
        //3、确定各个过滤器的顺序，验证码的验证过滤器应该在加载用户详细信息之前
        http.authenticationProvider(smsCodeAuthenticationProvider);
        /*http.addFilterBefore(smsCodeValidateFilter,UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(smsCodeAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);*/
        http.addFilterBefore(smsCodeValidateFilter, FilterSecurityInterceptor.class);
        http.addFilterAfter(smsCodeAuthenticationFilter,FilterSecurityInterceptor.class);
    }
}

