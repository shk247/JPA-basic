package hello.jpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
//@Table(name="USER")
public class Member extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "MEMEBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


//    // 로직 들어가면 set 말고 다른 함수명으로 지정하는게 좋다
//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }
}
