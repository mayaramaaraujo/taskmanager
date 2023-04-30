package com.api.taskmanager.usecase.gateway;

import com.api.taskmanager.usecase.gateway.model.request.TaskSaverRequestModel;
import com.api.taskmanager.usecase.gateway.model.response.TaskSaverResponseModel;

public interface TaskSaverGateway {
  TaskSaverResponseModel verify(TaskSaverRequestModel requestModel);
}
