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
public class ReviewMessage {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id ;
    private String reviewId;
    private LocalDateTime lastUpdated = LocalDateTime.now();
    private String userId;
    private String message;
    private boolean updated;
}
