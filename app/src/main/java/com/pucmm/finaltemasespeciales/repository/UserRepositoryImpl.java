package com.pucmm.finaltemasespeciales.repository;

import com.pucmm.finaltemasespeciales.database.dao.UserDAO;
import com.pucmm.finaltemasespeciales.database.entity.User;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    UserDAO dao;

    public UserRepositoryImpl(UserDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAll();
    }

    @Override
    public User findUserById(int userId) {
        return dao.findById(userId);
    }

    public User getUserLogin(String correo, String contrasenia) {
        return dao.getUserLogin(correo, contrasenia);
    }

    public String getPasswordByEmail(String correo) {
        return dao.getPasswordByEmail(correo);
    }

    @Override
    public void insertUser(User user) {
        dao.insert(user);
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void deleteUser(User user) {
        dao.delete(user);
    }
}
