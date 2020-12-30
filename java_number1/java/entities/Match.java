package entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "football_match")
public class  Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer year;

    @Column
    private Date date;

    @Column
    private Integer stadium_id;

    @OneToOne
    @JoinColumn(name = "home_team_id")
    private Team home_team_id;

    @OneToOne
    @JoinColumn(name = "away_team_id")
    private Team away_team_id;


}
