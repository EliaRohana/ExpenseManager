package com.elia.em.util;

/**
 * Created by Elia on 12/17/2016.
 */
@FunctionalInterface
public interface QueryParamParser<Type> {

    Type parse(String value);

}
