package com.test.testing.Dao;

import com.test.testing.Model.CustomerInput;
import com.test.testing.Model.User;

import java.util.List;

public interface UserDAOI {
    void createUser(CustomerInput cust);
    boolean updateUser(User cust);
    void deleteUser(User cust);
    List<User> getAllUser();
    User getUserbyId(String id);
}
