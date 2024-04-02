package com.example.customerproject157.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassportDto {
    private String fin;
    private String serialNumber;
    private LocalDate expireDate;
    private CustomerDto customer;

    @Data
    public static class CustomerDto {
        private Integer id;
        private String name;
        private Integer age;
        private String surname;
    }
}
