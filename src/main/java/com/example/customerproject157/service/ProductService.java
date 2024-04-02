package com.example.customerproject157.service;

import com.example.customerproject157.dao.ProductRepository;
import com.example.customerproject157.exception.NotFoundException;
import com.example.customerproject157.mapper.ProductMapper;
import com.example.customerproject157.model.ProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public void addProduct(ProductDto productDto) {
        log.info("ActionLog.addProduct.start: product {}", productDto);
        var entity = productMapper.toEntity(productDto);
        productRepository.save(entity);
        log.info("ActionLog.addProduct.end: product {}", productDto);
    }

    public ProductDto getProduct(Integer productId) {
        log.info("ActionLog.getProduct.start: productId {}", productId);
        var entity = productRepository.findById(productId).orElseThrow(
                () -> new NotFoundException("PRODUCT_NOT_FOUND")
        );
        var dto = productMapper.toDto(entity);
        log.info("ActionLog.getProduct.end: productId {}", productId);

        return dto;
    }
}
