package com.test.testing.Model;

import com.test.testing.Util.StaticVariable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Table(schema = "User")
@Data
public class Cart_Order {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id;
    private String orderId;
    private String cartId;
    private Double price;
    private StaticVariable.orderStat status = StaticVariable.orderStat.Pending;
    private LocalDateTime acceptedDate;
    private LocalDateTime estimatedDeliveryDate;
    private LocalDateTime deliveredDate;
    private LocalDateTime lastUpdated = LocalDateTime.now();
}
