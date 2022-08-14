package com.junmo.record.interceptor.exception;

import com.junmo.common.result.CodeEnum;

/**
 * @author: sucf
 * @date: 2022/8/14 23:38
 * @description: 参数提交错误
 */
public class ParamException extends RuntimeException{
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

    public ParamException(CodeEnum codeEnum) {
        super(codeEnum.getCode());
        this.code = codeEnum.getCode();
        this.message = codeEnum.getText();
    }
    public ParamException(String code, String message) {
        super(code);
        this.code = code;
        this.message = message;
    }
}
