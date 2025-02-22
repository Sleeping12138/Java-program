package com.test.spring2025_2_22.Controller;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "array")
@Component
@Data
public class ArrayTest {
   private Integer[] number;
}
