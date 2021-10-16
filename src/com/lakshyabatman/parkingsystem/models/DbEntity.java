package com.lakshyabatman.parkingsystem.models;

public class DbEntity {
    public String id;

    DbEntity() {
        this.id = String.valueOf(Math.round(Math.random()*101 ));
    }
}
