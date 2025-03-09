package com.test.spring2025_3_9.Single;

public class SingleTon6 {
    private SingleTon6(){}

    private static class SingleTon{
        private static final SingleTon singleTon = new SingleTon();
    }

    public SingleTon getSingleTon(){
        return SingleTon.singleTon;
    }
}
