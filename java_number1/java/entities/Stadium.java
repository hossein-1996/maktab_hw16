package entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Stadium {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer city_id;

    @OneToMany
    @JoinColumn(name = "stadium_id")
    private Set<Match> matches;
}
