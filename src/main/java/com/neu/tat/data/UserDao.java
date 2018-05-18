package com.neu.tat.data;

import com.neu.tat.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserDao extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email=:email")
    Iterable<User> findUserByEmail(@Param("email") String email);


    @Query("SELECT u FROM User u WHERE u.email=:email AND u.password=:password")
    Iterable<User> findUserByCredentials(@Param("email") String email, @Param("password") String password);

}