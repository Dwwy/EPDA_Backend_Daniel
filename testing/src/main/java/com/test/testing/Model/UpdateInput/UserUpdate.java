package com.test.testing.Model.UpdateInput;

import com.test.testing.Model.User;
import lombok.Data;

@Data
public class UserUpdate {
    private String userId;
    private String email;
    private String password;

    public User toUser(User user){
        user.setPassword(password);
        user.setEmail(email);
        return user;
    }

}
