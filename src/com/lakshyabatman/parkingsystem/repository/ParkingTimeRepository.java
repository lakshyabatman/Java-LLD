package com.lakshyabatman.parkingsystem.repository;

import com.lakshyabatman.parkingsystem.DAO.CarDAO;
import com.lakshyabatman.parkingsystem.DAO.IDAO;
import com.lakshyabatman.parkingsystem.DAO.ParkingTimeDAO;
import com.lakshyabatman.parkingsystem.models.Car;
import com.lakshyabatman.parkingsystem.models.ParkingTime;

import java.security.InvalidParameterException;

public class ParkingTimeRepository extends IRepository<ParkingTime> {
    @Override
    public ParkingTime create(IDAO dao) {
        if(!(dao instanceof ParkingTimeDAO)) throw new InvalidParameterException();
        ParkingTimeDAO parkingTimeDAO = (ParkingTimeDAO) dao;
        return new ParkingTime(parkingTimeDAO.slotid,parkingTimeDAO.carId,parkingTimeDAO.date,parkingTimeDAO.movement);
    }
}
