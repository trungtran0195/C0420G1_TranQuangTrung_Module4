package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Size(min = 5, max = 45,message = "name not valid")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @Size(min = 5, max = 45,message = "name not valid")
    @Column(name = "last_name")
    private String lastName;

    @Pattern(regexp="(^$|[0-9]{10})" ,message = "phone must have 9 numbers")
    @Column(name = "phone_number")
    private String phone;

    @Min(value = 18, message = "must be older than 18")
    @Column(name = "age")
    private int age;

    @Email
    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(int id, @NotEmpty @Size(min = 5, max = 45) String firstName, @NotEmpty @Size(min = 5, max = 45) String lastName, @Pattern(regexp = "(^$|[0-9]{10})") String phone, @Min(18) int age, @Email String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
