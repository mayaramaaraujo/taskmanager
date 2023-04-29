package com.api.taskmanager.entity;

import com.api.taskmanager.entity.types.Status;
import com.api.taskmanager.entity.types.Type;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
  private final String title;
  private final String description;
  private final LocalDateTime createdDate;
  private final LocalDateTime deadline;
  private final LocalDateTime startDate;
  private final LocalDateTime endDate;
  private final Type type;
  private final Status status;

  public Task(String title, String description, LocalDateTime deadline, LocalDateTime startDate, LocalDateTime endDate, Type type, Status status) {
    this.title = title;
    this.description = description;
    this.createdDate = LocalDateTime.now();
    this.deadline = deadline;
    this.startDate = startDate;
    this.endDate = endDate;
    this.type = type;
    this.status = status;
  }

  public boolean isValid() {
    if(title == null || title.isEmpty()) {
      return false;
    }

    if(description == null || description.isEmpty()) {
      return false;
    }

    if(deadline == null) {
      return false;
    }

    if(startDate == null || startDate.isBefore(LocalDateTime.now())) {
      return false;
    }

    if(endDate == null || endDate.isBefore(LocalDateTime.now())) {
      return false;
    }

    if(type == null) {
      return false;
    }

    if(status == null) {
      return false;
    }

    return true;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public LocalDateTime getDeadline() {
    return deadline;
  }

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public LocalDateTime getEndDate() {
    return endDate;
  }

  public Type getType() {
    return type;
  }

  public Status getStatus() {
    return status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Task task = (Task) o;
    return Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(createdDate, task.createdDate) && Objects.equals(deadline, task.deadline) && Objects.equals(startDate, task.startDate) && Objects.equals(endDate, task.endDate) && type == task.type && status == task.status;
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description, createdDate, deadline, startDate, endDate, type, status);
  }

  @Override
  public String toString() {
    return "Task{" +
        "title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", createdDate=" + createdDate +
        ", deadline=" + deadline +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        ", type=" + type +
        ", status=" + status +
        '}';
  }
}
