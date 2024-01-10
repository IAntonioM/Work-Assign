package com.app.WorkAssign.controller;

import com.app.WorkAssign.dto.TaskRequest;
import com.app.WorkAssign.persistence.entity.Category;
import com.app.WorkAssign.persistence.entity.Task;
import com.app.WorkAssign.persistence.entity.User;
import com.app.WorkAssign.persistence.repository.CategoryRepository;
import com.app.WorkAssign.persistence.repository.TaskRepository;
import com.app.WorkAssign.persistence.repository.UserRepository;
import com.app.WorkAssign.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    TaskService taskService;
    @PostMapping
    public ResponseEntity<Task> createOne(@RequestBody @Valid TaskRequest taskRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                taskService.createTask(taskRequest)
        );
    }

    @GetMapping
    public ResponseEntity<List<Task>> findTasksByUser(){
        Long userId=1L;
        List<Task> tasks=taskService.findTasksByUser(userId);
        if(tasks!=null && !tasks.isEmpty()){
            return ResponseEntity.ok(tasks);
        }
        return ResponseEntity.notFound().build();
    }


}
