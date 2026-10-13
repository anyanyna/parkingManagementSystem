package com.gemcoder.system.security.sms;

import com.gemcoder.system.security.YtUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;

/**
 * 主要是用来配置userDetailsService类来查询用户信息
 * 跟之前的用户名密码登录汇合到一起
 */
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {

    private Logger logger = LoggerFactory.getLogger(SmsCodeAuthenticationProvider.class);

    private YtUserDetailsService userDetailsService;
    private UserDetailsChecker preAuthenticationChecks = new SmsCodeAuthenticationProvider.DefaultPreAuthenticationChecks();

    public void setUserDetailsService(YtUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    protected UserDetailsService getUserDetailsService() {
        return this.userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsCodeAuthenticationToken authenticationToken = (SmsCodeAuthenticationToken) authentication;
        UserDetails userDetails = null;

        try {
            userDetails = userDetailsService.loadUserByPhone((String) authenticationToken.getPrincipal());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        SmsCodeAuthenticationToken authenticationResult = new SmsCodeAuthenticationToken(userDetails, new ArrayList<SimpleGrantedAuthority>());
        authenticationResult.setDetails(authenticationToken.getDetails());
        preAuthenticationChecks.check(userDetails);
        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
    }

    /**
     * 模拟DaoAuthenticationProvider
     * 用来检验账号是否被禁用、被锁
     * 直接粘过来就能用
     */
    private class DefaultPreAuthenticationChecks implements UserDetailsChecker {
        private DefaultPreAuthenticationChecks() {
        }

        @Override
        public void check(UserDetails user) {
            if (!user.isAccountNonLocked()) {
                logger.debug("User account is locked");
                throw new LockedException("User account is locked");
            } else if (!user.isEnabled()) {
                logger.debug("User account is disabled");
                throw new DisabledException("User is disabled");
            } else if (!user.isAccountNonExpired()) {
                logger.debug("User account is expired");
                throw new AccountExpiredException("User account has expired");
            }
        }
    }
}

