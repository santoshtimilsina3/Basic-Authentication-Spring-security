package com.example.springs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restricted")
public class Restricted {

    @GetMapping
    public String restrictedContent() {
        return "This is restricted";
    }
}
