package com.springlearning.MongoCrud.repository;

import com.springlearning.MongoCrud.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense, String> {

}
