package com.springboot.test.data.repository;

import com.springboot.test.data.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE.NONE)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void save() {
        Product product = new Product();
        product.setName("lightStick");
        product.setPrice(5000);
        product.setStock(1000);

        Product savedProduct = productRepository.save(product);

        Assertions.assertEquals(product.getName(), savedProduct.getName());
        Assertions.assertEquals(product.getPrice(), savedProduct.getPrice());
        Assertions.assertEquals(product.getStock(), savedProduct.getStock());
    }
}
