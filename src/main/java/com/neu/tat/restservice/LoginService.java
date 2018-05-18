package com.neu.tat.restservice;


import com.neu.tat.data.UserDao;
import com.neu.tat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class LoginService {

   @Autowired
    private UserDao userDao;

    @GetMapping("/login")
    public Iterable<User> findAllUsers(@RequestParam(name = "email", required = false) String email,
                                            @RequestParam(name = "password", required = false) String password) {
        if (email!= null)
            return userDao.findUserByEmail(email);
        return userDao.findUserByCredentials(email ,password);
    }
}
