package jpabook.model;

import jpabook.model.entity.Item;
import jpabook.model.entity.Member;
import jpabook.model.entity.Order;
import jpabook.model.entity.OrderItem;

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

        // 회원 등록
        Long id = 1234L;
        Member member = new Member();
        member.setId(id);
        member.setName("송정윤");
        em.persist(member);

        // 주문 등록
        Order order = new Order();
        order.setMember(member);
        em.persist(order);

        // 상품 등록
        Item item = new Item();
        item.setName("응원봉");
        item.setId(000L);
        item.setPrice(15000);
        item.setStockQuantity(1);
        em.persist(item);

        // 주문 상품 등록
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrder(order);
        orderItem.setOrderPrice(15000);
        orderItem.setCount(1);
        em.persist(orderItem);

        System.out.println("주문한 회원 이름 : " + order.getMember().getName());
        System.out.println("주문한 상품 이름 : " + order.getOrderItems().get(0).getItem());

    }


}
