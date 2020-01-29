package com.clickbus.placesmanager.services;

import com.clickbus.placesmanager.application.request.CityRequestModel;
import com.clickbus.placesmanager.application.response.CityResponseModel;

import java.util.List;

public interface CityService {
    CityResponseModel createCity(CityRequestModel cityRequestModel);
    List<CityResponseModel> getCities();
}
