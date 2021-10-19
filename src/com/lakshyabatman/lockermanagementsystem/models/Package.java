package com.lakshyabatman.lockermanagementsystem.models;

public class Package {
    public Size size;

    public String name;

    public Package(Size size, String name) {
        this.size = size;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Package{" +
                "size=" + size +
                ", name='" + name + '\'' +
                '}';
    }
}
