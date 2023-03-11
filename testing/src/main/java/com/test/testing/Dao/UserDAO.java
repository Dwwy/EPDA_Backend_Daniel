package com.test.testing.Dao;

import com.test.testing.Model.GenericQuery;
import com.test.testing.Model.User;
import com.test.testing.Util.StaticVariable;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO extends GenericDAO<User> implements UserDAOI{

    private EntityManagerFactory emf;
    @Autowired
    public UserDAO(@Qualifier("emf") EntityManagerFactory emf){
        super(emf.createEntityManager(),User.class);
    }
    public boolean createUser(User user){
        try {
            this.create(user);
            return true;
        }
        catch (Exception e){
            return false;
        }
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
    public User getUserbyEmail(String email){
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("email");
        query.setValue(email);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        List<User> output = this.findListByWhereCondition(queries, StaticVariable.Condition.and);
        if (output == null || output.isEmpty()){
            return null;
        }
        else {
            return output.get(0);
        }
    }

}
