package com.example.hibernate_ex.repository;

import com.example.hibernate_ex.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}