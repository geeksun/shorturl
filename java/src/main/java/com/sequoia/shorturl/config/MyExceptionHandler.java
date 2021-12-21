package com.sequoia.shorturl.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Description: Spring Boot 全局异常处理
 * @Author: usr1999
 * @Create: 2021/9/20
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value =Exception.class)
    public String exceptionHandler(Exception e) {
        System.out.println("发生了一个异常: "+e);
        return e.getMessage();
    }

}
