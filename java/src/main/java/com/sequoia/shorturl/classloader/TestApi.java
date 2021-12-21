package com.sequoia.shorturl.classloader;

import java.time.LocalTime;

/**
 * @Description:
 * @Author: usr1999
 * @Create: 2021/9/3
 */
public class TestApi implements BaseApi {

    @Override
    public void update() {
        System.out.println(LocalTime.now() + ": Java类的热加载");
        System.out.println("test222...");
    }

}
