package com.falko.dao.interfaces;


import com.falko.model.User;

public interface UserDao {

    User findById(int id);
    User findByUsername(String username);
    int saveUser(User user);
}
