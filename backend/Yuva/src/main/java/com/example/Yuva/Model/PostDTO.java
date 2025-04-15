package com.example.Yuva.Model;

import java.time.LocalDateTime;

public class PostDTO {

    private Long pid;
    private String title;
    private String about;
    private String username;
    private Long likeCount;  // Number of likes
    private LocalDateTime createdAt;  // Timestamp

    // Constructor with 5 arguments (for full post data including timestamp)
    public PostDTO(Long pid, String title, String about, String username, LocalDateTime createdAt) {
        this.pid = pid;
        this.title = title;
        this.about = about;
        this.username = username;
        this.createdAt = createdAt;
    }

    // Constructor with 4 arguments (without createdAt)
    public PostDTO(Long pid, String title, String about, String username) {
        this.pid = pid;
        this.title = title;
        this.about = about;
        this.username = username;
    }

    // Constructor with 5 arguments (including likeCount)
    public PostDTO(Long pid, String title, String about, String username, Long likeCount) {
        this.pid = pid;
        this.title = title;
        this.about = about;
        this.username = username;
        this.likeCount = likeCount;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
