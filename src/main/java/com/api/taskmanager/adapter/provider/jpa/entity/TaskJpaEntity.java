package com.api.taskmanager.adapter.provider.jpa.entity;

import com.api.taskmanager.entity.types.Status;
import com.api.taskmanager.entity.types.Type;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity(name = "task")
public class TaskJpaEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String description;
  private LocalDateTime createdDate;
  private LocalDateTime deadline;
  private LocalDateTime startDate;
  private LocalDateTime completionDate;
  private Type type;
  private Status status;

  public TaskJpaEntity(String title, String description, LocalDateTime createdDate, LocalDateTime deadline, Type type, Status status) {
    this.title = title;
    this.description = description;
    this.createdDate = createdDate;
    this.deadline = deadline;
    this.type = type;
    this.status = status;
  }


}
