package com.test.spring2025_3_25.Demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demo4 {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static void main(String[] args) {

    }
}
