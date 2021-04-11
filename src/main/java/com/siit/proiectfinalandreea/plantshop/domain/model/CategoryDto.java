package com.siit.proiectfinalandreea.plantshop.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CategoryDto {

    private int id;

    private String categoryName;

}
