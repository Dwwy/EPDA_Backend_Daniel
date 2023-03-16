package com.test.testing.Service;

import com.test.testing.Model.Input.ProductInput;
import com.test.testing.Model.Output.ProductOutput;
import com.test.testing.Model.Product;
import com.test.testing.Model.UpdateInput.ProductUpdate;
import com.test.testing.response.Response;

import java.util.List;

public interface ProductBLI {
    Response createProduct(ProductInput input);
    Response searchProduct(String criteria);
    Response updateProduct(ProductUpdate input);
    ProductOutput getFullProduct (Product product);
    List<ProductOutput> getProductBySellerId (String sellerId);
}
