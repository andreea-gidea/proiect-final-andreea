package com.siit.proiectfinalandreea.plantshop.domain.exception;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String msg){
        super(msg);
    }
}
