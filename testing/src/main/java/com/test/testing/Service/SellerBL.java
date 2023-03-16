package com.test.testing.Service;

import com.test.testing.Dao.*;
import com.test.testing.Model.GeoLocation;
import com.test.testing.Model.Input.SellerInput;
import com.test.testing.Model.Input.WalletHistoryInput;
import com.test.testing.Model.Output.SellerProfile;
import com.test.testing.Model.Seller;
import com.test.testing.Model.UpdateInput.SellerUpdate;
import com.test.testing.Model.User;
import com.test.testing.Util.ImgUp_Down;
import com.test.testing.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component

public class SellerBL implements SellerBLI {
    @Autowired
    UserDAOI userDAO;
    @Autowired
    GeoLocationDAOI geoLocationDAO;
    @Autowired
    SellerDAOI sellerDAO;
    @Autowired
    UserBLI userBL;
    @Autowired
    WalletHistoryDAOI walletHistoryDAO;
    public Response register(SellerInput input){
        if (userDAO.createUser(input.toUser())){
            User user = userDAO.getUserbyEmail(input.getEmail());
            String url;
            try {
                url = ImgUp_Down.uploadImage(input.getCompanyImage()).get().getResponseData().getImageUrl();
            } catch (IOException e) {
                userDAO.deleteUser(user);
                return new Response(false, "Error occurred while uploading image");
            }
            input.setImageUrl(url);
            input.setUserId(user.getId());
            if (sellerDAO.createSeller(input.toSeller())){
                Seller seller = sellerDAO.getSellerbyUserID(user.getId());
                if (geoLocationDAO.createGeoLocation(input.toGeoLocation())){
                    GeoLocation geoLocation = geoLocationDAO.getAllGeoLocationbyUserId(user.getId()).get(0);
                    return new Response(new SellerProfile(seller,user,geoLocation));
                }
                else {
                    sellerDAO.deleteSeller(seller);
                    userDAO.deleteUser(user);
                    return new Response(false, "Error occurred while creating address");
                }
            }
            else {
                userDAO.deleteUser(user);
                return new Response(false, "Error occurred while creating seller");
            }
        }
        else {
            return new Response(false, "Error occurred while creating user");
        }
    }
    public Response update(SellerUpdate input){
        if (input.getCompanyImage()!= null){
            try {
                String url = ImgUp_Down.uploadImage(input.getCompanyImage()).get().getResponseData().getImageUrl();
                input.setImageUrl(url);
            } catch (IOException e) {
                return new Response(false, "Error occurred while uploading image");
            }
        }
        Seller seller = sellerDAO.getSellerbyId(input.getSellerId());
        if (seller == null){
            return new Response(false, "Customer not found");
        }
        else {
            if (input.getPassword() != null || input.getEmail() != null){
                userBL.update(input.toUserUpdate(seller.getUserId()));
            }
            sellerDAO.updateSeller(input.toSeller(seller));
            return new Response(true);
        }
    }
    public SellerProfile getSellerProfilebySellerId(String sellerId){
        Seller seller = sellerDAO.getSellerbyId(sellerId);
        User user = userDAO.getUserbyId(seller.getUserId());
        List<GeoLocation> geoLocation = geoLocationDAO.getAllGeoLocationbyUserId(user.getId());
        return new SellerProfile(seller,user,geoLocation.get(0));
    }
    public SellerProfile getSellerProfilebyUserId(String id){
        User user = userDAO.getUserbyId(id);
        Seller seller = sellerDAO.getSellerbyUserID(id);
        List<GeoLocation> geoLocation = geoLocationDAO.getAllGeoLocationbyUserId(user.getId());
        return new SellerProfile(seller,user,geoLocation.get(0));
    }
    public Response collectPaymentFromWallet (String sellerId, Double amount) {
        WalletHistoryInput walletHistoryInput = new WalletHistoryInput(amount, sellerId);
        if (walletHistoryDAO.createWalletHistory(walletHistoryInput.toWalletHistory())){
            Seller seller = sellerDAO.getSellerbyId(sellerId);
            if (amount > 0) {
                seller.setWalletBalance(seller.getWalletBalance()+ amount);
            }
            else {
                if (amount > seller.getWalletBalance()){
                    return new Response(false, "Seller is trying to retrieve more than what he has");
                }
                else {
                    seller.setWalletBalance(seller.getWalletBalance() - amount);
                }
            }
            sellerDAO.updateSeller(seller);
            return new Response(true);
        }
        else {
            return new Response(false, "Error occurred while creating wallet history");
        }
    }
}
