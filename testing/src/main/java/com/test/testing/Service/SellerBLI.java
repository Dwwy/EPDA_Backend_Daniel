package com.test.testing.Service;

import com.test.testing.Model.Input.SellerInput;
import com.test.testing.Model.Output.SellerProfile;
import com.test.testing.Model.UpdateInput.SellerUpdate;
import com.test.testing.response.Response;

public interface SellerBLI {
    Response register(SellerInput input);

    SellerProfile getSellerProfilebySellerId(String sellerId);
    SellerProfile getSellerProfilebyUserId(String id);
    Response update(SellerUpdate input);
}
