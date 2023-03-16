package com.test.testing.Model.UpdateInput;

import com.test.testing.Model.Cart;
import lombok.Data;

import java.util.UUID;

@Data
public class CartUpdate {
    private String cartId;
    private int quantity;
    private Double price;
    public Cart toCart(Cart cart){
        cart.setQuantity(quantity);
        cart.setPrice(price *  Double.valueOf(quantity));
        return cart;
    }
}
