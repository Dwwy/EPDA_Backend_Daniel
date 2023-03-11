package com.test.testing.Service;

import com.test.testing.Dao.ProductDAOI;
import com.test.testing.Dao.ProductDropDownDAOI;
import com.test.testing.Dao.SellerDAOI;
import com.test.testing.Model.Input.ProductDropDownInput;
import com.test.testing.Model.ProductDropDown;
import com.test.testing.Model.UpdateInput.ProductDropDownUpdate;
import com.test.testing.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductDropDownBL implements ProductDropDownBLI{
    @Autowired
    SellerDAOI sellerDAO;
    @Autowired
    ProductDAOI productDAO;
    @Autowired
    ProductDropDownDAOI productDropDownDAO;
    public Response createProductDropDown(ProductDropDownInput input){
        if (productDropDownDAO.createProductDropDown(input.toProductDropDown())){
            return new Response(true);
        }
        else {
            return new Response(false, "Error occurred while creating product subcategory");
        }
    }

    public List<ProductDropDown> getProductDropDownbyProductId (String productId){
        return productDropDownDAO.getAllProductDropDownbyProductId(productId);
    }
    public Response update(ProductDropDownUpdate input){
        ProductDropDown productDropDown = productDropDownDAO.getProductDropDownbyId(input.getProductDropDownId());
        if (productDropDown == null){
            return new Response(false, "Address not found");
        }
        else {
            productDropDownDAO.updateProductDropDown(input.toProductDropDown(productDropDown));
            return new Response(true);
        }
    }

}
