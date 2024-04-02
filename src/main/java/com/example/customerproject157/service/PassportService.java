package com.example.customerproject157.service;

import com.example.customerproject157.dao.PassportEntity;
import com.example.customerproject157.dao.PassportRepository;
import com.example.customerproject157.mapper.PassportMapper;
import com.example.customerproject157.model.PassportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassportService {
    private final PassportRepository passportRepository;
    private final PassportMapper passportMapper;

    public List<PassportDto> getPassports() {
        var passports = (List<PassportEntity>) passportRepository.findAll();
        return passports.stream().map(passportMapper::mapToDto).toList();
    }
}
