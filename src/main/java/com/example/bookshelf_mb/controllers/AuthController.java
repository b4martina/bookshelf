package com.example.bookshelf_mb.controllers;


import com.example.bookshelf_mb.dto.LogInRequest;
import com.example.bookshelf_mb.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")

public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LogInRequest request){
        boolean success = userService.login(request);

        if(success){
            return "Login successful!";

        }

        return "Log in unsuccessful";

    }

}
