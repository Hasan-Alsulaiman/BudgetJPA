package com.example.budgetwithjpa.data;

import com.example.budgetwithjpa.entity.Category;
import com.example.budgetwithjpa.entity.Expense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {

    public Long deleteByCategory(String category);

    public Iterable<Expense> findAllByCategory(Category category);
}
