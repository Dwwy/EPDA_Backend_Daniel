package com.test.testing.Model;

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
public class PriceHistory {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id = UUID.randomUUID().toString();
    private String productDropDownId;
    private LocalDateTime creationDate = LocalDateTime.now();
    private Double price;
    private boolean isActive;
}
