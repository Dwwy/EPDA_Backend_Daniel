package com.test.testing.Model;

import lombok.Data;

@Data
public class GenericQuery {
    private String whereColumn;
    private Where whereCondition;
    private Object value;
    private Object value2; //optional
    private type type; //optional
    public enum type {
        timestamp,
        integer
    }
    public enum Where{
        id,
        like, //only string
        between, //type enum
        equal,
        greaterOrEqual, //type enum
        lesserOrEqual //type enum
    }

}
