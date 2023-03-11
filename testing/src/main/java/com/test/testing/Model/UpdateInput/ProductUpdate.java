package com.test.testing.Model.UpdateInput;

import com.test.testing.Model.Product;
import com.test.testing.Util.StaticVariable;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class ProductUpdate {
    private String productId;
    private StaticVariable.prodCat productCategory;
    private String name;
    private String description;
    private String imageURL;
    private MultipartFile productImg;

    public Product toProduct(Product product){
        product.setProductCategory(productCategory);
        product.setDescription(description);
        product.setName(name);
        product.setImageURL(imageURL);
        return product;
    }
}
