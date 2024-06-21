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

    public Question() {
    }

    public Question(int id, String title, String content, LocalDateTime createdAt, int votes, User user, List<Answer> answers) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.votes = votes;
        this.user = user;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}