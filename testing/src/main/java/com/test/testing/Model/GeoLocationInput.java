package com.test.testing.Model;

import lombok.Data;

@Data
public class GeoLocationInput {
    private boolean primary;
    private String zipCode;
    private String unit;
    private String street;
    private String city;
    private String state;
    private String country;
}
