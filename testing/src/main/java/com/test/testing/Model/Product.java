package com.test.testing.Model;

import com.test.testing.Util.StaticVariable;
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
public class Product {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id = UUID.randomUUID().toString();
    private String SellerId;
    private StaticVariable.prodCat productCategory;
    private String name;
    private String description;
    private String imageURL;
}
