package com.lakshyabatman.parkingsystem.models;

import java.util.LinkedList;

public class ParkingHistory  {


    LinkedList<ParkingTime> history = new LinkedList<ParkingTime>();

    public void push(ParkingTime time) {
        history.push(time);

    }

    public LinkedList<ParkingTime> getBySlotId(int id) {
            LinkedList<ParkingTime> res = new LinkedList<ParkingTime>();
            for(ParkingTime parkingTime : history) {
                if(parkingTime.slotid == id && parkingTime.movement == ParkingMovement.PARK) res.push(parkingTime);
            }
            return res;
    }
    public LinkedList<ParkingTime> getByCardId(String id) {
        LinkedList<ParkingTime> res = new LinkedList<ParkingTime>();
        for(ParkingTime parkingTime : history) {
            if(parkingTime.carId.equals(id) && parkingTime.movement == ParkingMovement.PARK) res.push(parkingTime);
        }
        return res;
    }
}
