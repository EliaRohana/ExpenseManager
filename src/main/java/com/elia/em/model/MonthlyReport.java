package com.elia.em.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Elia on 12/2/2016.
 */
@Document(collection = "monthly_reports")
public class MonthlyReport {

    @Id
    private String id;
    private String name;
    private Month month;
    private int year;
    @JsonProperty("expenses")
    private Collection<Expense> expenses;
    private String userId;

    public MonthlyReport() {
    }

    public MonthlyReport(String name, Month month, int year, String userId) {
        this.name = name;
        this.month = month;
        this.year = year;
        this.userId = userId;
        expenses = new ArrayList<>(5);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean addExpense(Expense expense){return expenses.add(expense);}
    public boolean removeExpense(Expense expense){return expenses.remove(expense);}

    @Override
    public String toString() {
        return "MonthlyReport{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", month=" + month +
                ", year=" + year +
                ", expenses=" + expenses +
                ", userId='" + userId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MonthlyReport that = (MonthlyReport) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (month != that.month) return false;
        return userId != null ? userId.equals(that.userId) : that.userId == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (month != null ? month.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
