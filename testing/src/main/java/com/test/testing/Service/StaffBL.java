package com.test.testing.Service;

import com.test.testing.Dao.StaffDAOI;
import com.test.testing.Dao.UserDAOI;
import com.test.testing.Model.Customer;
import com.test.testing.Model.GeoLocation;
import com.test.testing.Model.Input.CustomerInput;
import com.test.testing.Model.Input.StaffInput;
import com.test.testing.Model.Output.CustomerProfile;
import com.test.testing.Model.Output.StaffProfile;
import com.test.testing.Model.Staff;
import com.test.testing.Model.User;
import com.test.testing.Util.ImgUp_Down;
import com.test.testing.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class StaffBL implements StaffBLI{
    @Autowired
    StaffDAOI staffDAO;
    @Autowired
    UserDAOI userDAO;
    public Response register(StaffInput input){
        if (userDAO.createUser(input.toUser())){
            User user = userDAO.getUserbyEmail(input.getEmail());
            try {
                String url = ImgUp_Down.uploadImage(input.getProfile()).get().getResponseData().getImageUrl();
                input.setImageUrl(url);
            } catch (IOException e) {
                userDAO.deleteUser(user);
                return new Response(false, "Error occurred while uploading image");
            }
            input.setUserId(user.getId());
            if (staffDAO.createStaff(input.toStaff())){
                Staff staff = staffDAO.getStaffbyUserID(user.getId());
                return new Response(new StaffProfile(staff,user));
            }
            else {
                userDAO.deleteUser(user);
                return new Response(false, "Error occurred while creating staff");
            }
        }
        else {
            return new Response(false, "Error occurred while creating user");
        }
    }
}
