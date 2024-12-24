package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User createUser(User user);

    User saveNewUser(User user);
}
