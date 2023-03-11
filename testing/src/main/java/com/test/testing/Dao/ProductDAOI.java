package com.test.testing.Dao;

import com.test.testing.Model.Product;

import java.util.List;

public interface ProductDAOI {
    boolean createProduct(Product product);
    boolean updateProduct(Product product);
    void deleteProduct(Product product);
    List<Product> getAllProduct();
    Product getProductbyId(String id);
    List<Product> searchProductbyName(String name);
}
