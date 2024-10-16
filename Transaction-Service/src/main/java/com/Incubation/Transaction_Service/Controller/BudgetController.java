package com.Incubation.Transaction_Service.Controller;

import com.Incubation.Transaction_Service.Entity.Budget;
import com.Incubation.Transaction_Service.Service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/category")
public class BudgetController {
    @Autowired
    private BudgetService budgetService;

    @GetMapping("/getAll")
    public List<Budget> getAllCategories() {
        return budgetService.getCategories();
    }

    @PostMapping("/new")
    public Budget addNewCategory(@Param("categoryName") String categoryName, @Param("categoryBudget") Long categoryBudget)
    {
        return budgetService.addNewCategory(categoryName, categoryBudget);
    }

    @PutMapping("/update")
    public Budget updateCategory(@Param ("categoryId") int categoryId,
                                 @RequestParam("categoryName") String categoryName, @RequestParam("categoryBudget") Long categoryBudget)
    {
        return budgetService.updateCategory(categoryId, categoryName, categoryBudget);
    }

}
