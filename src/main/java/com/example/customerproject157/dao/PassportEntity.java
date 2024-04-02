package com.example.customerproject157.dao;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "passport_az")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fin;
    private String serialNumber;
    private LocalDate expireDate;
    @OneToOne(mappedBy = "passport")
    private CustomerEntity customer;
}
