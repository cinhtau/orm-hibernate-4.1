package net.cinhtau.domain;

import javax.persistence.*;

import java.io.Serializable;

@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private Long workHours = 0L;

    @Version
    private Long version;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getVersion() {
        return version;
    }

    public void addHours(final Long hours){
        this.workHours += hours;
    }

    public Long getWorkHours() {
        return this.workHours;
    }
}
