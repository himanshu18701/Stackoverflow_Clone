package com.mountblue.stackoverflow.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="votes")
    private int votes;

    @ManyToOne
    @JoinColumn(name="user_id",nullable=false)
    private User user;

    @OneToMany(mappedBy="question",cascade=CascadeType.ALL)
    private List<Answer> answers;
}