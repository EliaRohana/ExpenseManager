package com.elia.em.repository;

import com.elia.em.model.Category;
import com.elia.em.model.Expense;
import com.elia.em.model.ExpenseFactory;
import com.elia.em.model.MonthlyReport;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by Elia on 12/2/2016.
 */
public class MonthlyReportRepositoryImpl implements MonthlyReportRepositoryCustom {

    private final MongoTemplate template;
    private final ExpenseFactory expenseFactory;

    @Autowired
    public MonthlyReportRepositoryImpl(MongoTemplate template, ExpenseFactory expenseFactory) {
        this.template = template;
        this.expenseFactory = expenseFactory;
    }

    @Override
    public boolean addExpense(Expense newExpense, String monthlyReportId) {
        newExpense = expenseFactory.create(newExpense);
        WriteResult writeResult = template.updateFirst(new Query(
                where("_id").is(monthlyReportId)), new Update().push("expenses", newExpense), MonthlyReport.class);
        return writeResult.wasAcknowledged();
    }

    @Override
    public boolean updateExpense(String monthlyReportId, String expenseId, Expense expense) {
        Criteria id = where("_id").is(monthlyReportId);
        Criteria expenseWhere = where("expenses.id").is(expenseId);
        WriteResult writeResult = template.updateFirst(new Query().addCriteria(id).addCriteria(expenseWhere),
                new Update()
                        .set("expenses.$.cost", expense.getCost())
                        .set("expenses.$.category", expense.getCategory())
                        .set("expenses.$.name", expense.getName()),
                MonthlyReport.class);
        return writeResult.wasAcknowledged();
    }

    @Override
    public boolean deleteExpense(String reportId, String expenseId) {
        WriteResult writeResult = template.updateFirst(new Query(
                where("_id").is(reportId)), new Update().pull("expenses", new Query(where("id").is(expenseId))), MonthlyReport.class);
        return writeResult.wasAcknowledged();
    }

    public int getExpenseListTotalCost(String reportId){
        MatchOperation idMatcher = match(where("_id").is(reportId));
        Aggregation aggregation = newAggregation(idMatcher, unwind("expenses"), group("id").sum("expenses.cost").as("total"));
        AggregationResults<DBObject> result = template.aggregate(aggregation, MonthlyReport.class, DBObject.class);
        return result.getMappedResults().isEmpty() ? 0 : (int) result.getMappedResults().get(0).get("total");
    }

    public int getExpenseListTotalCostByCategory(String reportId, Category category){
        MatchOperation idMatcher = match(where("_id").is(reportId));
        Aggregation aggregation = newAggregation(
                idMatcher, unwind("expenses"),
                match(where("expenses.category").is(category)),
                group("id").sum("expenses.cost").as("total"));
        AggregationResults<DBObject> result = template.aggregate(aggregation, MonthlyReport.class, DBObject.class);
        return result.getMappedResults().isEmpty() ? 0 : (int) result.getMappedResults().get(0).get("total");
    }
}
