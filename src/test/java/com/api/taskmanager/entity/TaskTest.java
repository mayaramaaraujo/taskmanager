package com.api.taskmanager.entity;

import com.api.taskmanager.entity.types.Status;
import com.api.taskmanager.entity.types.Type;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTest {
  @Test
  public void given_ValidTask_shouldReturnSuccess() {
    Task task = new Task("to do", "to do something", Type.NORMAL, Status.TO_DO);
    assertTrue(task.isValid());
  }

  @Test
  public void given_InvalidValidTask_shouldReturnError() {
    Task task = new Task("to do", "", Type.NORMAL, Status.TO_DO);
    assertFalse(task.isValid());
  }
}
