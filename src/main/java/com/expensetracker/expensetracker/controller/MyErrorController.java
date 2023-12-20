package com.expensetracker.expensetracker.controller;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.web.servlet.error.ErrorController;

@Controller
public class MyErrorController implements ErrorController{

    @RequestMapping("/error")
    public String handleError(){
        return "error/error";
    }
    
}
