package com.test.testing.Service;

import com.test.testing.Dao.GeoLocationDAOI;
import com.test.testing.Dao.UserDAOI;
import com.test.testing.Model.GeoLocation;
import com.test.testing.Model.Input.GeoLocationInput;
import com.test.testing.Model.UpdateInput.GeoLocationUpdate;
import com.test.testing.Model.UpdateInput.UserUpdate;
import com.test.testing.Model.User;
import com.test.testing.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GeoLocationBL implements GeoLocationBLI {
    @Autowired
    UserDAOI userDAO;
    @Autowired
    GeoLocationDAOI geoLocationDAO;
    public Response createGeolocation (GeoLocationInput input){
        if (geoLocationDAO.createGeoLocation(input.toGeoLocation())){
            return new Response(true);
        }
        else {
            return new Response(false, "Error occurred while creating address");
        }
    }
    public Response update(GeoLocationUpdate input){
        GeoLocation location = geoLocationDAO.getGeoLocationbyId(input.getGeoLocationId());
        if (location == null){
            return new Response(false, "Address not found");
        }
        else {
            geoLocationDAO.updateGeoLocation(input.toGeoLocation(location));
            return new Response(true);
        }
    }
}
