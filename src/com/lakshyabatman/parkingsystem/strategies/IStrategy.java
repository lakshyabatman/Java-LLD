package com.lakshyabatman.parkingsystem.strategies;

import com.lakshyabatman.parkingsystem.exceptions.InvalidParamsException;
import com.lakshyabatman.parkingsystem.exceptions.ParkingLotFullException;
import com.lakshyabatman.parkingsystem.DAO.CarDAO;
import com.lakshyabatman.parkingsystem.models.ParkingTime;

public interface IStrategy {
    ParkingTime park(CarDAO car) throws ParkingLotFullException;

    ParkingTime park(CarDAO car, int id) throws ParkingLotFullException;

    ParkingTime unpark(String carId) throws InvalidParamsException;
}
