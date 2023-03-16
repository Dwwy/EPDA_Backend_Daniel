package com.test.testing.Model.UpdateInput;

import com.test.testing.Model.Review;
import com.test.testing.Model.ReviewMessage;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewMessageUpdate {
    private String reviewMessageId;
    private String message;
    public ReviewMessage toReviewMessage(ReviewMessage review){
        review.setMessage(message);
        review.setLastUpdated(LocalDateTime.now());
        review.setUpdated(true);
        return review;
    }
}
