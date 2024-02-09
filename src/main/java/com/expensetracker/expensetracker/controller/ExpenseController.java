package com.expensetracker.expensetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.expensetracker.expensetracker.model.Expense;
import com.expensetracker.expensetracker.repository.ExpenseRepository;
import com.expensetracker.expensetracker.services.BudgetService;
import com.expensetracker.expensetracker.services.CategoryService;
import com.expensetracker.expensetracker.services.ExpenseService;

import jakarta.validation.Valid;


//@controller because we build a traditional web application that returns HTML pages.
@Controller 
public class ExpenseController {
    @Autowired private ExpenseRepository expenseRepository;
    @Autowired private CategoryService categoryService;
    @Autowired private ExpenseService expenseService;
    @Autowired private BudgetService budgetService;
    @GetMapping("/expense")
    // public String hello(){
    //     return "expense/add";
    // }
    public String showForm(Model model) {
        model.addAttribute("expense", new Expense());
        model.addAttribute("categories", categoryService.getAllEntities());
        return "expense/add-expense";
    }
    @PostMapping("/expense")
    public String processForm(@Valid @ModelAttribute Expense expense, BindingResult result, Model model) {
        if (result.hasErrors())
        {
            model.addAttribute("categories", categoryService.getAllEntities());
            return "expense/add-expense";
        }
        if(( expenseService.getSumCategory() + expense.getExpenseprice() ) > budgetService.getBudgetLimit(expense.getCategory().getCategory_id())){
            model.addAttribute("message", "Your Budget has been exceeded ");
            model.addAttribute("categories", categoryService.getAllEntities());  
        }
        else{
            expenseRepository.save(expense);
            model.addAttribute("message", "Expense Added Successfully");
            model.addAttribute("categories", categoryService.getAllEntities());
        }
        return "expense/add-expense";
    }
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("expenses", expenseService.getAllEntities());
        return "expense/list";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id,Model model) {
        Expense expense = expenseRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid expense Id: " + id));
        model.addAttribute("expense", expense);
        model.addAttribute("categories", categoryService.getAllEntities());
        return "expense/edit";
    }
    //Update Expense
    @PostMapping("/update/{id}")
    public String updateExpense(@PathVariable("id") int id, @Valid Expense expense,BindingResult result, Model model) {

        if (result.hasErrors())
        {
            expense.setId(id);
            return "expense/edit";
        }
        expenseRepository.save(expense);
        return "redirect:/list";
    }
    //delete Expense
    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable("id") int id, Model model) {
        Expense expense = expenseRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid expense Id: " + id));
        expenseRepository.delete(expense);
        return "redirect:/list";
    }   
}