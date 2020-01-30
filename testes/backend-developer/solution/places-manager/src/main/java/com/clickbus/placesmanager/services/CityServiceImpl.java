package com.clickbus.placesmanager.services;

import com.clickbus.placesmanager.application.request.CityRequestModel;
import com.clickbus.placesmanager.application.response.CityResponseModel;
import com.clickbus.placesmanager.application.response.StateResponseModel;
import com.clickbus.placesmanager.entities.City;
import com.clickbus.placesmanager.entities.State;
import com.clickbus.placesmanager.exception.ResourceNotFoundException;
import com.clickbus.placesmanager.repository.CityRepository;
import com.clickbus.placesmanager.repository.StateRepository;
import com.clickbus.placesmanager.utils.ModelMapperFactory;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;
    private StateRepository stateRepository;

    @Override
    public CityResponseModel createCity(CityRequestModel cityRequestModel) {
        ModelMapper modelMapper = ModelMapperFactory.getInstance();

        City city = City.builder()
                    .cityName(cityRequestModel.getCityName())
                    .state(stateRepository
                            .findByStateId(cityRequestModel.getStateId())
                            .orElseThrow(ResourceNotFoundException::new))
                    .build();
        city = cityRepository.save(city);

        CityResponseModel returnValue = modelMapper.map(city, CityResponseModel.class);

        return returnValue;
    }

    @Override
    public List<CityResponseModel> getCities() {
        ModelMapper modelMapper = ModelMapperFactory.getInstance();
        List<City> cityList = cityRepository.findAll();

        return Optional.ofNullable(cityList)
                .filter(list -> !list.isEmpty())
                .orElseThrow(ResourceNotFoundException::new)
                .stream()
                .map(city -> modelMapper.map(city, CityResponseModel.class))
                .collect(Collectors.toList());
    }
}
