package com.example.budgetwithjpa.control;

import com.example.budgetwithjpa.data.ExpenseRepository;
import com.example.budgetwithjpa.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/budget")
public class ExpenseController {
    ExpenseRepository expenseRepo;

    @Autowired
    public ExpenseController(ExpenseRepository expenseRepo) {
        this.expenseRepo = expenseRepo;
    }

    @GetMapping("/view")
    public Iterable<Expense> viewAll(Model model) {
        System.out.println(expenseRepo.findAll());
        return expenseRepo.findAll();
    }

    @PostMapping
    public String addExpense(@RequestBody Expense expense) {
        expenseRepo.save(expense);
        return "ok.";
    }
}
