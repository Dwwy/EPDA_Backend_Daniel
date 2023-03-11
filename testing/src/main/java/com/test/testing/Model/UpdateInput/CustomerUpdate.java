package com.test.testing.Model.UpdateInput;

import com.test.testing.Model.Customer;
import com.test.testing.Model.UpdateInput.UserUpdate;
import com.test.testing.Util.StaticVariable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class CustomerUpdate {
    private String customerId;
    private String firstName;
    private String lastName;
    private String telNo;
    private String email;
    private String password;
    private MultipartFile profile;
    private String imageUrl;
    public Customer toCustomer(Customer customer){
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setTelNo(telNo);
        customer.setImageURL(imageUrl);
        return customer;
    }
    public UserUpdate toUserUpdate(String userId){
        UserUpdate input = new UserUpdate();
        input.setPassword(password);
        input.setUserId(userId);
        input.setEmail(email);
        return input;
    }
}
