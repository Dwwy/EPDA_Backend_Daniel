package com.test.testing.Dao;

import com.test.testing.Model.User;

import java.util.List;

public interface UserDAOI {
    boolean createUser(User user);
    boolean updateUser(User cust);
    void deleteUser(User cust);
    List<User> getAllUser();
    User getUserbyId(String id);
    User getUserbyEmail(String email);
}
