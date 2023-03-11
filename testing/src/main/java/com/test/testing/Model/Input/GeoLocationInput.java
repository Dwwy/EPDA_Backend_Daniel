package com.test.testing.Model.Input;

import com.test.testing.Model.GeoLocation;
import lombok.Data;

@Data
public class GeoLocationInput {
    private boolean primary;
    private String userId;
    private String zipCode;
    private String unit;
    private String street;
    private String city;
    private String state;
    private String country;
    public GeoLocation toGeoLocation(){
        GeoLocation location = new GeoLocation();
        location.setCity(city);
        location.setUnit(unit);
        location.setCountry(country);
        location.setState(state);
        location.setPrimary(primary);
        location.setZipCode(zipCode);
        location.setUserId(userId);
        location.setStreet(street);
        return location;
    }
}
