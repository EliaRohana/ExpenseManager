package com.elia.em.repository;

import com.elia.em.model.MonthlyReport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Elia on 11/14/2016.
 */
@Repository
public interface MonthlyReportRepository extends MongoRepository<MonthlyReport, String>, MonthlyReportRepositoryCustom {

    MonthlyReport findByYear(int year);


}
