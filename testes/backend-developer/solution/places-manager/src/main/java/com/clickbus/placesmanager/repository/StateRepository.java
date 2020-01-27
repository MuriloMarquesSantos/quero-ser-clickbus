package com.clickbus.placesmanager.repository;

import com.clickbus.placesmanager.entities.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends CrudRepository<State, Long> {
    List<State> findAll();
}
