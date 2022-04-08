package com.lakshyabatman.splitwise.repository;

import com.lakshyabatman.splitwise.exceptions.EntityNotFound;
import com.lakshyabatman.splitwise.models.User;

import java.util.HashMap;

public class UserRepository {

    private final HashMap<Integer, User> userRepository;
    private int indexCounter;

    public UserRepository() {
        userRepository = new HashMap<>();
        indexCounter = 0;
    }
    public User getUser(int userId) throws EntityNotFound {
        if(!userRepository.containsKey(userId)) throw new EntityNotFound();
        return userRepository.get(userId);
    }


    public User addUser(String name) {
        User newUser =  new User(name, indexCounter);
        userRepository.put(indexCounter,newUser);
        indexCounter++;
        return newUser;
    }
}
