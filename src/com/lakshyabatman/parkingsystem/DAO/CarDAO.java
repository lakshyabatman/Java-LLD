package com.lakshyabatman.parkingsystem.DAO;

public class CarDAO extends IDAO {
    public String colour;
    public String owner;


    public CarDAO(String colour, String owner) {
        this.colour = colour;
        this.owner = owner;
    }
}
