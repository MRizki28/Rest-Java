package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired

    private UserService userService;

    @GetMapping("/all")
    public Object getAllData() {
        return userService.getAllData();
    }
}
