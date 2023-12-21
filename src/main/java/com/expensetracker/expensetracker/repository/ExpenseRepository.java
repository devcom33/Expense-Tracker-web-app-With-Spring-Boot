package com.expensetracker.expensetracker.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.expensetracker.expensetracker.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
        @Query("select e.expenseprice from Expense e where e.category.category_id = ?1")
        List<Double> ListExpx(double categoryId);

}
