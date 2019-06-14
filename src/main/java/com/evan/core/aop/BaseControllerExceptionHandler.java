package com.evan.core.aop;

import com.evan.common.model.ErrorModel;
import com.evan.core.exception.EvanException;
import com.evan.core.exception.EvanExceptionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by liuxm on 2019/6/14.
 */
public class BaseControllerExceptionHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 拦截业务异常
     */
    @ExceptionHandler(EvanException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorModel notFount(EvanException e) {
        log.error("业务异常:", e);
        return new ErrorModel(e.getCode(), e.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorModel notFount(RuntimeException e) {
        log.error("运行时异常:", e);
        return new ErrorModel(EvanExceptionEnum.SERVER_ERROR.getCode(), EvanExceptionEnum.SERVER_ERROR.getMessage());
    }

}
