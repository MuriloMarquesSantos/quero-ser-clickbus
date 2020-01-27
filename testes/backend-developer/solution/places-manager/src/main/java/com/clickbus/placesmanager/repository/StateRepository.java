package com.clickbus.placesmanager.repository;

import com.clickbus.placesmanager.entities.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends CrudRepository<State, Long> {
}
