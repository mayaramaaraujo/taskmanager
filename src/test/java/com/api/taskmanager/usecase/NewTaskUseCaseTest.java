package com.api.taskmanager.usecase;

import com.api.taskmanager.entity.types.Type;
import com.api.taskmanager.usecase.gateway.TaskSaverGateway;
import com.api.taskmanager.usecase.gateway.model.request.TaskSaverRequestModel;
import com.api.taskmanager.usecase.gateway.model.response.TaskSaverResponseModel;
import com.api.taskmanager.usecase.model.request.NewTaskRequestModel;
import com.api.taskmanager.usecase.model.response.NewTaskResponseModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NewTaskUseCaseTest {

  @Mock
  TaskSaverGateway taskSaverGateway;

  @InjectMocks
  NewTaskUseCase newTaskUseCase;

  @Test
  public void given_ValidTaskRequestModel_shouldReturnSuccess() {
    NewTaskRequestModel requestModel = new NewTaskRequestModel("to do", "to do something", Type.URGENT);

    TaskSaverResponseModel taskSaverResponseModel = new TaskSaverResponseModel(true, "");
    when(taskSaverGateway.verify(any(TaskSaverRequestModel.class))).thenReturn(taskSaverResponseModel);

    NewTaskResponseModel responseModel = newTaskUseCase.execute(requestModel);

    assertTrue(responseModel.success());
  }

  @Test
  public void given_InvalidTaskRequestModel_shouldReturnError() {
    NewTaskRequestModel requestModel = new NewTaskRequestModel("", "to do something", Type.IMPORTANT);
    NewTaskResponseModel responseModel = newTaskUseCase.execute(requestModel);

    assertFalse(responseModel.success());
  }

  @Test
  public void given_ErrorOnTaskSaverGateway_shouldReturnError() {
    NewTaskRequestModel requestModel = new NewTaskRequestModel("title", "to do something", Type.URGENT);

    TaskSaverResponseModel taskSaverResponseModel = new TaskSaverResponseModel(false, "Could not saver task");
    when(taskSaverGateway.verify(any(TaskSaverRequestModel.class))).thenReturn(taskSaverResponseModel);

    NewTaskResponseModel responseModel = newTaskUseCase.execute(requestModel);

    assertFalse(responseModel.success());
  }
}
