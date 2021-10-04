package com.example.hibernate_ex.service.impl;


import com.example.hibernate_ex.exception.ResourceNotFoundException;
import com.example.hibernate_ex.model.City;
import com.example.hibernate_ex.model.Country;
import com.example.hibernate_ex.repository.CityRepository;
import com.example.hibernate_ex.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    CityRepository cityRepository;
    private Thread city;

    public CityServiceImpl(CityRepository cityRepository){
        super();
        this.cityRepository = cityRepository;
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City get(long id) {
        return cityRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Country", "id", id));
    }
    @Override
    public City update(Country country, long id) {
        City existCity = cityRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("City", "id", id));
        existCity.setName(city.getName());
        existCity.setId(city.getId());
        cityRepository.save(existCity);
        return existCity;
    }

    @Override
    public void delete(long id) {
        cityRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("City", "Id", id));
        cityRepository.deleteById(id);
    }
}