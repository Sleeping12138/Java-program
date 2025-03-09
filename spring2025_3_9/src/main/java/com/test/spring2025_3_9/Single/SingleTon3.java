package com.test.spring2025_3_9.Single;

// 懒汉模式
public class SingleTon3 {
    private SingleTon3() {

    }

    private static SingleTon3 singleTon3;

    public SingleTon3 getSingleTon3() {
        if (singleTon3 == null) {
            singleTon3 = new SingleTon3();
        }
        return singleTon3;
    }
}
