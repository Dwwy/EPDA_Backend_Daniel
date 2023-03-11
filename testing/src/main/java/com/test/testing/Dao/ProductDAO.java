package com.test.testing.Dao;

import com.test.testing.Model.GenericQuery;
import com.test.testing.Model.Product;
import com.test.testing.Util.StaticVariable;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAO extends GenericDAO<Product> implements ProductDAOI{

    private EntityManagerFactory emf;
    @Autowired
    public ProductDAO(@Qualifier("emf") EntityManagerFactory emf){
        super(emf.createEntityManager(),Product.class);
    }
    public boolean createProduct(Product product){
        try {
            this.create(product);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean updateProduct(Product product){
        try {
            this.update(product);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteProduct(Product product){
        this.delete(product);
    }
    public List<Product> getAllProduct() {
        return this.findAll();
    }
    public Product getProductbyId(String id) {
        return this.findById(id);
    }
//    public List<Product> getAllProductbyId (List<String> id) {
//        List<GenericQuery> queries = new ArrayList<>();
//        GenericQuery query = new GenericQuery();
//        query.setWhereColumn("id");
//        query.setValue(id);
//        query.setWhereCondition(GenericQuery.Where.id);
//        queries.add(query);
//        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
//    }
    public List<Product> searchProductbyName(String name){
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("name");
        query.setValue("%" + name + "%");
        query.setWhereCondition(GenericQuery.Where.like);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
    }


}
