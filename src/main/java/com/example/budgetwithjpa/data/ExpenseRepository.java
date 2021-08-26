package com.example.budgetwithjpa.data;

import com.example.budgetwithjpa.entity.Expense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
}
