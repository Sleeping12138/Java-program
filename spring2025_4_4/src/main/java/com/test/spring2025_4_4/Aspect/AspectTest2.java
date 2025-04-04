package com.test.spring2025_4_4.Aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class AspectTest2 {
    @Before("@annotation(com.test.spring2025_4_4.Aspect.MyAspect)")
    public void doBefore(){

    }
}
