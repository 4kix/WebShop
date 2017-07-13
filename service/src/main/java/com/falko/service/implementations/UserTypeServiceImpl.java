package com.falko.service.implementations;

import com.falko.dao.interfaces.UserTypeDao;
import com.falko.model.UserType;
import com.falko.service.interfaces.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userTypeService")
@Transactional
public class UserTypeServiceImpl implements UserTypeService {

    @Autowired
    private UserTypeDao userTypeDao;

    public void save(UserType userType) {
        userTypeDao.saveUserType(userType);
    }
}
