package com.clickbus.placesmanager.services;

import com.clickbus.placesmanager.application.request.PlaceRequestModel;
import com.clickbus.placesmanager.application.response.PlaceResponseModel;
import com.clickbus.placesmanager.entities.City;
import com.clickbus.placesmanager.entities.Place;
import com.clickbus.placesmanager.exception.ResourceNotFoundException;
import com.clickbus.placesmanager.repository.CityRepository;
import com.clickbus.placesmanager.repository.PlaceRepository;
import com.clickbus.placesmanager.utils.ModelMapperFactory;
import com.github.slugify.Slugify;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;
    private final CityRepository cityRepository;

    @Override
    public PlaceResponseModel createPlace(PlaceRequestModel placeRequestModel) {
        ModelMapper modelMapper = ModelMapperFactory.getInstance();
        Slugify slugifier = new Slugify();

        Place place = Place.builder()
                .placeName(placeRequestModel.getPlaceName())
                .slug(slugifier.slugify(placeRequestModel.getPlaceName()))
                .city(cityRepository
                        .findByCityId(placeRequestModel.getCityId())
                        .orElseThrow(ResourceNotFoundException::new))
                .build();

        place = placeRepository.save(place);

        return modelMapper.map(place, PlaceResponseModel.class);
    }
}
