package com.barbirms.infrastructure.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private int password;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Habit> habits;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password.hashCode();
        this.email = email;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getPassword() {
        return password;
    }

    public List<Habit> getHabits() {
        return habits;
    }

    public String getEmail() {
        return email;
    }
}