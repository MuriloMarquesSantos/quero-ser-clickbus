package com.clickbus.placesmanager.services;

import com.clickbus.placesmanager.dto.request.PlaceRequestModel;
import com.clickbus.placesmanager.dto.response.PlaceResponseModel;
import com.clickbus.placesmanager.entities.Place;
import com.clickbus.placesmanager.exception.ResourceNotFoundException;
import com.clickbus.placesmanager.repository.CityRepository;
import com.clickbus.placesmanager.repository.PlaceRepository;
import com.clickbus.placesmanager.utils.ModelMapperFactory;
import com.github.slugify.Slugify;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<PlaceResponseModel> getPlaces() {
        ModelMapper modelMapper = ModelMapperFactory.getInstance();
        List<Place> placeList = placeRepository.findAll();

        return Optional.ofNullable(placeList)
                .filter(list -> !list.isEmpty())
                .orElseThrow(ResourceNotFoundException::new)
                .stream()
                .map(place -> modelMapper.map(place, PlaceResponseModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public PlaceResponseModel getPlaceByPlaceId(String placeId) {
        ModelMapper modelMapper = ModelMapperFactory.getInstance();
        Place place = placeRepository
                .findByPlaceId(placeId)
                .orElseThrow(ResourceNotFoundException::new);

        return modelMapper.map(place, PlaceResponseModel.class);
    }

    @Override
    public List<PlaceResponseModel> getPlacesByPlaceName(String placeName) {
        ModelMapper modelMapper = ModelMapperFactory.getInstance();

        List<Place> placeList = placeRepository.findAllByPlaceName(placeName);
        return Optional.ofNullable(placeList)
                .filter(list -> !list.isEmpty())
                .orElseThrow(ResourceNotFoundException::new)
                .stream()
                .map(place -> modelMapper.map(place, PlaceResponseModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public PlaceResponseModel updatePlace(String placeId, PlaceRequestModel placeRequestModel) {
        return null;
    }
}
