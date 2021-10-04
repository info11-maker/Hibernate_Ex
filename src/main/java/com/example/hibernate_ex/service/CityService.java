package com.example.hibernate_ex.service;

import com.example.hibernate_ex.model.City;
import com.example.hibernate_ex.model.Country;

import java.util.List;

public interface CityService {
    City save(City country);
    List<City> getAll();
    City get(long id);
    City update(Country country, long id);
    void delete(long id);


}