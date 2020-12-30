package entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String user_type;

    @ManyToMany(mappedBy = "users")
    private Set<MatchEvent> matchEvents;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<Contract> contracts;



}
