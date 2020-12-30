package entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String telNumber;

    @Column
    private String mobNumber;

    public PhoneNumber(String telNumber, String mobNumber) {
        this.mobNumber = mobNumber;
        this.telNumber = telNumber;
    }

    public PhoneNumber() {
    }
}
