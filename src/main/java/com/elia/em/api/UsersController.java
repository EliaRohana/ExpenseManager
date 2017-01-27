package com.elia.em.api;

import com.elia.em.model.User;
import com.elia.em.security.CurrentUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Elia on 12/8/2016.
 */
@RestController
public class UsersController {

    @RequestMapping(value = "/principal")
    public ResponseEntity<User> currentPrincipal(@CurrentUser User currentUser) {
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }


}
