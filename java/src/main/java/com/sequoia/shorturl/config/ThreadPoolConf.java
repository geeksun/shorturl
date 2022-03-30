package com.sequoia.shorturl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description:
 * @Author: jzq
 * @Create: 2022/3/30
 */
@Configuration
@EnableAsync
public class ThreadPoolConf {

    @Bean(name = "userCacheThreadPool")
    public ThreadPoolTaskExecutor userCacheThreadPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数,它是可以同时被执行的线程数量
        executor.setCorePoolSize(32);
        // 设置最大线程数,缓冲队列满了之后会申请超过核心线程数的线程
        executor.setMaxPoolSize(64);
        // 设置缓冲队列容量,在执行任务之前用于保存任务
        executor.setQueueCapacity(128);
        // 设置线程生存时间（秒）,当超过了核心线程出之外的线程在生存时间到达之后会被销毁
        executor.setKeepAliveSeconds(600);
        // 设置线程名称前缀
        executor.setThreadNamePrefix("userCachePool-");
        // 设置拒绝策略:
        //        CallerRunsPolicy: 不在新线程中执行任务，而是由调用者所在的线程来执行；
        //        AbortPolicy: 拒绝执行新任务，并抛出RejectedExecutionException异常；
        //        DiscardPolicy：丢弃当前将要加入队列的任务；
        //        DiscardOldestPolicy：丢弃任务队列中最旧的任务；
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        //executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();

        return executor;
    }

}
