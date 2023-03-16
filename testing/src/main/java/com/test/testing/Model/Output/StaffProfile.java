package com.test.testing.Model.Output;

import com.test.testing.Model.Staff;
import com.test.testing.Model.User;
import lombok.Data;

import java.time.format.DateTimeFormatter;

@Data
public class StaffProfile {
    private String id;
    private String userId;
    private String firstName;
    private String lastName;
    private String telNo;
    private String imageURL;
    private String lastUpdated;
    private String email;
    public StaffProfile (Staff staff, User user){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
        this.id = staff.getId();
        this.userId = staff.getUserId();
        this.firstName = staff.getFirstName();
        this.lastName = staff.getLastName();
        this.telNo = staff.getTelNo();
        this.imageURL = staff.getImageURL();
        this.lastUpdated = formatter.format(staff.getLastUpdated());
        this.email = user.getEmail();
    }
}
