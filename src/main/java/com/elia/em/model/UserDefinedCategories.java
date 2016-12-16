package com.elia.em.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Elia on 11/20/2016.
 */
@Document(collection = "categories")
public class UserDefinedCategories {

    @Id
    private String id;
    private String name;

    public UserDefinedCategories(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
