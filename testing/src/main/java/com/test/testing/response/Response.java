package com.test.testing.response;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Response {
    private boolean status;
    private String message;
    private Object data;

//    public Response (String id){
//        this.data = new HashMap<>(){{put("result", id);}};
//        this.status = true;
//        this.message = "Successfully executed";
//    }
    public Response (boolean status, String message){
        this.status = status;
        this.message = message;
    }
    public Response (boolean status){
        if (!status){
            this.status = false;
            this.message = "An exception occurred while executing.";
        }
        else {
            this.status = true;
            this.message = "Successfully executed.";
        }
    }
    public Response (Object data){
        this.status = true;
        this.message = "Successfully executed.";
        this.data = data;
    }
    public Response (boolean status, String message, Object data){
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
