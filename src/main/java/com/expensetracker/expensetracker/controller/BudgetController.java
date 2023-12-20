package com.expensetracker.expensetracker.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import com.expensetracker.expensetracker.model.Budget;


@Controller
public class BudgetController {
    

    @GetMapping("/budget")
    public String budget()
    {
        return "budget/add-budget";
    }
    @PostMapping("/budget")
    public String postBudget(Budget budget) {
        return "redirect:/budget";
    }
}
