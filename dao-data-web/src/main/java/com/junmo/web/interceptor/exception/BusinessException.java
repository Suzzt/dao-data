package com.junmo.web.interceptor.exception;


import com.junmo.common.result.CodeEnum;

/**
 * @author: sucf
 * @create: 2022-04-17 18:09:07
 * @description: 业务异常
 */
public class BusinessException extends RuntimeException{
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

    public BusinessException(String code, String message) {
        super(code);
        this.code = code;
        this.message = message;
    }

    public BusinessException(CodeEnum codeEnum) {
        super(codeEnum.getCode());
        this.code = codeEnum.getCode();
        this.message = codeEnum.getText();
    }
}
