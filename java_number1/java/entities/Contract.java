package entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Contract{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer year;

    @Column
    private String type;

    @Column
    private Double salary;

    @Column
    private Integer team_id;

    @Column
    private Integer user_id;

}

