package com.wastefood.redistribution.controller;

import com.wastefood.redistribution.entity.User;
import com.wastefood.redistribution.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserService service;

    // Register API
    @PostMapping("/register")
    public User register(@RequestBody User user) {

        return service.register(user);
    }

    // Login API
    @PostMapping("/login")
    public User login(@RequestBody User user) {

        return service.login(user.getUsername(), user.getPassword());
    }
}