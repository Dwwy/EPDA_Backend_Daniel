package com.test.testing.Model.Input;

import com.test.testing.Model.Review;
import com.test.testing.Util.StaticVariable;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ReviewInput {
    private int score;
    private String title;
    private String description;
    public Review toReview(){
        Review review = new Review();
        review.setScore(score);
        review.setDescription(description);
        review.setTitle(title);
        return review;
    }
}
