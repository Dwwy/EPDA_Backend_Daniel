package com.test.testing.Dao;

import com.test.testing.Model.PriceHistory;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PriceHistoryDAO extends GenericDAO<PriceHistory> implements PriceHistoryDAOI{

    private EntityManagerFactory emf;
    @Autowired
    public PriceHistoryDAO(@Qualifier("emf") EntityManagerFactory emf){
        super(emf.createEntityManager(),PriceHistory.class);
    }
    public void createPriceHistory(PriceHistory priceHistory){
        this.create(priceHistory);
    }
    public boolean updatePriceHistory(PriceHistory priceHistory){
        try {
            this.update(priceHistory);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deletePriceHistory(PriceHistory priceHistory){
        this.delete(priceHistory);
    }
    public List<PriceHistory> getAllPriceHistory() {
        return this.findAll();
    }
    public PriceHistory getPriceHistorybyId(String id) {
        return this.findById(id);
    }
//    public List<PriceHistory> getAllPriceHistorybyId (List<String> id) {
//        List<GenericQuery> queries = new ArrayList<>();
//        GenericQuery query = new GenericQuery();
//        query.setWhereColumn("id");
//        query.setValue(id);
//        query.setWhereCondition(GenericQuery.Where.id);
//        queries.add(query);
//        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
//    }


}
