package com.lakshyabatman.parkingsystem.models;

import java.util.Date;

public class ParkingTime {
    public int slotid;

    public String carId;

    public Date date;

    public ParkingMovement movement;


    public ParkingTime(int slotid, String carId, Date date, ParkingMovement movement) {
        this.slotid = slotid;
        this.carId = carId;
        this.date = date;
        this.movement = movement;
    }


    @Override
    public String toString() {
        return "ParkingTime{" +
                "slotid=" + slotid +
                ", carId='" + carId + '\'' +
                ", date=" + date +
                ", movement=" + movement +
                '}';
    }
}
