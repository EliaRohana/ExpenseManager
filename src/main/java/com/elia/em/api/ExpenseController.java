package com.elia.em.api;

import com.elia.em.model.Expense;
import com.elia.em.service.MontlyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Elia on 11/20/2016.
 */
@RestController()
@RequestMapping("/api/expense/{reportId}")
public class ExpenseController {

    private MontlyReportService service;

    @Autowired
    public ExpenseController(MontlyReportService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@PathVariable String reportId, @RequestBody Expense expense){
        boolean added = service.addExpense(reportId, expense);
        return added ? ResponseEntity.status(HttpStatus.CREATED).build() : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{expenseId}")
    public ResponseEntity<?> update(@PathVariable String reportId,@PathVariable String expenseId, @RequestBody Expense expense){
        boolean added = service.updateExpense(reportId, expenseId, expense);
        return added ? ResponseEntity.status(HttpStatus.CREATED).build() : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{expenseId}")
    public ResponseEntity<?> delete(@PathVariable String reportId,@PathVariable String expenseId){
        boolean delete = service.deleteExpense(reportId, expenseId);
        return ResponseEntity.ok().build();
    }
}
