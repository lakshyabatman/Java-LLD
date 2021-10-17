package com.lakshyabatman.tictactoe.models;

import com.lakshyabatman.tictactoe.DAO.UserDAO;
import com.lakshyabatman.tictactoe.enums.CellState;
import com.lakshyabatman.tictactoe.enums.GameState;
import com.lakshyabatman.tictactoe.exceptions.InvalidParamsException;

public class Game {

    public GameBoard gameBoard;
    public User user1;
    public User user2;
    public CellState chance;
    public GameState gameState;
    int moves;

    public Game(UserDAO userDAO1, UserDAO userDAO2, CellState firstChance) throws InvalidParamsException {
        this.gameBoard = new GameBoard();
        if(userDAO1.cell == userDAO2.cell) throw new InvalidParamsException();
        this.user1 = User.create(userDAO1);
        this.user2 = User.create(userDAO2);
        this.chance = firstChance;
        moves = 9;
        this.gameState = GameState.NOT_STARTED;
    }

    public void startGame() {
        this.gameState = GameState.RUNNING;
    }

    public void makeMove(int i, int j) {
        try {
            gameBoard.makeMove(chance,i, j);
            moves--;
            chance = chance == CellState.X ? CellState.O : CellState.X;
        } catch (InvalidParamsException error) {
            System.out.println("Invalid move, please try again");
        }
    }

    public boolean isWinnerFound() {
        boolean result =  gameBoard.isWinnerFound() != CellState.EMPTY;
       if(result) this.gameState = GameState.FINISHED;
       return result;
    }

    public UserDAO getWinner() throws InvalidParamsException {
        CellState winner = gameBoard.isWinnerFound();
        if(winner == CellState.EMPTY) return null;
        if(user1.cell.equals(winner)) return UserDAO.fromUser(user1);
        return UserDAO.fromUser(user2);
    }

    public void resetGame() {
        this.gameBoard = new GameBoard();
        this.gameState = GameState.NOT_STARTED;
        moves = 9;
    }

    public boolean movesLeft() {
        return moves>0;
    }

}
