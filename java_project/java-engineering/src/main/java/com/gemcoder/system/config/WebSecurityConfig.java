package com.gemcoder.system.config;

import com.gemcoder.system.filter.CustomPermissionInterceptor;
import com.gemcoder.system.security.CustomAuthenticationFailureHandler;
import com.gemcoder.system.security.CustomAuthenticationSuccessHandler;
import com.gemcoder.system.security.sms.SmsCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.annotation.Resource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${security.url.login}")
    private String loginUrl;

    @Value("${security.url.permit}")
    private String[] permitUrl;

    @Value("${security.url.index}")
    private String indexUrl;


    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Autowired
    private CustomPermissionInterceptor customPermissionInterceptor;
    @Resource
    private SmsCodeSecurityConfig securityConfig;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.cors(); //禁用CSRF
        http.csrf().disable().cors(); //禁用CSRF
        http.exceptionHandling()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint(loginUrl))
                .and()
                .authorizeRequests()
                .antMatchers(permitUrl).permitAll() // 允许对于网站静态资源的无授权访问
                .anyRequest().authenticated() // 其他地址的访问均需验证权限
                .and()
                .apply(securityConfig).and()
                .formLogin()
                .loginProcessingUrl("/login")
                .loginPage(loginUrl) // 设置登录页
                .permitAll() // 登录页面用户任意访问
                .successHandler(new CustomAuthenticationSuccessHandler(indexUrl))
                .failureHandler(customAuthenticationFailureHandler)
                .and()
                .logout()
                .logoutSuccessUrl(loginUrl)
                .permitAll()
        ; // 注销行为任意访问
        //  http.cors();
        //添加拦截器
        http.addFilterBefore(customPermissionInterceptor, FilterSecurityInterceptor.class);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
