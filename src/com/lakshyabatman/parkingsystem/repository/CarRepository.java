package com.lakshyabatman.parkingsystem.repository;

import com.lakshyabatman.parkingsystem.DAO.CarDAO;
import com.lakshyabatman.parkingsystem.DAO.IDAO;
import com.lakshyabatman.parkingsystem.models.Car;

import java.security.InvalidParameterException;

public class CarRepository extends IRepository<Car> {
    @Override
    public Car create(IDAO dao) {
        if(!(dao instanceof CarDAO)) throw new InvalidParameterException();
        CarDAO carDao = (CarDAO) dao;
        return new Car(carDao.colour, carDao.owner);
    }
}
