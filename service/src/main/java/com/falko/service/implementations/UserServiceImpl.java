package com.falko.service.implementations;

import com.falko.dao.interfaces.UserDao;
import com.falko.model.User;
import com.falko.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;

    public User findById(int id) {
        return dao.findById(id);
    }

    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public int saveUser(User user) {
        return dao.saveUser(user);
    }
}
