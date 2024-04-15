package com.example.customerproject157.service;

import com.example.customerproject157.client.CustomerClient;
import com.example.customerproject157.dao.CustomerRepository;
import com.example.customerproject157.exception.NotFoundException;
import com.example.customerproject157.mapper.CustomerMapper;
import com.example.customerproject157.model.CustomerDto;
import com.example.customerproject157.model.CustomerLightDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final CustomerClient customerClient;

    public List<CustomerDto> getCustomers() {
//        System.out.println(customerClient.hello());

        return customerRepository.findAll()
                .stream().map(customerMapper::mapToDto).toList();
    }


    public List<CustomerLightDto> getCustomerLightList(String name) {
        return customerRepository.findCustomerSurnamesByName(name);
    }

    @Transactional
    public CustomerDto getCustomer(Integer customerId) {
        log.info("ActionLog.getCustomer.start customerId {}", customerId);
        var customerEntity = customerRepository.findById(customerId).orElseThrow(
                () -> {
                    log.error("ActionLog.getCustomer.error customerId {}", customerId);
                    return new NotFoundException("CUSTOMER_NOT_FOUND");
                }

        );
        customerEntity.setAge(50);
        log.info("ActionLog.getCustomer.end customerId {}", customerId);

        return customerMapper.mapToDto(customerEntity);
    }

    public void createCustomer(CustomerDto customer) {
//        if (customer.getPassport().getFin().length() != 7) {
//            throw new ValidationException("FIN_CODE_INVALID");
//        }
        var customerEntity = customerMapper.mapToEntity(customer);
        customerRepository.save(customerEntity);
    }

    public void updateCustomer(Integer customerId, CustomerDto customer) {
        log.info("ActionLog.updateCustomer.start customerId {}", customerId);
        var customerEntity = customerMapper.mapToEntity(customer);
        customer.setId(customerId);
        customerRepository.save(customerEntity);
        log.info("ActionLog.updateCustomer.end customerId {}", customerId);
    }

    public void deleteCustomer(Integer customerId) {
        customerRepository.deleteById(customerId);
    }
}
