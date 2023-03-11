package com.test.testing.Model.Input;

import com.test.testing.Model.Payment;
import com.test.testing.Util.StaticVariable;
import lombok.Data;

@Data
public class PaymentInput {
    private StaticVariable.Payment_Type paymentType;
    private StaticVariable.Payment_Status status;
    private Double Price;
    private String orderId;
    public Payment toPayment(){
        Payment payment = new Payment();
        payment.setPaymentType(paymentType);
        payment.setStatus(status);
        payment.setPrice(Price);
        payment.setOrderId(orderId);
        return payment;
    }
}
