package com.api.taskmanager.adapter.provider;

import com.api.taskmanager.adapter.provider.jpa.repository.TaskRepository;
import com.api.taskmanager.entity.types.Status;
import com.api.taskmanager.entity.types.Type;
import com.api.taskmanager.usecase.gateway.model.request.NewTaskVerifierRequestModel;
import com.api.taskmanager.usecase.gateway.model.response.NewTaskVerifierResponseModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CreateNewTaskByJpaDataProviderTest {

  @Mock
  TaskRepository taskRepository;

  @InjectMocks
  CreateNewTaskByJpaDataProvider createNewTaskByJpaDataProvider;

  @Test
  public void given_ValidNewTaskRequestModel_shouldReturnSuccess() {
    NewTaskVerifierRequestModel requestModel = new NewTaskVerifierRequestModel("title", "description", LocalDateTime.of(2023, 3, 5, 9, 3 ), LocalDateTime.of(2023, 3, 5, 9, 3 ), Type.NORMAL, Status.TO_DO);
    NewTaskVerifierResponseModel response = createNewTaskByJpaDataProvider.verify(requestModel);

    assertTrue(response.success());
  }

  @Test
  public void given_invalidNewTaskRequestModel_shouldReturnError() {
    NewTaskVerifierRequestModel requestModel = new NewTaskVerifierRequestModel(null, "description", LocalDateTime.of(2023, 3, 5, 9, 3 ), LocalDateTime.of(2023, 3, 5, 9, 3 ), Type.NORMAL, Status.TO_DO);
    when(taskRepository.save(any())).thenThrow(RuntimeException.class);
    NewTaskVerifierResponseModel response = createNewTaskByJpaDataProvider.verify(requestModel);
    assertFalse(response.success());
  }

}
