package com.example.hibernate_ex.repository;
import com.example.hibernate_ex.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
