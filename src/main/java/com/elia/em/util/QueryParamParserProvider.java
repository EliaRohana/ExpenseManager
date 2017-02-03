package com.elia.em.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by Elia on 12/17/2016.
 */
@Component
public class QueryParamParserProvider {
    private static final QueryParamParser<Integer> INT_PARSER = Integer::parseInt;
    private static final QueryParamParser<Double> DOUBLE_PARSER = Double::parseDouble;
    private static final QueryParamParser<String> STRING_PARSER = (x)->x;

    private static final HashMap<Class, QueryParamParser> parsersMap = new HashMap<>() ;

    static {
        parsersMap.put(Integer.class, INT_PARSER);
        parsersMap.put(int.class, INT_PARSER);
        parsersMap.put(Double.class, DOUBLE_PARSER);
        parsersMap.put(double.class, DOUBLE_PARSER);
    }

    public QueryParamParser getParser(Class type){
        return parsersMap.getOrDefault(type, STRING_PARSER);
    }
}

