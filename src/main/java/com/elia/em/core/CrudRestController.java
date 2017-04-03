package com.elia.em.core;

import org.springframework.web.bind.annotation.*;

/**
 * Created by Elia on 4/1/2017.
 */

public interface CrudRestController<T> {

    @PostMapping
    T create(@RequestBody T object);

    @GetMapping
    T read(@PathVariable long id);

    @DeleteMapping
    void delete(@PathVariable long id);

    @PutMapping("/{id}")
    T update(T object);
}
