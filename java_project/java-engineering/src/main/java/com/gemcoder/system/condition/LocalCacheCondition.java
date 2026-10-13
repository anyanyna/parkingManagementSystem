package com.gemcoder.system.condition;

import cn.hutool.core.util.StrUtil;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

/**
 * @Author: gemcoder
 * @CreateTime: 2024-03-21  10:43
 * @Description:
 */
@Component
public class LocalCacheCondition implements Condition {



    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        String redisHost = env.getProperty("spring.redis.host");
        return StrUtil.isBlank(redisHost);
    }
}
