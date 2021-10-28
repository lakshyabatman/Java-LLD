package com.lakshyabatman.snakeladder;

import com.lakshyabatman.snakeladder.DicePolicy.RandomValueDicePolicy;
import com.lakshyabatman.snakeladder.enums.GameStatus;
import com.lakshyabatman.snakeladder.exceptions.BadRequestException;
import com.lakshyabatman.snakeladder.models.Dice;
import com.lakshyabatman.snakeladder.models.Game;
import com.lakshyabatman.snakeladder.models.GameBoard;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws BadRequestException {
        GameBoard gameBoard = new GameBoard(8);
        Dice<Integer> dice = new Dice<>(new RandomValueDicePolicy());
        ArrayList<String> players = new ArrayList<>(Arrays.asList(
                "Apple",
                "Mango",
                "Orange"
        ));
        Game newGame = new Game(gameBoard,players, dice);
        while(newGame.gameStatus != GameStatus.ENDED) {
            newGame.makeMove();
        }




    }
}
