package com.clickbus.placesmanager.services;

import com.clickbus.placesmanager.repository.PlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PlaceServiceImpl {

    private final PlaceRepository placeRepository;
}
