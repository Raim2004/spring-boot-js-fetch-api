package com.peaksoft.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping("/admin")
    public String adminPage(){
        return "admin-page";
    }

    @GetMapping("/user")
    public String userPage(){
        return "user-page";
    }

}
