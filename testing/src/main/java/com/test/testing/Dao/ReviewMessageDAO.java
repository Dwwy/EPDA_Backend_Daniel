package com.test.testing.Dao;

import com.test.testing.Model.GenericQuery;
import com.test.testing.Model.Review;
import com.test.testing.Model.ReviewMessage;
import com.test.testing.Util.StaticVariable;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReviewMessageDAO extends GenericDAO<ReviewMessage> implements ReviewMessageDAOI{

    private EntityManagerFactory emf;
    @Autowired
    public ReviewMessageDAO(@Qualifier("emf") EntityManagerFactory emf){
        super(emf.createEntityManager(), ReviewMessage.class);
    }
    public boolean createReviewMessage(ReviewMessage review){
        try{
            this.create(review);
            return true;
        }
        catch (Exception e){
            return false;
        }    }
    public boolean updateReviewMessage(ReviewMessage review){
        try {
            this.update(review);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteReviewMessage(ReviewMessage review){
        this.delete(review);
    }
    public List<ReviewMessage> getAllReviewMessage() {
        return this.findAll();
    }
    public ReviewMessage getReviewMessagebyId(String id) {
        return this.findById(id);
    }
    public List<ReviewMessage> getAllReviewMessagebyReviewId (String reviewId) {
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("reviewId");
        query.setValue(reviewId);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
    }


}
