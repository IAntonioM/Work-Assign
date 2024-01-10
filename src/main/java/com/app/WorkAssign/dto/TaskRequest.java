package com.app.WorkAssign.dto;

import com.app.WorkAssign.persistence.entity.Category;
import com.app.WorkAssign.persistence.entity.User;
import com.app.WorkAssign.persistence.util.PriorityTask;
import com.app.WorkAssign.persistence.util.StatusTask;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class TaskRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private StatusTask status;

    @NotNull
    private PriorityTask priority;

    @NotNull
    private Date deadline;

    @NotNull
    private Long userId;

    @NotNull
    private Long categoryId;

    public TaskRequest() {
    }

    public TaskRequest(String title, String description, StatusTask status, PriorityTask priority, Date deadline, Long userId, Long categoryId) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.deadline = deadline;
        this.userId = userId;
        this.categoryId = categoryId;
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

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
