package com.test.testing.Dao;

import com.test.testing.Model.Review;
import com.test.testing.Model.ReviewMessage;

import java.util.List;

public interface ReviewMessageDAOI {
    boolean createReviewMessage(ReviewMessage review);
    boolean updateReviewMessage(ReviewMessage review);
    void deleteReviewMessage(ReviewMessage review);
    List<ReviewMessage> getAllReviewMessage();
    ReviewMessage getReviewMessagebyId(String id);
    List<ReviewMessage> getAllReviewMessagebyReviewId (String reviewId);
}
