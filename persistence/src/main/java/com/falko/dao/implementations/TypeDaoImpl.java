package com.falko.dao.implementations;

import com.falko.dao.AbstractDao;
import com.falko.dao.interfaces.TypeDao;
import com.falko.model.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("typeDao")
public class TypeDaoImpl extends AbstractDao<Integer, Type> implements TypeDao {

    public Type getById(int id) {
        return getByKey(id);
    }

    public List<Type> getAll() {
        return (List<Type>) createEntityCriteria().list();
    }
}
