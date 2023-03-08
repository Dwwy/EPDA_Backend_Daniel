package com.test.testing.Dao;

import com.test.testing.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

//@Component
public class PostresQL_CRUD implements Postgres {
/*    private JdbcTemplate template;
    @Autowired
    public PostresQL_CRUD (JdbcTemplate jdbcTemplate){
        this.template = jdbcTemplate;
    }*/
    /*public int save (User user){
        return template.update("INSERT INTO \"default\".\"User\" VALUES(?,?)",
                new Object[] { user.getId(),user.getName()});
    }*/
}
