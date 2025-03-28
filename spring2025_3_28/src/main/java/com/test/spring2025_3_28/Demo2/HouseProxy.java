package com.test.spring2025_3_28.Demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HouseProxy implements InvocationHandler {
    private Object target;

    public HouseProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin");
        Object invoke = method.invoke(target, args);
        System.out.println("end");
        return invoke;
    }
}
