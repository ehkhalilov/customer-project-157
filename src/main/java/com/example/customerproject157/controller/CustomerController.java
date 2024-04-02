package com.example.customerproject157.controller;

import com.example.customerproject157.model.CustomerDto;
import com.example.customerproject157.model.CustomerLightDto;
import com.example.customerproject157.model.PostValidation;
import com.example.customerproject157.model.PutValidation;
import com.example.customerproject157.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDto> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/surnames")
    public List<CustomerLightDto> getCustomerLightList(@RequestParam(required = false) String name) {
        return customerService.getCustomerLightList(name);
    }

    @GetMapping("/{customerId}")
    public CustomerDto getCustomer(@PathVariable Integer customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping
    public void createCustomer(@RequestBody @Validated(value = PostValidation.class) CustomerDto customer) {
        customerService.createCustomer(customer);
    }

    @PutMapping("/{customerId}")
    public void updateCustomer(
            @PathVariable Integer customerId,
            @RequestBody @Validated(value = PutValidation.class) CustomerDto customer
    ) {
        customerService.updateCustomer(customerId, customer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerService.deleteCustomer(id);
    }
}
