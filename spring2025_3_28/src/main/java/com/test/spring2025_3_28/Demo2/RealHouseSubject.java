package com.test.spring2025_3_28.Demo2;

import com.test.spring2025_3_28.Demo.HouseSubject;

// 被代理的类
public class RealHouseSubject implements HouseSubject {
    @Override
    public void rentHouse() {
        System.out.println("rentHouse...");
    }
}
