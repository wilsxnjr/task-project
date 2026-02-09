package model.entities;

import model.enums.Status;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task implements Comparable<Task> {

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private Integer id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime dueDate;
    private Status status;

    public Task(Integer id, String title, String description, LocalDateTime createdAt, LocalDateTime dueDate, Status status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.dueDate = dueDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%d, ", id)
                + String.format("%s, ", title)
                + String.format("%s, ", description)
                + String.format("%s, ", fmt.format(createdAt))
                + String.format("%s, ", fmt.format(dueDate))
                + status;
    }

    @Override
    public int compareTo(Task other) {
        return getId().compareTo(other.getId());
    }
}