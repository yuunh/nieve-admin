package com.admin.service;

import com.admin.entity.CategoryEntity;
import com.admin.model.Category;
import com.admin.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategoryList() {
        List<CategoryEntity> categoryList = categoryRepository.findAll();

        List<Category> categories = new ArrayList<>();
        for (CategoryEntity ce : categoryList) {
            Category c = Category.builder()
                    .categoryNo(ce.getCategoryNo())
                    .categoryName(ce.getCategoryName())
                    .build();
            categories.add(c);
        }

        return categories;
    }

    public void addCategory(Category category){
        CategoryEntity entity = CategoryEntity.builder()
                .categoryName(category.getCategoryName())
                .build();
        categoryRepository.save(entity);
    }

    public void updateCategory(Category category) {

        CategoryEntity ce = categoryRepository.findById(category.getCategoryNo()).orElseThrow();

        ce.setCategoryName(category.getCategoryName());

        categoryRepository.save(ce);
    }

    public Category getCategory(int categoryNo) {

        CategoryEntity ce = categoryRepository.findById(categoryNo).orElseThrow();

        Category c = Category.builder()
                .categoryNo(ce.getCategoryNo())
                .categoryName(ce.getCategoryName())
                .build();
        return c;
    }
}
