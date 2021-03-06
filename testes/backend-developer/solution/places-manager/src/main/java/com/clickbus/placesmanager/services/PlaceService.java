package com.clickbus.placesmanager.services;

import com.clickbus.placesmanager.dto.request.PlaceRequestModel;
import com.clickbus.placesmanager.dto.response.PlaceResponseModel;

import java.util.List;

public interface PlaceService {
    PlaceResponseModel createPlace(PlaceRequestModel placeRequestModel);
    List<PlaceResponseModel> getPlaces();
    PlaceResponseModel getPlaceByPlaceId(String placeId);
    List<PlaceResponseModel> getPlacesByPlaceName(String placeName);
    PlaceResponseModel updatePlace(String placeId, PlaceRequestModel placeRequestModel);
}
