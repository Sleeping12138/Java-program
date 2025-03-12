package com.test.spring2025_3_12.Demo;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisTest {
    @Autowired
    public RedissonClient redissonClient;
}
