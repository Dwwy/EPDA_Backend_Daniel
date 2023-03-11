package com.test.testing.Model.Output;

import com.test.testing.Model.Customer;
import com.test.testing.Model.GeoLocation;
import com.test.testing.Model.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Data
public class CustomerProfile {
    private String id;
    private String userId;
    private String firstName;
    private String lastName;
    private String telNo;
    private String imageURL;
    private LocalDateTime lastUpdated;
    private List<GeoLocation> geoLocation;
    private String email;
    public CustomerProfile (User user, Customer customer,GeoLocation geoLocation){
        this.id = customer.getId();
        this.userId = customer.getUserId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.telNo = customer.getTelNo();
        this.imageURL = customer.getImageURL();
        this.lastUpdated = customer.getLastUpdated();
        this.geoLocation = new ArrayList<>(){{add(geoLocation);}};
        this.email = user.getEmail();
    }
    public CustomerProfile (User user, Customer customer,List<GeoLocation> geoLocation){
        this.id = customer.getId();
        this.userId = customer.getUserId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.telNo = customer.getTelNo();
        this.imageURL = customer.getImageURL();
        this.lastUpdated = customer.getLastUpdated();
        this.geoLocation = geoLocation;
        this.email = user.getEmail();
    }

}
