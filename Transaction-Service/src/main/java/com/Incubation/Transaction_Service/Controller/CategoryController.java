package com.Incubation.Transaction_Service.Controller;

import com.Incubation.Transaction_Service.Entity.Category;
import com.Incubation.Transaction_Service.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAll")
    public List<Category> getAllCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("/new")
    public Category addNewCategory(@Param("categoryName") String categoryName, @Param("categoryBudget") Long categoryBudget)
    {
        return categoryService.addNewCategory(categoryName, categoryBudget);
    }

    @PutMapping("/update")
    public Category updateCategory(@Param ("categoryId") int categoryId,
                                   @RequestParam("categoryName") String categoryName, @RequestParam("categoryBudget") Long categoryBudget)
    {
        return categoryService.updateCategory(categoryId, categoryName, categoryBudget);
    }

}
