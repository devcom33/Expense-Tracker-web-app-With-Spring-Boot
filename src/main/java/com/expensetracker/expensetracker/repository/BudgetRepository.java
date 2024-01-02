package com.expensetracker.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.expensetracker.expensetracker.model.Budget;
/*Repository:  a repository is a part of the Spring Data module that provides an abstraction for data access. 
    It simplifies the way you interact with databases by allowing you to perform common
    database operations (like saving, updating, deleting, and querying data) without writing
    a lot of boilerplate code.
*/
@Repository
public interface BudgetRepository extends JpaRepository<Budget, Integer>{
    @Query("SELECT b.budget_limit FROM Budget b where b.category.category_id = ?1")
    Double findBudgetLimitByCategoryId(Integer category_id);
}
