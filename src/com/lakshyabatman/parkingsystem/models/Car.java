package com.lakshyabatman.parkingsystem.models;

import java.util.Random;

public class Car extends DbEntity{
    public String colour;
    public String owner;


    public Car(String colour, String owner) {
        super();
        this.colour = colour;
        this.owner = owner;
    }
}
