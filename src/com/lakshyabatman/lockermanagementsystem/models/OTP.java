package com.lakshyabatman.lockermanagementsystem.models;

public class OTP {

    public final LockerUser user;
    final Package p;


    final String key;

    public OTP(LockerUser user, Package p) {
        this.user = user;
        this.key = "otp-" + user.name +"-"+p.name;
        this.p = p;
    }

    @Override
    public String toString() {
        return key;
    }
}
