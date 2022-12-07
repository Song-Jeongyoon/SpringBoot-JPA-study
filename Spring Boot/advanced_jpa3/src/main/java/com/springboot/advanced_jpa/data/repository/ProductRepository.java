package com.springboot.advanced_jpa3.data.repository;

import com.springboot.advanced_jpa3.data.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> { // 대상 엔티티, @ID의 필드타입

    // find by
    Optional<Product> findByNumber (Long number);
    List<Product> findAllByName(String name);
    Product queryByNumber(Long number);

    // exist by
    boolean existsByNumber(Long number);

    // count by
    long countByName(String name);

    // delete by, remove by
    void deleteByNumber(Long number);
    long removeByName(String name);

    // First<number>, Top<number>
    // 쿼리를 통해 조회된 결과값의 개수를 제한
    List<Product> findFirst5ByName(String name);
    List<Product> findTop10ByName(String name);

    // is
    Product findByNumberIs(Long number);
    Product findByNumberEquals(Long number);

    // is not
    Product findByNumberIsNot(Long number);
    Product findByNumberNot(Long number);

    // null, notnull
    List<Product> findByUpdatedAtNull();
    List<Product> findByUpdatedAtIsNull();
    List<Product> findByUpdatedAtNotNull();
    List<Product> findByUpdatedAtIsNotNull();

    // and, or
    Product findByNumberAndName(Long number,String name);
    Product findByNumberOrName(Long number, String name);

    // greater than, less than, between
    List<Product> findByPriceIsGreaterThan(Long price);
    List<Product> findByPriceGreaterThan(Long price);
    List<Product> findByPriceGreaterThanEqual(Long price);
    List<Product> findByPriceIsLessThan(Long price);
    List<Product> findByPriceLessThan(Long price);
    List<Product> findByPriceLessThanEqual(Long price);
    List<Product> findByPriceIsBetween(Long lowPrice, Long highPrice);
    List<Product> findByPriceBetween(Long lowPrice, Long highPrice);

    // starting with, ending with, containing, like
    List<Product> findByNameLike(String name);
    List<Product> findByNameIsLike(String name);

    List<Product> findByNameContains(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByNameIsContaining(String name);

    List<Product> findByNameStartsWith(String name);
    List<Product> findByNameStartingWith(String name);
    List<Product> findByNameIsStartingWith(String name);

    List<Product> findByNameEndsWith(String name);
    List<Product> findByNameEndingWith(String name);
    List<Product> findByNameIsEndingWith(String name);

    // 정렬
    List<Product> findByNameOrderByNumberAsc(String name);
    List<Product> findByNameOrderByNumberDesc(String name);
    List<Product> findByNameOrderByPriceAscStockDesc(String name);
    List<Product> findByName(String name, Sort sort);

}

