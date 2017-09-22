package com.andy.jay.web.dto;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

public enum ErrorCode {

    MISSING_ARGUMENT(2001, HttpStatus.BAD_REQUEST.value(), "missing argument"),
    INVALID_ARGUMENT(2002, HttpStatus.BAD_REQUEST.value(), "invalid argument"),;

    private int code;
    private int httpCode;
    private String message;

    ErrorCode(int code, int httpCode, String message) {
        this.code = code;
        this.message = message;
        this.httpCode = httpCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(String message) {
        if (StringUtils.isNotEmpty(message)) {
            return String.format("%s (%s)", this.getMessage(), message);
        }
        return getMessage();
    }

    public static ErrorCode stateOf(int code) {
        for (ErrorCode errCode : values()) {
            if (errCode.getCode() == code) {
                return errCode;
            }
        }
        return null;
    }

}
