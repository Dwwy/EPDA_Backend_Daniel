package com.test.testing.Dao;

import com.test.testing.Model.Customer;
import com.test.testing.Model.CustomerInput;
import com.test.testing.Model.User;
import com.test.testing.Util.ConfigureDataSource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO extends GenericDAO<User> implements UserDAOI{

    private EntityManagerFactory emf;
    @Autowired
    public UserDAO(@Qualifier("emf") EntityManagerFactory emf){
        super(emf.createEntityManager(),User.class);
    }
    public void createUser(CustomerInput cust){
        User user = new User();
        user.setEmail(cust.getEmail());
        user.setAccountType(cust.getAccountType());
        user.setPassword(cust.getPassword());
        this.create(user);
    }
    public boolean updateUser(User cust){
        try {
            this.update(cust);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteUser(User cust){
        this.delete(cust);
    }
    public List<User> getAllUser() {
        return this.findAll();
    }
    public User getUserbyId(String id) {
        return this.findById(id);
    }

}
