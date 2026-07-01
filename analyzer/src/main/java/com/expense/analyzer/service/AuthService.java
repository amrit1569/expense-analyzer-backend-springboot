package com.expense.analyzer.service;

import com.expense.analyzer.config.JwtUtil;
import com.expense.analyzer.dto.UserDTO;
import com.expense.analyzer.entity.User;
import com.expense.analyzer.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtil jwtUtil;

    // Register
    public String register(UserDTO dto) {

        if (repo.existsByUsername(dto.username)) {
            throw new RuntimeException("Username already exists");
        }

        if (repo.existsByEmail(dto.email)) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setUsername(dto.username);
        user.setEmail(dto.email);
        user.setPassword(encoder.encode(dto.password));
        user.setRole("ROLE_USER");

        repo.save(user);

        return "Registered Successfully";
    }

    // Login
    public String login(UserDTO dto) {

        User user = repo.findByEmail(dto.email)
                .orElseThrow(() -> new RuntimeException("Email not found"));

        if (!encoder.matches(dto.password, user.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        System.out.println("Generated JWT: " + token);

        return token;
    }
}