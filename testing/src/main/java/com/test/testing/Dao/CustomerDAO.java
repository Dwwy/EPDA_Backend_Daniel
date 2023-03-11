package com.test.testing.Dao;

import com.test.testing.Model.Customer;
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
public class CustomerDAO extends GenericDAO<Customer> implements CustomerDAOI{
//    @Inject
//    @PersistenceUnit(unitName = "Postgres_DB")

    private EntityManagerFactory emf;
    @Autowired
    public CustomerDAO (@Qualifier("emf") EntityManagerFactory emf){
        super(emf.createEntityManager(),Customer.class);
    }
    public boolean createCustomer(Customer cust){
        try{
            this.create(cust);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean updateCustomer(Customer cust){
        try {
            this.update(cust);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteCustomer(Customer cust){
        this.delete(cust);
    }
    public List<Customer> getAllCustomers() {
        return this.findAll();
    }
    public Customer getCustomerbyId(String id) {
        return this.findById(id);
    }
    public Customer getCustomerbyUserID(String id){
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("userId");
        query.setValue(id);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        List<Customer> output = this.findListByWhereCondition(queries, StaticVariable.Condition.and);
        if (output == null || output.isEmpty()){
            return null;
        }
        else {
            return output.get(0);
        }    }

}
