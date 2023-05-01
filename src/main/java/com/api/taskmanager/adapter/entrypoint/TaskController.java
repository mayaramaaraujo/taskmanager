package com.api.taskmanager.adapter.entrypoint;

import com.api.taskmanager.adapter.entrypoint.model.request.NewTaskControllerRequestModel;
import com.api.taskmanager.usecase.NewTaskUseCase;
import com.api.taskmanager.usecase.model.request.NewTaskRequestModel;
import com.api.taskmanager.usecase.model.response.NewTaskResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/task-manager")
public class TaskController {

  private final NewTaskUseCase newTaskUseCase;

  public TaskController(NewTaskUseCase newTaskUseCase) {
    this.newTaskUseCase = newTaskUseCase;
  }

  @PostMapping
  public ResponseEntity<Object> add(@Valid @RequestBody NewTaskControllerRequestModel model) {
    NewTaskRequestModel requestModel = new NewTaskRequestModel(model.title(), model.description(), model.type());
    NewTaskResponseModel responseModel = newTaskUseCase.execute(requestModel);

    if(!responseModel.success()) {
      return ResponseEntity.badRequest().build();
    }

    return ResponseEntity.ok().build();
  }
}
