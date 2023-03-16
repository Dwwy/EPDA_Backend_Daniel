package com.test.testing.Model.Input;

import com.test.testing.Model.ReviewMessage;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewMessageInput {
    private String reviewMessageId;
    private String reviewId;
    private LocalDateTime lastUpdated ;
    private String userId;
    private String message;

    public ReviewMessage toReviewMessage (){
        ReviewMessage reviewMessage = new ReviewMessage();
        reviewMessage.setReviewId(reviewId);
        reviewMessage.setMessage(message);
        reviewMessage.setUserId(userId);
        reviewMessage.setUpdated(false);
        return reviewMessage;
    }
}
