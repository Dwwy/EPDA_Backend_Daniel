package com.test.testing.Model.Input;

import com.test.testing.Model.Customer;
import com.test.testing.Model.GeoLocation;
import com.test.testing.Model.User;
import com.test.testing.Util.StaticVariable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CustomerInput {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String telNo;
    @NotBlank
    private StaticVariable.accountType accountType;
    private String userId;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private MultipartFile profile;
    @NotBlank
    private boolean primary;
    @NotBlank
    private String zipCode;
    @NotBlank
    private String unit;
    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String country;
    private String imageUrl;

    public Customer toCustomer(){
        Customer customer = new Customer();
        customer.setLastName(lastName);
        customer.setFirstName(firstName);
        customer.setTelNo(telNo);
        customer.setImageURL(imageUrl);
        customer.setUserId(userId);
        return customer;
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
        location.setPrimary(primary);
        location.setZipCode(zipCode);
        location.setUserId(userId);
        location.setStreet(street);
        return location;
    }
}
