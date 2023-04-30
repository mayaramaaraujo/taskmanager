package com.api.taskmanager.adapter.config;

import com.api.taskmanager.adapter.provider.TaskSaverByJPADataProvider;
import com.api.taskmanager.usecase.gateway.TaskSaverGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskManagerDIConfig {
    @Bean
  public TaskSaverGateway taskSaverGateway() {
      return new TaskSaverByJPADataProvider();
    }
}
