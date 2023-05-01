package com.api.taskmanager.usecase;

import com.api.taskmanager.entity.Task;
import com.api.taskmanager.entity.types.Type;
import com.api.taskmanager.usecase.exception.BadTaskException;
import com.api.taskmanager.usecase.exception.CouldNotVerifySaverException;
import com.api.taskmanager.usecase.gateway.NewTaskVerifierGateway;
import com.api.taskmanager.usecase.gateway.model.request.NewTaskVerifierRequestModel;
import com.api.taskmanager.usecase.gateway.model.response.NewTaskVerifierResponseModel;
import com.api.taskmanager.usecase.model.request.NewTaskRequestModel;
import com.api.taskmanager.usecase.model.response.NewTaskResponseModel;

public class NewTaskUseCase {

  private final NewTaskVerifierGateway newTaskVerifierGateway;

  public NewTaskUseCase(NewTaskVerifierGateway newTaskVerifierGateway) {
    this.newTaskVerifierGateway = newTaskVerifierGateway;
  }

  public NewTaskResponseModel execute(NewTaskRequestModel requestModel) {
    try {
      Task task = new Task(
          requestModel.title(),
          requestModel.description(),
          Type.fromString(requestModel.type())
      );

      if(!task.isValid()) {
        throw new BadTaskException("Task data is invalid: " + task);
      }

      NewTaskVerifierRequestModel newTaskVerifierRequestModel = new NewTaskVerifierRequestModel(task.getTitle(), task.getDescription(), task.getCreatedDate(), task.getDeadline(), task.getType(), task.getStatus());
      NewTaskVerifierResponseModel newTaskVerifierResponseModel = newTaskVerifierGateway.verify(newTaskVerifierRequestModel);

      if(!newTaskVerifierResponseModel.success()) {
        throw new CouldNotVerifySaverException("Could not verify task saver: " + newTaskVerifierResponseModel.errorMessage());
      }

      return new NewTaskResponseModel(true, "");
    } catch (BadTaskException | CouldNotVerifySaverException e) {
      return new NewTaskResponseModel(false, e.getMessage());
    }
  }
}
