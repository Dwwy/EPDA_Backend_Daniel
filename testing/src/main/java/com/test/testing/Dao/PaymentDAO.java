package com.test.testing.Dao;

import com.test.testing.Model.GenericQuery;
import com.test.testing.Model.Payment;
import com.test.testing.Util.StaticVariable;
import com.test.testing.response.Response;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentDAO extends GenericDAO<Payment> implements PaymentDAOI{

    private EntityManagerFactory emf;
    @Autowired
    public PaymentDAO(@Qualifier("emf") EntityManagerFactory emf){
        super(emf.createEntityManager(),Payment.class);
    }
    public boolean createPayment(Payment payment){
        try {
            this.create(payment);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean updatePayment(Payment payment){
        try {
            this.update(payment);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deletePayment(Payment payment){
        this.delete(payment);
    }
    public List<Payment> getAllPayment() {
        return this.findAll();
    }
    public Payment getPaymentbyId(String id) {
        return this.findById(id);
    }
    public Payment getPaymentbyOrderId (String orderId) {
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("orderId");
        query.setValue(orderId);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and).get(0);
    }


}
