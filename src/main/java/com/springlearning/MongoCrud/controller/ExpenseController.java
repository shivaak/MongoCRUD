package com.springlearning.MongoCrud.controller;

import com.springlearning.MongoCrud.model.Expense;
import com.springlearning.MongoCrud.service.ExpenseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @ApiOperation(
            value = "Add new expense",
            notes = "Create new expense with expense name, category and amount",
            produces = "application/json")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(
            value = "Update expense",
            notes = "Update expense with new expense name, category and amount",
            produces = "application/json")
    @PutMapping
    public ResponseEntity<Object> updateExpense(@RequestBody Expense expense) {
        expenseService.updateExpense(expense);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(
            value = "Get all expense",
            notes = "Provides list of all available expenses",
            produces = "application/json")
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }


    @ApiOperation(
            value = "Get expense by name",
            notes = "Filter the expense by name",
            produces = "application/json")
    @GetMapping("/{name}")
    public ResponseEntity<Expense> getExpenseByName(@PathVariable String name) {
        return ResponseEntity.ok(expenseService.getExpenseByName(name));
    }

    @ApiOperation(
            value = "Delete expense by ID",
            notes = "Delete the given expense",
            produces = "application/json")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteExpense(@PathVariable  String id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
