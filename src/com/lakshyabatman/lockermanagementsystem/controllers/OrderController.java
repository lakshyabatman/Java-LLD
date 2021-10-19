package com.lakshyabatman.lockermanagementsystem.controllers;

import com.lakshyabatman.lockermanagementsystem.View.LockerOtpView;
import com.lakshyabatman.lockermanagementsystem.exceptions.InsufficientLockerSpaceException;
import com.lakshyabatman.lockermanagementsystem.exceptions.InvalidOTPException;
import com.lakshyabatman.lockermanagementsystem.exceptions.LockerNotAvailableException;
import com.lakshyabatman.lockermanagementsystem.exceptions.LockerNotFoundException;
import com.lakshyabatman.lockermanagementsystem.models.Locker;
import com.lakshyabatman.lockermanagementsystem.models.LockerUser;
import com.lakshyabatman.lockermanagementsystem.models.Package;
import com.lakshyabatman.lockermanagementsystem.repository.LockerRepository;
import com.lakshyabatman.lockermanagementsystem.repository.OTPRepository;
import com.lakshyabatman.lockermanagementsystem.service.LockerService;
import com.lakshyabatman.lockermanagementsystem.service.OTPService;

public class OrderController {

    final LockerService lockerService;

    final OTPService otpService;


    public OrderController() {
        this.lockerService = new LockerService(new LockerRepository());
        this.otpService = new OTPService(new OTPRepository());

    }

    public LockerOtpView addPackage(Package p, LockerUser user) throws LockerNotAvailableException, InsufficientLockerSpaceException {
        Locker l = lockerService.allocateLocker(user, p);
        String otp = otpService.createOTP(p, user);
        return new LockerOtpView(l.id,otp);

    }

    public Package collectOrder(String otp, LockerUser user, String lockerId) throws LockerNotFoundException, InvalidOTPException {
        if(otpService.match(otp,user)) {
            return lockerService.freeLocker(lockerId, user);
        }
        throw new InvalidOTPException();
    }
}
