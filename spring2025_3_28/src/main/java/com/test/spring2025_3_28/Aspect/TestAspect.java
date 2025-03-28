package com.test.spring2025_3_28.Aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class TestAspect {
    @Pointcut("execution(* com.test.spring2025_3_28.Controller.*.*(..))")
    private void pt(){}

    @Around("pt()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("beginning...");
        Object result = proceedingJoinPoint.proceed();
        log.info("ending...");
        return result;
    }
}
