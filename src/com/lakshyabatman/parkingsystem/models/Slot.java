package com.lakshyabatman.parkingsystem.models;

public class Slot {

    public boolean isAvailable = true;
    int id;

    public String carId;

    public Slot(String carId) {
        this.carId = carId;

    }

    public void toggle() {
        this.isAvailable = !this.isAvailable;
    }

}
