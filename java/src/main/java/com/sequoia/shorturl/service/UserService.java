package com.sequoia.shorturl.service;

import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: jzq
 * @Create: 2022/2/18
 */
public interface UserService {

    void foo();

    Future<String> testAsync() throws InterruptedException;

}
