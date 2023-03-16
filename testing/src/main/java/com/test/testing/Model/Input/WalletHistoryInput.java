package com.test.testing.Model.Input;

import com.test.testing.Model.WalletHistory;
import lombok.Data;

@Data
public class WalletHistoryInput {
    private Double amount;
    private String sellerId;
    public WalletHistory toWalletHistory (){
        WalletHistory walletHistory = new WalletHistory();
        walletHistory.setAmount(amount);
        walletHistory.setSellerId(sellerId);
        return walletHistory;
    }
    public WalletHistoryInput (Double amount, String sellerId){
        this.amount = amount;
        this.sellerId = sellerId;
    }
}
