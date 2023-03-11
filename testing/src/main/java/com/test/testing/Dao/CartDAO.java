package com.test.testing.Dao;

import com.test.testing.Model.Cart;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDAO extends GenericDAO<Cart> implements CartDAOI{

    private EntityManagerFactory emf;
    @Autowired
    public CartDAO(@Qualifier("emf") EntityManagerFactory emf){
        super(emf.createEntityManager(),Cart.class);
    }
    public void createCart(Cart cart){
        this.create(cart);
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

}
