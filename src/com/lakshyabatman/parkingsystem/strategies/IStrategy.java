package com.lakshyabatman.parkingsystem.strategies;

import com.lakshyabatman.exceptions.InvalidParamsException;
import com.lakshyabatman.exceptions.ParkingLotFullException;
import com.lakshyabatman.parkingsystem.DAO.CarDAO;
import com.lakshyabatman.parkingsystem.models.Car;
import com.lakshyabatman.parkingsystem.models.ParkingTime;
import com.lakshyabatman.parkingsystem.models.Slot;

public interface IStrategy {
    ParkingTime park(CarDAO car) throws ParkingLotFullException;

    ParkingTime park(CarDAO car, int id) throws ParkingLotFullException;

    ParkingTime unpark(String carId) throws InvalidParamsException;
}
