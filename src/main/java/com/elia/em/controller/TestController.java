package com.elia.em.controller;

import com.elia.em.core.CrudRestController;
import com.elia.em.model.MonthlyReport;

/**
 * Created by Elia on 4/1/2017.
 */
//@CrudController(service = SimpleCrudService.class, path = "/test")
public interface TestController extends CrudRestController<MonthlyReport> {
}
