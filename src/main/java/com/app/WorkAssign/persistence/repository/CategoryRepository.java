package com.app.WorkAssign.persistence.repository;

import com.app.WorkAssign.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
