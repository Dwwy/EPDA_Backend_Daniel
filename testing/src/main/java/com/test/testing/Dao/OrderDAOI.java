package com.test.testing.Dao;

import com.test.testing.Model.GeoLocation;
import com.test.testing.Model.Order;

import java.util.List;

public interface OrderDAOI {
    boolean createOrder(Order order);
    boolean updateOrder(Order cust);
    void deleteOrder(Order cust);
    List<Order> getAllOrder();
    Order getOrderbyId(String id);
    List<Order> getAllOrderbyCustomerId (String customerId);
}
