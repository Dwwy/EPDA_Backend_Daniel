package com.test.testing.Service;

import com.test.testing.Model.Input.LoginInput;
import com.test.testing.Model.UpdateInput.UserUpdate;
import com.test.testing.response.Response;

public interface UserBLI {
    Response getQR2FA (String userId);
    Response authenticate2FACode(String code);
    Response login (LoginInput input);
    Response update(UserUpdate input);
}
