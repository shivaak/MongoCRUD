package com.springlearning.MongoCrud.repository;

import com.springlearning.MongoCrud.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ExpenseRepository extends MongoRepository<Expense, String> {

    @Query("{'expense': ?0}")
    public Optional<Expense> findByName(String name);

}
