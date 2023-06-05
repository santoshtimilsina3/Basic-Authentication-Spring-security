package com.example.springs.controller;

import com.example.springs.entity.User;
import com.example.springs.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;
    @GetMapping
    public String home() {
        return "HELLO FROM all";
    }
    @GetMapping(value = "users")
    public String messages(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "home.html";
    }
}
