package com.falko.dao.implementations;

import com.falko.dao.AbstractDao;
import com.falko.dao.interfaces.CountryDao;
import com.falko.model.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("countryDao")
public class CountryDaoImpl extends AbstractDao<Integer, Country> implements CountryDao {

    public Country getById(int id) {
        return getByKey(id);
    }

    public List<Country> getAll() {
        return (List<Country>) createEntityCriteria().list();
    }
}
