package com.example.customerproject157.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Integer id;
    private String name;
    private Double price;
    private Double rating;
    private List<OrderDto> orders;

    @Data
    public static class OrderDto {
        private Integer id;
        private Double price;
        private String productName;
        private ProductType productType;
    }
}
