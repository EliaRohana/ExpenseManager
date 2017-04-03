package com.elia.em.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by Elia on 4/1/2017.
 */
@Component
public class CrudControllerBeanFactory implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return null;
    }
}
