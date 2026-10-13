package com.gemcoder.system.security;

import com.gemcoder.system.bo.Result;
import com.gemcoder.system.exception.BaseSystemException;
import com.gemcoder.system.exception.ErrorCodeEnum;
import com.gemcoder.system.service.UserSdkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userDetailsService")
public class YtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserSdkService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Map<String, Object> paramMap = new HashMap<>(1);
        paramMap.put("user_name", username);
        Result userResult = userService.getUser(paramMap);
        if (userResult.getData() == null || ((List<Map<String, Object>>) userResult.getData()).size() == 0) {
            throw new UsernameNotFoundException("用户不存在");
        }
        Map<String, Object> userMap = ((List<Map<String, Object>>) userResult.getData()).get(0);
        Integer status = (Integer) userMap.getOrDefault("status", 0);
        if (status == 1) {
            throw new DisabledException("账户被删除");
        } else if (status == 2) {
            throw new LockedException("账户被锁定");
        }
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        //把用户的相关数据加入信息中
        return new User((String) userMap.get("user_name"), (String) userMap.get("password"), authorityList);
    }

    public UserDetails loadUserByPhone(String mobile) throws Exception {

        Map<String, Object> paramMap = new HashMap<>(1);
        paramMap.put("mobile", mobile);
        Result userResult = userService.getUserByMobile(paramMap);
        if (userResult.getData() == null || ((List<Map<String, Object>>) userResult.getData()).size() == 0) {
            throw new UsernameNotFoundException("用户不存在");
        }
        Map<String, Object> userMap = ((List<Map<String, Object>>) userResult.getData()).get(0);
        Integer status = (Integer) userMap.getOrDefault("status", 0);
        if (status == 1) {
            throw new DisabledException("账户被删除");
        } else if (status == 2) {
            throw new LockedException("账户被锁定");
        }
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        //把用户的相关数据加入信息中
        return new User((String) userMap.get("user_name"), (String) userMap.get("password"), authorityList);
    }

}
