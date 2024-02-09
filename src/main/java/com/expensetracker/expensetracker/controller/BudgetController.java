package com.expensetracker.expensetracker.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import com.expensetracker.expensetracker.model.Budget;
import com.expensetracker.expensetracker.repository.BudgetRepository;
import com.expensetracker.expensetracker.services.BudgetService;
import com.expensetracker.expensetracker.services.CategoryService;



@Controller
public class BudgetController {
    @Autowired private CategoryService categoryService;
    @Autowired private BudgetRepository budgetRepository;
    @Autowired private BudgetService budgetService;
    @GetMapping("/budget")
    public String budget(Model model)
    {
        model.addAttribute("budget", new Budget());
        model.addAttribute("categories", categoryService.getAllEntities());
        model.addAttribute("budgets", budgetService.getAllEntities());
        return "budget/add-budget";
    }
    @PostMapping("/budget")
    public String processBudget(Budget budget,Model model) {
        budgetRepository.save(budget);
        model.addAttribute("categories", categoryService.getAllEntities());
        model.addAttribute("budgets", budgetService.getAllEntities());
        return "redirect:/budget";
    }
}