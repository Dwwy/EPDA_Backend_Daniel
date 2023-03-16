package com.test.testing.Model.Output;

import com.test.testing.Model.GeoLocation;
import com.test.testing.Model.Seller;
import com.test.testing.Model.User;
import lombok.Data;

import java.time.format.DateTimeFormatter;

@Data
public class SellerProfile {
    private String id;
    private String email;
    private String companyName;
    private String contactFName;
    private String contactLName;
    private String companyEmail;
    private String companyNumber;
    private String userId;
    private String imageURL;
    private String zipCode;
    private String unit;
    private String street;
    private String city;
    private String state;
    private String country;
    private Double walletBalance;
    private String lastUpdated;
    public SellerProfile (Seller seller, User user, GeoLocation geoLocation){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
        this.id  = seller.getId();
        this.email = user.getEmail();
        this.companyName = seller.getCompanyName();
        this.contactFName = seller.getContactFName();
        this.contactLName = seller.getContactLName();
        this.companyEmail = seller.getCompanyEmail();
        this.companyNumber = seller.getCompanyNumber();
        this.userId = user.getId();
        this.imageURL = seller.getImageURL();
        this.zipCode = geoLocation.getZipCode();
        this.unit = geoLocation.getUnit();
        this.street = geoLocation.getStreet();
        this.city = geoLocation.getCity();
        this.state = geoLocation.getState();
        this.country = geoLocation.getCountry();
        this.walletBalance = seller.getWalletBalance();
    }
}
