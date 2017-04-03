package com.elia.em.core;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by Elia on 4/3/2017.
 */
public class CrudRestControllerFactoryBean<T> implements FactoryBean<SimpleCrudController<T>> {
    @Override
    public SimpleCrudController<T> getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
