package com.gemcoder.system.config;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.CacheControl;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

@Configuration
public class BaseWebMvcConfig implements WebMvcConfigurer {

    /**
     * 应用资源地址，未配置为当前目录下 resource 文件夹
     */
    @Value("${external.resource.path:#{null}}")
    private String externalResourcePath;

    @Value("${upload.dir:d:\\upload}")
    String uploadDir;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
        WebMvcConfigurer.super.addCorsMappings(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/staticResource/**")
                .addResourceLocations(getResourcePath())
                .setCacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS));
        registry.addResourceHandler("/staticCommonUpload/**")
                .addResourceLocations(getCommonLoadPath())
                .setCacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS));
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    private String getResourcePath() {
        if (StrUtil.isBlank(externalResourcePath)) {
            return Paths.get(System.getProperty("user.dir"), "resource").toUri().toString();
        }
        return Paths.get(externalResourcePath).toUri().toString();
    }
    public String getResourcePathString() {
        if (StrUtil.isBlank(externalResourcePath)) {
            return System.getProperty("user.dir") + File.separator + "resource";
        }
        return externalResourcePath;
    }
    private String getCommonLoadPath() {
        return Paths.get(uploadDir,"commonUpload").toUri().toString();
    }

    @Bean
    public FilterRegistrationBean<DelegatingFilterProxy> permissionFilter() {
        FilterRegistrationBean<DelegatingFilterProxy> registration = new FilterRegistrationBean<>();
        DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy("customPermissionInterceptor");

        registration.setFilter(delegatingFilterProxy);
        registration.addUrlPatterns("/*/**");  // 根据需要调整 URL 模式
        registration.setName("customPermissionInterceptor");
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE); // 设置合适的优先级
        return registration;
    }

}
