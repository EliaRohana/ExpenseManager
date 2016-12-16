package com.elia.em.model;

import com.elia.em.service.MongoCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Elia on 12/3/2016.
 */
@Component
public class ExpenseFactory {

    private final MongoCounterService mongoCounterService;

    @Autowired
    public ExpenseFactory(MongoCounterService mongoCounterService) {
        this.mongoCounterService = mongoCounterService;
    }

    public Expense create(int cost, String name, String category){
        return new Expense(mongoCounterService.getNextSequence("expenses"), cost, name, category);
    }

    public Expense create(int cost, String name, String category, String remarks){
        return new Expense(mongoCounterService.getNextSequence("expenses"), cost, name, category, remarks);
    }


    public Expense create(Expense newExpense) {
        return create(newExpense.getCost(), newExpense.getName(), newExpense.getCategory(), newExpense.getRemarks());
    }
}
