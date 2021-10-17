package com.lakshyabatman.tictactoe.models;

import com.lakshyabatman.tictactoe.DAO.UserDAO;
import com.lakshyabatman.tictactoe.enums.CellState;

public class User {

    public String name;
    public CellState cell;

     User(UserDAO user) {
        this.name = user.name;
        this.cell = user.cell;
    }



    static public User create(UserDAO user) {
         return new User(user);
    }

}
