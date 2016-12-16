package com.elia.em.repository;

import com.elia.em.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Elia on 11/14/2016.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query(fields = "{'expenseList' : 1}")
    List<User> getUserById(String userId);
}
