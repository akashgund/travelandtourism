package com.neu.tat.restservice;


import com.neu.tat.data.UserDao;
import com.neu.tat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class RegisterService {

    @Autowired
    private UserDao userDao;

    @GetMapping("/register")
    public String create(User u){
        userDao.save(u);
        int userId = u.getUserId();
        try{
        }catch (Exception ex){
            return "Error creating user";
        }
        return "User created with id: "+userId;
    }
}
