package com.elia.em.service.util;

import java.lang.reflect.Field;

/**
 * Created by Elia on 12/17/2016.
 */
public class DefaultFieldTypeProvider implements FieldTypeProvider{

    private Class type;

    public DefaultFieldTypeProvider(Class type) {
        this.type = type;
    }

    @Override
    public Class getFieldType(String name) {
        try {
            Field field = this.type.getDeclaredField(name);
            field.setAccessible(true);
            return field.getType();
        } catch (NoSuchFieldException e) {
            return String.class;
        }
    }
}
