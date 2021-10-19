package com.lakshyabatman.lockermanagementsystem.repository;

import com.lakshyabatman.lockermanagementsystem.models.LockerUser;
import com.lakshyabatman.lockermanagementsystem.models.OTP;
import com.lakshyabatman.lockermanagementsystem.models.Package;

import java.util.HashMap;
import java.util.Objects;

public class OTPRepository extends  IOTPRepository{

    HashMap<String, OTP> otpHashMap = new HashMap<String, OTP>();

    @Override
    public String generateOTP(Package p, LockerUser user) {
        OTP otp = new OTP(user, p);
       otpHashMap.put(otp.toString(),otp);
       return otp.toString();
    }

    @Override
    public boolean verifyOTP(String otp, LockerUser user) {
        if(!otpHashMap.containsKey(otp)) return false;
        return Objects.equals(otpHashMap.get(otp).user.name, user.name);
    }
}
