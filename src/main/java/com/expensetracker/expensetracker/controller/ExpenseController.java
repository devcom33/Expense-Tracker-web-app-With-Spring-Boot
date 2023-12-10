package com.expensetracker.expensetracker.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.expensetracker.expensetracker.model.Expense;
import com.expensetracker.expensetracker.repository.ExpenseRepository;
import com.expensetracker.expensetracker.services.CategoryService;


//@controller because we build a traditional web application that returns HTML pages.
@Controller 
public class ExpenseController {
    @Autowired private ExpenseRepository expenseRepository;
    @Autowired private CategoryService categoryService;
    @GetMapping("/expense")
    // public String hello(){
    //     return "expense/add";
    // }
    public String showForm(Model model) {
        model.addAttribute("expense", new Expense());
        model.addAttribute("categories", categoryService.getAllEntities());
        return "expense/add";
    }

    @PostMapping("/expense")
    public String processForm(@ModelAttribute Expense expense) {
        expenseRepository.save(expense);
        return "redirect:/expense";
    }
    
}
