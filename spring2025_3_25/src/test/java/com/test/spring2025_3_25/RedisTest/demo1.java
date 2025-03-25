package com.test.spring2025_3_25.RedisTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class demo1 {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test1(){
        stringRedisTemplate.opsForValue().set("name","lisi");
        System.out.println(stringRedisTemplate.opsForValue().get("name"));
    }
}
