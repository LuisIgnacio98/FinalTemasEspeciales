package com.pucmm.finaltemasespeciales.repository;

import com.pucmm.finaltemasespeciales.database.entity.Category;

import java.util.List;

public interface CategoryRepository {

    List<Category> getAllCategory();

    void insertCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Category category);
}
