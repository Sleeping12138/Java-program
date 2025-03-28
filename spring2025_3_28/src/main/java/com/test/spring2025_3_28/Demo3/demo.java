package com.test.spring2025_3_28.Demo3;

import net.sf.cglib.proxy.Enhancer;

public class demo {
    public static void main(String[] args) {
        HouseSubject2 target = new RealHouseSubject();

        HouseSubject2 ret = (HouseSubject2) Enhancer.create(target.getClass(), new HouseProxy2(target));
        ret.rentHouse();
    }
}
