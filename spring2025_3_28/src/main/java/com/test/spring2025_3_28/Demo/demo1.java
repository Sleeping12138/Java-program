package com.test.spring2025_3_28.Demo;

public class demo1 {
    public static void main(String[] args) {
        HouseSubject houseSubject = new RealHouseSubject();
        HouseProxy houseProxy = new HouseProxy(houseSubject);
        houseProxy.rentHouse();
    }
}
