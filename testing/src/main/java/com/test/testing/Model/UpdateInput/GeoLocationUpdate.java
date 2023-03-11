package com.test.testing.Model.UpdateInput;

import com.test.testing.Model.GeoLocation;
import lombok.Data;

import java.util.UUID;

@Data
public class GeoLocationUpdate {
    private String geoLocationId;
    private boolean primary;
    private String zipCode;
    private String unit;
    private String street;
    private String city;
    private String state;
    private String country;
    public GeoLocation toGeoLocation(GeoLocation location){
        location.setCity(city);
        location.setUnit(unit);
        location.setCountry(country);
        location.setState(state);
        location.setPrimary(primary);
        location.setZipCode(zipCode);
        location.setStreet(street);
        return location;
    }
}
