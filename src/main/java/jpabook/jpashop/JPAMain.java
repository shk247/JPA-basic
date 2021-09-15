package jpabook.jpashop;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAMain {
    public static void main(String[] args) {
        // 애플리케이션 로딩 시점에 하나만 만들어야함
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 트랜잭션 작업할 때마다 EntityManager 만들어줌. 사용하고 버려야함
        // JPA에서 데이터를 변경하는 모든 작업은 트랜잭션 안에서 작업해야함
        EntityManager em = emf.createEntityManager();

        EntityTransaction ts = em.getTransaction();
        ts.begin();

        try {
            Order order = new Order();
            order.addItem(new OrderItem());
            ts.commit();
        }catch (Exception e){
            ts.rollback();
        }finally {
            em.close();
        }

        emf.close();

    }
}
