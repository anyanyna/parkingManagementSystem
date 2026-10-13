package com.gemcoder.system.bo;

import com.gemcoder.system.exception.ErrorCodeEnum;

import java.io.Serializable;

public class Result implements Serializable {
    private static final long serialVersionUID = 1L;

    public boolean flag;
    public String message;
    public Object data;

    public String code;

    public Result() {}

    public Result(boolean flag, String message, Object data) {
        this.flag = flag;
        this.message = message;
        this.data = data;
    }

    public Result(boolean flag, String message, Object data, String code) {
        this.flag = flag;
        this.message = message;
        this.data = data;
        this.code = code;
    }

    public static Result buildSuccess(Object data){
        return new Result(true, "success", data);
    }

    public static Result buildError(ErrorCodeEnum errorCodeEnum) {
        return new Result(false, errorCodeEnum.getDesc(), null, errorCodeEnum.getCode());
    }

    public Result(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public  void failMessage(String message) {
        this.setFlag(false);
        this.setMessage(message);
    }

}
