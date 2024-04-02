package com.example.customerproject157.scheduler;

import com.example.customerproject157.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@RequiredArgsConstructor
public class SchedulerConfig {
    private final CustomerService customerService;

    //    @Scheduled(cron = "*****")
    public void task() {
        var customers = customerService.getCustomers();
        log.info("customers {}", customers);
    }
}
