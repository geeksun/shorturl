package com.sequoia.shorturl.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: jzq
 * @Create: 2022/3/30
 */
@Service
public class FutureService {

    @Async
    public Future<String> futureTest() throws InterruptedException {
        System.out.println("任务执行开始,需要：1000ms");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            System.out.println("do:" + i);
        }
        System.out.println("完成任务");
        return new AsyncResult<>(Thread.currentThread().getName());
    }

}
