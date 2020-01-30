package com.clickbus.placesmanager.services;

import com.clickbus.placesmanager.dto.request.CityRequestModel;
import com.clickbus.placesmanager.dto.response.CityResponseModel;

import java.util.List;

public interface CityService {
    CityResponseModel createCity(CityRequestModel cityRequestModel);
    List<CityResponseModel> getCities();

}
