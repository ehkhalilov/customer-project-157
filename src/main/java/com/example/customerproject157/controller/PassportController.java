package com.example.customerproject157.controller;


import com.example.customerproject157.model.PassportDto;
import com.example.customerproject157.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/passports")
@RequiredArgsConstructor
public class PassportController {
    private final PassportService passportService;

    @GetMapping
    public List<PassportDto> getPassports() {
        return passportService.getPassports();
    }
}
