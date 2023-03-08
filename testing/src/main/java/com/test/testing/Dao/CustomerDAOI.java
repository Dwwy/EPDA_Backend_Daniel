package com.test.testing.Dao;

import com.test.testing.Model.Customer;
import com.test.testing.Model.CustomerInput;

import java.util.List;

public interface CustomerDAOI {
    void createCustomer(CustomerInput cust);
    boolean updateCustomer(Customer cust);
    void deleteCustomer(Customer cust);
    List<Customer> getAllCustomers();
    Customer getCustomerbyId(String id);
}
