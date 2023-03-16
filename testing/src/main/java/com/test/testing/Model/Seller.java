package com.test.testing.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(schema = "User")
@Data
public class Seller {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id;
    private String companyName;
    private String contactFName;
    private String contactLName;
    private String companyEmail;
    private String companyNumber;
    private String userId;
    private String imageURL;
    private Double walletBalance;
    private LocalDateTime lastUpdated ;
    public Seller (){
        lastUpdated = LocalDateTime.now();
    }

}
