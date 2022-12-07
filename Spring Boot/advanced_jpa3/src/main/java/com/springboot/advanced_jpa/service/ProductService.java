package com.springboot.advanced_jpa3.service;

import com.springboot.advanced_jpa3.data.dto.ProductDto;
import com.springboot.advanced_jpa3.data.dto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}

