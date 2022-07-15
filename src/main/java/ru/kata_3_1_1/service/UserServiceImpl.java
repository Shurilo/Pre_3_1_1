package ru.kata_3_1_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata_3_1_1.model.User;
import ru.kata_3_1_1.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers () {

        return userRepository.findAll();
    }

    public void createUser(User user) {
        userRepository.save(user);

    }
    public User getById(long id) {
        return userRepository.getOne(id);
    }

    public void updateUser (User user) {
        userRepository.save(user);

    }
    public void deleteUser(long id) {
        userRepository.delete(getById(id));

    }
}
