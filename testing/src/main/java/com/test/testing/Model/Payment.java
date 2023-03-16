package com.test.testing.Model;

import com.test.testing.Util.StaticVariable;
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
public class Payment {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id;
    private String orderId;
    private StaticVariable.Payment_Type paymentType;
    private StaticVariable.Payment_Status status;
    private Double Price;
    private LocalDateTime lastUpdated ;
    public Payment (){
        lastUpdated = LocalDateTime.now();
    }
}
