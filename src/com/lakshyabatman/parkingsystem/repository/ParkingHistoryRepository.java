package com.lakshyabatman.parkingsystem.repository;

import com.lakshyabatman.parkingsystem.DAO.CarDAO;
import com.lakshyabatman.parkingsystem.DAO.IDAO;
import com.lakshyabatman.parkingsystem.DAO.ParkingHistoryDAO;
import com.lakshyabatman.parkingsystem.models.Car;
import com.lakshyabatman.parkingsystem.models.ParkingHistory;

import java.security.InvalidParameterException;

public class ParkingHistoryRepository extends IRepository<ParkingHistory> {
    @Override
    public ParkingHistory create(IDAO dao) {
        return new ParkingHistory();
    }
}
