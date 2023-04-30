package com.api.taskmanager.usecase.model.request;

public record NewTaskRequestModel(String title, String description, String type) {
}
