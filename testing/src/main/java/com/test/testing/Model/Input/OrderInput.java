package com.test.testing.Model.Input;

import com.test.testing.Dao.CartDAOI;
import com.test.testing.Model.Cart;
import com.test.testing.Model.Input.CartInput;
import com.test.testing.Model.Order;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderInput {
    private List<String> cartId;
    private String customerId;
    public Order toOrder(Double freight){
        Order order = new Order();
        order.setCustomerId(customerId);
        order.setFreightCost(freight);
        return order;
    }
    public List<CartInput> toCartOrder(String orderId, CartDAOI cartDAO){
        List<CartInput> input = new ArrayList<>();
        cartId.forEach(x->{
            Cart cart = cartDAO.getCartbyId(x);
            input.add(new CartInput(){{
                setOrderId(orderId);
                setPrice(cart.getPrice());
                setQuantity(cart.getQuantity());
                setUserId(cart.getUserId());
                setProductId(cart.getProductId());
                setCartId(cart.getId());
            }});
        });
        return input;
    }
}
