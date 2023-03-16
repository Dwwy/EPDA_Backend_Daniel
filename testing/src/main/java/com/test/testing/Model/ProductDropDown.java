package com.test.testing.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(schema = "User")
@Data
public class ProductDropDown {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id;
    private String productId;
    private String name;
    private Double weight_g;
    private Double length_cm;
    private Double height_cm;
    private Double width_cm;
    private Double price;
}
