package com.clickbus.placesmanager.repository;

import com.clickbus.placesmanager.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    Optional<Place> findByPlaceId(String placeId);
    List<Place> findAllByPlaceName(String placeName);
}
