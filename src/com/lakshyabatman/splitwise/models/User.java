package com.lakshyabatman.splitwise.models;

public class User extends Entity{
    public final String name;
    public final int userId;
    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

}
