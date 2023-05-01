package com.api.taskmanager.usecase.gateway;

import com.api.taskmanager.usecase.gateway.model.request.NewTaskVerifierRequestModel;
import com.api.taskmanager.usecase.gateway.model.response.NewTaskVerifierResponseModel;

public interface NewTaskVerifierGateway {
  NewTaskVerifierResponseModel verify(NewTaskVerifierRequestModel requestModel);
}
