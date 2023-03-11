package com.test.testing.Service;

import com.test.testing.Model.Input.ProductDropDownInput;
import com.test.testing.Model.ProductDropDown;
import com.test.testing.Model.UpdateInput.ProductDropDownUpdate;
import com.test.testing.response.Response;

import java.util.List;

public interface ProductDropDownBLI {
    Response createProductDropDown(ProductDropDownInput input);
    List<ProductDropDown> getProductDropDownbyProductId (String productId);
    Response update(ProductDropDownUpdate input);
}
