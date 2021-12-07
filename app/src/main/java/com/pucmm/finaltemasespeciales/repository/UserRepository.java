package com.pucmm.finaltemasespeciales.repository;

import com.pucmm.finaltemasespeciales.database.entity.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUsers();

    User findUserById(int userId);

    User getUserLogin(String correo, String contrasenia);

    String getPasswordByEmail(String correo);

    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(User user);
}
