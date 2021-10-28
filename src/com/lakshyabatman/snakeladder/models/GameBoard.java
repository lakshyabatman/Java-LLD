package com.lakshyabatman.snakeladder.models;

public class GameBoard {

    GameBoardCell[][] gameBoard;

    int n;

    public GameBoard(int n) {
        this.n = n;
        gameBoard = new GameBoardCell[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                gameBoard[i][j] = new GameBoardCell();
            }
        }
        for (int i = 0; i < n / 2; i++) {
            gameBoard[(int) (Math.random() * i)][(int) (Math.random() * i)].gameComponent = new Snake(new Position((int) (Math.random() * i), (int) (Math.random() * i)));
            gameBoard[(int) (Math.random() * i)][(int) (Math.random() * i)].gameComponent = new Ladder(new Position((int) (Math.random() * i), (int) (Math.random() * i)));

        }


    }

    public Position makeMove(Player player, int steps) {
        Position currentPosition = player.currentPosition;
        int newJ = currentPosition.col + steps;
        int newI = currentPosition.row;
        if (newJ >= n) {
            newJ %= n;
            newI++;

        }
        if (newI >= n) {
            return null;
        }

        if (gameBoard[newI][newJ].gameComponent != null) {
            GameComponent gameComponent = gameBoard[newI][newJ].gameComponent;
            newI = gameComponent.endPosition.row;
            newJ = gameComponent.endPosition.col;
        }
        gameBoard[currentPosition.row][currentPosition.col].removePlayer(player);
        Position newPosition = new Position(newI, newJ);
        gameBoard[newI][newJ].setPlayer(player);
        player.currentPosition = newPosition;
        return newPosition;


    }

    public Player foundWinner() {
        return gameBoard[n - 1][n - 1].getPlayers().size() > 0 ? gameBoard[n - 1][n - 1].getPlayers().get(0) : null;
    }


}
