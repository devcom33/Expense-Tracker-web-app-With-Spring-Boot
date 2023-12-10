package com.expensetracker.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expensetracker.expensetracker.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
    
}
