package com.sequoia.shorturl.service;

import com.sequoia.shorturl.domain.User;
import javax.validation.Valid;

/**
 * @Description:
 * @Author: usr1999
 * @Create: 2021/9/20
 */
public interface CheckoutService {

    //OrderDTO checkout(@Valid CheckoutCommand cmd);

    String checkout(@Valid User cmd);

}
