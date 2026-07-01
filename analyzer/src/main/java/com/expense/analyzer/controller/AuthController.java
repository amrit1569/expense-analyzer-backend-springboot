package com.expense.analyzer.controller;

import com.expense.analyzer.dto.UserDTO;
import com.expense.analyzer.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public String register(@RequestBody UserDTO dto) {
        return service.register(dto);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDTO dto) {
        return service.login(dto);
    }
}