package com.expensetracker.expensetracker.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.expensetracker.expensetracker.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
}
