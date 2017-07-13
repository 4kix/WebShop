package com.falko.dao.interfaces;

import com.falko.model.Country;

import java.util.List;


public interface CountryDao {

    Country getById(int id);
    List<Country> getAll();

}
