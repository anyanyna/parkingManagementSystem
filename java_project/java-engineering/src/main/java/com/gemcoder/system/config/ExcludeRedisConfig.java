package com.gemcoder.system.config;



import com.gemcoder.system.condition.LocalCacheCondition;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 使用本地缓存时，排除Redis自动配置
 * @author: gemcoder
 * @createTime: 2024-04-16 13:46
 */
@Conditional(LocalCacheCondition.class)
@Configuration
@EnableAutoConfiguration(exclude = RedisAutoConfiguration.class)
public class ExcludeRedisConfig {
}
