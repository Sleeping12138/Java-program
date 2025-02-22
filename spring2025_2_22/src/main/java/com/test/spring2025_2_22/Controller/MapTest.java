package com.test.spring2025_2_22.Controller;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@ConfigurationProperties(prefix = "test")
@Component
@Data
public class MapTest {
    private HashMap<String,String> str;
}
