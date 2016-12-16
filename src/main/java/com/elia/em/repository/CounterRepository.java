package com.elia.em.repository;

import com.elia.em.model.Counter;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Elia on 12/3/2016.
 */
public interface CounterRepository extends MongoRepository<Counter, String> {
}
