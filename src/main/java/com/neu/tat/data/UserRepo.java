package com.neu.tat.data;

import com.neu.tat.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email=:email")
    Iterable<User> findUserByEmail(@Param("email") String u);

    @Query("SELECT u FROM User u WHERE u.email=:email AND u.password=:password")
    Iterable<User> findUserByCredentials(@Param("email") String username, @Param("password") String password);
}
