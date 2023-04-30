package com.api.taskmanager.usecase.gateway.model.request;

import com.api.taskmanager.entity.types.Status;
import com.api.taskmanager.entity.types.Type;

import java.time.LocalDateTime;

public record TaskSaverRequestModel(String title, String description, LocalDateTime createdDate, LocalDateTime deadline, Type type, Status status) {
}
