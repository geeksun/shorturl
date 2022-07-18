package com.sequoia.shorturl.thread;

/**
 * @Description: volatile可见性测试
 * @Author: jzq
 * @Create: 2022/7/18
 */
public class VolatileTest {

    public static volatile int count = 0;

    public static void inc() {
        // 这里延迟1毫秒，使得结果明显
        /*try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        count++;
    }

    public static void main(String[] args) {
        // 同时启动1000个线程，去进行i++计算，看看实际结果
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    inc();
                }
            }).start();
        }

        // 这里每次运行的值都有可能不同, 小于1000
        System.out.println("运行结果: count=" + VolatileTest.count);
    }

}
