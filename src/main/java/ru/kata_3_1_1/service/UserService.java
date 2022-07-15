package ru.kata_3_1_1.service;

import ru.kata_3_1_1.model.User;

import java.util.List;

public interface UserService {
    public List<User> allUsers ();

    public void createUser(User user);

    public User getById(long id);

    public void updateUser (User user);

    public void deleteUser(long id);
}
