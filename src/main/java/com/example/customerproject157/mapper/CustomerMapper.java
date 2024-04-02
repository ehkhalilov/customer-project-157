package com.example.customerproject157.mapper;

import com.example.customerproject157.dao.CustomerEntity;
import com.example.customerproject157.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper {

    public abstract CustomerDto mapToDto(CustomerEntity customerEntity);

    public abstract CustomerEntity mapToEntity(CustomerDto customerDto);
}
