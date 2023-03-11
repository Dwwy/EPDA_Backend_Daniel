package com.test.testing.Model.Input;

import com.test.testing.Model.ProductDropDown;
import com.test.testing.Util.StaticVariable;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductDropDownInput {
    private String productId;
    private String name;
    private Double weight_g;
    private Double length_cm;
    private Double height_cm;
    private Double width_cm;
    private Double price;
    public ProductDropDown toProductDropDown(){
        ProductDropDown product = new ProductDropDown();
        product.setProductId(productId);
        product.setWeight_g(weight_g);
        product.setName(name);
        product.setLength_cm(length_cm);
        product.setHeight_cm(height_cm);
        product.setWidth_cm(width_cm);
        product.setPrice(price);
        return product;
    }
}
