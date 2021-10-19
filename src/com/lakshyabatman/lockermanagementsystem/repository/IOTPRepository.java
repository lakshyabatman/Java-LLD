package com.lakshyabatman.lockermanagementsystem.repository;

import com.lakshyabatman.lockermanagementsystem.models.LockerUser;
import com.lakshyabatman.lockermanagementsystem.models.Package;

public abstract class IOTPRepository {



    public abstract String generateOTP(Package p, LockerUser user);

    public abstract boolean verifyOTP(String otp, LockerUser user);

}
