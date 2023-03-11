package com.test.testing.Dao;

import com.test.testing.Model.Payment;

import java.util.List;

public interface PaymentDAOI {
    void createPayment(Payment payment);
    boolean updatePayment(Payment payment);
    void deletePayment(Payment payment);
    List<Payment> getAllPayment();
    Payment getPaymentbyId(String id);
}
