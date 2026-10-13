package com.gemcoder.system.datasource;

import cn.hutool.core.util.StrUtil;
import com.alibaba.druid.util.JdbcConstants;
import cn.hutool.extra.spring.SpringUtil;
import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.druid.util.JdbcConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.alibaba.druid.sql.PagerUtils;
public class JdbcTemplateUtil {

    private static final Logger log = LoggerFactory.getLogger(JdbcTemplateUtil.class);
    private final static String SELECT = "select";
    private final static int LENGTH_SIX = 6;

 
   public static <T> T executeSQL(String sql, Object... args) {
	   	if(args!=null&&args.length==1&& args[0] instanceof List) {
	   		List<Object> list=(List<Object>)args[0];
	   		args=list.toArray();
	   	}
        log.info("执行SQL：" + sql);
        log.info("参数：" + Arrays.toString(args));
        JdbcTemplate jdbcTemplate = SpringUtil.getBean(JdbcTemplate.class);
        Predicate<String> judgeExist = StrUtil::isNotEmpty;
        Predicate<String> judgeLength = param -> param.trim().length() > LENGTH_SIX;
        Predicate<String> judgeHead = param -> param.trim().toLowerCase().startsWith(SELECT);
        Predicate<String> judgeHave = param -> param.trim().toLowerCase().contains("set");
        boolean isSelect = judgeExist.and(judgeLength).and(judgeHead).test(sql) || judgeHead.and(judgeHave).test(sql);
        if (isSelect) {
            if (args == null || args.length == 0) {
                return (T) jdbcTemplate.queryForList(sql);
            } else {
                return (T) jdbcTemplate.queryForList(sql, args);
            }
        } else {
            if (args == null || args.length == 0) {
                return (T) Integer.valueOf(jdbcTemplate.update(sql));
            } else {
                return (T) Integer.valueOf(jdbcTemplate.update(sql, args));
            }
        }
    }

    /**
     * 查询sql总数
     */
    public static Integer sdkOfPaginationQueryCount(String sql, Object... args) {
        String countSql = PagerUtils.count(sql, JdbcConstants.MYSQL);
        List<Map<String, Object>> countResult = executeSQL(countSql, args);
        return countResult.isEmpty() ? 0 : Integer.parseInt(String.valueOf(countResult.get(0).get("COUNT(*)")));
    }
}
