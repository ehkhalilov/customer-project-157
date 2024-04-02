package com.example.customerproject157.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "customer", url = "http://localhost:8081")
public interface CustomerClient {

    @GetMapping("/main")
    String hello();
}
