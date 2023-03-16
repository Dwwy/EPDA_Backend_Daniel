package com.test.testing.Dao;

import com.test.testing.Model.GenericQuery;
import com.test.testing.Model.GeoLocation;
import com.test.testing.Model.Order;
import com.test.testing.Util.StaticVariable;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDAO extends GenericDAO<Order> implements OrderDAOI{

    private EntityManagerFactory emf;
    @Autowired
    public OrderDAO(@Qualifier("emf") EntityManagerFactory emf){
        super(emf.createEntityManager(),Order.class);
    }
    public boolean createOrder(Order order){
        try{
            this.create(order);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean updateOrder(Order order){
        try {
            this.update(order);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteOrder(Order order){
        this.delete(order);
    }
    public List<Order> getAllOrder() {
        return this.findAll();
    }
    public Order getOrderbyId(String id) {
        return this.findById(id);
    }
    public List<Order> getAllOrderbyCustomerId (String customerId) {
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("customerId");
        query.setValue(customerId);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
    }


}
