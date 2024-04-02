package com.example.customerproject157.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Integer id;
    private Double price;
    private String productName;
    private ProductType productType;
    private List<ProductDto> products;

    @Data
    public static class ProductDto {
        private Integer id;
        private String name;
        private Double price;
        private Double rating;
    }
}
