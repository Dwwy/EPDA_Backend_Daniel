package com.test.testing.Dao;

import com.test.testing.Model.Customer;
import com.test.testing.Model.CustomerInput;
import com.test.testing.Util.ConfigureDataSource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
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
    public void createCustomer(CustomerInput cust){
        Customer cust1 = new Customer();
        cust1.setTelNo(cust.getTelNo());
        cust1.setFirstName(cust.getFirstName());
        cust1.setLastName(cust.getLastName());
        this.create(cust1);
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

}
