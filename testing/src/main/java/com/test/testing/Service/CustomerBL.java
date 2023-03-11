package com.test.testing.Service;

import com.test.testing.Dao.CustomerDAOI;
import com.test.testing.Dao.GeoLocationDAOI;
import com.test.testing.Dao.UserDAOI;
import com.test.testing.Model.Customer;
import com.test.testing.Model.GeoLocation;
import com.test.testing.Model.Input.CustomerInput;
import com.test.testing.Model.Output.CustomerProfile;
import com.test.testing.Model.UpdateInput.CustomerUpdate;
import com.test.testing.Model.User;
import com.test.testing.Util.ImgUp_Down;
import com.test.testing.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class CustomerBL implements CustomerBLI{
    @Autowired
    CustomerDAOI customerDAO;
    @Autowired
    UserDAOI userDAO;
    @Autowired
    GeoLocationDAOI geoLocationDAO;
    @Autowired
    UserBLI userBL;
    public Response register(CustomerInput input){
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
            if (customerDAO.createCustomer(input.toCustomer())){
                Customer customer = customerDAO.getCustomerbyUserID(user.getId());
                if (geoLocationDAO.createGeoLocation(input.toGeoLocation())){
                    GeoLocation geoLocation = geoLocationDAO.getAllGeoLocationbyUserId(user.getId()).get(0);
                    return new Response(new CustomerProfile(user,customer,geoLocation));
                }
                else {
                    customerDAO.deleteCustomer(customer);
                    userDAO.deleteUser(user);
                    return new Response(false, "Error occurred while creating address");
                }
            }
            else {
                userDAO.deleteUser(user);
                return new Response(false, "Error occurred while creating customer");
            }
        }
        else {
            return new Response(false, "Error occurred while creating user");
        }
    }
    public Response update(CustomerUpdate input){
        if (input.getProfile()!= null){
            try {
                String url = ImgUp_Down.uploadImage(input.getProfile()).get().getResponseData().getImageUrl();
                input.setImageUrl(url);
            } catch (IOException e) {
                return new Response(false, "Error occurred while uploading image");
            }
        }
        Customer customer = customerDAO.getCustomerbyId(input.getCustomerId());
        if (customer == null){
            return new Response(false, "Customer not found");
        }
        else {
            if (input.getPassword() != null || input.getEmail() != null){
                userBL.update(input.toUserUpdate(customer.getUserId()));
            }
            customerDAO.updateCustomer(input.toCustomer(customer));
            return new Response(true);
        }
    }
    public CustomerProfile getCustomerProfilebyCustomerId(String customerId){
        Customer customer = customerDAO.getCustomerbyId(customerId);
        User user = userDAO.getUserbyId(customer.getUserId());
        List<GeoLocation> geoLocation = geoLocationDAO.getAllGeoLocationbyUserId(user.getId());
        return new CustomerProfile(user,customer,geoLocation);
    }
    public CustomerProfile getCustomerProfilebyUserId(String id){
        User user = userDAO.getUserbyId(id);
        Customer customer = customerDAO.getCustomerbyUserID(id);
        List<GeoLocation> geoLocation = geoLocationDAO.getAllGeoLocationbyUserId(user.getId());
        return new CustomerProfile(user,customer,geoLocation);
    }
}
