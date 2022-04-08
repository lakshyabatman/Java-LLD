package com.lakshyabatman.splitwise.repository;

import com.lakshyabatman.splitwise.exceptions.EntityNotFound;
import com.lakshyabatman.splitwise.models.Group;

import java.util.HashMap;

public class GroupRepository {

    private final HashMap<Integer, Group> groupRepository;
    private int indexCounter;

    public GroupRepository() {
        groupRepository = new HashMap<>();
        indexCounter = 0;
    }

    public Group getGroup(int groupId) throws EntityNotFound {
        if(!groupRepository.containsKey(groupId)) throw new EntityNotFound();
        return groupRepository.get(groupId);
    }


    public Group createGroup(int authorId, String title, String description) {
        Group createdGroup = new Group(indexCounter,authorId,title,description);
        groupRepository.put(indexCounter,createdGroup);
        indexCounter++;
        return createdGroup;
    }

}
