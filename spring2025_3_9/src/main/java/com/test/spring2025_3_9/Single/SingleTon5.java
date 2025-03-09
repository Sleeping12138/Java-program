package com.test.spring2025_3_9.Single;

public class SingleTon5 {
    private SingleTon5() {
    }

    private static SingleTon5 singleTon5;
    private Object locker = new Object();

    public SingleTon5 getSingleTon5() {
        if (singleTon5 == null) {
            synchronized (locker) {
                if (singleTon5 == null) {
                    singleTon5 = new SingleTon5();
                }
            }
        }
        return singleTon5;
    }

}
