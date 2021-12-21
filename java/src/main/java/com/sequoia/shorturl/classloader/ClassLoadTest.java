package com.sequoia.shorturl.classloader;

/**
 * @Description:
 * @Author: usr1999
 * @Create: 2021/9/4
 */
public class ClassLoadTest {

    public static void main(String[] args) {
        new Thread(new MsgHandle()).start();
    }

}
