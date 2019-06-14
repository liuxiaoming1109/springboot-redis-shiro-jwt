package com.evan.common.model;

import com.evan.exception.BizExceptionEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by liuxm on 2018/4/25.
 *
 * 正确返回model
 */
@Data
@ApiModel(description= "API响应实体")
public class ResultModel<T> {
    @ApiModelProperty(value = "响应代码;0:正常; 0以外:异常")
    private int code;
    @ApiModelProperty(value = "响应消息")
    private String message;
    @ApiModelProperty(value = "响应数据")
    private T data;

    public ResultModel(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultModel(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultModel() {
        this.code = BizExceptionEnum.OK.getCode();
        this.message = BizExceptionEnum.OK.getMessage();
    }

    public ResultModel(T data) {
        this.code = BizExceptionEnum.OK.getCode();
        this.message = BizExceptionEnum.OK.getMessage();
        this.data = data;
    }

    public ResultModel(BizExceptionEnum bizExceptionEnum, T data) {
        this.code = bizExceptionEnum.getCode();
        this.message = bizExceptionEnum.getMessage();
        this.data = data;
    }

    public void setByBizExceptionEnum(BizExceptionEnum bizExceptionEnum) {
        this.code = bizExceptionEnum.getCode();
        this.message = bizExceptionEnum.getMessage();
    }

    public void setByBizExceptionEnumAndData(BizExceptionEnum bizExceptionEnum, T data) {
        this.code = bizExceptionEnum.getCode();
        this.message = bizExceptionEnum.getMessage();
        this.data = data;
    }
}
