package com.example.ch08jpaproxy;

import com.example.ch08jpaproxy.cascade.Child;
import com.example.ch08jpaproxy.cascade.Parent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Ch08JpaProxyApplication {

	// 엔티티 매니저 팩토리 - 생성
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.example.ch08jpaproxy");
	// 엔티티 매니저 - 생성
	EntityManager em = emf.createEntityManager();
	// 트랜잭션 - 획특
	EntityTransaction tx = em.getTransaction();
/*
	public static void main(String[] args) {

		// 엔티티 매니저 팩토리 - 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.example.ch08jpaproxy");
		// 엔티티 매니저 - 생성
		EntityManager em = emf.createEntityManager();
		// 트랜잭션 - 획특
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			logic(em);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}

	private static void logic(EntityManager em) {}
*/

	public void printUserAndTeam(String memberId) {

		Member member = em.find(Member.class, memberId);
		Team team = member.getTeam();
		System.out.print("회원 이름: " + member.getUsername());
		System.out.print("소속 팀: " + member.getUsername());
	}

	public void printUser(String memberId) {

		Member member = em.find(Member.class, memberId);
		System.out.print("회원 이름: " + member.getUsername());
	}

	public void eagerLoaing() {
		Member member = em.find(Member.class, "member1");
		Team team = member.getTeam();
	}

	public void lazyLoaing() {
		Member member = em.find(Member.class, "member1");
		Team team = member.getTeam(); // 프록시 객체
		team.getName(); // 팀 객체 실제 사용
	}

	public static void saveNoCascade(EntityManager em) {

		// 부모 저장
		Parent parent = new Parent();
		em.persist(parent);

		// 첫쨰 저장
		Child child1 = new Child();
		child1.setParent(parent); // 연관관계 설정
		parent.getChildren().add(child1); // 연관관계 설정
		em.persist(child1);

		// 둘째 저장
		Child child2 = new Child();
		child2.setParent(parent); // 연관관계 설정
		parent.getChildren().add(child2); // 연관관계 설정
		em.persist(child2);
	}

	public static void saveWithCascade(EntityManager em) {

		Child child1 = new Child();
		Child child2 = new Child();

		Parent parent = new Parent();
		child1.setParent(parent); // 연관관계 설정
		child2.setParent(parent); // 연관관계 설정
		parent.getChildren().add(child1);
		parent.getChildren().add(child2);

		// 부모와 함께 자식들도 저장
		em.persist(parent);
	}

}
