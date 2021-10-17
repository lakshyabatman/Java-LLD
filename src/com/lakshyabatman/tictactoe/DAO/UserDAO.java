package com.lakshyabatman.tictactoe.DAO;

import com.lakshyabatman.tictactoe.exceptions.InvalidParamsException;
import com.lakshyabatman.tictactoe.enums.CellState;
import com.lakshyabatman.tictactoe.models.User;

public class UserDAO extends IDAO {
    public String name;
    public CellState cell;

    public UserDAO(String name, CellState cell) throws InvalidParamsException {
        if (cell == CellState.EMPTY) throw new InvalidParamsException();
        this.cell = cell;
        this.name = name;
    }

    static public UserDAO fromUser(User user) throws InvalidParamsException {
        return new UserDAO(user.name, user.cell);
    }
}
