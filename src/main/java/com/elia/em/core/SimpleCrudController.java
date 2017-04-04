package com.elia.em.core;

import org.springframework.web.bind.annotation.*;

/**
 * Created by Elia on 4/1/2017.
 */
//@Component
public class SimpleCrudController<T> implements CrudRestController<T>{

    protected final CrudService<T> crudService;


    public SimpleCrudController(CrudService<T> crudService) {
        this.crudService = crudService;
    }

    @PostMapping
    public T create(@RequestBody T object){return this.crudService.create(object);}

    @GetMapping
    public T read(@PathVariable long id){return this.crudService.read(id);}

    @DeleteMapping
    public void delete(@PathVariable long id){this.crudService.delete(id);}

    @PutMapping("/{id}")
    public T update(T object){return this.crudService.update(object);}


}
