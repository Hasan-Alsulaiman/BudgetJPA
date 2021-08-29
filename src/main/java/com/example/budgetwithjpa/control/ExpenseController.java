package com.example.budgetwithjpa.control;

import com.example.budgetwithjpa.data.ExpenseRepository;
import com.example.budgetwithjpa.data.CategoryRepository;
import com.example.budgetwithjpa.entity.Category;
import com.example.budgetwithjpa.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


@RestController
@RequestMapping("/budget")
@Transactional
public class ExpenseController {
    ExpenseRepository expenseRepo;
    CategoryRepository catRepo;

    @Autowired
    public ExpenseController(ExpenseRepository expenseRepo, CategoryRepository typeRepo) {
        this.expenseRepo = expenseRepo;
        this.catRepo = typeRepo;
    }

    @GetMapping("/view")
    public Iterable<Expense> viewAll() {
        return expenseRepo.findAll();
    }

    @GetMapping("/view/category/{category}")
    public Iterable<Expense> viewByCategory(@PathVariable String category) {
        return expenseRepo.findAllByCategory(catRepo.findCategoryByName(category));
    }

    @PostMapping
    public String addExpense(@RequestBody Expense expense) {
        expense.setCategory(catRepo.findCategoryByName(expense.getCategory().getName()));
        expenseRepo.save(expense);
        return "ok";
    }

    @DeleteMapping("/deleteby/type/{type}")
    public Long deleteExpenseBy(@PathVariable String type) {
        System.out.println(type);
        return expenseRepo.deleteByCategory(type);
    }


    @DeleteMapping("/deleteby/id/{id}")
    public void deleteExpenseBy(@PathVariable Long id) {
        expenseRepo.deleteById(id);
    }

    @DeleteMapping("/deleteby/id/all")
    public void deleteExpenseBy() {
        expenseRepo.deleteAll();
    }

}
