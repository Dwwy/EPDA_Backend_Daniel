package com.test.testing.Dao;

import com.test.testing.Model.*;
import com.test.testing.Util.StaticVariable;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GeoLocationDAO extends GenericDAO<GeoLocation> implements GeoLocationDAOI{

    private EntityManagerFactory emf;
    @Autowired
    public GeoLocationDAO(@Qualifier("emf") EntityManagerFactory emf){
        super(emf.createEntityManager(),GeoLocation.class);
    }
    public boolean createGeoLocation(GeoLocation location){
        try{
            this.create(location);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean updateGeoLocation(GeoLocation location){
        try {
            this.update(location);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteGeoLocation(GeoLocation location){
        this.delete(location);
    }
    public List<GeoLocation> getAllGeoLocation() {
        return this.findAll();
    }
    public GeoLocation getGeoLocationbyId(String id) {
        return this.findById(id);
    }
    public List<GeoLocation> getAllGeoLocationbyUserId (String userId) {
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("userId");
        query.setValue(userId);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
    }


}
