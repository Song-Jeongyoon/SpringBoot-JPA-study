package com.springboot.advanced_jpa;

import com.springboot.advanced_jpa.data.entity.Product;
import com.springboot.advanced_jpa.data.repository.support.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdvancedJpa3ApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void auditingTest() {
		Product product1 = new Product();
		product1.setName("응원봉");
		product1.setPrice(10000);
		product1.setStock(500);

		Product savedProduct = productRepository.save(product1);

		System.out.println("Product Name: " + savedProduct.getName());
		System.out.println("Product Name: " + savedProduct.getCreatedAt());
	}

}
