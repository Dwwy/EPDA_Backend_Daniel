package com.test.testing.Model.Output;

import com.test.testing.Model.Cart_Order;
import com.test.testing.Model.Product;
import com.test.testing.Util.StaticVariable;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Cart_OrderOutput {
    private String id;
    private Product product;
    private Double price;
    private String status;
    private String acceptedDate;
    private String estimatedDeliveryDate;
    private String deliveredDate;
    private String lastUpdated;

    public Cart_OrderOutput (Cart_Order input, Product product) {
        this.id = input.getId();
        this.product = product;
        this.price = input.getPrice();
        this.status = input.getStatus().toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
        this.acceptedDate = formatter.format(input.getAcceptedDate());
        this.estimatedDeliveryDate = formatter.format(input.getEstimatedDeliveryDate());
        this.deliveredDate = formatter.format(input.getDeliveredDate());
        this.lastUpdated = formatter.format(input.getLastUpdated());
    }


}
