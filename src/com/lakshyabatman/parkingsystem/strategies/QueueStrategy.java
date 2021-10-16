package com.lakshyabatman.parkingsystem.strategies;

import com.lakshyabatman.exceptions.InvalidParamsException;
import com.lakshyabatman.exceptions.ParkingLotFullException;
import com.lakshyabatman.parkingsystem.DAO.CarDAO;
import com.lakshyabatman.parkingsystem.models.Car;
import com.lakshyabatman.parkingsystem.models.ParkingMovement;
import com.lakshyabatman.parkingsystem.models.ParkingTime;
import com.lakshyabatman.parkingsystem.models.Slot;
import com.lakshyabatman.parkingsystem.repository.CarRepository;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.LinkedList;

public class QueueStrategy implements IStrategy {

    Slot[] slots;
    CarRepository carRepository;

    public QueueStrategy(Integer cap) {
        this.carRepository = new CarRepository();
        slots = new Slot[cap];
        for(int i =0;i<cap;i++) {
            slots[i] = new Slot(null);
        }

    }

    int searchForAvailable() throws ParkingLotFullException {
        for(int i = 0; i<slots.length; i++) {
            if(slots[i].isAvailable) return i;
        }
        throw new ParkingLotFullException();
    }

    @Override
    public ParkingTime park(CarDAO carDAO) throws ParkingLotFullException {
        Car car = carRepository.create(carDAO);
        int i = searchForAvailable();
        slots[i].isAvailable = false;
        slots[i].carId = car.id;
        return new ParkingTime(i,car.id,new Date(), ParkingMovement.PARK);

    }

    @Override
    public ParkingTime park(CarDAO carDAO, int i) throws ParkingLotFullException {
        if(i>= slots.length || i<0) throw new InvalidParameterException();
        if(!slots[i].isAvailable) throw new ParkingLotFullException();
        Car car = carRepository.create(carDAO);
        slots[i].isAvailable = false;
        slots[i].carId = car.id;
        return new ParkingTime(i,car.id,new Date(), ParkingMovement.PARK);
    }

    @Override
    public ParkingTime unpark(String carId) throws InvalidParamsException {
        for(int i = 0; i<slots.length; i++) {
            if(slots[i].carId != null && slots[i].carId.equals(carId)) {

                slots[i].isAvailable = true;
                slots[i].carId = null;
                return new ParkingTime(i,carId,new Date(), ParkingMovement.UN_PARK);
            }
        }
        throw new InvalidParamsException();
    }
}
