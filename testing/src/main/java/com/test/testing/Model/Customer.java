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
public class Customer {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id = UUID.randomUUID().toString();
    private String userId;
    private String firstName;
    private String lastName;
    private String telNo;
    private String imageURL;
    private LocalDateTime lastUpdated = LocalDateTime.now();
}
