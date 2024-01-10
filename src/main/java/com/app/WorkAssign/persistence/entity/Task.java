package com.app.WorkAssign.persistence.entity;

import com.app.WorkAssign.persistence.util.PriorityTask;
import com.app.WorkAssign.persistence.util.StatusTask;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @Enumerated(EnumType.STRING)
    @NotNull
    private StatusTask status;

    @Enumerated(EnumType.STRING)
    @NotNull
    private PriorityTask priority;

    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Column(name="deadline")
    private Date deadline;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public Task() {
    }

    public Task(Long id, String title, String description, StatusTask status, PriorityTask priority, Date createdAt, Date deadline, User user, Category category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.createdAt = createdAt;
        this.deadline = deadline;
        this.user = user;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusTask getStatus() {
        return status;
    }

    public void setStatus(StatusTask status) {
        this.status = status;
    }

    public PriorityTask getPriority() {
        return priority;
    }

    public void setPriority(PriorityTask priority) {
        this.priority = priority;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
