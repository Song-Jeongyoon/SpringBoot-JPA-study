package com.springboot.test.data.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.springboot.test.data.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ProductRepositoryTest2 {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void basicCRUDTest() {
        /* create */
        // given
        Product givenProduct = Product.builder()
                .name("슬로건").price(1000).stock(500)
                .build();

        // when
        Product savedProduct = productRepository.save(givenProduct);

        // then
        Assertions.assertThat(savedProduct.getNumber()).isEqualTo(givenProduct.getNumber());
        Assertions.assertThat(savedProduct.getName()).isEqualTo(givenProduct.getName());
        Assertions.assertThat(savedProduct.getPrice()).isEqualTo(givenProduct.getPrice());
        Assertions.assertThat(savedProduct.getStock()).isEqualTo(givenProduct.getStock());

        /* read */
        // when
        Product selectedProduct = productRepository.findById(savedProduct.getNumber())
                .orElseThrow(RuntimeException::new);

        // then
        Assertions.assertThat(savedProduct.getNumber()).isEqualTo(givenProduct.getNumber());
        Assertions.assertThat(savedProduct.getName()).isEqualTo(givenProduct.getName());
        Assertions.assertThat(savedProduct.getPrice()).isEqualTo(givenProduct.getPrice());
        Assertions.assertThat(savedProduct.getStock()).isEqualTo(givenProduct.getStock());

        /* update */
        // when
        Product foundProduct = productRepository.findById(savedProduct.getNumber())
                .orElseThrow(RuntimeException::new);

        foundProduct.setName("종이슬로건");
        Product updatedProduct = productRepository.save(foundProduct);

        // then
        assertEquals(updatedProduct.getName(), "종이슬로건");

        /* delete */
        // when
        productRepository.delete(updatedProduct);

        // then
        assertFalse(productRepository.findById(selectedProduct.getNumber()).isPresent());
    }
}
