package com.test.spring2025_3_12;

import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisTest {
    @Autowired
    public RedissonClient redissonClient;

    @Test
    void test() throws InterruptedException {
        // 获取锁对象
        RLock user = redissonClient.getLock("user");
        // 尝试获取锁
        boolean flag = user.tryLock(1, 10, TimeUnit.SECONDS);
        if (flag) {
            try {
                System.out.println("业务逻辑...");
            } finally {
                // 解锁
                user.unlock();
            }
        }
    }
}
