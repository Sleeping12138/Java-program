package com.test.spring2025_3_28.Demo2;

import com.test.spring2025_3_28.Demo.HouseSubject;

import java.lang.reflect.Proxy;

public class demo {
    public static void main(String[] args) {
        HouseSubject target = new RealHouseSubject();

        HouseSubject proxy = (HouseSubject)Proxy.newProxyInstance(target.getClass().getClassLoader(),
                new Class[]{HouseSubject.class}, new HouseProxy(target));
        proxy.rentHouse();
    }
}
