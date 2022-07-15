package ru.kata_3_1_1.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column (name = "name")
    @Pattern(regexp = "[A-Za-z]{3,15}", message = "WARNING!!! Name is too little or too much. Must be from 3 to 15")
    private String name;


    @Column (name = "lastName")
    @Pattern(regexp = "[A-Za-z]{3,15}", message = "WARNING!!! Lastname is too little or too much. Must be from 3 to 15")
    private String lastName;

    @Column (name = "phone")
    @Min(value = 5)
    @Max(value = 11)
    private int phone;

    @Column (name = "email")
    @Pattern(regexp = "([A-z0-9_.-]+)@([A-z0-9_.-]+).([A-z]{2,8})", message = "Enter correct email")
    private String email;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
