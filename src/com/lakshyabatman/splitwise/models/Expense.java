package com.lakshyabatman.splitwise.models;

public class Expense extends Entity {
    public final int userId,amount, groupId;

    public Expense(int userId, int groupId, int amount) {
        this.userId = userId;
        this.amount = amount;
        this.groupId = groupId;
    }

    public Expense(int userId, int groupId) {
        this.userId = userId;
        this.amount = 0;
        this.groupId = groupId;
    }

}
