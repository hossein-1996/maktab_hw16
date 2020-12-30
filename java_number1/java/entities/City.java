package entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private Set<Team> teams;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private Set<Stadium> stadiums;

}

