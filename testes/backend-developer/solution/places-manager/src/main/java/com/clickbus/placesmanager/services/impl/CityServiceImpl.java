package com.clickbus.placesmanager.services.impl;

import com.clickbus.placesmanager.application.responsemodels.CityResponseModel;
import com.clickbus.placesmanager.repository.CityRepository;
import com.clickbus.placesmanager.services.CityService;
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
