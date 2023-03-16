package com.test.testing.Service;

import com.test.testing.Model.Input.ReviewInput;
import com.test.testing.Model.Input.ReviewMessageInput;
import com.test.testing.Model.UpdateInput.ReviewMessageUpdate;
import com.test.testing.Model.UpdateInput.ReviewUpdate;
import com.test.testing.response.Response;

public interface ReviewBLI {
    Response createReview (ReviewInput input);
    Response updateReview(ReviewUpdate input);
    Response getReviewsByProductId (String productId);
    Response createReviewMessage (ReviewMessageInput input);
    Response updateReviewMessage(ReviewMessageUpdate input);
}
