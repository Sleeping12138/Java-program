package com.test.spring2025_3_9.SpringDataRedisTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class springDataRedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void testString() {
        redisTemplate.opsForValue().set("name","zhangsan");

        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }
}
