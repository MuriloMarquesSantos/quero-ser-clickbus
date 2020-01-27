package com.clickbus.placesmanager.repository;

import com.clickbus.placesmanager.entities.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
}
