package com.example.customerproject157.mapper;

import com.example.customerproject157.dao.ProductEntity;
import com.example.customerproject157.model.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    public abstract ProductEntity toEntity(ProductDto productDto);

    public abstract ProductDto toDto(ProductEntity productEntity);
}
