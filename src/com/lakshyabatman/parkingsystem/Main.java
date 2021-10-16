package com.lakshyabatman.parkingsystem;

import com.lakshyabatman.parkingsystem.DAO.CarDAO;
import com.lakshyabatman.parkingsystem.controller.ParkingLot;
import com.lakshyabatman.parkingsystem.models.ParkingHistory;
import com.lakshyabatman.parkingsystem.strategies.IStrategy;
import com.lakshyabatman.parkingsystem.strategies.QueueStrategy;

public class Main {
    public static void main(String[] args) {
        try {
            ParkingHistory h = new ParkingHistory();
            IStrategy s = new QueueStrategy(10);
            ParkingLot p = new ParkingLot(h,s);
            String car1 = p.park(new CarDAO("RED","Me"));
            String car2 = p.park(new CarDAO("BLUE","HE"));
            p.unpark(car1);
            String car3 = p.park(new CarDAO("RED","Us"));
            p.getCarHistory(car1);
            p.getSlotHistory(0);
        }catch (Exception err) {
            System.out.println(err.toString());
        }
    }
}
