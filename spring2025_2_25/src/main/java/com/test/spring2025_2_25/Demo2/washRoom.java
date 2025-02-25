package com.test.spring2025_2_25.Demo2;

public class washRoom implements Light{
    @Override
    public void on() {
        System.out.println("washRoom On");
    }

    @Override
    public void off() {
        System.out.println("washRoom off");
    }
}
