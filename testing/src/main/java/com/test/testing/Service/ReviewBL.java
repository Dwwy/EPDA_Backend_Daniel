package com.test.testing.Service;

import com.test.testing.Dao.ReviewDAOI;
import com.test.testing.Dao.ReviewMessageDAOI;
import com.test.testing.Model.GeoLocation;
import com.test.testing.Model.Input.GeoLocationInput;
import com.test.testing.Model.Input.ReviewInput;
import com.test.testing.Model.Input.ReviewMessageInput;
import com.test.testing.Model.Review;
import com.test.testing.Model.ReviewMessage;
import com.test.testing.Model.UpdateInput.GeoLocationUpdate;
import com.test.testing.Model.UpdateInput.ReviewMessageUpdate;
import com.test.testing.Model.UpdateInput.ReviewUpdate;
import com.test.testing.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

public class ReviewBL implements ReviewBLI{
    @Autowired
    ReviewDAOI reviewDAO;
    @Autowired
    ReviewMessageDAOI reviewMessageDAO;
    public Response createReview (ReviewInput input){
        if (reviewDAO.createReview(input.toReview())){
            return new Response(true);
        }
        else {
            return new Response(false, "Error occurred while creating review");
        }
    }
    public Response updateReview(ReviewUpdate input){
        Review review = reviewDAO.getReviewbyId(input.getReviewId());
        if (review == null){
            return new Response(false, "Review not found");
        }
        else {
            reviewDAO.updateReview(input.toReview(review));
            return new Response(true);
        }
    }
    public Response getReviewsByProductId (String productId){
        return new Response(reviewDAO.getAllReviewbyProductId(productId));
    }
    public Response createReviewMessage (ReviewMessageInput input) {
        if (reviewMessageDAO.createReviewMessage(input.toReviewMessage())){
            return new Response(true);
        }
        else {
            return new Response(false, "Error occurred while creating review message");
        }
    }
    public Response updateReviewMessage(ReviewMessageUpdate input){
        ReviewMessage review = reviewMessageDAO.getReviewMessagebyId(input.getReviewMessageId());
        if (review == null){
            return new Response(false, "Review message not found");
        }
        else {
            reviewMessageDAO.updateReviewMessage(input.toReviewMessage(review));
            return new Response(true);
        }
    }
}
