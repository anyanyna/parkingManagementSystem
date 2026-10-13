package com.gemcoder.system.exception;

public class BaseSystemException extends RuntimeException {
    private String errorCode;
    private String errorMsg;
    private String complementary;

    public BaseSystemException(BaseErrorCodeEnum error) {
        super(error.getDesc());
        this.errorCode = error.getCode();
        this.errorMsg = error.getDesc();
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getComplementary() {
        return this.complementary;
    }

    public void setComplementary(String complementary) {
        this.complementary = complementary;
    }

    @Override
    public String toString() {
        return "异常信息{errorCode='" + this.errorCode + "', errorMsg='" + this.errorMsg + "', cause='" + this.getCause() + "', complementary='" + this.complementary + "'}";
    }
}
