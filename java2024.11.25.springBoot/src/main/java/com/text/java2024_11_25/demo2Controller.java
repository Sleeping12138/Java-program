package com.text.java2024_11_25;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/demo2")
@RestController
public class demo2Controller {
    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }
}
