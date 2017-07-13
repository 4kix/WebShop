package com.falko.service.interfaces;

import com.falko.model.User;


public interface UserService {

    User findById(int id);

    User findByUsername(String username);

    int saveUser(User user);

}
