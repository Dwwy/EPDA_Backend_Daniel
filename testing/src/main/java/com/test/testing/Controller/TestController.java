package com.test.testing.Controller;

import com.google.zxing.WriterException;
import com.test.testing.Dao.*;
import com.test.testing.Model.*;
import com.test.testing.Model.Input.CustomerInput;
import com.test.testing.Model.Input.GeoLocationInput;
import com.test.testing.Util.Authenticator;
import com.test.testing.Util.ImgUp_Down;
import com.test.testing.Util.StaticVariable;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
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
    @Autowired
    GeoLocationDAOI geoLocationDAOI;
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
        List<GeoLocationInput> addresses = new ArrayList<>();
//        if (userDAO.createUser(cust.toUser())){
//            String id = userDAO.getUserbyEmail("danielwong2612@gmail.com").getId();
//            cust.setUserId(id);
//            customerDAO.createCustomer(cust.toCustomer());
//            for (int i = 0; i<3; i++){
//                GeoLocationInput address = new GeoLocationInput();
//                address.setZipCode("12345");
//                address.setUnit(Integer.toString(i+1));
//                address.setUserId(id);
//                address.setCity("Shah Alam");
//                address.setState("Selangor");
//                address.setCountry("Malaysia");
//                address.setStreet("Jalan Hello");
//                address.setPrimary(false);
//                if (i == 0){
//                    address.setPrimary(true);
//                }
//                addresses.add(address);
//            }
////            addresses.forEach(x->{
////                geoLocationDAOI.createGeoLocation(x.toGeoLocation());
////            });
//        }
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
    @PostMapping("imageUpload")
    public String imageUpload(@RequestBody MultipartFile file){
        try {
            return ImgUp_Down.uploadImage(file).get().getResponseData().getImageUrl();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("test")
    public byte[] test() throws IOException {
//        try {
//            return ImgUp_Down.uploadImage(file).get().getResponseData().getImageUrl();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        String id = userDAO.getUserbyEmail("danielwong2612@gmail.com").getId();
//        return geoLocationDAOI.getAllGeoLocationbyUserId(id);
        File image  = new File("QRCode.png");
        InputStream inputStream = new FileInputStream(image);
        byte[] img = IOUtils.toByteArray(inputStream);
        FileOutputStream output = new FileOutputStream("QRCODE1.png");
        output.write(img);
        output.close();
        return img;
    }
    @GetMapping("test1")
    public byte[] test1(@RequestBody MultipartFile file) throws IOException{
        return file.getBytes();
    }

}
