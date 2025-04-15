package com.example.Yuva.Model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDateTime; // Add LocalDateTime for timestamp

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    private String title;
    private String about;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userid")
    private Users users;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Like> likes = new HashSet<>();

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;  // Add createdAt field

    // Default constructor
    public Post() {}

    // Constructor for easy initialization
    public Post(String title, String about, Users users) {
        this.title = title;
        this.about = about;
        this.users = users;
        this.createdAt = LocalDateTime.now();  // Set createdAt to current time
    }

    // Getters and Setters
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Set<Like> getLikes() {
        return likes;
    }

    public void setLikes(Set<Like> likes) {
        this.likes = likes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
