package com.springboot.test.service.impl;

import com.springboot.test.data.dto.ProductDto;
import com.springboot.test.data.dto.ProductResponseDto;
import com.springboot.test.data.entity.Product;
import com.springboot.test.data.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.verify;

public class ProductServiceTest {

    private ProductRepository productRepository = Mockito.mock(ProductRepository.class);
    private ProductServiceImpl productService;

    // 리포지토리 객체 초기화
    @BeforeEach
    public void setUpTest() {
        productService = new ProductServiceImpl(productRepository);
    }

    // 테스트 코드
    @Test
    void getProductTest() {
        // 엔티티 객체 생성
        Product givenProduct = new Product();
        givenProduct.setNumber(123L);
        givenProduct.setName("lightStick");
        givenProduct.setPrice(5000);
        givenProduct.setStock(1234);

        // repository 결과 리턴
        Mockito.when(productRepository.findById(123L)).thenReturn(Optional.of(givenProduct));

        // 동작 테스트
        ProductResponseDto productResponseDto = productService.getProduct(123L);

        // 결과 검증
        Assertions.assertEquals(productResponseDto.getNumber(), givenProduct.getNumber());
        Assertions.assertEquals(productResponseDto.getName(), givenProduct.getName());
        Assertions.assertEquals(productResponseDto.getPrice(), givenProduct.getPrice());
        Assertions.assertEquals(productResponseDto.getStock(), givenProduct.getStock());

        verify(productRepository).findById(123L);
    }

    @Test
    void saveProductTest() {
        Mockito.when(productRepository.save(any(Product.class)))
                .then(returnsFirstArg());

        ProductResponseDto productResponseDto = productService.saveProduct(
                new ProductDto("lightStick", 5000, 1234));

        Assertions.assertEquals(productResponseDto.getName(), "lightStick");
        Assertions.assertEquals(productResponseDto.getPrice(), "5000");
        Assertions.assertEquals(productResponseDto.getStock(), "1234");

        verify(productRepository).save(any());
    }
}
