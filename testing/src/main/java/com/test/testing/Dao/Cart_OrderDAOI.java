package com.test.testing.Dao;

import com.test.testing.Model.Cart_Order;

import java.util.List;

public interface Cart_OrderDAOI {
    void createCart_Order(Cart_Order cartOrder);
    boolean updateCart_Order(Cart_Order cartOrder);
    void deleteCart_Order(Cart_Order cartOrder);
    List<Cart_Order> getAllCart_Order();
    Cart_Order getCart_OrderbyId(String id);
}
