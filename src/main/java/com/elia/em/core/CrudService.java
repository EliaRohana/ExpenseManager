package com.elia.em.core;

/**
 * Created by Elia on 4/1/2017.
 */
public interface CrudService<T> {

    T create(T object);

    T read(long id);

    void delete(long id);

    T update(T object);

}
