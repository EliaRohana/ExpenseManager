package com.elia.em.controller;

import com.elia.em.core.CrudController;
import com.elia.em.core.CrudRestController;
import com.elia.em.core.SimpleCrudService;
import com.elia.em.model.MonthlyReport;

/**
 * Created by Elia on 4/1/2017.
 */
@CrudController(service = SimpleCrudService.class)
public interface TestController extends CrudRestController<MonthlyReport> {
}
