package com.sequoia.shorturl.service.impl;

import com.sequoia.shorturl.mapper.UserMapper;
import com.sequoia.shorturl.po.User;
import com.sequoia.shorturl.service.UserService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: jzq
 * @Create: 2022/2/18
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ThreadPoolTaskExecutor userMQThreadPool;

    @Transactional
    @Override
    public void foo() {
        try {
            Future future = testAsync();
            //System.out.println("foo threadName="+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } /*catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        userMQThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("foo.threadName=" + Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        User user = new User();
        user.setAge(18);
        user.setName("test");
        user.setEmail("test@gamil.com");
        userMapper.insert(user);

        System.out.println("foo finished!");

        if (false) {
            throw new RuntimeException("Save 抛异常了");
        }
    }

    @Async
    @Override
    public Future<String> testAsync() throws InterruptedException {
        System.out.println("testAsync任务执行开始,需要：1000ms");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            System.out.println("testAsync-do:" + i);
        }
        System.out.println("testAsync完成任务: "+Thread.currentThread().getName());
        return new AsyncResult<>(Thread.currentThread().getName());
    }

}


