package com.api.taskmanager.usecase.gateway.model.response;

public record NewTaskVerifierResponseModel(Boolean success, String errorMessage) {
}
