package com.test.testing.Service;

import com.test.testing.Model.Input.PaymentInput;
import com.test.testing.Model.UpdateInput.PaymentUpdate;
import com.test.testing.response.Response;

public interface PaymentBLI {
    Response createPayment(PaymentInput input);
    Response makePayment(PaymentUpdate update);
}
