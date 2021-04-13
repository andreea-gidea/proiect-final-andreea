package com.siit.proiectfinalandreea.plantshop.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {

    private int id;

    private String categoryName;

}
