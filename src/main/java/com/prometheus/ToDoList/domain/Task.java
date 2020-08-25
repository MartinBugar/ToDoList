package com.prometheus.ToDoList.domain;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

public class Task {

    @Nullable
    private Integer id;

    @NonNull
    private Integer userId;

    @NonNull
    private String name;

    @NonNull
    private Integer status;

    @NonNull
    private String category;

    @NonNull
    private String description;

    @NonNull
    private Timestamp createdAt;

    public Task (){}

    public Task(@NonNull Integer userId, @NonNull String name, @NonNull Integer status, @NonNull String category, @NonNull String description, @NonNull Timestamp createdAt) {
        this.userId = userId;
        this.name = name;
        this.status = status;
        this.category = category;
        this.description = description;
        this.createdAt = Timestamp.from(Instant.now());
    }

    @Nullable
    public Integer getId() {
        return id;
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
    }

    @NonNull
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(@NonNull Integer userId) {
        this.userId = userId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public Integer getStatus() {
        return status;
    }

    public void setStatus(@NonNull Integer status) {
        this.status = status;
    }

    @NonNull
    public String getCategory() {
        return category;
    }

    public void setCategory(@NonNull String category) {
        this.category = category;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    @NonNull
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@NonNull Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) &&
                userId.equals(task.userId) &&
                name.equals(task.name) &&
                status.equals(task.status) &&
                category.equals(task.category) &&
                description.equals(task.description) &&
                createdAt.equals(task.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, name, status, category, description, createdAt);
    }
}
