package com.test.testing.Dao;

import com.test.testing.Model.GeoLocation;

import java.util.List;

public interface GeoLocationDAOI {
    boolean createGeoLocation(GeoLocation geoLocation);
    boolean updateGeoLocation(GeoLocation cust);
    void deleteGeoLocation(GeoLocation cust);
    List<GeoLocation> getAllGeoLocation();
    GeoLocation getGeoLocationbyId(String id);
    List<GeoLocation> getAllGeoLocationbyUserId (String id);
}
