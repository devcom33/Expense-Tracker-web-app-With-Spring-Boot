package com.expensetracker.expensetracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensetracker.expensetracker.model.Expense;
import com.expensetracker.expensetracker.repository.ExpenseRepository;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class ExpenseService {
    @Autowired private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }
    public List<Expense> getAllEntities() {
        return expenseRepository.findAll();
    }
    public double subExpense(double budgetLimit, double expensePrice){
        return (budgetLimit - expensePrice);
    }
    public double getSumCategory(){
        List<Double> listcat = expenseRepository.ListExpx(1);
        double sumCategories = 0.0;
        for (Double i : listcat) {
            sumCategories += i;
        }
        return sumCategories;
    }
}
