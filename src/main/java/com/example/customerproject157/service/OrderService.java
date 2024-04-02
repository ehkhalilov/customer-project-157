package com.example.customerproject157.service;

import com.example.customerproject157.dao.CustomerRepository;
import com.example.customerproject157.dao.OrderRepository;
import com.example.customerproject157.dao.ProductRepository;
import com.example.customerproject157.exception.NotFoundException;
import com.example.customerproject157.mapper.OrderMapper;
import com.example.customerproject157.model.OrderDto;
import com.example.customerproject157.model.OrderStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    public void createOrder(OrderDto orderDto, Integer customerId, List<Integer> productIdList) {
        log.info("ActionLog.createOrder.start: customerId {}", customerId);
        var orderEntity = orderMapper.toEntity(orderDto);
        orderEntity.setOrderStatus(OrderStatus.INITIALIZE);
        var customerEntity = customerRepository.findById(customerId).orElseThrow(
                () -> new NotFoundException("CUSTOMER_NOT_FOUND")
        );
        orderEntity.setCustomer(customerEntity);
        var products = productRepository.findAllById(productIdList);
        orderEntity.setProducts(products);
        orderRepository.save(orderEntity);
        log.info("ActionLog.createOrder.end: customerId {}", customerId);
    }

    public OrderDto getOrder(Integer orderId) {
        log.info("ActionLog.getOrder.start: orderId {}", orderId);
        var orderEntity = orderRepository.findById(orderId).orElseThrow(
                () -> new NotFoundException("ORDER_NOT_FOUND")
        );
        var orderDto = orderMapper.toDto(orderEntity);
        log.info("ActionLog.getOrder.end: orderId {}", orderId);

        return orderDto;
    }
}
