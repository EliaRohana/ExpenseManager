package com.elia.em.service;

import com.elia.em.model.Category;
import com.elia.em.model.Expense;
import com.elia.em.model.MonthlyReport;
import com.elia.em.repository.MonthlyReportRepository;
import com.elia.em.service.util.DefaultFieldTypeProvider;
import com.elia.em.service.util.QueryParamParserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Elia on 12/2/2016.
 */
@Service
public class MontlyReportService {

    private final MonthlyReportRepository monthlyReportRepository;
    private final QueryParamParserProvider queryParamParserProvider;

    @Autowired
    public MontlyReportService(MonthlyReportRepository monthlyReportRepository, QueryParamParserProvider queryParamParserProvider) {
        this.monthlyReportRepository = monthlyReportRepository;
        this.queryParamParserProvider = queryParamParserProvider;
    }

    public MonthlyReport create(MonthlyReport monthlyReport) {
        return monthlyReportRepository.save(monthlyReport);
    }

    public List<MonthlyReport> findAll() {
        return monthlyReportRepository.findAll();
    }


    public MonthlyReport update(String id, MonthlyReport monthlyReport) {
        MonthlyReport monthlyReportToUpdate = monthlyReportRepository.findOne(id);
        if(monthlyReportToUpdate != null){
            monthlyReportToUpdate.setMonth(monthlyReport.getMonth());
            monthlyReportToUpdate.setYear(monthlyReport.getYear());
            monthlyReportToUpdate.setName(monthlyReport.getName());
            return monthlyReportRepository.save(monthlyReportToUpdate);
        }
        return null;
    }

    public void delete(String id) {
        monthlyReportRepository.delete(id);
    }

    public boolean addExpense(String reportId, Expense expense) {
        return monthlyReportRepository.addExpense(expense, reportId);
    }

    public boolean updateExpense(String monthlyReportId, String expenseId, Expense expense) {
        return monthlyReportRepository.updateExpense(monthlyReportId, expenseId, expense);
    }

    public boolean deleteExpense(String reportId, String expenseId) {
        return monthlyReportRepository.deleteExpense(reportId, expenseId);
    }

    public int getReportTotalCosts(String id, Category category) {
        if(category == null)
            return monthlyReportRepository.getExpenseListTotalCost(id);
        else
            return monthlyReportRepository.getExpenseListTotalCostByCategory(id, category);
    }

    public List<MonthlyReport> findBy(MultiValueMap<String, String> allRequestParams) {
        HashMap<String, List<Object>> parsedRequestParams = new HashMap<>(allRequestParams.size());
        DefaultFieldTypeProvider fieldTypeProvider = new DefaultFieldTypeProvider(MonthlyReport.class);
        allRequestParams.forEach((key, values)->{
            Class fieldType = fieldTypeProvider.getFieldType(key);
            List<Object> parsedValues = values.stream()
                    .map(value -> this.queryParamParserProvider.getParser(fieldType).parse(value))
                    .collect(Collectors.toList());
            parsedRequestParams.put(key, parsedValues);
        });
        return monthlyReportRepository.findByParams(parsedRequestParams);
    }
}
