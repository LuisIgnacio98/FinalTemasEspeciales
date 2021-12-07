package com.pucmm.finaltemasespeciales.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.pucmm.finaltemasespeciales.database.entity.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Query("select * from User")
    List<User> getAll();

    @Query("select * from User where userId = :userId")
    User findById(int userId);

    @Query("select * from User where correo = :correo and contrasenia = :contrasenia")
    User getUserLogin(String correo, String contrasenia);

    @Query("select contrasenia from User where correo = :correo")
    public String getPasswordByEmail(String correo);

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);
}
