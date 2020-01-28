package com.clickbus.placesmanager.repository;

import com.clickbus.placesmanager.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
    List<State> findAll();
    Optional<State> findByStateId(String stateId);
}
