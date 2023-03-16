package com.test.testing.Model.UpdateInput;

import com.test.testing.Model.Payment;
import com.test.testing.Util.StaticVariable;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentUpdate {
    private String paymentId;
    private StaticVariable.Payment_Type paymentType;
    private StaticVariable.Payment_Status status;
    private Double Price;
    public Payment toPayment(Payment payment){
        payment.setPaymentType(paymentType);
        payment.setStatus(status);
        payment.setPrice(Price);
        payment.setLastUpdated(LocalDateTime.now());
        return payment;
    }
}
