package com.springboot.advanced_jpa.data.repository;

import com.springboot.advanced_jpa.data.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import java.time.LocalDateTime;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void sortingAndPagingTest() {
        Product product1 = new Product();
        product1.setName("응원봉");
        product1.setPrice(10000);
        product1.setStock(500);
        product1.setCreatedAt(LocalDateTime.now());
        product1.setUpdatedAt(LocalDateTime.now());

        Product product2 = new Product();
        product2.setName("응원봉");
        product2.setPrice(5000);
        product2.setStock(300);
        product2.setCreatedAt(LocalDateTime.now());
        product2.setUpdatedAt(LocalDateTime.now());

        Product product3 = new Product();
        product3.setName("응원봉");
        product3.setPrice(3000);
        product3.setStock(100);
        product3.setCreatedAt(LocalDateTime.now());
        product3.setUpdatedAt(LocalDateTime.now());

        Product product4 = new Product();
        product4.setName("슬로건");
        product4.setPrice(1000);
        product4.setStock(500);
        product4.setCreatedAt(LocalDateTime.now());
        product4.setUpdatedAt(LocalDateTime.now());

        Product savedProduct1 = productRepository.save(product1);
        Product savedProduct2 = productRepository.save(product2);
        Product savedProduct3 = productRepository.save(product3);
        Product savedProduct4 = productRepository.save(product4);

        // sort
        productRepository.findByName("응원봉", Sort.by(Order.asc("price")));
        productRepository.findByName("응원봉", Sort.by(Order.asc("price"), Order.desc("stock")));

        // paging
        Page<Product> productPage = productRepository.findByName("응원봉", PageRequest.of(0, 2));
        System.out.println("productPage = " + productPage);
        System.out.println("productPage.getContent() = " + productPage.getContent()); // 배열 형태로 출력

        // @Query
        System.out.println(productRepository.findByNameParam("슬로건"));
    }

}
