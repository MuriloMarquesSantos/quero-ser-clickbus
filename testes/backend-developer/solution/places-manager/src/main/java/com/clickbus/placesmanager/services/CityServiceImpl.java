package com.clickbus.placesmanager.services;

import com.clickbus.placesmanager.application.response.CityResponseModel;
import com.clickbus.placesmanager.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    @Override
    public CityResponseModel createCity() {
        return CityResponseModel.builder().build();
    }
}
