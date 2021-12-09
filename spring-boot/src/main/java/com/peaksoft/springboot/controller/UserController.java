package com.peaksoft.springboot.controller;

import com.peaksoft.springboot.entity.User;
import com.peaksoft.springboot.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/page")
    public User getUser(Principal principal){
        User user = userService.findUsersByUsername(principal.getName());
        user = new User(user.getId(),user.getName(),user.getLastName(),user.getAge(),user.getEmail());
        return user;
    }

}
