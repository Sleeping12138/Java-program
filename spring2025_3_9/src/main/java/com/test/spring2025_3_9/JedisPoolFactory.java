package com.test.spring2025_3_9;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolFactory {
    private static final JedisPool jedisPool;

    static {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(8);
        poolConfig.setMaxIdle(8);
        poolConfig.setMinIdle(0);
        poolConfig.setMaxWaitMillis(1000);
        jedisPool = new JedisPool(poolConfig,
                "192.168.60.101",6379,1000,"woshizjy12138");
    }

    public static Jedis getJedisPool(){
        return jedisPool.getResource();
    }

}
