package com.Incubation.Transaction_Service.Service;
import com.Incubation.Transaction_Service.Entity.Category;
import com.Incubation.Transaction_Service.Repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

//    @Override
//    public boolean existsCategory(int id) {
//        return categoryRepository.existsById(id);
//    }

    public Category getCategoryById(int id)  {
        return categoryRepository.findById(id).get();
    }

    public Category addNewCategory(String categoryName, Long categoryBudget)
    {

        Category category = new Category(
                categoryName,
                categoryBudget,
                true
        );

            categoryRepository.save(category);
            return category;
    }

    public Category updateCategory(int categoryId, String categoryName, Long categoryBudget){

        Category category = getCategoryById(categoryId);

        category.setCategoryName(categoryName);
        category.setCategoryBudget(categoryBudget);
            return category;
    }

}
