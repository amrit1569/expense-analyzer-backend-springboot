package com.expense.analyzer.repository;

import com.expense.analyzer.entity.Expense;
import com.expense.analyzer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByUser(User user);

}