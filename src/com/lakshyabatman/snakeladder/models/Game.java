package com.lakshyabatman.snakeladder.models;

import com.lakshyabatman.snakeladder.enums.GameStatus;
import com.lakshyabatman.snakeladder.exceptions.BadRequestException;
import com.lakshyabatman.snakeladder.repository.PlayerRepository;

import java.util.ArrayList;

public class Game {

    GameBoard gameboard;

    PlayerRepository playerRepository;

    public GameStatus gameStatus = GameStatus.NOT_STARTED;

    Dice<Integer> dice;

    public Game(GameBoard gameBoard, ArrayList<String> players, Dice<Integer> dice) throws BadRequestException {
        this.gameboard = gameBoard;
        this.playerRepository = new PlayerRepository(players);

        this.dice = dice;
        this.gameStatus = GameStatus.STARTED;
    }

    public void makeMove() {
        this.rollDice();
        this.foundWinner();
    }


    private void rollDice() {
        int value =  dice.roll();
        Player currentPlayer = playerRepository.getCurrentPlayer();
        Position res = gameboard.makeMove(currentPlayer,value);
        if(res!=null) {
            playerRepository.updateCurrentPlayerPosition(res);
            System.out.println(currentPlayer.name + "makes move to " + res.row + " " + res.col);
        }

    }

    private void foundWinner() {
        Player res = gameboard.foundWinner();
        if(res!=null) {
            this.gameStatus = GameStatus.ENDED;
            System.out.println("winner "+ res.name);
        }

    }






}
