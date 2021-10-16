package com.lakshyabatman.parkingsystem.controller;

import com.lakshyabatman.exceptions.ParkingLotFullException;
import com.lakshyabatman.parkingsystem.DAO.CarDAO;
import com.lakshyabatman.parkingsystem.models.ParkingHistory;
import com.lakshyabatman.parkingsystem.models.ParkingTime;
import com.lakshyabatman.parkingsystem.strategies.IStrategy;

import java.util.LinkedList;

public class ParkingLot {

    ParkingHistory history;
    IStrategy strategy;

    public ParkingLot(ParkingHistory history, IStrategy strategy) {
        this.history = history;
        this.strategy = strategy;
    }


    public String park(CarDAO car) throws ParkingLotFullException {
        try {
            ParkingTime time = strategy.park(car);
            history.push(time);
            System.out.println("Car "+ time.carId +  " has been parked on"  + time.slotid);
            return time.carId;
        }catch (Exception err) {
            throw err;


        }
    }

    public String park(CarDAO car, int slotId) throws ParkingLotFullException {
        try {
            ParkingTime time = strategy.park(car,slotId);
            history.push(time);
            System.out.println("Car "+ time.carId +  " has been parked on"  + time.slotid);
            return time.carId;
        }catch (Exception err) {
            throw err;
        }
    }

    public void unpark(String id) {
        try {
            ParkingTime time = strategy.unpark(id);
            history.push(time);
            System.out.println("Car "+ time.carId +  " has been un-parked from"  + time.slotid);
        }catch (Exception err) {
            System.out.println(err.toString());
        }

    }

    public void getSlotHistory(int id) {

        LinkedList<ParkingTime> res = history.getBySlotId(id);
        System.out.println(res.toString());

    }

    public void getCarHistory(String id) {

        LinkedList<ParkingTime> res =history.getByCardId(id);
        System.out.println(res.toString());
    }


}

