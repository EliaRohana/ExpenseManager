package com.elia.em.api;

import com.elia.em.model.User;
import com.elia.em.repository.UserRepository;
import com.elia.em.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Elia on 12/8/2016.
 */
@RestController("/api/user")
@CrossOrigin
public class UsersController {

    private final UserRepository userRepository;

    @Autowired
    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/principal")
    public ResponseEntity<User> currentPrincipal(@CurrentUser User currentUser) {
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

    @RequestMapping("/register")
    public ResponseEntity<?> register(User user){
        if(userRepository.findByEmail(user.getEmail()) != null)
            return ResponseEntity.badRequest().body("Email already in use, please choose different username");

        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }




}
