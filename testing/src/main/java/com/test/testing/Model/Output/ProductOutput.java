package com.test.testing.Model.Output;

import com.test.testing.Model.Product;
import com.test.testing.Model.ProductDropDown;
import com.test.testing.Util.StaticVariable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ProductOutput {
    private String id;
    private String SellerId;
    private StaticVariable.prodCat productCategory;
    private String name;
    private String description;
    private String imageURL;
    private Double price;
    private List<ProductDropDown> productDropDowns;
    public ProductOutput (Product product, List<ProductDropDown> productDropDowns, Double price){
        this.id = product.getId();
        this.SellerId = product.getSellerId();
        this.productCategory = product.getProductCategory();
        this.name = product.getName();
        this.description = product.getDescription();
        this.imageURL = product.getImageURL();
        this.price = price;
        this.productDropDowns = productDropDowns;
    }
    public ProductOutput (Product product, ProductDropDown productDropDown, Double price){
        this.id = product.getId();
        this.SellerId = product.getSellerId();
        this.productCategory = product.getProductCategory();
        this.name = product.getName();
        this.description = product.getDescription();
        this.imageURL = product.getImageURL();
        this.price = price;
        this.productDropDowns = new ArrayList<>(){{add(productDropDown);}};
    }
}
