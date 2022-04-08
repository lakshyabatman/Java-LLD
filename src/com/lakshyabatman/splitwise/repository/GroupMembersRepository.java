package com.lakshyabatman.splitwise.repository;

import com.lakshyabatman.splitwise.enums.UserRole;
import com.lakshyabatman.splitwise.exceptions.EntityNotFound;
import com.lakshyabatman.splitwise.models.Expense;
import com.lakshyabatman.splitwise.models.GroupMember;

import java.util.ArrayList;

public class GroupMembersRepository {

    ArrayList<GroupMember> groupMemberRepository;


    public GroupMembersRepository() {
        groupMemberRepository = new ArrayList<>();
    }

    public ArrayList<GroupMember> getByUserId(int userId) {
        ArrayList<GroupMember> res = new ArrayList<>();
        for(GroupMember groupMember : groupMemberRepository) {
            if(userId == groupMember.userId) res.add(groupMember);
        }
        return res;
    }


    public ArrayList<GroupMember> getByGroupId(int groupId) {
        ArrayList<GroupMember> res = new ArrayList<>();
        for(GroupMember groupMember : groupMemberRepository) {
            if(groupId == groupMember.groupId) res.add(groupMember);
        }
        return res;
    }


    public int getGroupAdmin(int groupId) throws EntityNotFound {
        for(GroupMember groupMember: groupMemberRepository) {
            if(groupMember.groupId == groupId && groupMember.userRole == UserRole.ADMIN) return groupMember.userId;
        }
        throw new EntityNotFound();
    }


    public void addGroupMember(int userId, int groupId, UserRole userRole, Expense expense) {
        groupMemberRepository.add(new GroupMember(userId,groupId,userRole,expense));
    }




}
