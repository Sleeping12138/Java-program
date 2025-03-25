package com.test.spring2025_3_25.Demo1;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class demo1 {
    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool("tcp://127.0.0.1:8888");
        try(Jedis jedis = jedisPool.getResource()){
            String s = jedis.get("name");
            System.out.println(s);
        }
    }
}
