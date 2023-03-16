package com.test.testing.Model.UpdateInput;

import com.test.testing.Model.Cart_Order;
import com.test.testing.Util.StaticVariable;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Cart_OrderUpdate {
    private String cartOrderId;
    private LocalDateTime acceptedDate;
    private LocalDateTime estimatedDeliveryDate;
    private LocalDateTime deliveredDate;
    private StaticVariable.orderStat status ;

    public Cart_Order toCartOrder (Cart_Order cart){
        cart.setAcceptedDate(acceptedDate);
        cart.setEstimatedDeliveryDate(estimatedDeliveryDate);
        cart.setDeliveredDate(deliveredDate);
        cart.setStatus(status);
        cart.setLastUpdated(LocalDateTime.now());
        return cart;
    }
}
