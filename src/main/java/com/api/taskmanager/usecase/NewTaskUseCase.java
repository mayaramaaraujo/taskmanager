package com.api.taskmanager.usecase;

import com.api.taskmanager.entity.Task;
import com.api.taskmanager.entity.types.Status;
import com.api.taskmanager.usecase.exception.BadTaskException;
import com.api.taskmanager.usecase.exception.CouldNotVerifySaverException;
import com.api.taskmanager.usecase.gateway.TaskSaverGateway;
import com.api.taskmanager.usecase.gateway.model.request.TaskSaverRequestModel;
import com.api.taskmanager.usecase.gateway.model.response.TaskSaverResponseModel;
import com.api.taskmanager.usecase.model.request.NewTaskRequestModel;
import com.api.taskmanager.usecase.model.response.NewTaskResponseModel;

public class NewTaskUseCase {

  private TaskSaverGateway taskSaverGateway;

  public NewTaskUseCase(TaskSaverGateway taskSaverGateway) {
    this.taskSaverGateway = taskSaverGateway;
  }

  public NewTaskResponseModel execute(NewTaskRequestModel requestModel) {
    try {
      Task task = new Task(
          requestModel.title(),
          requestModel.description(),
          requestModel.type(),
          Status.TO_DO
      );

      if(!task.isValid()) {
        throw new BadTaskException("Task data is invalid: " + task);
      }

      TaskSaverRequestModel taskSaverRequestModel = new TaskSaverRequestModel(task.getTitle(), task.getDescription(), task.getCreatedDate(), task.getDeadline(), task.getType(), task.getStatus());
      TaskSaverResponseModel taskSaverResponseModel = taskSaverGateway.verify(taskSaverRequestModel);

      if(!taskSaverResponseModel.success()) {
        throw new CouldNotVerifySaverException("Could save task on database: " + taskSaverResponseModel.errorMessage());
      }

      return new NewTaskResponseModel(true, "");
    } catch (BadTaskException | CouldNotVerifySaverException e) {
      return new NewTaskResponseModel(false, e.getMessage());
    }
  }
}
