package com.example.springs.controller;

import com.example.springs.entity.User;
import com.example.springs.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public String Hello() {
        return "This is USER HELLO";
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        User response = userService.saveUser(user);
        return response;
    }

}
