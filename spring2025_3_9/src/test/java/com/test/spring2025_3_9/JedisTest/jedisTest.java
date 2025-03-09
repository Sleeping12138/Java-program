package com.test.spring2025_3_9.JedisTest;

import com.test.spring2025_3_9.JedisPoolFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class jedisTest {
    private Jedis jedis;
    @BeforeEach
    void setUp() {
        jedis = new Jedis("192.168.60.101",6379);
        jedis.auth("woshizjy12138");
        jedis.select(0);
    }

    @Test
    void testString() {
        String ret = jedis.set("stu", "zhangsan");
        System.out.println(ret);

        System.out.println(jedis.get("stu"));
    }



    @Test
    void testHash() {
        jedis.hset("temp","name","lisi");
        jedis.hset("temp","age","18");

        Map<String, String> temp = jedis.hgetAll("temp");
        System.out.println(temp);
    }

    @AfterEach
    void tearDown() {
        if(jedis!=null){
            jedis.close();
        }
    }
}
