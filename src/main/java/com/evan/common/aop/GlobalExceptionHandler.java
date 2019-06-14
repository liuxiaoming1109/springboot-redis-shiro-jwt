package com.evan.common.aop;

import com.evan.common.model.ErrorModel;
import com.evan.core.aop.BaseControllerExceptionHandler;
import com.evan.exception.BizExceptionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 *
 * Created by liuxm on 2019/6/14.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends BaseControllerExceptionHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 拦截jwt相关异常
     */
//    @ExceptionHandler(JwtException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ErrorModel jwtException(JwtException e) {
//        return new ErrorModel(BizExceptionEnum.TOKEN_ERROR.getCode(), BizExceptionEnum.TOKEN_ERROR.getMessage());
//    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @Override
    public ErrorModel notFount(RuntimeException e) {
        if (e.getCause() != null && e.getCause().getMessage().contains("Data too long")) {
            log.error("运行时异常:", e);
            return new ErrorModel(BizExceptionEnum.SERVER_DATABASE_ERROR.getCode(), BizExceptionEnum.SERVER_DATABASE_ERROR.getMessage());
        } else {
            return super.notFount(e);
        }
    }

}
