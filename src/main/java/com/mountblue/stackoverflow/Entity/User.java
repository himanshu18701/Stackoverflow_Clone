package com.mountblue.stackoverflow.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="skills")
    private String skills;

    @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
    private List<Question> questions;

    @OneToMany(mappedBy="user",cascade= CascadeType.ALL)
    private List<Answer> answers;
}
