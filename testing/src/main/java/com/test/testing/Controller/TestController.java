package com.test.testing.Controller;

import com.google.zxing.WriterException;
import com.test.testing.Dao.*;
import com.test.testing.Model.Customer;
import com.test.testing.Model.CustomerInput;
import com.test.testing.Model.User;
import com.test.testing.Util.Authenticator;
import com.test.testing.Util.ImgUp_Down;
import com.test.testing.Util.StaticVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
public class TestController {
/*    @Autowired
    Postgres post;
    @Autowired
    Postgres_JPA postgres_jpa;*/
    @Autowired
    CustomerDAOI customerDAO;
    @Autowired
    UserDAOI userDAO;
    @GetMapping("/get")
    public void Get(String pass) throws GeneralSecurityException {
        if (pass.equals(Authenticator.getTOTPCode(StaticVariable.authenticator_secret()))) {
            System.out.println("Logged in successfully");
        } else {
            System.out.println("Invalid 2FA Code");
        }

    }
    @PostMapping("/post")
    public void Post(String pass) throws GeneralSecurityException, IOException, WriterException {
        String email = "test@gmail.com";
        String companyName = "Awesome Company";
        String barCodeUrl = Authenticator.getGoogleAuthenticatorBarCode(StaticVariable.authenticator_secret(), email, companyName);
        Authenticator.createQRCode(barCodeUrl, "QRCode.png", 400, 400);
    }
    @PostMapping("/init")
    public void initialise(){
        CustomerInput cust = new CustomerInput();
        cust.setFirstName("Daniel");
        cust.setLastName("Wong");
        cust.setTelNo("0183193068");
        cust.setAccountType(StaticVariable.accountType.Customer);
        cust.setPassword("daniel");
        cust.setEmail("danielwong2612@gmail.com");
        customerDAO.createCustomer(cust);
        userDAO.createUser(cust);

    }
    @PostMapping("/update")
    public void update(String id){
        Customer cust = customerDAO.getCustomerbyId(id);
        cust.setFirstName("Mun");
        cust.setLastName("Yen");
        customerDAO.updateCustomer(cust);
    }
    @PostMapping("/delete")
    public void delete(String id){
        Customer cust = customerDAO.getCustomerbyId(id);
        customerDAO.deleteCustomer(cust);
    }
    @GetMapping("/retrieveCustomer")
    public List<Customer> Get(){
        return customerDAO.getAllCustomers();
    }
    @GetMapping("/retrieveUser")
    public List<User> GetUser(){
        List<User> users = userDAO.getAllUser();
        return users;
    }
    @PostMapping("test")
    public String test(@RequestBody MultipartFile file){
        try {
            return ImgUp_Down.uploadImage(file).get().getResponseData().getImageUrl();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
