package com.test.testing.Dao;

import com.test.testing.Model.Payment;

import java.util.List;

public interface PaymentDAOI {
    boolean createPayment(Payment payment);
    boolean updatePayment(Payment payment);
    void deletePayment(Payment payment);
    List<Payment> getAllPayment();
    Payment getPaymentbyId(String id);
    Payment getPaymentbyOrderId (String orderId);
}
