package com.test.testing.Dao;

import com.test.testing.Model.Customer;

import java.util.List;

public interface CustomerDAOI {
    boolean createCustomer(Customer cust);
    boolean updateCustomer(Customer cust);
    void deleteCustomer(Customer cust);
    List<Customer> getAllCustomers();
    Customer getCustomerbyId(String id);
    Customer getCustomerbyUserID(String id);
}
