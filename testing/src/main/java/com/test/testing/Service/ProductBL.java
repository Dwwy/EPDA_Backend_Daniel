package com.test.testing.Service;

import com.test.testing.Dao.ProductDAOI;
import com.test.testing.Dao.ProductDropDownDAOI;
import com.test.testing.Dao.SellerDAOI;
import com.test.testing.Model.Input.ProductInput;
import com.test.testing.Model.Output.ProductOutput;
import com.test.testing.Model.Product;
import com.test.testing.Model.ProductDropDown;
import com.test.testing.Model.UpdateInput.ProductUpdate;
import com.test.testing.Util.ImgUp_Down;
import com.test.testing.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductBL implements ProductBLI{
    @Autowired
    SellerDAOI sellerDAO;
    @Autowired
    ProductDAOI productDAO;
    @Autowired
    ProductDropDownDAOI productDropDownDAO;
    @Autowired
    ProductDropDownBLI productDropDownBL;
    private static double calculateAverage(List<Double> list) {
        double sum = 0;
        for (double d : list) {
            sum += d;
        }
        return sum / list.size();
    }
    private Double getPrice (Product product) {
        List<ProductDropDown> dropDowns = productDropDownBL.getProductDropDownbyProductId(product.getId());
        return calculateAverage(dropDowns.stream().map(ProductDropDown::getPrice).collect(Collectors.toList()));
    }
    public Response createProduct(ProductInput input){
        Product product = input.toProduct();
        if (productDAO.createProduct(product)){
            try {
                String url = ImgUp_Down.uploadImage(input.getProductImg()).get().getResponseData().getImageUrl();
                input.setImageURL(url);
            } catch (IOException e) {
                productDAO.deleteProduct(product);
                return new Response(false, "Error occurred while uploading image");
            }
            if (productDropDownBL.createProductDropDown(input.toProductDropDownInput(product.getId())).isStatus()){
                return new Response(true);
            }
            else {
                productDAO.deleteProduct(product);
                return new Response(false, "Error occurred while creating product subcategory");
            }
        }
        else {
            return new Response(false, "Error occurred while creating product");
        }
    }
    public ProductOutput getFullProduct (Product product){
        List<ProductDropDown> drop = productDropDownBL.getProductDropDownbyProductId(product.getId());
        ProductOutput output = new ProductOutput(product,drop,getPrice(product));
        return output;
    }
    public List<ProductOutput> getProductBySellerId (String sellerId){
        List<ProductOutput> output = new ArrayList<>();
        List<Product> products = productDAO.searchProductbySellerId(sellerId);
        products.forEach(x->{
            List<ProductDropDown> drop = productDropDownBL.getProductDropDownbyProductId(x.getId());
            ProductOutput productOutput = new ProductOutput(x,drop,getPrice(x));
            output.add(getFullProduct(x));
        });
        return output;
    }
    public Response searchProduct(String criteria){
        List<ProductOutput> output = new ArrayList<>();
        List<Product> products = productDAO.searchProductbyName(criteria);
        products.forEach(x->{
            output.add(getFullProduct(x));
        });
        return new Response(output);
    }
    public Response updateProduct(ProductUpdate input){
        if (input.getProductImg()!= null){
            try {
                String url = ImgUp_Down.uploadImage(input.getProductImg()).get().getResponseData().getImageUrl();
                input.setImageURL(url);
            } catch (IOException e) {
                return new Response(false, "Error occurred while uploading image");
            }
        }
        Product product = productDAO.getProductbyId(input.getProductId());
        if (product == null){
            return new Response(false, "Product not found");
        }
        else {
            productDAO.updateProduct(input.toProduct(product));
            return new Response(true);
        }
    }

}
