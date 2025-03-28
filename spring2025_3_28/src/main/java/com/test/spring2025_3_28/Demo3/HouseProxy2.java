package com.test.spring2025_3_28.Demo3;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class HouseProxy2 implements MethodInterceptor {
    private Object target;

    public HouseProxy2(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("begin...");
        Object invoke = methodProxy.invoke(target, objects);
        System.out.println("end...");
        return invoke;
    }
}
