package com.pucmm.finaltemasespeciales.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.pucmm.finaltemasespeciales.database.entity.Category;

import java.util.List;

@Dao
public interface CategoryDAO {

    @Query("select * from Category")
    List<Category> getAll();

    @Insert
    void insert(Category category);

    @Update
    void update(Category category);

    @Delete
    void delete(Category category);

}
