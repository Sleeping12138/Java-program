package com.test.spring2025_3_26.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class TestAspect2 {
    // 这样当使用@MyAspect注解的时候，就会调用该切面
    @Before("@annotation(com.test.spring2025_3_26.Aspect.MyAspect)")
    public void doBegin(){
        log.info("doBegin...");
    }
}
