package entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;


    @Column
    private Integer city_id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Set<User> users;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Set<Contract> contracts;


    @OneToOne
    @JoinColumn(name = "coach_id")
    private User coach;




}
