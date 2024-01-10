package com.app.WorkAssign.controller;

import com.app.WorkAssign.persistence.entity.Category;
import com.app.WorkAssign.persistence.repository.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories-task")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categories=categoryRepository.findAll();
        if(categories!=null && !categories.isEmpty()){
            return ResponseEntity.ok(categories);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Category> createOne(@RequestBody @Valid Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                categoryRepository.save(category)
        );
    }
}
