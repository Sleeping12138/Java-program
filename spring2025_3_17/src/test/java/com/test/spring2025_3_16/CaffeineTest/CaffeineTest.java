package com.test.spring2025_3_16.CaffeineTest;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

@SpringBootTest
public class CaffeineTest {
    @Test
    void test() {

        // 设置最大存储容量
        Cache<String, String> cache = Caffeine.newBuilder()
                .maximumSize(1)
                .build();

        // 设置缓存有效期
        Cache<String, String> cache1 = Caffeine.newBuilder()
                .expireAfterWrite(Duration.ofSeconds(10))
                .build();

        cache.put("name", "zhangsan");

        System.out.println(cache.getIfPresent("name"));

        System.out.println(cache.getIfPresent("age"));

        System.out.println(cache.get("age", key -> {
            return "lisi";
        }));
    }

    @Test
    void testBasicOps() {
        // 构建cache对象
        Cache<String, String> cache = Caffeine.newBuilder().build();

        // 存数据
        cache.put("gf", "迪丽热巴");

        // 取数据
        String gf = cache.getIfPresent("gf");

        String defaultGF = cache.get("defaultGF", key -> {
            // 根据key去数据库查询数据
            return "柳岩";
        });
    }
}
