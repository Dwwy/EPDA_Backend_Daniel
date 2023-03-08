package com.test.testing.Dao;

import com.test.testing.Model.Customer;
import com.test.testing.Model.CustomerInput;
import com.test.testing.Model.GeoLocation;
import com.test.testing.Model.GeoLocationInput;

import java.util.List;

public interface GeoLocationDAOI {
    void createGeoLocation(GeoLocationInput cust, String userID);
    boolean updateGeoLocation(GeoLocation cust);
    void deleteGeoLocation(GeoLocation cust);
    List<GeoLocation> getAllGeoLocation();
    GeoLocation getGeoLocationbyId(String id);
}
