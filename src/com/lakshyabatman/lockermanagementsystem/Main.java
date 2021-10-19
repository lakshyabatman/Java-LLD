package com.lakshyabatman.lockermanagementsystem;

import com.lakshyabatman.lockermanagementsystem.View.LockerOtpView;
import com.lakshyabatman.lockermanagementsystem.controllers.OrderController;
import com.lakshyabatman.lockermanagementsystem.controllers.ReturnController;
import com.lakshyabatman.lockermanagementsystem.exceptions.InsufficientLockerSpaceException;
import com.lakshyabatman.lockermanagementsystem.exceptions.InvalidOTPException;
import com.lakshyabatman.lockermanagementsystem.exceptions.LockerNotAvailableException;
import com.lakshyabatman.lockermanagementsystem.exceptions.LockerNotFoundException;
import com.lakshyabatman.lockermanagementsystem.models.Package;
import com.lakshyabatman.lockermanagementsystem.models.Size;
import com.lakshyabatman.lockermanagementsystem.models.User;

public class Main {

    public static void main(String[] args) throws LockerNotAvailableException, InsufficientLockerSpaceException, LockerNotFoundException, InvalidOTPException {
        User lakshya = new User("lakshya");
        OrderController orderController = new OrderController();
        LockerOtpView l = orderController.addPackage(new Package(Size.small,"ps5"),lakshya);
        orderController.collectOrder(l.otp,lakshya,l.lockerId);


        ReturnController returnController = new ReturnController();
        LockerOtpView l1 = returnController.addPackage(new Package(Size.small,"ps5"),lakshya);
        returnController.collectOrder(l1.otp,lakshya,l1.lockerId);



    }
}
