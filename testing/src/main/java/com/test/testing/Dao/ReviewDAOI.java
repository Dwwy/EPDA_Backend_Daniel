package com.test.testing.Dao;

import com.test.testing.Model.Review;

import java.util.List;

public interface ReviewDAOI {
    void createReview(Review review);
    boolean updateReview(Review review);
    void deleteReview(Review review);
    List<Review> getAllReview();
    Review getReviewbyId(String id);
}
