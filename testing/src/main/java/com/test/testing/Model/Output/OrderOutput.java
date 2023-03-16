package com.test.testing.Model.Output;

import com.test.testing.Model.Cart_Order;
import com.test.testing.Model.Order;
import com.test.testing.Model.Payment;
import com.test.testing.Util.StaticVariable;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
@Data
public class OrderOutput {
    private String orderId;
    public String sellerId;
    private String customerId;
    private String creationDate;
    private Double freightCost;
    private List<Cart_OrderOutput> items;
    private Payment payment;
    public OrderOutput (Order order, Payment payment, List<Cart_OrderOutput> items){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
        this.orderId = order.getId();
        this.customerId = order.getCustomerId();
        this.creationDate = formatter.format(order.getCreationDate());
        this.items = items;
        this.payment = payment;
        this.sellerId = null;
    }
    public OrderOutput (Order order, Payment payment, List<Cart_OrderOutput> items, String sellerId){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
        this.orderId = order.getId();
        this.customerId = order.getCustomerId();
        this.creationDate = formatter.format(order.getCreationDate());
        this.items = items;
        this.payment = payment;
        this.sellerId = sellerId;
    }
}
