package com.api.taskmanager.adapter.entrypoint.model.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class TaskControllerApiError {
  private HttpStatus status;
  private String message;
  private List<String> errors;

  public TaskControllerApiError(HttpStatus status, String message, List<String> errors) {
    super();
    this.status = status;
    this.message = message;
    this.errors = errors;
  }
}
