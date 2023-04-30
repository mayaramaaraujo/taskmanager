package com.api.taskmanager.usecase.model.request;

import com.api.taskmanager.entity.types.Type;

public record NewTaskRequestModel(String title, String description, Type type) {
}
