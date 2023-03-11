package com.test.testing.Dao;

import com.test.testing.Model.Customer;
import com.test.testing.Model.GenericQuery;
import com.test.testing.Model.Seller;
import com.test.testing.Model.User;
import com.test.testing.Util.StaticVariable;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SellerDAO extends GenericDAO<Seller> implements SellerDAOI{

    private EntityManagerFactory emf;
    @Autowired
    public SellerDAO(@Qualifier("emf") EntityManagerFactory emf){
        super(emf.createEntityManager(),Seller.class);
    }
    public boolean createSeller(Seller seller){
        try {
            this.create(seller);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean updateSeller(Seller seller){
        try {
            this.update(seller);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteSeller(Seller seller){
        this.delete(seller);
    }
    public List<Seller> getAllSeller() {
        return this.findAll();
    }
    public Seller getSellerbyId(String id) {
        return this.findById(id);
    }

    public Seller getSellerbyUserID(String id){
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("userId");
        query.setValue(id);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        List<Seller> output = this.findListByWhereCondition(queries, StaticVariable.Condition.and);
        if (output == null || output.isEmpty()){
            return null;
        }
        else {
            return output.get(0);
        }
    }

}
