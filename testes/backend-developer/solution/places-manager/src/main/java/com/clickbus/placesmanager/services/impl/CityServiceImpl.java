package com.clickbus.placesmanager.services.impl;

import com.clickbus.placesmanager.application.responsemodels.CityResponseModel;
import com.clickbus.placesmanager.services.CityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Override
    public CityResponseModel createCity() {
        return CityResponseModel.builder().build();
    }
}
