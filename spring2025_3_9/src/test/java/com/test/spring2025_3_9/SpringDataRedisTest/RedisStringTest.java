package com.test.spring2025_3_9.SpringDataRedisTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.spring2025_3_9.Model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;

@SpringBootTest
public class RedisStringTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void stringTest() {
        stringRedisTemplate.opsForValue().set("name","zhangsan");

        String s = stringRedisTemplate.opsForValue().get("name");
        System.out.println(s);
    }

    private User user = new User("wangwu",20);
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    void objectTest() throws JsonProcessingException {
        String s = mapper.writeValueAsString(user);
        stringRedisTemplate.opsForValue().set("user:1",s);

        String ret = stringRedisTemplate.opsForValue().get("user:1");
        User res = mapper.readValue(ret, User.class);
        System.out.println(res);
    }

    @Test
    void testHash() {
        stringRedisTemplate.opsForHash().put("student","name","zhangsan");
        stringRedisTemplate.opsForHash().put("student","age","20");

        Map<Object, Object> student = stringRedisTemplate.opsForHash().entries("student");
        System.out.println(student);
    }

    @Test
    void testSet() {
        
    }
}
