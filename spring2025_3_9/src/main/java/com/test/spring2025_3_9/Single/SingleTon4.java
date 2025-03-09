package com.test.spring2025_3_9.Single;

public class SingleTon4 {
    private SingleTon4() {

    }

    private static SingleTon4 singleTon4;

    public synchronized SingleTon4 getSingleTon3() {
        if (singleTon4 == null) {
            singleTon4 = new SingleTon4();
        }
        return singleTon4;
    }
}
