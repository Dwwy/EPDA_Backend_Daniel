package com.test.testing.Dao;

import com.test.testing.Model.Cart_Order;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Cart_OrderDAO extends GenericDAO<Cart_Order> implements Cart_OrderDAOI{

    private EntityManagerFactory emf;
    @Autowired
    public Cart_OrderDAO(@Qualifier("emf") EntityManagerFactory emf){
        super(emf.createEntityManager(),Cart_Order.class);
    }
    public void createCart_Order(Cart_Order cartOrder){
        this.create(cartOrder);
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

}
