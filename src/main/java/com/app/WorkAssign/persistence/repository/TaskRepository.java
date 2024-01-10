package com.app.WorkAssign.persistence.repository;

import com.app.WorkAssign.persistence.entity.Category;
import com.app.WorkAssign.persistence.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findTasksByUser_Id(Long userId);
}
