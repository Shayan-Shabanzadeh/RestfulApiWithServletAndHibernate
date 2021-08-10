package com.example.usermanagment.dao;

import com.example.usermanagment.bean.User;

import java.util.List;

public interface OneToManyDAO {
    void saveUser(User user);

    void deleteUser(int userId);

    void updateUser(User user);

    List<User> selectAllUsers();

    User selectUser(int id);
}
