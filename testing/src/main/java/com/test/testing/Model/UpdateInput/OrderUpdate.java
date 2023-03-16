package com.test.testing.Model.UpdateInput;

import com.test.testing.Model.GeoLocation;
import com.test.testing.Model.Order;
import com.test.testing.Util.StaticVariable;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class OrderUpdate {
    private String orderId;
    private Double freightCost;

    public Order toOrder(Order order){
        order.setFreightCost(freightCost);
        return order;
    }
}
