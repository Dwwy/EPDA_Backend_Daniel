package com.test.testing.Service;

import com.test.testing.Model.Input.CustomerInput;
import com.test.testing.Model.Output.CustomerProfile;
import com.test.testing.response.Response;

public interface CustomerBLI {
    Response register(CustomerInput input);
    CustomerProfile getCustomerProfilebyCustomerId(String customerId);
    CustomerProfile getCustomerProfilebyUserId(String id);
}
