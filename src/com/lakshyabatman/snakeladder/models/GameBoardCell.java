package com.lakshyabatman.snakeladder.models;

import java.util.ArrayList;

public class GameBoardCell {

    public GameComponent gameComponent;

    private final ArrayList<Player> players;

    GameBoardCell() {
        this.players = new ArrayList<>();
    }

    public void setGameComponent(GameComponent gameComponent) {
        this.gameComponent = gameComponent;

    }

    public void setPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
