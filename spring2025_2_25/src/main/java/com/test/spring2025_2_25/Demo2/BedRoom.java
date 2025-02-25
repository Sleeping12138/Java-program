package com.test.spring2025_2_25.Demo2;

public class BedRoom implements Light{
    @Override
    public void on() {
        System.out.println("BedRoom On");
    }

    @Override
    public void off() {
        System.out.println("BedRoom off");
    }
}
