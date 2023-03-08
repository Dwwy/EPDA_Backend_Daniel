package com.test.testing.Service;

import com.test.testing.Dao.CustomerDAOI;
import com.test.testing.Dao.UserDAOI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerBL {
    @Autowired
    CustomerDAOI customerDAOI;
    @Autowired
    UserDAOI userDAOI;
}
