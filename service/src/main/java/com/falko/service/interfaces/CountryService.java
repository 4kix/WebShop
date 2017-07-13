package com.falko.service.interfaces;


import com.falko.model.Country;

import java.util.List;

public interface CountryService {

    Country getCountryById(int id);
    List<Country> getAllCountries();

}
