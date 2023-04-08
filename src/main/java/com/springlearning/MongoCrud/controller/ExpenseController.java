package com.springlearning.MongoCrud.controller;

import com.springlearning.MongoCrud.model.Expense;
import com.springlearning.MongoCrud.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity addExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public void updateExpense() {

    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    public void getExpenseByName() {

    }

    public void deleteExpense() {

    }
}
