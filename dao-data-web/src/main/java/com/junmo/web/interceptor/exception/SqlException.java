package com.junmo.web.interceptor.exception;

/**
 * @author: Sucf
 * @create: 2022-04-17 14:39:43
 * @description: sql相关报错
 */
public class SqlException extends RuntimeException{
    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SqlException(String code, String message) {
        super(code);
        this.code = code;
        this.message = message;
    }
}
