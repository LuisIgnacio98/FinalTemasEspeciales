package com.pucmm.finaltemasespeciales.repository;

import com.pucmm.finaltemasespeciales.database.dao.CategoryDAO;
import com.pucmm.finaltemasespeciales.database.entity.Category;

import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {

    CategoryDAO dao;

    public CategoryRepositoryImpl(CategoryDAO dao) {
        this.dao = dao;
    }


    @Override
    public List<Category> getAllCategory() {
        return dao.getAll();
    }

    @Override
    public void insertCategory(Category category) { dao.insert(category); }

    @Override
    public void updateCategory(Category category) { dao.update(category); }

    @Override
    public void deleteCategory(Category category) { dao.delete(category); }
}
