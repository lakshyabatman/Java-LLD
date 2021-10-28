package com.lakshyabatman.snakeladder.models;

public class Player {
    public String name;

    public Position currentPosition;

    public Player(String name) {
        this.name = name;
        this.currentPosition = new Position(0,0);
    }

    public Position move(int i, int j) {
        this.currentPosition.row = i;
        this.currentPosition.col = j;
        return this.currentPosition;
    }

}
