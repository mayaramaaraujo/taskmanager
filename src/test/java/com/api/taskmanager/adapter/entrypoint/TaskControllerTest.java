package com.api.taskmanager.adapter.entrypoint;

import com.api.taskmanager.adapter.entrypoint.model.request.NewTaskControllerRequestModel;
import com.api.taskmanager.usecase.NewTaskUseCase;
import com.api.taskmanager.usecase.model.request.NewTaskRequestModel;
import com.api.taskmanager.usecase.model.response.NewTaskResponseModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskControllerTest {

  @Mock
  NewTaskUseCase newTaskUseCase;

  @InjectMocks
  TaskController taskController;

  @Test
  public void given_ValidRequest_shouldReturnSuccess() {
    when(newTaskUseCase.execute(any(NewTaskRequestModel.class))).thenReturn(new NewTaskResponseModel(true, null));
    ResponseEntity<Object> response = taskController.add(new NewTaskControllerRequestModel("title", "description", "urgent"));
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  @Test
  public void given_InvalidRequest_shouldReturnError() {
    when(newTaskUseCase.execute(any(NewTaskRequestModel.class))).thenReturn(new NewTaskResponseModel(false, "error"));
    ResponseEntity<Object> response = taskController.add(new NewTaskControllerRequestModel("title", "description", "urgent"));
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }
}
