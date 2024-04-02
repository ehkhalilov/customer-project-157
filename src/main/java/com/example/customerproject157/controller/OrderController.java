package com.example.customerproject157.controller;

import com.example.customerproject157.model.OrderDto;
import com.example.customerproject157.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public void createOrder(
            @RequestHeader Integer customerId,
            @RequestBody OrderDto orderDto
    ) {
//        orderService.createOrder(orderDto, customerId);
    }

    @GetMapping("/{orderId}")
    public void getOrder(@PathVariable Integer orderId) {
        orderService.getOrder(orderId);
    }
}
