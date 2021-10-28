package com.lakshyabatman.snakeladder.repository;

import com.lakshyabatman.snakeladder.exceptions.BadRequestException;
import com.lakshyabatman.snakeladder.models.Player;
import com.lakshyabatman.snakeladder.models.Position;

import java.util.ArrayList;


public class PlayerRepository {

    ArrayList<Player> playerList = new ArrayList<>();

    Player currentPlayer;

    public PlayerRepository(ArrayList<String> players) throws BadRequestException {
        if (players.size() == 0) throw new BadRequestException("The number of players should not be lesser than 0");

        for (String playerName : players) {
            Player p =new Player(playerName);
            playerList.add(p);

        }
        currentPlayer = playerList.get(0);
    }

    public Player getCurrentPlayer() {
        Player p = currentPlayer;
        int index = playerList.indexOf(p);
        index%=playerList.size();
        currentPlayer = playerList.get(index);
        return p;
    }

    public void updateCurrentPlayerPosition(Position p)  {

        currentPlayer.currentPosition = p;
        int idx = playerList.indexOf(currentPlayer);
        idx++;
        idx%=playerList.size();
        currentPlayer = playerList.get(idx);

    }



}
