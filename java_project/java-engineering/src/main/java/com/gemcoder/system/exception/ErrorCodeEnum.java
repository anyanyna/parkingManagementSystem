package com.gemcoder.system.exception;

/**
 *
 */
public enum ErrorCodeEnum implements BaseErrorCodeEnum {

    NO_LOGIN("8001","用户未登录，请先登录!"),
    NO_PERMISSION("8002","对该接口没有访问权限!"),
    NO_USER("8003","用户不存在!"),
    PARAMETER_MISSING("8004","参数缺失"),
    SYSTEM_BUSINESS_ERROR("9001", "系统业务错误"),
    SYSTEM_UNKNOWN_ERROR("9002", "系统未知错误"),
    DATA_UNKNOWN_ERROR("9003","数据格式化异常");

    private String code;
    private String desc;

    ErrorCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Error{" + "code='" + code + '\'' + ", desc='" + desc + '\'' + '}';
    }
}
