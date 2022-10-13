package com.springboot.test.data.repository;

import com.springboot.test.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> { // 대상 엔티티, @ID의 필드타입
}

