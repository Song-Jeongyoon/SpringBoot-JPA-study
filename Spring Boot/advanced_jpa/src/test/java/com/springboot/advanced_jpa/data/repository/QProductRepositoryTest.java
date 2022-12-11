package com.springboot.advanced_jpa.data.repository;

import com.querydsl.core.types.Predicate;
import com.springboot.advanced_jpa.data.entity.Product;
import com.springboot.advanced_jpa.data.entity.QProduct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;


@SpringBootTest
public class QProductRepositoryTest {

    @Autowired
    QProductRepository qProductRepository;

    @Test
    public void queryDSLTest1() {

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

        Product savedProduct1 = qProductRepository.save(product1);
        Product savedProduct2 = qProductRepository.save(product2);
        Product savedProduct3 = qProductRepository.save(product3);

        Predicate predicate = QProduct.product.name.containsIgnoreCase("응원봉")
                .and(QProduct.product.price.between(500, 4000));

        Optional<Product> foundProduct = qProductRepository.findOne(predicate);

        if(foundProduct.isPresent()) {
            Product product = foundProduct.get();
            System.out.println(product.getNumber());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println(product.getStock());
        }
    }

    @Test
    public void queryDSLTest2() {
        QProduct qProduct = QProduct.product;

        Iterable<Product> productList = qProductRepository.findAll(
                qProduct.name.contains("응원봉")
                        .and(qProduct.price.between(500,6000))
        );

        for (Product product: productList) {
            System.out.println(product.getNumber());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println(product.getStock());
        }
    }

}
