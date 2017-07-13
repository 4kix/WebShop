package com.falko.dao.implementations;

import com.falko.dao.AbstractDao;
import com.falko.dao.interfaces.UserTypeDao;
import com.falko.model.UserType;
import org.springframework.stereotype.Repository;

@Repository("userTypeDao")
public class UserTypeDaoImpl extends AbstractDao<Integer, UserType> implements UserTypeDao {


    public void saveUserType(UserType userType) {
        save(userType);
    }
}
