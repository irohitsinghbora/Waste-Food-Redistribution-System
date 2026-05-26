package com.wastefood.redistribution.service;

import com.wastefood.redistribution.entity.User;
import com.wastefood.redistribution.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    // Register user
    public User register(User user) {

        return repository.save(user);
    }

    // Login user
    public User login(String username, String password) {

        User user = repository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {

            return user;
        }

        throw new RuntimeException("Invalid Username or Password");
    }
}