package com.test.testing.Model.Input;

import com.test.testing.Model.Cart;
import com.test.testing.Model.Input.CartInput;
import com.test.testing.Model.Order;
import lombok.Data;

import java.util.List;

@Data
public class OrderInput {
    private List<CartInput> carts;
    public Order toOrder(){
        Order order = new Order();
        return order;
    }
}
