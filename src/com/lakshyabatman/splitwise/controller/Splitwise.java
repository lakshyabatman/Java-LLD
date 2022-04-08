package com.lakshyabatman.splitwise.controller;

import com.lakshyabatman.splitwise.enums.UserRole;
import com.lakshyabatman.splitwise.exceptions.EntityNotFound;
import com.lakshyabatman.splitwise.models.Expense;
import com.lakshyabatman.splitwise.models.Group;
import com.lakshyabatman.splitwise.models.GroupMember;
import com.lakshyabatman.splitwise.models.User;
import com.lakshyabatman.splitwise.repository.GroupMembersRepository;
import com.lakshyabatman.splitwise.repository.GroupRepository;
import com.lakshyabatman.splitwise.repository.UserRepository;
import com.lakshyabatman.splitwise.service.PaymentGraphService;

import java.util.ArrayList;
import java.util.HashMap;

public class Splitwise {

    private final GroupMembersRepository groupMembersRepository;
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final PaymentGraphService paymentGraphService;


    public Splitwise(GroupMembersRepository groupMembersRepository, GroupRepository groupRepository, UserRepository userRepository, PaymentGraphService paymentGraphService) {
        this.groupMembersRepository = groupMembersRepository;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.paymentGraphService = paymentGraphService;
    }

    public Splitwise() {
        this.groupMembersRepository = new GroupMembersRepository();
        this.groupRepository = new GroupRepository();
        this.userRepository = new UserRepository();
        this.paymentGraphService = new PaymentGraphService(this.userRepository);
    }


    public User createUser(String name) {
        return userRepository.addUser(name);
    }

    public Group createGroup(User author, String title, String description) {
        return groupRepository.createGroup(author.userId, title, description);
    }


    public Expense addExpense(int groupId, int userId, int amount) throws EntityNotFound {
        Group group = groupRepository.getGroup(groupId);
        UserRole role = group.authorId == userId ? UserRole.ADMIN : UserRole.MEMBER;
        Expense expense = new Expense(userId, groupId,amount);
        groupMembersRepository.addGroupMember(userId, groupId,role, expense);
        return expense;
    }


    public void generatePaymentGraph(Group group) throws EntityNotFound {
        ArrayList<GroupMember> groupMembers = groupMembersRepository.getByGroupId(group.groupId);
        HashMap<User, HashMap<User, Integer>> graph = paymentGraphService.generatePaymentGraph(groupMembers);

        // use some logger class to display graph
        for(User user: graph.keySet()) {
            System.out.print(user.name + " owes ");
            for(User recipient: graph.get(user).keySet()) {
                System.out.println(recipient.name + " " + graph.get(user).get(recipient));

            }
        }
    }

}
