package com.test.testing.Model.UpdateInput;

import com.test.testing.Model.Review;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewUpdate {
    private String reviewId;
    private int score;
    private String title;
    private String description;

    public Review toReview(Review review){
        review.setScore(score);
        review.setTitle(title);
        review.setDescription(description);
        review.setLastUpdated(LocalDateTime.now());
        return review;
    }
}
