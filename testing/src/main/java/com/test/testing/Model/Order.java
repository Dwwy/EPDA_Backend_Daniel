package com.test.testing.Model;

import com.test.testing.Util.StaticVariable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(schema = "User")
@Data
public class Order {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id = UUID.randomUUID().toString();
    private StaticVariable.orderStat status = StaticVariable.orderStat.Pending;
    private LocalDateTime lastUpdated = LocalDateTime.now();
    private LocalDateTime acceptedDate;
    private LocalDateTime estimatedDeliveryDate;
    private LocalDateTime deliveredDate;
}
