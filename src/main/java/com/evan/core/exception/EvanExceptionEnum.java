package com.evan.core.exception;

/**
 * 异常枚举
 *
 * Created by liuxm on 2019/6/14.
 */
public enum EvanExceptionEnum implements ServiceExceptionEnum {
    /**
     * 输入日期格式不对
     */
    INVLIDE_DATE_STRING(400, "输入日期格式不对"),

    /**
     * 渲染界面错误
     */
    WRITE_ERROR(500, "渲染界面错误"),

    /**
     * 文件上传
     */
    FILE_READING_ERROR(400, "FILE_READING_ERROR!"),
    FILE_NOT_FOUND(400, "FILE_NOT_FOUND!"),

    /**
     * 错误的请求
     */
    REQUEST_NULL(400, "请求有错误"),
    SERVER_ERROR(500, "服务器异常");

    EvanExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

    @Override
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
