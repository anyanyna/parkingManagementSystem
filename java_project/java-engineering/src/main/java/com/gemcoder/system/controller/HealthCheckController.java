package com.gemcoder.system.controller;

import com.gemcoder.system.bo.Result;
import com.gemcoder.system.service.UserSdkService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.security.PermitAll;

@RestController
@PermitAll
public class HealthCheckController {
    @GetMapping("/healthcheck")
    public String healthCheck() {
        return "Application is accessible!";
    }

    @GetMapping("/system/logincheck")
    public Result loginCheck() {
        Result result = new Result();
        result.setFlag(true);
        //判断权限是否打开
        if(SystemPermissionController.IS_PERMISSION_ENABLED){
            String username = UserSdkService.sdkOfGetCurrentUserName();
            if(StringUtils.isEmpty(username) || "anonymousUser".equals(username)){
                result.setData(false);
            }else {
                result.setData(true);
            }
        }else {
            result.setData(true);
        }
        return result;
    }
}
