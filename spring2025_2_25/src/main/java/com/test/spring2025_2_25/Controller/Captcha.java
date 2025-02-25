package com.test.spring2025_2_25.Controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "captcha")
@Component
@Data
public class Captcha {
    private int width;
    private int height;
    private Session session;

    // 必须为静态内部类
    @Data
    public static class Session {
        private String code;
        private String time;
    }
}
