package com.test.spring2025_3_28.Demo;

// 静态代理
public class HouseProxy implements HouseSubject {
    public HouseSubject houseSubject;

    public HouseProxy(HouseSubject houseSubject) {
        this.houseSubject = houseSubject;
    }

    @Override
    public void rentHouse() {
        System.out.println("begin");
        houseSubject.rentHouse();
        System.out.println("end");
    }
}
