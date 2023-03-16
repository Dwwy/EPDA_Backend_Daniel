package com.test.testing.Dao;

import com.test.testing.Model.Cart;
import com.test.testing.Model.Cart_Order;
import com.test.testing.Model.GenericQuery;
import com.test.testing.Util.StaticVariable;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CartDAO extends GenericDAO<Cart> implements CartDAOI{

    private EntityManagerFactory emf;
    @Autowired
    public CartDAO(@Qualifier("emf") EntityManagerFactory emf){
        super(emf.createEntityManager(),Cart.class);
    }
    public boolean createCart(Cart cart){
        try{
            this.create(cart);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean updateCart(Cart cart){
        try {
            this.update(cart);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteCart(Cart cart){
        this.delete(cart);
    }
    public List<Cart> getAllCart() {
        return this.findAll();
    }
    public Cart getCartbyId(String id) {
        return this.findById(id);
    }
    public List<Cart> getAllCartbyProductId (String productId) {
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("productId");
        query.setValue(productId);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
    }

}
