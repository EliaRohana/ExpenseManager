package com.elia.em.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created by Elia on 11/14/2016.
 */
@Document
public class Expense {

    private String id;
    private int cost;
    private String name;
    private String remarks;
    private String category;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    public Expense() {
    }

    Expense(long id, int cost, String name, String category) {
        this.id = Long.toString(id);
        this.cost = cost;
        this.name = name;
        this.category = category;
        creationDate = LocalDateTime.now();
    }

    Expense(long id, int cost, String name, String category, String remarks) {
        this.id = Long.toString(id);
        this.cost = cost;
        this.name = name;
        this.category = category;
        this.remarks = remarks;
        creationDate = LocalDateTime.now();
    }

    Expense(int cost, String name, String category) {
        this.cost = cost;
        this.name = name;
        this.category = category;
        creationDate = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
        updateDate = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        updateDate = LocalDateTime.now();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
        updateDate = LocalDateTime.now();
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", cost=" + cost +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
