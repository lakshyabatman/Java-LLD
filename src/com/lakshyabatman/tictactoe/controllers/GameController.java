package com.lakshyabatman.tictactoe.controllers;

import com.lakshyabatman.tictactoe.DAO.UserDAO;
import com.lakshyabatman.tictactoe.enums.CellState;
import com.lakshyabatman.tictactoe.exceptions.InvalidParamsException;
import com.lakshyabatman.tictactoe.models.Game;

import java.util.Scanner;

public class GameController {


    public static void game() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Tell name and cell of first player");
            String name, cell;
            name = scanner.nextLine();
            cell = scanner.nextLine();
            UserDAO user1 = new UserDAO(name, CellState.valueOf(cell));
            System.out.println("Tell name and cell of second player");
            name = scanner.nextLine();
            cell = scanner.nextLine();
            UserDAO user2 = new UserDAO(name, CellState.valueOf(cell));
            System.out.println("Which player, should get first chance");
            cell = scanner.nextLine();
            Game game = new Game(user1, user2, CellState.valueOf(cell));
            game.startGame();
            while (!game.isWinnerFound() && game.movesLeft()) {
                System.out.println("Chance : " + game.chance);
                System.out.println("Write coordinates");
                int i, j;
                i = scanner.nextInt();
                j = scanner.nextInt();
                game.makeMove(i, j);
            }
            System.out.println("Winner is " + game.getWinner().name);
            System.out.println("Want to restart game? Y/N");


        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
