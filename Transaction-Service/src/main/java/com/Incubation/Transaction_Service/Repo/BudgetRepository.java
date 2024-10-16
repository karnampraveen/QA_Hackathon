package com.Incubation.Transaction_Service.Repo;
import com.Incubation.Transaction_Service.Entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Integer> {
}
