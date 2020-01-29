package com.clickbus.placesmanager.services;

import com.clickbus.placesmanager.application.request.PlaceRequestModel;
import com.clickbus.placesmanager.application.response.PlaceResponseModel;

public interface PlaceService {
    PlaceResponseModel createPlace(PlaceRequestModel placeRequestModel);
}
