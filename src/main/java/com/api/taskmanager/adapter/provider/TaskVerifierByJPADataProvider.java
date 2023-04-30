package com.api.taskmanager.adapter.provider;

import com.api.taskmanager.usecase.gateway.TaskVerifierGateway;
import com.api.taskmanager.usecase.gateway.model.request.TaskSaverRequestModel;
import com.api.taskmanager.usecase.gateway.model.response.TaskSaverResponseModel;

public class TaskVerifierByJPADataProvider implements TaskVerifierGateway {

  @Override
  public TaskSaverResponseModel verify(TaskSaverRequestModel requestModel) {
    return null;
  }

}
