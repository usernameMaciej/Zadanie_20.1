package com.example.zadanie_201;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> userList = new ArrayList<>();

    List<User> getUserList() {
        return userList;
    }

    void addUser(User user) {
        userList.add(user);
    }
}
