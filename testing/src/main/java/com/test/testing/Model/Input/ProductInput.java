package com.test.testing.Model.Input;

import com.test.testing.Model.Product;
import com.test.testing.Model.ProductDropDown;
import com.test.testing.Util.StaticVariable;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductInput {
    private String SellerId;
    private StaticVariable.prodCat productCategory;
    private String name;
    private String description;
    private String imageURL;
    private MultipartFile productImg;
    private String subCategory_name;
    private Double weight_g;
    private Double length_cm;
    private Double height_cm;
    private Double width_cm;
    private Double price;
    public Product toProduct(){
        Product product = new Product();
        product.setSellerId(SellerId);
        product.setProductCategory(productCategory);
        product.setName(name);
        product.setImageURL(imageURL);
        product.setDescription(description);
        return product;
    }
    public ProductDropDownInput toProductDropDownInput(String productId){
        ProductDropDownInput input = new ProductDropDownInput();
        input.setProductId(productId);
        input.setWeight_g(weight_g);
        input.setHeight_cm(height_cm);
        input.setWidth_cm(width_cm);
        input.setLength_cm(length_cm);
        input.setName(subCategory_name);
        input.setPrice(price);
        return input;
    }
}
