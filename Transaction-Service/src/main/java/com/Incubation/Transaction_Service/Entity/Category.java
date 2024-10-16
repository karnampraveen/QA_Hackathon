package com.Incubation.Transaction_Service.Entity;
import jakarta.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String categoryName;
    private Long categoryBudget;
    private boolean enabled;

    public Category() {
    }

    public Category(String categoryName, Long categoryBudget, boolean enabled) {
        this.categoryName = categoryName;
        this.categoryBudget = categoryBudget;
        this.enabled = enabled;
    }

    public Category(Integer categoryId, String categoryName, Long categoryBudget, boolean enabled) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryBudget = categoryBudget;
        this.enabled = enabled;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getCategoryBudget() {
        return categoryBudget;
    }

    public void setCategoryBudget(Long categoryBudget) {
        this.categoryBudget = categoryBudget;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
