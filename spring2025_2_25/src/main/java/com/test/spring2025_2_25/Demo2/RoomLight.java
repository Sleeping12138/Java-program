package com.test.spring2025_2_25.Demo2;

public class RoomLight implements Light{
    @Override
    public void on() {
        System.out.println("room On");
    }

    @Override
    public void off() {
        System.out.println("Room off");
    }
}
