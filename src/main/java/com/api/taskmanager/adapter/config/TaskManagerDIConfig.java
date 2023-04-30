package com.api.taskmanager.adapter.config;

import com.api.taskmanager.adapter.provider.TaskVerifierByJPADataProvider;
import com.api.taskmanager.usecase.gateway.TaskVerifierGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskManagerDIConfig {
    @Bean
  public TaskVerifierGateway taskSaverGateway() {
      return new TaskVerifierByJPADataProvider();
    }
}
