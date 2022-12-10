package com.springboot.advanced_jpa.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class QueryDSLConfiguration {

    @PersistenceContext
    EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {

        // JPAQueryFactory 객체를 빈에 등록하여 매번 JPAQueryFactory를 초기화하지 않고 스프링 컨테이너에서 가져다 쓰기
        return new JPAQueryFactory(entityManager);
    }
}
