package com.test.testing.Model.Input;

import com.test.testing.Model.Review;
import com.test.testing.Util.StaticVariable;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
public class ReviewInput {
    private int score;
    private String title;
    private String description;
    private String productId;
    private String userId;
    public Review toReview(){
        Review review = new Review();
        review.setScore(score);
        review.setDescription(description);
        review.setTitle(title);
        review.setUserId(userId);
        review.setProductId(productId);
        review.setLastUpdated(LocalDateTime.now());
        return review;
    }
}
