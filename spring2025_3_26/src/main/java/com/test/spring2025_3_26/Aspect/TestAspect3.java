package com.test.spring2025_3_26.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class TestAspect3 {
    @After("com.test.spring2025_3_26.Aspect.TestAspect.pt()")
    public void after(){
        log.info("test");
    }
}
