package com.example.usermanagment.dao;

import com.example.usermanagment.bean.Address;
import com.example.usermanagment.bean.User;

import java.util.List;

public interface OneToManyDAO {
    Long saveUserWithOutAddress(User user);

    void saveUserAddress(Long userId , List<Address> addresses);

    void deleteUser(Long userId);

    void updateUser(User user);

    List<User> selectAllUsers();

    User selectUser(Long id);


}
