package com.Incubation.Transaction_Service.Service;
import com.Incubation.Transaction_Service.Entity.Budget;
import com.Incubation.Transaction_Service.Repo.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {
    @Autowired
    private BudgetRepository budgetRepository;

    public List<Budget> getCategories() {
        return budgetRepository.findAll();
    }

//    @Override
//    public boolean existsCategory(int id) {
//        return categoryRepository.existsById(id);
//    }

    public Budget getCategoryById(int id)  {
        return budgetRepository.findById(id).get();
    }

    public Budget addNewCategory(String categoryName, Long categoryBudget)
    {

        Budget budget = new Budget(
                categoryName,
                categoryBudget,
                true
        );

            budgetRepository.save(budget);
            return budget;
    }

    public Budget updateCategory(int categoryId, String categoryName, Long categoryBudget){

        Budget budget = getCategoryById(categoryId);

        budget.setCategoryName(categoryName);
        budget.setCategoryBudget(categoryBudget);
            return budget;
    }

}
