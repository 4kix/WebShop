package com.falko.service.implementations;

import com.falko.dao.interfaces.TypeDao;
import com.falko.model.Type;
import com.falko.service.interfaces.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("typeService")
@Transactional
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao dao;

    public Type getTypeById(int id) {
        return dao.getById(id);
    }

    public List<Type> getAllTypes() {
        return dao.getAll();
    }
}
