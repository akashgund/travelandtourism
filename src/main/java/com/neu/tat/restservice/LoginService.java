package com.neu.tat.restservice;


import com.neu.tat.data.UserRepo;
import com.neu.tat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class LoginService {

   @Autowired
    private UserRepo userRepository;

    @GetMapping("/login")
    public Iterable<User> findAllUsers(@RequestParam(name = "email", required = false) String email,
                                            @RequestParam(name = "password", required = false) String password) {
        if (email!= null)
            return userRepository.findUserByEmail(email);
        return userRepository.findUserByCredentials(email ,password);


    }
}
