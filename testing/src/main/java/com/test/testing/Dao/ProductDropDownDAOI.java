package com.test.testing.Dao;

import com.test.testing.Model.ProductDropDown;

import java.util.List;

public interface ProductDropDownDAOI {
    boolean createProductDropDown(ProductDropDown productDropDown);
    boolean updateProductDropDown(ProductDropDown productDropDown);
    void deleteProductDropDown(ProductDropDown productDropDown);
    List<ProductDropDown> getAllProductDropDown();
    ProductDropDown getProductDropDownbyId(String id);
    List<ProductDropDown> getAllProductDropDownbyProductId (String productId);
}
