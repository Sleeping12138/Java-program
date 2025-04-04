package com.test.spring2025_4_4.Model;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "student")
@Component
public class People {
    private String name;
    private Integer age;
}
