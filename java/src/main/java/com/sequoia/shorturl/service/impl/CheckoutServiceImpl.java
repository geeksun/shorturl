package com.sequoia.shorturl.service.impl;

import com.sequoia.shorturl.domain.User;
import com.sequoia.shorturl.service.CheckoutService;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @Description:
 * @Author: usr1999
 * @Create: 2021/9/20
 */
@Validated // Spring的注解
public class CheckoutServiceImpl implements CheckoutService {


    @Override
    public String checkout(@Valid User cmd) {
        // 如果校验失败会抛异常，在interface层被捕捉

        return null;
    }

}
