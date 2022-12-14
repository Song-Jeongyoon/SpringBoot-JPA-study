package jpabook.model;

import jpabook.model.entity.Delivery;
import jpabook.model.entity.Order;
import jpabook.model.entity.OrderItem;
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

        Delivery delivery = new Delivery();
        OrderItem orderItem1 = new OrderItem();
        OrderItem orderItem2 = new OrderItem();

        Order order = new Order();
        order.setDelivery(delivery);
        order.addOrderItem(orderItem1);
        order.addOrderItem(orderItem2);

    }


}
