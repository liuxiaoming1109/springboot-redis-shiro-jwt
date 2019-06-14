package com.evan.core.exception;

/**
 * 封装异常
 *
 * Created by liuxm on 2019/6/14.
 */
public class EvanException extends RuntimeException {

    private Integer code;

    private String message;

    public EvanException(ServiceExceptionEnum serviceExceptionEnum) {
        this.code = serviceExceptionEnum.getCode();
        this.message = serviceExceptionEnum.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
