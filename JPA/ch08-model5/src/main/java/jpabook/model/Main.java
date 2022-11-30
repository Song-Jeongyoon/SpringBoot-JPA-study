package jpabook.model;

import jpabook.model.entity.item.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            logic(em);
            tx.commit();
        } catch(Exception ex) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void logic(EntityManager em) {

        // 영화 등록
        Movie movie = new Movie();
        movie.setActor("짐 캐리");
        movie.setDirector("팀 버튼");

        System.out.println("영화 배우 : " + movie.getActor());
        System.out.println("영화 감독 : " + movie.getDirector());

    }


}
