package com.test.testing.Model.Input;

import com.test.testing.Model.Staff;
import com.test.testing.Model.User;
import com.test.testing.Util.StaticVariable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class StaffInput {
    private String firstName;
    private String lastName;
    private String telNo;
    private MultipartFile profile;
    private String imageUrl;
    private String email;
    private String password;
    private StaticVariable.accountType accountType = StaticVariable.accountType.Staff;
    private String userId;
    public User toUser(){
        User user = new User();
        user.setEmail(email);
        user.setAccountType(accountType);
        user.setPassword(password);
        return user;
    }
    public Staff toStaff() {
        Staff staff = new Staff();
        staff.setImageURL(imageUrl);
        staff.setUserId(userId);
        staff.setFirstName(firstName);
        staff.setLastName(lastName);
        staff.setTelNo(telNo);
        return staff;
    }
}
