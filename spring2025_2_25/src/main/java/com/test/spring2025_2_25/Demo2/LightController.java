package com.test.spring2025_2_25.Demo2;

public class LightController implements Light{
    public BedRoom bedRoom = new BedRoom();
    public washRoom washRoom = new washRoom();
    public RoomLight roomLight= new RoomLight();


    @Override
    public void on() {
        bedRoom.on();
        washRoom.on();
        roomLight.on();
    }

    @Override
    public void off() {
        bedRoom.off();
        washRoom.off();
        roomLight.off();
    }
}
