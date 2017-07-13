package com.falko.dao.interfaces;


import com.falko.model.Type;

import java.util.List;


public interface TypeDao {

    Type getById(int id);
    List<Type> getAll();

}
