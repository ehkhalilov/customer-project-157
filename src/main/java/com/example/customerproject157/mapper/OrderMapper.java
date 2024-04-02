package com.example.customerproject157.mapper;

import com.example.customerproject157.dao.OrderEntity;
import com.example.customerproject157.model.OrderDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {

    public abstract OrderEntity toEntity(OrderDto orderDto);

    public abstract OrderDto toDto(OrderEntity orderEntity);
}
