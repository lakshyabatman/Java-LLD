package com.lakshyabatman.parkingsystem.DAO;

import com.lakshyabatman.parkingsystem.models.ParkingMovement;

import java.util.Date;

public class ParkingTimeDAO extends IDAO {
    public int slotid;

    public String carId;

    public Date date;

    public ParkingMovement movement;


    public ParkingTimeDAO(int slotid, String carId, Date date, ParkingMovement movement) {
        this.slotid = slotid;
        this.carId = carId;
        this.date = date;
        this.movement = movement;
    }
}

