package com.lakshyabatman.lockermanagementsystem.service;

import com.lakshyabatman.lockermanagementsystem.models.LockerUser;
import com.lakshyabatman.lockermanagementsystem.models.Package;
import com.lakshyabatman.lockermanagementsystem.repository.IOTPRepository;

import java.util.Map;

public class OTPService {


    IOTPRepository otpRepository;

    public OTPService(IOTPRepository otpRepository) {
        this.otpRepository = otpRepository;
    }

    public String createOTP(Package p, LockerUser user) {
        return this.otpRepository.generateOTP(p, user);


    }


    public boolean match(String otp, LockerUser user) {
        return this.otpRepository.verifyOTP(otp,user);

    }


}
