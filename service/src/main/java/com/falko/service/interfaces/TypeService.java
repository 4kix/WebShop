package com.falko.service.interfaces;


import com.falko.model.Type;

import java.util.List;


public interface TypeService {

    Type getTypeById(int id);
    List<Type> getAllTypes();

}
