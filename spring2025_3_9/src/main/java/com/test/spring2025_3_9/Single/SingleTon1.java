package com.test.spring2025_3_9.Single;

// 饿汉模式
public class SingleTon1 {
    private SingleTon1() {

    }

    private static final SingleTon1 singleton1 = new SingleTon1();

    public SingleTon1 getSingleton1() {
        return singleton1;
    }
}
