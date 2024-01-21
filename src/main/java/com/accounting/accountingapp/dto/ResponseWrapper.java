package com.accounting.accountingapp.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

public class ResponseWrapper {
    private boolean success;
    private String message;
    private Integer code;
    private Object data;


    public ResponseWrapper(String message, Object data){
        this.message=message;
        this.data=data;
        this.code= HttpStatus.OK.value();
        this.success=true;
    }

    //for delete
    public ResponseWrapper(String message){
        this.message=message;
        this.code= HttpStatus.OK.value();
        this.success=true;
    }
}
