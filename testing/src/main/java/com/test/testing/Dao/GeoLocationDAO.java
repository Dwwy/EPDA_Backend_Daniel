package com.test.testing.Dao;

import com.test.testing.Model.Customer;
import com.test.testing.Model.CustomerInput;
import com.test.testing.Model.GeoLocation;
import com.test.testing.Model.GeoLocationInput;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GeoLocationDAO extends GenericDAO<GeoLocation> implements GeoLocationDAOI{

    private EntityManagerFactory emf;
    @Autowired
    public GeoLocationDAO(@Qualifier("emf") EntityManagerFactory emf){
        super(emf.createEntityManager(),GeoLocation.class);
    }
    public void createGeoLocation(GeoLocationInput location, String userID){
        GeoLocation location1 = new GeoLocation();
        location1.setCity(location.getCity());
        location1.setUnit(location.getUnit());
        location1.setCountry(location.getCountry());
        location1.setState(location.getState());
        location1.setPrimary(location.isPrimary());
        location1.setZipCode(location.getZipCode());
        location1.setUserId(userID);
        location1.setStreet(location1.getStreet());
        this.create(location1);
    }
    public boolean updateGeoLocation(GeoLocation location){
        try {
            this.update(location);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteGeoLocation(GeoLocation location){
        this.delete(location);
    }
    public List<GeoLocation> getAllGeoLocation() {
        return this.findAll();
    }
    public GeoLocation getGeoLocationbyId(String id) {
        return this.findById(id);
    }

}
