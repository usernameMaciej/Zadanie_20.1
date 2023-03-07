package com.example.zadanie201;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> userList = new ArrayList<>();

    public UserRepository() {
        userList.add(new User("Daniel", "Abacki", 36));
        userList.add(new User("Jan", "Kowalski", 22));
        userList.add(new User("Basia", "Zawadzka", 17));
    }

    List<User> getUserList() {
        return userList;
    }

    void addUser(User user) {
        userList.add(user);
    }
}
