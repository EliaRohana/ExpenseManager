package com.elia.em.api;

import com.elia.em.model.Category;
import com.elia.em.model.MonthlyReport;
import com.elia.em.service.MontlyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Elia on 12/2/2016.
 */
@RestController()
@RequestMapping("/monthlyReport")
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
    public MonthlyReport read(@RequestParam String id){
        return service.findById(id);
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

}
