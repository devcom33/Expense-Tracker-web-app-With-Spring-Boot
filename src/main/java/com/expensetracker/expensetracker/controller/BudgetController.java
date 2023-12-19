package com.expensetracker.expensetracker.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BudgetController {
    

    @GetMapping("/budget")
    public String hello()
    {
        return "budget/add-budget";
    }
}
