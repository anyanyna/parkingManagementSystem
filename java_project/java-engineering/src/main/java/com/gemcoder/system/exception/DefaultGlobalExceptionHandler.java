package com.gemcoder.system.exception;

import com.gemcoder.system.bo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DefaultGlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(DefaultGlobalExceptionHandler.class);

    @SuppressWarnings("AlibabaMethodTooLong")
    @ExceptionHandler(Exception.class)
    public Result handle(Exception e) {
        Result result = new Result();
        result.setFlag(false);
        result.setMessage(e.getMessage());
        if (e instanceof BaseSystemException) {
            //基础服务自定义的异常
            BaseSystemException baseSystemException = (BaseSystemException) e;
            result.setMessage(baseSystemException.getMessage());
        } else {
            logger.error("系统异常", e);
            result.setMessage(e.getMessage());
        }
        return result;
    }
}
