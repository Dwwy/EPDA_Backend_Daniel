package com.test.testing.Dao;

import com.test.testing.Model.Seller;
import com.test.testing.Model.User;

import java.util.List;

public interface SellerDAOI {
    boolean createSeller(Seller seller);
    boolean updateSeller(Seller seller);
    void deleteSeller(Seller seller);
    List<Seller> getAllSeller();
    Seller getSellerbyId(String id);
    Seller getSellerbyUserID(String id);
}
