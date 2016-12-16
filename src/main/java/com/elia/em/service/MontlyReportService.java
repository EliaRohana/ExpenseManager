package com.elia.em.service;

import com.elia.em.model.Category;
import com.elia.em.model.Expense;
import com.elia.em.model.MonthlyReport;
import com.elia.em.repository.MonthlyReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Elia on 12/2/2016.
 */
@Service
public class MontlyReportService {

    private final MonthlyReportRepository monthlyReportRepository;

    @Autowired
    public MontlyReportService(MonthlyReportRepository monthlyReportRepository) {
        this.monthlyReportRepository = monthlyReportRepository;
    }

    public MonthlyReport create(MonthlyReport monthlyReport) {
        return monthlyReportRepository.save(monthlyReport);
    }

    public List<MonthlyReport> findAll() {
        return monthlyReportRepository.findAll();
    }

    public MonthlyReport findById(String id) {
        return monthlyReportRepository.findOne(id);
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

}
