package com.lakshyabatman.tictactoe.models;

import com.lakshyabatman.tictactoe.enums.CellState;
import com.lakshyabatman.tictactoe.exceptions.InvalidParamsException;

public class GameBoard {
    CellState[][] board;

    public GameBoard() {
        this.board = new CellState[3][3];
        for(int i =0;i<3;i++) {
            for(int j= 0;j<3;j++) {
                this.board[i][j] = CellState.EMPTY;
            }
        }

    }

    private boolean validate(int i, int j) {
        return (i >= 0 && j >= 0 && i < 3 && j < 3);
    }

    public void makeMove(CellState player, int i, int j) throws InvalidParamsException {
        if (!validate(i, j) || this.board[i][j] != CellState.EMPTY) throw new InvalidParamsException();
        board[i][j] = player;
    }

    public CellState isWinnerFound() {
        // column wise
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != CellState.EMPTY && board[i][0] == board[i][1] && board[i][1] == board[i][2])
                return board[i][0];
        }

        // row wise
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != CellState.EMPTY && board[0][j] == board[1][j] && board[1][j] == board[2][j])
                return board[0][j];
        }

        if (board[0][0] != CellState.EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return board[0][0];
        if (board[0][2] != CellState.EMPTY && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return board[0][2];

        return CellState.EMPTY;

    }




}
