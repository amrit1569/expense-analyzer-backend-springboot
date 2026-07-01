package com.expense.analyzer.service;

import com.expense.analyzer.dto.ExpenseDTO;
import com.expense.analyzer.entity.Expense;
import com.expense.analyzer.entity.User;
import com.expense.analyzer.repository.ExpenseRepository;
import com.expense.analyzer.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository repo;

    @Autowired
    private UserRepository userRepo;

    // Add Expense
    public Expense add(ExpenseDTO dto, String email) {

        User user = userRepo.findByEmail(email).orElseThrow();

        Expense exp = new Expense();

        exp.setTitle(dto.title);
        exp.setAmount(dto.amount);
        exp.setCategory(dto.category);
        exp.setDate(LocalDate.now());
        exp.setUser(user);

        return repo.save(exp);
    }

    // Get Expenses
    public List<Expense> get(String email) {

        User user = userRepo.findByEmail(email).orElseThrow();

        return repo.findByUser(user);
    }

    // Update Expense
    public Expense update(Long id, ExpenseDTO dto, String email) {

        Expense expense = repo.findById(id).orElseThrow();

        if (!expense.getUser().getEmail().equals(email)) {
            throw new RuntimeException("Unauthorized");
        }

        expense.setTitle(dto.title);
        expense.setAmount(dto.amount);
        expense.setCategory(dto.category);
        expense.setDate(LocalDate.now());

        return repo.save(expense);
    }

    // Delete Expense
    public String delete(Long id, String email) {

        Expense expense = repo.findById(id).orElseThrow();

        if (!expense.getUser().getEmail().equals(email)) {
            throw new RuntimeException("Unauthorized");
        }

        repo.delete(expense);

        return "Expense Deleted";
    }
}