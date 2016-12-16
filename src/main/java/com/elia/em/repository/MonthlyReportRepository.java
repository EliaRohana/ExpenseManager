package com.elia.em.repository;

import com.elia.em.model.MonthlyReport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Elia on 11/14/2016.
 */
@Repository
public interface MonthlyReportRepository extends MongoRepository<MonthlyReport, String>, MonthlyReportRepositoryCustom {


}
