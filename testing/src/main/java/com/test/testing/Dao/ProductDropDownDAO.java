package com.test.testing.Dao;

import com.test.testing.Model.GenericQuery;
import com.test.testing.Model.ProductDropDown;
import com.test.testing.Util.StaticVariable;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDropDownDAO extends GenericDAO<ProductDropDown> implements ProductDropDownDAOI{

    private EntityManagerFactory emf;
    @Autowired
    public ProductDropDownDAO(@Qualifier("emf") EntityManagerFactory emf){
        super(emf.createEntityManager(),ProductDropDown.class);
    }
    public boolean createProductDropDown(ProductDropDown productDropDown){
        try {
            this.create(productDropDown);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean updateProductDropDown(ProductDropDown productDropDown){
        try {
            this.update(productDropDown);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteProductDropDown(ProductDropDown productDropDown){
        this.delete(productDropDown);
    }
    public List<ProductDropDown> getAllProductDropDown() {
        return this.findAll();
    }
    public ProductDropDown getProductDropDownbyId(String id) {
        return this.findById(id);
    }
    public List<ProductDropDown> getAllProductDropDownbyProductId (String productId) {
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("productId");
        query.setValue(productId);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
    }


}
