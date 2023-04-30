package com.api.taskmanager.adapter.provider;

import com.api.taskmanager.usecase.gateway.TaskSaverGateway;
import com.api.taskmanager.usecase.gateway.model.request.TaskSaverRequestModel;
import com.api.taskmanager.usecase.gateway.model.response.TaskSaverResponseModel;

public class TaskSaverByJPADataProvider implements TaskSaverGateway {

  @Override
  public TaskSaverResponseModel verify(TaskSaverRequestModel requestModel) {
    return null;
  }

}
