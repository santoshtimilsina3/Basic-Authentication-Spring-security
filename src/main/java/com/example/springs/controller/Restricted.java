package com.example.springs.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restricted")
@Hidden  //we can also apply in swagger
public class Restricted {

    @GetMapping
    @Hidden // this hides this method in swagger
    public String restrictedContent() {
        return "This is restricted";
    }
}
