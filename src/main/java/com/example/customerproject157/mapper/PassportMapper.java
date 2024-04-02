package com.example.customerproject157.mapper;

import com.example.customerproject157.dao.PassportEntity;
import com.example.customerproject157.model.PassportDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class PassportMapper {

    public abstract PassportDto mapToDto(PassportEntity passportEntity);
}
