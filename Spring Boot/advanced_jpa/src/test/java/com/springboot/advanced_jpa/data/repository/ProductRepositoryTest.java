package com.springboot.advanced_jpa.data.repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import com.querydsl.jpa.impl.JPAQuery;
import com.springboot.advanced_jpa.data.entity.Product;
import com.springboot.advanced_jpa.data.entity.QProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

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


    /* QueryDSL */

    @PersistenceContext
    EntityManager entityManager;

    @Test
    void queryDslTest() {
        JPAQuery<Product> query = new JPAQuery(entityManager);
        QProduct qProduct = QProduct.product;

        List<Product> productList = query
                .from(qProduct)
                .where(qProduct.name.eq("응원봉"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for(Product product : productList) {
            System.out.println("---------------------");
            System.out.println("Product Number : " + product.getNumber());
            System.out.println("Product Name : " + product.getName());
            System.out.println("Product Price : " + product.getPrice());
            System.out.println("Product Stock : " + product.getStock());
            System.out.println("---------------------");
        }

    }

    @Test
    void queryDstlTest2() {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QProduct qProduct = QProduct.product;

        List<Product> productList = jpaQueryFactory.selectFrom(qProduct)
                .where(qProduct.name.eq("응원봉"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (Product product : productList) {
            System.out.println("---------------------");
            System.out.println("Product Number : " + product.getNumber());
            System.out.println("Product Name : " + product.getName());
            System.out.println("Product Price : " + product.getPrice());
            System.out.println("Product Stock : " + product.getStock());
            System.out.println("---------------------");
        }
    }

    @Test
    void queryDslTest3() {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QProduct qProduct = QProduct.product;

        List<String> productList = jpaQueryFactory
                .select(qProduct.name)
                .from(qProduct)
                .orderBy(qProduct.price.asc())
                .fetch();

        for (String product : productList) {
            System.out.println("---------------------");
            System.out.println("Product Name : " + product);
            System.out.println("---------------------");
        }

        List<Tuple> tupleList = jpaQueryFactory
                .select(qProduct.name, qProduct.price)
                .from(qProduct)
                .where(qProduct.name.eq("응원봉"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (Tuple product : tupleList) {
            System.out.println("---------------------");
            System.out.println("Product Name : " + product.get(qProduct.name));
            System.out.println("Product Name : " + product.get(qProduct.price));
            System.out.println("---------------------");
        }
    }

    // JPAQueryFactory Bean 활용
    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Test
    void queryDslTest4() {
        QProduct qProduct = QProduct.product;

        List<String> productList = jpaQueryFactory
                .select(qProduct.name)
                .from(qProduct)
                .where(qProduct.name.eq("웅원봉"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (String product : productList) {
            System.out.println("---------------------");
            System.out.println("Product Name : " + product);
            System.out.println("---------------------");
        }
    }


}
