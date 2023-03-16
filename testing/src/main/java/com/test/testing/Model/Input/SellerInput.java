package com.test.testing.Model.Input;

import com.test.testing.Model.GeoLocation;
import com.test.testing.Model.Input.GeoLocationInput;
import com.test.testing.Model.Seller;
import com.test.testing.Model.User;
import com.test.testing.Util.StaticVariable;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class SellerInput {
    private String companyName;
    private String contactFName;
    private String contactLName;
    private String companyEmail;
    private String companyNumber;
    private String userId;

    private String imageURL;
    private String email;
    private String password;
    private MultipartFile companyImage;
    private String zipCode;
    private String unit;
    private String street;
    private String city;
    private String state;
    private String country;
    private String imageUrl;
    private StaticVariable.accountType accountType = StaticVariable.accountType.Seller;
    public void setImageUrl(String url){
        this.imageUrl = url;
    }
    public Seller toSeller(){
        Seller seller = new Seller();
        seller.setCompanyName(companyName);
        seller.setContactFName(contactFName);
        seller.setContactLName(contactLName);
        seller.setCompanyEmail(companyEmail);
        seller.setCompanyNumber(companyNumber);
        seller.setImageURL(imageUrl);
        seller.setUserId(userId);
        seller.setWalletBalance(0.0);
        return seller;
    }
    public User toUser(){
        User user = new User();
        user.setEmail(email);
        user.setAccountType(accountType);
        user.setPassword(password);
        return user;
    }
    public GeoLocation toGeoLocation(){
        GeoLocation location = new GeoLocation();
        location.setCity(city);
        location.setUnit(unit);
        location.setCountry(country);
        location.setState(state);
        location.setPrimary(true);
        location.setZipCode(zipCode);
        location.setUserId(userId);
        location.setStreet(street);
        return location;
    }
}
