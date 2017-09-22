package com.andy.jay.web.dto;


import com.andy.jay.util.JsonHelper;

public class Result<T> {

    private boolean success;
    private T data;
    private String msg;
    private int errorCode;

    public Result() {
    }

    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public Result(boolean success, ErrorCode errorCode) {
        this.success = success;
        this.msg = errorCode.getMessage();
        this.errorCode = errorCode.getCode();
    }

    public Result(boolean success, String msg, int errorCode) {
        this.success = success;
        this.msg = msg;
        this.errorCode = errorCode;
    }

    public Result(boolean success, T data, String msg, int errorCode) {
        this.success = success;
        this.data = data;
        this.msg = msg;
        this.errorCode = errorCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String toJson() {
        return JsonHelper.getInstance().toString(this);
    }

}
