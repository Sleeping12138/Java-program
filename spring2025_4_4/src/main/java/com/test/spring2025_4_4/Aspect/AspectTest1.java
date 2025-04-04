package com.test.spring2025_4_4.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@Order(4)
public class AspectTest1 {
    @Pointcut("execution(* com.test.spring2025_4_4.Controller.test.*.*(..))")
    public void pt(){}

    @Around("pt()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("begin");
        Object proceed = proceedingJoinPoint.proceed();
        log.info("end");
        return proceed;
    }

    @Before("execution(* com.test.spring2025_4_4.Controller.test.*.*(..))")
    public void doBefore(){
        log.info("doBefore...");
    }
}
