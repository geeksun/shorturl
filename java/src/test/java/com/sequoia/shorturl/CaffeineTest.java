package com.sequoia.shorturl;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author: jzq
 * @Create: 2022/4/15
 */
public class CaffeineTest {

    private static ThreadPoolExecutor executorService = new ThreadPoolExecutor(4,
            4,
            2,
            TimeUnit.MINUTES,
            new LinkedBlockingDeque<>());

    private static LoadingCache<String, String> localCache = Caffeine.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(10, TimeUnit.MINUTES)  // 10分钟淘汰掉
            .refreshAfterWrite(1, TimeUnit.SECONDS)
            .build(new CacheLoader<String, String>() {

                @Override
                public String load(String token) throws Exception {
                    return "直接获取数据";
                }

                @Override
                public CompletableFuture<String> asyncReload(String key, String oldValue, Executor executor) {
                    System.out.println("自动刷新缓存");

                    return CompletableFuture.supplyAsync(() -> {
                        System.out.println("执行异步刷新");
                        return "异步刷新的值";
                    }, executorService);
                }
            });


    public static void main(String[] args) throws InterruptedException {
        System.out.println(getValue("1"));
        Thread.sleep(2000);
        System.out.println(getValue("1"));
        Thread.sleep(2000);
        System.out.println(getValue("1"));
    }

    public static String getValue(String key) {
        System.out.println("getValue: " + key);
        return localCache.get(key);
    }

}
