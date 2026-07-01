package com.expense.analyzer.controller;

import com.expense.analyzer.config.JwtUtil;
import com.expense.analyzer.dto.ExpenseDTO;
import com.expense.analyzer.entity.Expense;
import com.expense.analyzer.service.ExpenseService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService service;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping
    public List<Expense> get(HttpServletRequest request) {

        String token = request.getHeader("Authorization").substring(7);

        String email = jwtUtil.extractUsername(token);

        return service.get(email);
    }

    @PostMapping
    public Expense add(@RequestBody ExpenseDTO dto,
                       HttpServletRequest request) {

        String token = request.getHeader("Authorization").substring(7);

        String email = jwtUtil.extractUsername(token);

        return service.add(dto, email);
    }

    @PutMapping("/{id}")
    public Expense update(@PathVariable Long id,
                          @RequestBody ExpenseDTO dto,
                          HttpServletRequest request) {

        String token = request.getHeader("Authorization").substring(7);

        String email = jwtUtil.extractUsername(token);

        return service.update(id, dto, email);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id,
                         HttpServletRequest request) {

        String token = request.getHeader("Authorization").substring(7);

        String email = jwtUtil.extractUsername(token);

        return service.delete(id, email);
    }

}