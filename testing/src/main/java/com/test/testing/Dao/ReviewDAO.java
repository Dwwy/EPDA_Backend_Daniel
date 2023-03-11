package com.test.testing.Dao;

import com.test.testing.Model.Review;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewDAO extends GenericDAO<Review> implements ReviewDAOI{

    private EntityManagerFactory emf;
    @Autowired
    public ReviewDAO(@Qualifier("emf") EntityManagerFactory emf){
        super(emf.createEntityManager(),Review.class);
    }
    public void createReview(Review review){
        this.create(review);
    }
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
//    public List<Review> getAllReviewbyId (List<String> id) {
//        List<GenericQuery> queries = new ArrayList<>();
//        GenericQuery query = new GenericQuery();
//        query.setWhereColumn("id");
//        query.setValue(id);
//        query.setWhereCondition(GenericQuery.Where.id);
//        queries.add(query);
//        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
//    }


}
