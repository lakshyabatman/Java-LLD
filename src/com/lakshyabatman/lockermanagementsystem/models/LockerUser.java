package com.lakshyabatman.lockermanagementsystem.models;

public class LockerUser {
    public String id;

    public String name;

    LockerUser(String name) {
        this.name = name;
        this.id = Double.toString(Math.random() * (101));
    }
}
