package com.clickbus.placesmanager.services;

import com.clickbus.placesmanager.application.request.PlaceRequestModel;
import com.clickbus.placesmanager.application.response.PlaceResponseModel;

import java.util.List;

public interface PlaceService {
    PlaceResponseModel createPlace(PlaceRequestModel placeRequestModel);
    List<PlaceResponseModel> getPlaces();
    PlaceResponseModel getPlaceByPlaceId(String placeId);
}
