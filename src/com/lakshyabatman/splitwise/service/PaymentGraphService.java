package com.lakshyabatman.splitwise.service;

import com.lakshyabatman.splitwise.exceptions.EntityNotFound;
import com.lakshyabatman.splitwise.models.Expense;
import com.lakshyabatman.splitwise.models.GroupMember;
import com.lakshyabatman.splitwise.models.User;
import com.lakshyabatman.splitwise.repository.GroupRepository;
import com.lakshyabatman.splitwise.repository.UserRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PaymentGraphService {


    private final UserRepository userRepository;

    public PaymentGraphService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public HashMap<User, HashMap<User, Integer>> generatePaymentGraph(ArrayList<GroupMember> groupMembers) throws EntityNotFound {
        HashMap<User, HashMap<User, Integer>> expenseGraph = new  HashMap<>();
        HashMap<Integer, User> userDetailsCache = new HashMap<>();
        PriorityQueue<Expense> paidExpenses = new PriorityQueue<>(Comparator.comparingInt(x -> -x.amount));
        PriorityQueue<Expense> owedExpenses = new PriorityQueue<>(Comparator.comparingInt(x -> x.amount));
        for(GroupMember groupMember : groupMembers) {

            //hydrating users map
            if(!userDetailsCache.containsKey(groupMember.userId)) {
                User user =  userRepository.getUser(groupMember.userId);
                userDetailsCache.put(user.userId, user);

            }

            if(groupMember.expense.amount > 0) paidExpenses.add(groupMember.expense);
            else owedExpenses.add(groupMember.expense);


        }

        while(paidExpenses.size() > 0 && owedExpenses.size() > 0) {
            Expense paidExpense = paidExpenses.poll();
            Expense owedExpense = owedExpenses.poll();
            //for intellj
            if(owedExpense == null) throw new NullPointerException();

            User payee = userDetailsCache.get(paidExpense.userId);
            User recipient = userDetailsCache.get(owedExpense.userId);

            if(payee == null || recipient == null) throw new EntityNotFound();


            int amountLeft = paidExpense.amount - owedExpense.amount;
            if(amountLeft > 0) {
                Expense updatedExpense = new Expense(paidExpense.userId, paidExpense.groupId, amountLeft);
                paidExpenses.offer(updatedExpense);
            }else if(amountLeft < 0){
                Expense updatedExpense = new Expense(owedExpense.userId, owedExpense.groupId, amountLeft);
                owedExpenses.offer(updatedExpense);
            }
            HashMap<User, Integer> userExpensesGraph = expenseGraph.getOrDefault(payee ,new HashMap<>());

            userExpensesGraph.put(recipient, Math.min( paidExpense.amount, owedExpense.amount));

            expenseGraph.put(payee, userExpensesGraph);
        }
        return expenseGraph;

    }
}
