package com.expensetracker.expensetracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensetracker.expensetracker.model.Budget;
import com.expensetracker.expensetracker.repository.BudgetRepository;

@Service
public class BudgetService {
    @Autowired BudgetRepository budgetRepository;
    public double getBudgetLimit(Integer categoryId)
    {
        return budgetRepository.findBudgetLimitByCategoryId(categoryId);
    }
    public List<Budget> getAllEntities() {
        return budgetRepository.findAll();
    }
}
