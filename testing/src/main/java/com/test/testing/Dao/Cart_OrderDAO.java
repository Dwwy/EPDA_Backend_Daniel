package com.test.testing.Dao;

import com.test.testing.Model.Cart_Order;
import com.test.testing.Model.GenericQuery;
import com.test.testing.Model.Order;
import com.test.testing.Util.StaticVariable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Cart_OrderDAO extends GenericDAO<Cart_Order> implements Cart_OrderDAOI{

    private EntityManagerFactory emf;
    @Autowired
    public Cart_OrderDAO(@Qualifier("emf") EntityManagerFactory emf){
        super(emf.createEntityManager(),Cart_Order.class);
        this.emf = emf;
    }
    public boolean createCart_Order(Cart_Order cartOrder){
        try{
            this.create(cartOrder);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean updateCart_Order(Cart_Order cartOrder){
        try {
            this.update(cartOrder);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteCart_Order(Cart_Order cartOrder){
        this.delete(cartOrder);
    }
    public List<Cart_Order> getAllCart_Order() {
        return this.findAll();
    }
    public Cart_Order getCart_OrderbyId(String id) {
        return this.findById(id);
    }
    public List<Cart_Order> getAllCartOrderbyOrderId (String orderId) {
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("orderId");
        query.setValue(orderId);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
    }
    public List<Cart_Order> getAllCartOrderbyCartId (String cartId) {
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("cartId");
        query.setValue(cartId);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
    }
    public boolean updateCartOrdersStatus (List<Cart_Order> update, StaticVariable.orderStat status){
        return this.bulkUpdate(update, "status", status);
    }

}
