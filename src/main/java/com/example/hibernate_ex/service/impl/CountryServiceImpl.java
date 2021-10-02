package com.example.hibernate_ex.service.impl;

import com.example.hibernate_ex.exception.ResourceNotFoundException;
import com.example.hibernate_ex.model.Country;
import com.example.hibernate_ex.repository.CountryRepository;
import com.example.hibernate_ex.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        super();
        this.countryRepository = countryRepository;
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country get(long id) {
        return countryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Country", "id", id));
    }

    @Override
    public Country update(Country country, long id) {
        Country existCountry = countryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Country", "id", id));
        existCountry.setName(country.getName());
        existCountry.setId(country.getId());
        countryRepository.save(existCountry);
        return existCountry;
    }

    @Override
    public void delete(long id) {
        countryRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Country", "Id", id));
        countryRepository.deleteById(id);
    }
}