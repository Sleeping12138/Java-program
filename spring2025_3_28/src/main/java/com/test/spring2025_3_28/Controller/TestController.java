package com.test.spring2025_3_28.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("m1")
    private void method1(){
        log.info("this is a test");
    }
}
