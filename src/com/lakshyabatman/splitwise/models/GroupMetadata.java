package com.lakshyabatman.splitwise.models;

public class GroupMetadata extends Entity{

    public final String name, description;

    public GroupMetadata(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
