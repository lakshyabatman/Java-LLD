package com.lakshyabatman.splitwise.models;

import com.lakshyabatman.splitwise.enums.UserRole;

public class GroupMember extends Entity{
    public final int userId, groupId;

    public final UserRole userRole;
    public final Expense expense;

    public GroupMember(int userId, int groupId, UserRole userRole, Expense expense) {
        this.userId = userId;
        this.groupId = groupId;
        this.userRole = userRole;
        this.expense = expense;
    }
}
