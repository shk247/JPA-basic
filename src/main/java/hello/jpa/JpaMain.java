package hello.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        // 애플리케이션 로딩 시점에 하나만 만들어야함
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 트랜잭션 작업할 때마다 EntityManager 만들어줌. 사용하고 버려야함
        // JPA에서 데이터를 변경하는 모든 작업은 트랜잭션 안에서 작업해야함
        EntityManager em = emf.createEntityManager();

        EntityTransaction ts = em.getTransaction();
        ts.begin();

        try {
            // 회원 추가
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("helloB");
//            em.persist(member);
//            ts.commit();

            // 회원 수정
//            Member findmember = em.find(Member.class, 1L);
//            findmember.setName("HelloJPA");
//            ts.commit();

            // 전체 회원 조회
            // JPA는 객체를 대상으로 쿼리함
            List<Member> res = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(10)
                    .getResultList();
            for (Member re : res) {
                System.out.println("re.getName() = " + re.getName());
            }
        }catch (Exception e){
            ts.rollback();
        }finally {
            em.close();
        }

        emf.close();

    }
}
