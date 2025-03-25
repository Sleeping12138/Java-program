package com.test.spring2025_3_25.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("redis")
@RestController
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


}
