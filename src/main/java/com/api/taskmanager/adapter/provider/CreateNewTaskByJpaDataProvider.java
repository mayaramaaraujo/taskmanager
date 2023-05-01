package com.api.taskmanager.adapter.provider;

import com.api.taskmanager.adapter.provider.jpa.entity.TaskJpaEntity;
import com.api.taskmanager.adapter.provider.jpa.repository.TaskRepository;
import com.api.taskmanager.usecase.gateway.NewTaskVerifierGateway;
import com.api.taskmanager.usecase.gateway.model.request.NewTaskVerifierRequestModel;
import com.api.taskmanager.usecase.gateway.model.response.NewTaskVerifierResponseModel;

public class CreateNewTaskByJpaDataProvider implements NewTaskVerifierGateway {

  private final TaskRepository taskRepository;

  public CreateNewTaskByJpaDataProvider(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Override
  public NewTaskVerifierResponseModel verify(NewTaskVerifierRequestModel requestModel) {

    try {
      TaskJpaEntity taskJpaEntity = new TaskJpaEntity(
          requestModel.title(),
          requestModel.description(),
          requestModel.createdDate(),
          requestModel.deadline(),
          requestModel.type(),
          requestModel.status()
      );

      taskRepository.save(taskJpaEntity);

      return new NewTaskVerifierResponseModel(true, null);
    } catch (Exception e) {
      return new NewTaskVerifierResponseModel(false, e.getMessage());
    }

  }

}
