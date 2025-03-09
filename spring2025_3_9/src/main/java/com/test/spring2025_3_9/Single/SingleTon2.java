package com.test.spring2025_3_9.Single;

public class SingleTon2 {
    private SingleTon2() {

    }

    private static final SingleTon2 singleTon2;

    static {
        singleTon2 = new SingleTon2();
    }

    public SingleTon2 getSingleTon2() {
        return singleTon2;
    }
}
