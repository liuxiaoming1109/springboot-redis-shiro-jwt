package com.evan.exception;


import com.evan.core.exception.ServiceExceptionEnum;

/**
 * 所有业务异常的枚举
 *
 * @author fengshuonan
 * @date 2016年11月12日 下午5:04:51
 */
public enum BizExceptionEnum implements ServiceExceptionEnum {

    OK(0, "SUCCESS"),


    BAD_REQUEST(300, "请求参数错误"),

    DATA_NOT_EXIST(301, "该数据不存在"),


    /**
     * token异常
     */
    TOKEN_EXPIRED(700, "登录信息已失效，请重新登录。"),
    TOKEN_ERROR(700, "登录信息验证失败，请重新登录。"),
    TOKEN_CHANGE_ERROR(700, "您的账号在其他设备登录，请注意密码是否泄露！"),
    /**
     * 签名异常
     */
    SIGN_ERROR(700, "签名验证失败"),


    /**
     * 其他
     */
    AUTH_REQUEST_ACCOUNT_NOT_EXIST(400, "账号不存在"),
    AUTH_REQUEST_PASSWORD_ERROR(401, "密码错误"),
    SERVER_DATABASE_ERROR(501, "数据保存失败"),
    DELETE_DATABASE_ERROR(502, "数据删除失败");


    BizExceptionEnum(int code, String message) {
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
