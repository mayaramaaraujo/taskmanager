package com.api.taskmanager.adapter.entrypoint.exception;

import com.api.taskmanager.adapter.entrypoint.TaskController;
import com.api.taskmanager.adapter.entrypoint.model.error.TaskControllerApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
    List<String> errors = ex.getBindingResult()
        .getFieldErrors()
        .stream()
        .map(error -> error.getField() + ": " + error.getDefaultMessage())
        .collect(Collectors.toList());

    TaskControllerApiError apiError = new TaskControllerApiError(HttpStatus.BAD_REQUEST, "Validation error", errors);

    return new ResponseEntity<>(apiError, apiError.getStatus());
  }
}
