package com.sequoia.shorturl.config;

import com.sequoia.shorturl.common.Result;
import com.sequoia.shorturl.enums.ErrorEnum;
import com.sequoia.shorturl.exception.DefinitionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: AOP 处理全局异常:
 *  SpringBoot系列（十）统一异常处理与统一结果返回: https://www.cnblogs.com/swzx-1213/p/12781836.html
 * @Author: usr1999
 * @Create: 2021/9/20
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(value = DefinitionException.class)
    @ResponseBody
    public Result bizExceptionHandler(DefinitionException e) {
        return Result.defineError(e);
    }

    /**
     * 处理其他异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e) {
        return Result.otherError(ErrorEnum.INTERNAL_SERVER_ERROR);
    }

}
