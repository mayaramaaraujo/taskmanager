package com.api.taskmanager.usecase;

import com.api.taskmanager.entity.Task;
import com.api.taskmanager.entity.types.Status;
import com.api.taskmanager.entity.types.Type;
import com.api.taskmanager.usecase.exception.BadTaskException;
import com.api.taskmanager.usecase.exception.CouldNotVerifySaverException;
import com.api.taskmanager.usecase.gateway.TaskVerifierGateway;
import com.api.taskmanager.usecase.gateway.model.request.TaskSaverRequestModel;
import com.api.taskmanager.usecase.gateway.model.response.TaskSaverResponseModel;
import com.api.taskmanager.usecase.model.request.NewTaskRequestModel;
import com.api.taskmanager.usecase.model.response.NewTaskResponseModel;

public class NewTaskUseCase {

  private TaskVerifierGateway taskVerifierGateway;

  public NewTaskUseCase(TaskVerifierGateway taskVerifierGateway) {
    this.taskVerifierGateway = taskVerifierGateway;
  }

  public NewTaskResponseModel execute(NewTaskRequestModel requestModel) {
    try {
      Task task = new Task(
          requestModel.title(),
          requestModel.description(),
          Type.fromString(requestModel.type()),
          Status.TO_DO
      );

      if(!task.isValid()) {
        throw new BadTaskException("Task data is invalid: " + task);
      }

      TaskSaverRequestModel taskSaverRequestModel = new TaskSaverRequestModel(task.getTitle(), task.getDescription(), task.getCreatedDate(), task.getDeadline(), task.getType(), task.getStatus());
      TaskSaverResponseModel taskSaverResponseModel = taskVerifierGateway.verify(taskSaverRequestModel);

      if(!taskSaverResponseModel.success()) {
        throw new CouldNotVerifySaverException("Could not verify task saver: " + taskSaverResponseModel.errorMessage());
      }

      return new NewTaskResponseModel(true, "");
    } catch (BadTaskException | CouldNotVerifySaverException e) {
      return new NewTaskResponseModel(false, e.getMessage());
    }
  }
}
