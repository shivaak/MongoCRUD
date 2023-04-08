package com.springlearning.MongoCrud.service;

import com.springlearning.MongoCrud.model.Expense;
import com.springlearning.MongoCrud.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    ExpenseRepository expenseRepository;

    ExpenseService(ExpenseRepository repository){
        this.expenseRepository = repository;
    }

    public void addExpense(Expense expense) {
        expenseRepository.insert(expense);
    }
    public void updateExpense(Expense expense) {
        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(()-> new RuntimeException(String.format("Cannot find ID %s", expense.getId())));

        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());

        expenseRepository.save(savedExpense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public void getExpenseByName() {

    }

    public void deleteExpense() {

    }
}
