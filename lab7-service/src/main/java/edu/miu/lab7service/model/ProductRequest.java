package edu.miu.lab7service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {

    private String name;

    private Integer rating;

    private Double price;

    private Integer categoryId;
}
