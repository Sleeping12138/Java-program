package com.test.spring2025_3_26.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("m1")
    public void method1() throws InterruptedException {
        Thread.sleep(1000);
        log.info("正在执行逻辑...");
    }
}
