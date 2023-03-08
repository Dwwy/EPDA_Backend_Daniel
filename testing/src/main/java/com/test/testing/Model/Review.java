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
public class Review {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id = UUID.randomUUID().toString();
    private int score;
    private String title;
    private String description;
    private LocalDateTime creationTime;
    private LocalDateTime lastUpdated = LocalDateTime.now();
}
