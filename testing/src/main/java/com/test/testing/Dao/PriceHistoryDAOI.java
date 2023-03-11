package com.test.testing.Dao;

import com.test.testing.Model.PriceHistory;

import java.util.List;

public interface PriceHistoryDAOI {
    void createPriceHistory(PriceHistory priceHistory);
    boolean updatePriceHistory(PriceHistory priceHistory);
    void deletePriceHistory(PriceHistory priceHistory);
    List<PriceHistory> getAllPriceHistory();
    PriceHistory getPriceHistorybyId(String id);
}
