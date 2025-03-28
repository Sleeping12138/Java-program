package com.test.spring2025_3_28.Demo3;

import com.test.spring2025_3_28.Demo.HouseSubject;

// 被代理的类
public class RealHouseSubject implements HouseSubject2 {
    @Override
    public void rentHouse() {
        System.out.println("rentHouse...");
    }
}
