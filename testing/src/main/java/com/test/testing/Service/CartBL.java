package com.test.testing.Service;

import com.test.testing.Dao.CartDAOI;
import com.test.testing.Dao.Cart_OrderDAOI;
import com.test.testing.Model.Cart;
import com.test.testing.Model.Cart_Order;
import com.test.testing.Model.Input.CartInput;
import com.test.testing.Model.Order;
import com.test.testing.Model.UpdateInput.CartUpdate;
import com.test.testing.Model.UpdateInput.Cart_OrderUpdate;
import com.test.testing.Model.UpdateInput.OrderUpdate;
import com.test.testing.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

public class CartBL implements  CartBLI{
    @Autowired
    CartDAOI cartDAO;
    @Autowired
    Cart_OrderDAOI cartOrderDAO;
    public Response createCart(CartInput input){
        if (cartDAO.createCart(input.toCart())){
            return new Response(true);
        }
        else {
            return new Response(false, "Error occurred while creating cart");
        }
    }
    public Response createCartOrder(Cart_Order input){
        if (cartOrderDAO.createCart_Order(input)){
            return new Response(true);
        }
        else {
            return new Response(false, "Error occurred while creating cart");
        }
    }
    public Response updateCart(CartUpdate input){
        Cart cart = cartDAO.getCartbyId(input.getCartId());
        if (cart == null){
            return new Response(false, "Cart not found");
        }
        else {
            cartDAO.updateCart(input.toCart(cart));
            return new Response(true);
        }
    }
    public Response updateCartOrder(Cart_OrderUpdate input){
        Cart_Order cart = cartOrderDAO.getCart_OrderbyId(input.getCartOrderId());
        if (cart == null){
            return new Response(false, "Cart Order not found");
        }
        else {
            cartOrderDAO.updateCart_Order(input.toCartOrder(cart));
            return new Response(true);
        }
    }
}
