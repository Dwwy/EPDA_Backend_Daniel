package com.test.testing.Model.UpdateInput;

import com.test.testing.Model.Staff;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class StaffUpdate {
    private String staffId;
    private String firstName;
    private String lastName;
    private String telNo;
    private String email;
    private String password;
    private MultipartFile profile;
    private String imageUrl;
    public UserUpdate toUserUpdate(String userId){
        UserUpdate input = new UserUpdate();
        input.setPassword(password);
        input.setUserId(userId);
        input.setEmail(email);
        return input;
    }
    public Staff toStaff() {
        Staff staff = new Staff();
        staff.setImageURL(imageUrl);
        staff.setFirstName(firstName);
        staff.setLastName(lastName);
        staff.setTelNo(telNo);
        return staff;
    }
}
