package com.barbirms.presentation.controllers;

import com.barbirms.service.DTOs.UserDTO;
import com.barbirms.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users/{username}/{password}")
    public void AddUser(@PathVariable String username, @PathVariable String password) {
        userService.CreateUser(username, password);
    }

    @GetMapping("/users/{username}")
    public UserDTO getUserByUsername(@PathVariable String username) {
        return userService.GetUserInfo(username);
    }

    @GetMapping("/users/all")
    public List<UserDTO> getAllUsers() {
        return userService.GetAllUsers();
    }

}