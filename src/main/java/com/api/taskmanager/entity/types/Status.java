package com.api.taskmanager.entity.types;

public enum Status {
  TO_DO,
  DOING,
  DONE;

  static Status fromString(String text) {
    switch (text.toLowerCase()) {
      case "doing": {
        return DOING;
      }
      case "done": {
        return DONE;
      }
      default:
        return TO_DO;
    }
  }
}
