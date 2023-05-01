package com.api.taskmanager.adapter.provider.jpa.repository;

import com.api.taskmanager.adapter.provider.jpa.entity.TaskJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskJpaEntity, Long> {
}
