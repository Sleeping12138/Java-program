package com.test.spring2025_3_26.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
// 使用@Aspect注释
@Aspect
@Component
public class TestAspect {

    @Pointcut("execution(* com.test.spring2025_3_26.Controller.*.*(..))")
    public void pt(){};

    @Before("pt()")
    public void doBefore() {
        log.info("before...");
    }


    @Around("pt()")
    public Object recordTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("beginning...");
        long start = System.currentTimeMillis();

        Object ret = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();
        log.info("消耗时间为：" + (end - start));
        log.info("ending...");
        return ret;
    }

    @After("execution(* com.test.spring2025_3_26.Controller.*.*(..))")
    public void doAfter() {
        log.info("after...");
    }

    @AfterReturning("execution(* com.test.spring2025_3_26.Controller.*.*(..))")
    public void doAfterReturn(){
        log.info("doAfterReturn");
    }

    @AfterThrowing("execution(* com.test.spring2025_3_26.Controller.*.*(..))")
    public void doAfterThrowing(){
        log.info("doAfterThrowing...");
    }


}
