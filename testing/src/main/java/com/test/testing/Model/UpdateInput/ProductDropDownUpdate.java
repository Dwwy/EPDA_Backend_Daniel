package com.test.testing.Model.UpdateInput;

import com.test.testing.Model.ProductDropDown;
import lombok.Data;

@Data
public class ProductDropDownUpdate {
    private String productDropDownId;
    private String name;
    private Double weight_g;
    private Double length_cm;
    private Double height_cm;
    private Double width_cm;
    private Double price;
    public ProductDropDown toProductDropDown(ProductDropDown product){
        product.setWeight_g(weight_g);
        product.setName(name);
        product.setLength_cm(length_cm);
        product.setHeight_cm(height_cm);
        product.setWidth_cm(width_cm);
        product.setPrice(price);
        return product;
    }
}
