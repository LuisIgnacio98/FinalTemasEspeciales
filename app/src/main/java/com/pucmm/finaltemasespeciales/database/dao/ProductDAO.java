package com.pucmm.finaltemasespeciales.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.pucmm.finaltemasespeciales.database.entity.Product;

import java.util.List;

@Dao
public interface ProductDAO {

    @Query("select * from Product")
    List<Product> getAll();

    @Query("select * from Product where codigo = :codigo")
    Product findById(String codigo);

    @Insert
    void insert(Product product);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);
}
