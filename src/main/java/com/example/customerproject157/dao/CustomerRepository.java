package com.example.customerproject157.dao;

import com.example.customerproject157.model.CustomerLightDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    @Query(value = "select * from customers " +
            "where name = :name order by id desc",
            nativeQuery = true)
    List<CustomerEntity> findAllByName(String name);


    @Query("select new com.example.customerproject157.model.CustomerLightDto(c.surname, c.age) " +
            "from CustomerEntity c where c.name = :name order by c.id desc")
    List<CustomerLightDto> findCustomerSurnamesByName(String name);
}
