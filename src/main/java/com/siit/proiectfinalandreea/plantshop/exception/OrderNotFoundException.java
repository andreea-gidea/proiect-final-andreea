package com.siit.proiectfinalandreea.plantshop.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String msg){
        super(msg);
    }
}
