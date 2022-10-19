package com.springboot.test.data.repository;

import com.springboot.test.data.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ProductRepositoryTestByH2 {

    @Autowired
    private ProductRepository productRepository;

    /* 데이터베이스에 값을 저장 */
    @Test
    void saveTest() {
        // given - entity 객체 생성
        Product product = new Product();
        product.setName("lightStick");
        product.setPrice(5000);
        product.setStock(1000);

        // when - 테스트 진행
        Product savedProduct = productRepository.save(product);

        // then - 검증
        Assertions.assertEquals(product.getName(), savedProduct.getName());
        Assertions.assertEquals(product.getPrice(), savedProduct.getPrice());
        Assertions.assertEquals(product.getStock(), savedProduct.getStock());
    }

    /* 데이터 조회 */
    @Test
    void selectTest() {
        //given
        Product product = new Product();
        product.setName("lightStick");
        product.setPrice(5000);
        product.setStock(1000);

        Product savedProduct = productRepository.saveAndFlush(product);

        // when
        Product foundProduct = productRepository.findById(savedProduct.getNumber()).get();

        // then
        Assertions.assertEquals(product.getName(), foundProduct.getName());
        Assertions.assertEquals(product.getPrice(), foundProduct.getPrice());
        Assertions.assertEquals(product.getStock(), foundProduct.getStock());
    }
}
