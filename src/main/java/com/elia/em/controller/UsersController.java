package com.elia.em.controller;

import com.elia.em.model.User;
import com.elia.em.security.CurrentUser;
import com.elia.em.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Elia on 12/8/2016.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class UsersController {

    private final UserService userService;


    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/principal")
    public ResponseEntity<User> currentPrincipal(@CurrentUser User currentUser) {
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody User user){
        userService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }




}
