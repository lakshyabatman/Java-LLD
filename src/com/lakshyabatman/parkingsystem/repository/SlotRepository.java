package com.lakshyabatman.parkingsystem.repository;

import com.lakshyabatman.parkingsystem.DAO.IDAO;
import com.lakshyabatman.parkingsystem.DAO.ParkingTimeDAO;
import com.lakshyabatman.parkingsystem.DAO.SlotDAO;
import com.lakshyabatman.parkingsystem.models.Slot;

import java.security.InvalidParameterException;

public class SlotRepository extends IRepository<Slot> {
    @Override
    public Slot create(IDAO dao) {
        if(!(dao instanceof SlotDAO)) throw new InvalidParameterException();
        SlotDAO slotDAO = (SlotDAO) dao;
        return new Slot(slotDAO.carId);
    }
}
