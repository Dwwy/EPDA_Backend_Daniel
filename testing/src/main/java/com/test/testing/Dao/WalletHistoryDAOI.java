package com.test.testing.Dao;

import com.test.testing.Model.WalletHistory;

import java.util.List;

public interface WalletHistoryDAOI {
    boolean createWalletHistory(WalletHistory WalletHistory);
    boolean updateWalletHistory(WalletHistory cust);
    void deleteWalletHistory(WalletHistory cust);
    WalletHistory getWalletHistorybyId(String id);
    List<WalletHistory> getWalletHistorybySellerId(String sellerId);
}
