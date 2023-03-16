package com.test.testing.Dao;

import com.test.testing.Model.GenericQuery;
import com.test.testing.Model.User;
import com.test.testing.Model.WalletHistory;
import com.test.testing.Util.StaticVariable;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WalletHistoryDAO extends GenericDAO<WalletHistory> implements WalletHistoryDAOI{

    private EntityManagerFactory emf;
    @Autowired
    public WalletHistoryDAO(@Qualifier("emf") EntityManagerFactory emf){
        super(emf.createEntityManager(),WalletHistory.class);
    }
    public boolean createWalletHistory(WalletHistory walletHistory){
        try {
            this.create(walletHistory);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean updateWalletHistory(WalletHistory walletHistory){
        try {
            this.update(walletHistory);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteWalletHistory(WalletHistory walletHistory){
        this.delete(walletHistory);
    }
    public WalletHistory getWalletHistorybyId(String id) {
        return this.findById(id);
    }
    public List<WalletHistory> getWalletHistorybySellerId(String sellerId){
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("sellerId");
        query.setValue(sellerId);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        List<WalletHistory> output = this.findListByWhereCondition(queries, StaticVariable.Condition.and);
        if (output == null || output.isEmpty()){
            return null;
        }
        else {
            return output;
        }
    }

}
