package com.elia.em.controller;

import com.elia.em.model.Category;
import com.elia.em.model.MonthlyReport;
import com.elia.em.model.User;
import com.elia.em.security.CurrentUser;
import com.elia.em.service.MontlyReportService;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by Elia on 12/2/2016.
 */
@RestController()
@RequestMapping("/api/monthlyReport")
public class MonthlyReportController {

    private final MontlyReportService service;

    @Autowired
    public MonthlyReportController(MontlyReportService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<MonthlyReport> create(@RequestBody MonthlyReport monthlyReport){
        MonthlyReport createdReport = service.create(monthlyReport);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReport);
    }

    @GetMapping("/all")
    public List<MonthlyReport> readAll(){
        return service.findAll();
    }

    @GetMapping
    public List<MonthlyReport> read(@RequestParam MultiValueMap<String, String> allRequestParams){
        return service.findBy(allRequestParams);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody MonthlyReport monthlyReport){
        MonthlyReport updatedReport = service.update(id, monthlyReport);
        return updatedReport == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(updatedReport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/total")
    public int getTotalExpensesCost(@PathVariable String id, @RequestParam(required = false) Category category){
        return service.getReportTotalCosts(id, category);
    }

    @GetMapping("/totalCategories")
    public List<DBObject> getTotalExpensesForCategories(@CurrentUser User currentUser, @RequestParam(required = false) Optional<Integer> year){
        return service.getTotalExpensesForCategories(currentUser.getId(), year);
    }




}
