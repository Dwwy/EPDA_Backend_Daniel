package com.test.testing.Dao;

import com.test.testing.Model.GenericQuery;
import com.test.testing.Model.Review;
import com.test.testing.Util.StaticVariable;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReviewDAO extends GenericDAO<Review> implements ReviewDAOI{

    private EntityManagerFactory emf;
    @Autowired
    public ReviewDAO(@Qualifier("emf") EntityManagerFactory emf){
        super(emf.createEntityManager(),Review.class);
    }
    public boolean createReview(Review review){
        try{
            this.create(review);
            return true;
        }
        catch (Exception e){
            return false;
        }    }
    public boolean updateReview(Review review){
        try {
            this.update(review);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteReview(Review review){
        this.delete(review);
    }
    public List<Review> getAllReview() {
        return this.findAll();
    }
    public Review getReviewbyId(String id) {
        return this.findById(id);
    }
    public List<Review> getAllReviewbyProductId (String productId) {
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("productId");
        query.setValue(productId);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
    }


}
