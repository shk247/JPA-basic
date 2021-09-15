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
//            List<Member> res = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();
            // 객체 지향 모델링
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            //member.changeTeam(team);
//            em.persist(member);
//
//            team.addMember(member);
//
//            em.flush();
//            em.clear();
//
//            Member member1 = em.find(Member.class, member.getId());
//            for (Member member2 : member1.getTeam().getMembers()) {
//                System.out.println("member getUsername = " + member2.getUsername());
//            }

            Member member = new Member();
            member.setUsername("member3");
            em.persist(member);
//
//            Team team = new Team();
//            team.setName("teamA");
//            team.getMembers().add(member);
//
//            Member member2 = new Member();
//            member2.setUsername("member4");
//            em.persist(member2);
//
//            team.getMembers().add(member2);
//
//            em.persist(team);
            ts.commit();
        }catch (Exception e){
            ts.rollback();
        }finally {
            em.close();
        }

        emf.close();

    }
}
