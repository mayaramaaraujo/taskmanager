package com.api.taskmanager.entity.types;

public enum Type {
  NORMAL,
  IMPORTANT,
  URGENT;

  static Type fromString(String text) {
    switch (text.toLowerCase()) {
      case "important": {
        return IMPORTANT;
      }
      case "urgent": {
        return URGENT;
      }
      default:
        return NORMAL;
    }
  }
}
