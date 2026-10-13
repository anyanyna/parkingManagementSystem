package com.gemcoder.system.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemcoder.system.bo.Result;
import com.gemcoder.system.controller.SystemPermissionController;
import com.gemcoder.system.exception.ErrorCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import static com.gemcoder.system.service.permission.PermissionSdkService.*;

@Component("customPermissionInterceptor")
public class CustomPermissionInterceptor extends OncePerRequestFilter {

    private final static Set<String> urls = getAllPermissionsUrl();

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!SystemPermissionController.IS_PERMISSION_ENABLED) {
            filterChain.doFilter(request, response);
            return;
        }

        if (!urls.contains(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }

        if (authentication != null && authentication.isAuthenticated()) {
            String userName = authentication.getName();
            String endpoint = request.getRequestURI();

            // 获取用户角色
            List<String> roleCodes = getRoleCodesByUserName(userName);

            // 获取角色权限
            List<String> urls = getUrlPermissionsByRole(roleCodes);

            // 检查权限
            boolean hasPermission = urls.stream().anyMatch(url ->
                    url.equals(endpoint)
            );

            if (!hasPermission) {
                respondWithError(response, ErrorCodeEnum.NO_PERMISSION.getDesc(),ErrorCodeEnum.NO_LOGIN.getCode());
                return;
            }
        } else {
            respondWithError(response, ErrorCodeEnum.NO_LOGIN.getDesc(),ErrorCodeEnum.NO_LOGIN.getCode());
            return;
        }

        filterChain.doFilter(request, response);
    }

    private void respondWithError(HttpServletResponse response, String message,String code) throws IOException {
        response.setStatus(200);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(new Result(false, message, null,code)));
    }
}