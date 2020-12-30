package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String city;

    @Column
    private String postalAddress;

    @Column
    private String postalCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Employee employee;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Set<PhoneNumber> phoneNumbers;

    public Address(String city,String postalAddress,String postalCode,Set<PhoneNumber> phoneNumbers,Employee employee) {
        this.city=city;
        this.postalAddress= postalAddress;
        this.postalCode = postalCode;
        setPhoneNumbers(phoneNumbers);
        this.employee=employee;

    }

    public Address() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
