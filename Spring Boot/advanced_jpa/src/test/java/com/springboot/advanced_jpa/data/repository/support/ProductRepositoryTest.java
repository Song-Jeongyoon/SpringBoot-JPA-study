package com.springboot.advanced_jpa.data.repository.support;

import com.springboot.advanced_jpa.data.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void findByNameTest() {

        Product product1 = new Product();
        product1.setName("응원봉");
        product1.setPrice(10000);
        product1.setStock(500);

        Product product2 = new Product();
        product2.setName("응원봉");
        product2.setPrice(5000);
        product2.setStock(300);

        productRepository.save(product1);
        productRepository.save(product2);

        List<Product> productList = productRepository.findByName("응원봉");

        for(Product product : productList) {
            System.out.println("----------");
            System.out.println(product.getNumber());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println(product.getStock());
            System.out.println("----------");
        }
    }
}
