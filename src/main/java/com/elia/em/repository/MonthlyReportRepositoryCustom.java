package com.elia.em.repository;

import com.elia.em.model.Category;
import com.elia.em.model.Expense;
import com.elia.em.model.MonthlyReport;
import com.mongodb.DBObject;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Created by Elia on 12/2/2016.
 */
public interface MonthlyReportRepositoryCustom {

    boolean addExpense(Expense newExpense, String monthlyReportId);

    boolean updateExpense(String monthlyReportId, String expenseId, Expense expense);

    boolean deleteExpense(String reportId, String expenseId);

    int getExpenseListTotalCost(String reportId);

    int getExpenseListTotalCostByCategory(String reportId, Category category);

    List<MonthlyReport> findByParams(HashMap<String, List<Object>> allRequestParams);

    List<DBObject> getTotalExpensesForCategories(String userId, Optional<Integer> year);

}

