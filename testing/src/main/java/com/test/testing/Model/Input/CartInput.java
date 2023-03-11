package com.test.testing.Model.Input;

import com.test.testing.Model.Cart;
import com.test.testing.Model.Cart_Order;
import com.test.testing.Util.StaticVariable;
import lombok.Data;

@Data
public class CartInput {
    private String userId;
    private String orderId;
    private String productId;
    private int quantity;
    private Double price;
    public Cart toCart(){
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setProductId(productId);
        cart.setPrice(price);
        cart.setQuantity(quantity);
        return cart;
    }
    public Cart_Order toCart_Order(String cartId){
        if (orderId == null){
            return null;
        }
        else {
            Cart_Order cartOrder = new Cart_Order();
            cartOrder.setOrderId(orderId);
            cartOrder.setFreightCost(StaticVariable.freightCost);
            cartOrder.setCartId(cartId);
            return cartOrder;
        }
    }
}
