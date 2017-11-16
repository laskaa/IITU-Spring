package com.spring.dao;

import javax.persistence.*;

/**
 * Created by arman 04.11.17.
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "active")
    private boolean isActive;

//    @ManyToOne
//    @JoinColumn(name = "role_id")
//    private Long role_id;
//
//    @ManyToOne
//    @JoinColumn(name = "company_id")
//    private Long company_id;

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public User() {
    }

    public User(String login, String password, String firstName, String surname) {

        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.isActive = true;

    }
}
