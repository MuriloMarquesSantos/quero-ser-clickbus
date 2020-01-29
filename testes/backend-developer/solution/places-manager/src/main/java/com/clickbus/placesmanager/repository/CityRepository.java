package com.clickbus.placesmanager.repository;

import com.clickbus.placesmanager.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAll();
    Optional<City> findByCityName(String name);
    Optional<City> findByCityId(String cityId);
}
