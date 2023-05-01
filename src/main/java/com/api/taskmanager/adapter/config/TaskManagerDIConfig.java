package com.api.taskmanager.adapter.config;

import com.api.taskmanager.adapter.provider.CreateNewTaskByJpaDataProvider;
import com.api.taskmanager.adapter.provider.jpa.repository.TaskRepository;
import com.api.taskmanager.usecase.NewTaskUseCase;
import com.api.taskmanager.usecase.gateway.NewTaskVerifierGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskManagerDIConfig {

  @Autowired
  TaskRepository taskRepository;

  @Bean
  public NewTaskVerifierGateway newTaskVerifierGateway() {
      return new CreateNewTaskByJpaDataProvider(taskRepository);
  }

  @Bean
  public NewTaskUseCase newTaskUseCase() {
    return new NewTaskUseCase(newTaskVerifierGateway());
  }
}
