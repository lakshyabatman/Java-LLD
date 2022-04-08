package com.lakshyabatman.splitwise;

import com.lakshyabatman.splitwise.controller.Splitwise;
import com.lakshyabatman.splitwise.exceptions.EntityNotFound;
import com.lakshyabatman.splitwise.models.Expense;
import com.lakshyabatman.splitwise.models.Group;
import com.lakshyabatman.splitwise.models.User;

public class Main {

    public static void main(String[] args) throws EntityNotFound {
        Splitwise splitwise = new Splitwise();

        User lakshya = splitwise.createUser("lakshya");
        User uphaar = splitwise.createUser("uphaar");
        User pranshu = splitwise.createUser("pranshu");

        Group group = splitwise.createGroup(lakshya,"Fahad's bday", "random");

        splitwise.addExpense(group.groupId,uphaar.userId,100);
        splitwise.addExpense(group.groupId,pranshu.userId,-80);
        splitwise.addExpense(group.groupId,lakshya.userId,-20);


        splitwise.generatePaymentGraph(group);

    }

}
