package com.test.testing.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Table(schema = "User")
@Data
public class Staff {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id;
    private String userId;
    private String firstName;
    private String lastName;
    private String telNo;
    private String imageURL;
    private LocalDateTime lastUpdated ;
    public Staff (){
        lastUpdated = LocalDateTime.now();
    }
}
