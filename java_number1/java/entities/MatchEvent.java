package entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class  MatchEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Boolean isDerby;

    @Column
    private Date date;

    @Column
    private Integer match_id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "mk_user_match", joinColumns = @JoinColumn(name = "match_event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;

}
