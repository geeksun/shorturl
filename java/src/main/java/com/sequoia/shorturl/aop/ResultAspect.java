package com.sequoia.shorturl.aop;

import com.sequoia.shorturl.common.Result;
import com.sequoia.shorturl.exception.ConstraintViolationException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Description: AOP 统一异常处理
 * @Author: usr1999
 * @Create: 2021/9/20
 */
@Aspect
@Component
public class ResultAspect {

    @Around("@annotation(ResultHandler)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (ConstraintViolationException cve) {
            return Result.fail(cve.getMessage());
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
        return proceed;
    }

}
