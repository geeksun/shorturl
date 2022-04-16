package com.sequoia.shorturl;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.CompletableFuture;

/**
 * @Description:
 * @Author: jzq
 * @Create: 2022/4/15
 */
public class CaffenieTest2 {

    public static void main(String... args) throws Exception {

        AsyncLoadingCache<String, Integer> cache = Caffeine.newBuilder().buildAsync(name -> {
            System.out.println("name:" + name);
            return 18;
        });

        CompletableFuture<Integer> ageFuture = cache.get("张三");

        Integer age = ageFuture.get();
        System.out.println("age:" + age);
    }

}
