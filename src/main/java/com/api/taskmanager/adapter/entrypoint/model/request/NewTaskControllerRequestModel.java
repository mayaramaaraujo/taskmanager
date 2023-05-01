package com.api.taskmanager.adapter.entrypoint.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record NewTaskControllerRequestModel(
    @NotNull(message = "title is mandatory")
    @NotBlank (message = "title is mandatory")
    String title,
    @NotNull (message = "description is mandatory")
    @NotBlank (message = "description is mandatory")
    String description,
    @NotNull (message = "type is mandatory")
    @NotBlank (message = "type is mandatory")
    String type) {}