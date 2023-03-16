package com.test.testing.Dao;

import com.test.testing.Model.Cart;

import java.util.List;

public interface CartDAOI {
    boolean createCart(Cart cart);
    boolean updateCart(Cart cart);
    void deleteCart(Cart cart);
    List<Cart> getAllCart();
    Cart getCartbyId(String id);
    List<Cart> getAllCartbyProductId (String productId);
}
