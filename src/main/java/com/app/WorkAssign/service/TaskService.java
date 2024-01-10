package com.app.WorkAssign.service;

import com.app.WorkAssign.dto.TaskRequest;
import com.app.WorkAssign.persistence.entity.Category;
import com.app.WorkAssign.persistence.entity.Task;
import com.app.WorkAssign.persistence.entity.User;
import com.app.WorkAssign.persistence.repository.CategoryRepository;
import com.app.WorkAssign.persistence.repository.TaskRepository;
import com.app.WorkAssign.persistence.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Task createTask(TaskRequest taskRequest) {
        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setStatus(taskRequest.getStatus());
        task.setPriority(taskRequest.getPriority());
        task.setDeadline(taskRequest.getDeadline());
        task.setCreatedAt(new Date());
        User user = userRepository.findById(taskRequest.getUserId()).orElseThrow(() -> new EntityNotFoundException("User not found"));
        task.setUser(user);
        Category category = categoryRepository.findById(taskRequest.getCategoryId()).orElseThrow(() -> new EntityNotFoundException("Category not found"));
        task.setCategory(category);
        return taskRepository.save(task);
    }
    public List<Task> findTasksByUser(Long userId) {
        List<Task> tasks = taskRepository.findTasksByUser_Id(userId);
        if (!tasks.isEmpty()) {
            return tasks;
        }
        throw new EntityNotFoundException("No tasks found for the user with ID: " + userId);
    }

}
