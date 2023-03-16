package com.test.testing.Model.UpdateInput;

import com.test.testing.Model.GeoLocation;
import com.test.testing.Model.Seller;
import com.test.testing.Model.User;
import com.test.testing.Util.StaticVariable;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
public class SellerUpdate {
    private String sellerId;
    private String companyName;
    private String contactFName;
    private String contactLName;
    private String companyEmail;
    private String companyNumber;

    private String imageURL;
    private String email;
    private String password;
    private MultipartFile companyImage;
    private String imageUrl;
    public void setImageUrl(String url){
        this.imageUrl = url;
    }
    public Seller toSeller(Seller seller){
        seller.setCompanyName(companyName);
        seller.setContactFName(contactFName);
        seller.setContactLName(contactLName);
        seller.setCompanyEmail(companyEmail);
        seller.setCompanyNumber(companyNumber);
        seller.setImageURL(imageUrl);
        seller.setLastUpdated(LocalDateTime.now());
        return seller;
    }
    public UserUpdate toUserUpdate(String userId){
        UserUpdate input = new UserUpdate();
        input.setPassword(password);
        input.setUserId(userId);
        input.setEmail(email);
        return input;
    }
}
