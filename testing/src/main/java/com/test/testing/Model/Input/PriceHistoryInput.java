package com.test.testing.Model.Input;

import com.test.testing.Model.PriceHistory;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PriceHistoryInput {
    private String productDropDownId;
    private Double price;
    private boolean isActive;
    public PriceHistory toPriceHistory(){
        PriceHistory priceHistory = new PriceHistory();
        priceHistory.setProductDropDownId(productDropDownId);
        priceHistory.setPrice(price);
        priceHistory.setActive(isActive);
        return priceHistory;
    }
}
