package com.test.testing.Model;

import com.test.testing.Util.StaticVariable;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Date;
@Data
public class CustomerInput {
    private String firstName;
    private String lastName;
    private String telNo;
    private StaticVariable.accountType accountType;
    private String email;
    private String password;
    private MultipartFile profile;
    private GeoLocationInput address;
}
